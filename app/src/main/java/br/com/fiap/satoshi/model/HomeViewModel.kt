package br.com.fiap.satoshi.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import br.com.fiap.satoshi.factory.RetrofitFactory
import br.com.fiap.satoshi.model.CryptoProfitable
import br.com.fiap.satoshi.model.CryptoSustainable
import br.com.fiap.satoshi.model.DataProfitable
import br.com.fiap.satoshi.model.DataSustainable
import br.com.fiap.satoshi.utils.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeViewModel (application: Application) : AndroidViewModel(application) {

    private val userPreferences = UserPreferences(application.applicationContext)

    var cryptoTopThree = mutableStateOf<List<CryptoProfitable>>(emptyList())
        private set

    var cryptoSustainable = mutableStateOf<List<CryptoSustainable>>(emptyList())
        private set

    var isLoading = mutableStateOf(true)
        private set

    var authError = mutableStateOf(false)
        private set

    fun loadCryptoData() {
        isLoading.value = true

//        val token = userPreferences.getAuthToken()
//
//        if (token.isNullOrEmpty()) {
//            authError.value = true
//            isLoading.value = false
//            return
//        }

        //val autHeader = "Bearer $token"

        val getCryptoTopThree = RetrofitFactory()
            .getCryptoService()
            .getTopProfitable(token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2N2M0ZWRmN2UyZDFlZGJiNjE0MWQ0MjgiLCJpYXQiOjE3NDIzNDEwMjgsImV4cCI6MTc0MjM0NDYyOH0.2EjIYkloRj-kFcvL1mJf6wsxuIAAOeJRgSmFwMSreBg")

        val getCryptoSustainable = RetrofitFactory()
            .getCryptoService()
            .getTopSustainable(token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2N2M0ZWRmN2UyZDFlZGJiNjE0MWQ0MjgiLCJpYXQiOjE3NDIzNDEwMjgsImV4cCI6MTc0MjM0NDYyOH0.2EjIYkloRj-kFcvL1mJf6wsxuIAAOeJRgSmFwMSreBg")

        getCryptoTopThree.enqueue(object : Callback<DataProfitable> {
            override fun onResponse(p0: Call<DataProfitable>, resultado: Response<DataProfitable>) {
                if (resultado.code() == 401) authError.value = true
                cryptoTopThree.value = resultado.body()?.data ?: emptyList()
                isLoading.value = false
            }

            override fun onFailure(p0: Call<DataProfitable>, p1: Throwable) {
                isLoading.value = false
            }
        })

        getCryptoSustainable.enqueue(object : Callback<DataSustainable> {
            override fun onResponse(
                p0: Call<DataSustainable>,
                resultado: Response<DataSustainable>
            ) {
                if (resultado.code() == 401) authError.value = true
                cryptoSustainable.value = resultado.body()?.data ?: emptyList()
                isLoading.value = false
            }

            override fun onFailure(p0: Call<DataSustainable>, p1: Throwable) {
                isLoading.value = false
            }
        })
    }
}
