package com.example.exampleclearapp.data

import com.example.exampleclearapp.data.dto.AccessToken
import com.example.exampleclearapp.data.dto.HorizontalCard
import retrofit2.http.GET
import retrofit2.http.Header


interface OpenComApi {

    @GET("https://api.dev.decathlon.ru/bitrix-backend/api/v1/oauth/token")
    suspend fun getAccessToken(): AccessToken

    @GET("https://api.dev.decathlon.ru/bitrix-backend/api/v1/content/main/horizontal-cards")
    suspend fun getHorizontalCard(
        @Header("region") region: String = "moscow",
        @Header("channel") channel: String = "web",
        @Header("locale") locale: String = "ru-RU",
        @Header("Authorization") breaer: String ,
    ): List<HorizontalCard>
}