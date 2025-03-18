package br.com.fiap.satoshi.model

data class CryptoDetail(
    val coinInfo: CryptoData,
    val marketChart: List<List<Double>>
)

data class CryptoData(
    val name: String,
    val image: CoinImage,
    val tickers: List<Ticket>,
    val description: Description

)

data class CoinImage(

    val large: String
)

data class Ticket(
    val target: String,
    val last: String
)

data class Description(
    val en: String
)

