package com.psob96.network

import android.util.Log
import com.psob96.common_utils.AppError
import com.psob96.common_utils.AppResult
import retrofit2.Response

internal inline fun <reified T> safeCall(request: () -> Response<T>): AppResult<T> {

    return try {
        val response = request()
        val body = response.body()

        when {
            !response.isSuccessful -> AppResult.Error(AppError.Offline)
            response.errorBody() != null -> AppResult.Error(AppError.ServerError)
            body == null -> AppResult.Error(AppError.Offline)
            else -> AppResult.Success(body)
        }

    } catch (e: Exception) {
        Log.d("caughtException", e.message.toString())
        AppResult.Error(AppError.of(e))
    }
}
