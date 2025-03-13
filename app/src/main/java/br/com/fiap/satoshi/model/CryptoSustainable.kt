package br.com.fiap.satoshi.model

import com.google.gson.annotations.SerializedName

data class CryptoSustainable (

    var id: String = "",
    var symbol: String = "",
    var name: String = "",
    var image: String = "",
    @SerializedName("esg_score") var esgScore: Int = 0,
    @SerializedName("current_price") var currentPrice: Double = 0.0,
    @SerializedName("market_cap") var marketCap: Int = 0
    )