package br.com.fiap.satoshi.model

import com.google.gson.annotations.SerializedName

data class AlertsCurrency(
    @SerializedName("_id") val id: String = "",
    val title: String = "",
    val subtitle: String = "",
    val updatedAt: String = ""
)