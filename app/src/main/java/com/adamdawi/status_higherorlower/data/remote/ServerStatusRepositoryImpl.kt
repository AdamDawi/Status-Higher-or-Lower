package com.adamdawi.status_higherorlower.data.remote

import android.util.Log
import com.adamdawi.status_higherorlower.BuildConfig
import com.adamdawi.status_higherorlower.domain.ServerStatusRepository
import com.adamdawi.status_higherorlower.domain.model.ServerStatus
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.nio.channels.UnresolvedAddressException

class ServerStatusRepositoryImpl(
    private val httpClient: HttpClient
) : ServerStatusRepository {

    companion object {
        private const val TAG = "ServerStatusRepo"
    }

    override suspend fun getStatus(): ServerStatus {
        return try {
            val response: HttpResponse = httpClient.get(BuildConfig.SERVER_URL)
            val statusCode = response.status
            Log.d(TAG, "Server response code: ${statusCode.value} ${statusCode.description}")

            if (statusCode.value in 200..299) {
                ServerStatus.Up
            } else {
                ServerStatus.Down("HTTP ${statusCode.value} ${statusCode.description}")
            }
        }catch (e: Exception) {
            Log.e("Network", "${e.localizedMessage}")
            return when (e) {
                is UnknownHostException -> ServerStatus.Unreachable
                is UnresolvedAddressException -> ServerStatus.Unreachable
                is SocketTimeoutException -> ServerStatus.Unreachable
                is ConnectException -> ServerStatus.Down("Exception: ${e.message}") // Maybe server but can be user problem
                else -> {
                    ServerStatus.Down("Exception: ${e.message}")
                }
            }
        }
    }
}