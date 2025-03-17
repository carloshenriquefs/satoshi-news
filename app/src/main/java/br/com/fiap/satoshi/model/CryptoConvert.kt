package br.com.fiap.satoshi.model

data class CryptoConvert(
    val id: Long = 0,
    val from: String = "",
    val to: String = "",
    val amount: Int = 0,
    val convertedAmount: Double = 0.0
)
