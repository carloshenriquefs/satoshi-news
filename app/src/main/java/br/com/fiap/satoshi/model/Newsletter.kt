package br.com.fiap.satoshi.model

import com.google.gson.annotations.SerializedName

data class Newsletter(

    @SerializedName("_id") val id: String = "",
    val title: String = "",
    val subtitle: String = "",
    val thirdTitle: String = "",
    val image: String = "",
    val article: String = "",
    val authorName: String = "",
    val authorImage: String = "",
    val createdAt: String = "",
    val updatedAt: String = "",
    @SerializedName("__v") val v: String = ""
)
