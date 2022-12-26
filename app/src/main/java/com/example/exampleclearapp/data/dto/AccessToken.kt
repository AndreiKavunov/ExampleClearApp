package com.example.exampleclearapp.data.dto

@kotlinx.serialization.Serializable
data class AccessToken(
    val accessToken: String?,
    val refreshToken: String?,
    val expiresIn: Int?,
)