package br.com.fiap.satoshi.model

import com.google.gson.annotations.SerializedName

data class CryptoProfitable (

    var id: String = "",
    var symbol: String = "",
    var name: String = "",
    var image: String = "",
    @SerializedName("current_price") var currentPrice: Double = 0.0,
    @SerializedName("price_change_percentage_24h") var percentChange: Double = 0.0
)