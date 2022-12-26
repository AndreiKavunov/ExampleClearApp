package com.example.exampleclearapp.data.dto

@kotlinx.serialization.Serializable
class HorizontalCard(
    val description: String?,
    val filterMap: Map<String, String>?,
    val id: Int?,
    val image: Image?,
    val internalLink: Boolean?,
    val leftOriented: Boolean?,
    val subtitle: String?,
    val title: String?,
    val url: String?,
)