package br.com.fiap.satoshi.model

data class CryptoDetail(
    val coinInfo: CryptoData
)

data class CryptoData(
    val name: String,
    val image: CoinImage,
    val tickers: List<Ticket>,
    //val marketChart: List<Pair<Long, Int>>,
    val marketChart: List<MarketChart>?,
    val description: Description

)

data class MarketChart (

    val timestamp:Long,
    val price: Double


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

