package br.com.fiap.satoshi.model

import com.google.gson.annotations.SerializedName

data class Newsletter(

    val image: String = "",
    val authorImage: String = "",
    val authorName: String = "",
    val article: String = "",
    val thirdTitle: String = "",
    @SerializedName("__v") val valueCoin: Double = 0.0
)
