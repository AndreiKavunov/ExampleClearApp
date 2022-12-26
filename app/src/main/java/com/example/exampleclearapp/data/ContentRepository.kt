package com.example.exampleclearapp.data

import com.example.exampleclearapp.App
import com.example.exampleclearapp.data.dto.HorizontalCard

class ContentRepository {

    suspend fun getHorizontalCards(): List<HorizontalCard>{

        val token = App.openComApi.getAccessToken()

        return App.openComApi.getHorizontalCard(breaer = "Bearer ${token.accessToken}")
    }
}