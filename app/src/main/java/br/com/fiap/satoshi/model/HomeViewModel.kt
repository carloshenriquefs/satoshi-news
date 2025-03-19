package br.com.fiap.satoshi.viewmodel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.fiap.satoshi.factory.RetrofitFactory
import br.com.fiap.satoshi.model.CryptoProfitable
import br.com.fiap.satoshi.model.CryptoSustainable
import br.com.fiap.satoshi.model.DataProfitable
import br.com.fiap.satoshi.model.DataSustainable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel() : ViewModel() {

    private val mockCryptoTopThree = listOf(
        CryptoProfitable("eos", "eos", "EOS", "https://coin-images.coingecko.com/coins/images/738/large/CG_EOS_Icon.png?1731705232", 0.655193, 32.70716),
        CryptoProfitable("maker", "mkr", "Maker", "https://coin-images.coingecko.com/coins/images/1364/large/Mark_Maker.png?1696502423", 1316.36, 11.06352),
        CryptoProfitable("tron", "trx", "TRON", "https://coin-images.coingecko.com/coins/images/1094/large/tron-logo.png?1696502193", 0.242276, 9.85609)
    )

    private val mockCryptoSustainable = listOf(
        CryptoSustainable("algorand", "algo", "Algorand", "https://coin-images.coingecko.com/coins/images/4380/large/download.png?1696504978",90, 0.186485, 1586965642),
        CryptoSustainable("bitcoin", "btc", "Bitcoin", "https://coin-images.coingecko.com/coins/images/1/large/bitcoin.png?1696501400", 10, 82847.0, 1641054865495),
        CryptoSustainable("ethereum", "eth", "Ethereum", "https://coin-images.coingecko.com/coins/images/279/large/ethereum.png?1696501628", 70, 1938.09, 233047080514),
        CryptoSustainable("cardano", "ada", "Cardano", "https://coin-images.coingecko.com/coins/images/975/large/cardano.png?1696502090", 85, 0.70472, 25246987540)
    )

    var cryptoTopThree = mutableStateOf<List<CryptoProfitable>>(mockCryptoTopThree)
        private set

    var cryptoSustainable = mutableStateOf<List<CryptoSustainable>>(mockCryptoSustainable)
        private set

    var isLoading = mutableStateOf(true)
        private set

    var authError = mutableStateOf(false)
        private set

    fun loadCryptoData() {
        isLoading.value = true

        val getCryptoTopThree = RetrofitFactory()
            .getCryptoService()
            .getTopProfitable(token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2N2M0ZWRmN2UyZDFlZGJiNjE0MWQ0MjgiLCJpYXQiOjE3NDIzNTIyMDIsImV4cCI6MTc0Mjk1NzAwMn0.YS0CbsyVBP_6qnL9DVzUVdcPxemNtjH5dnVxUUOrArQ")

        val getCryptoSustainable = RetrofitFactory()
            .getCryptoService()
            .getTopSustainable(token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2N2M0ZWRmN2UyZDFlZGJiNjE0MWQ0MjgiLCJpYXQiOjE3NDIzNTIyMDIsImV4cCI6MTc0Mjk1NzAwMn0.YS0CbsyVBP_6qnL9DVzUVdcPxemNtjH5dnVxUUOrArQ")


        getCryptoTopThree.enqueue(object : Callback<DataProfitable> {
            override fun onResponse(p0: Call<DataProfitable>, resultado: Response<DataProfitable>) {

                if (resultado.body() == null)
                if (resultado.code() == 401) authError.value = true
                cryptoTopThree.value = resultado.body()?.data ?: mockCryptoTopThree
                isLoading.value = false
            }

            override fun onFailure(p0: Call<DataProfitable>, p1: Throwable) {
                Log.e("FIAP", "Error Cima: ${p1.cause}")
                cryptoTopThree.value = mockCryptoTopThree
                isLoading.value = false
            }
        })

        getCryptoSustainable.enqueue(object : Callback<DataSustainable> {
            override fun onResponse(
                p0: Call<DataSustainable>,
                resultado: Response<DataSustainable>
            ) {
                Log.i("TESTE","BATEUBAIXO")
                if (resultado.code() == 401) authError.value = true
                cryptoSustainable.value = resultado.body()?.data ?: mockCryptoSustainable
                isLoading.value = false
            }

            override fun onFailure(p0: Call<DataSustainable>, p1: Throwable) {
                Log.e("FIAP", "Error Baixo: ${p1.cause}")
                cryptoSustainable.value = mockCryptoSustainable
                isLoading.value = false
            }
        })

    }
}
