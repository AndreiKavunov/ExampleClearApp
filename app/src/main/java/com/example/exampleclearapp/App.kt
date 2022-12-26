package com.example.exampleclearapp

import android.app.Application
import com.example.exampleclearapp.data.OpenComApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit

class App: Application() {

    companion object{

        private val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        val json = Json{
            isLenient = true
            ignoreUnknownKeys = true
        }

        private val openComRetrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl("https://api.dev.decathlon.ru/bitrix-backend/api/")
            .build()

        val openComApi: OpenComApi = openComRetrofit.create(OpenComApi::class.java)
    }
}