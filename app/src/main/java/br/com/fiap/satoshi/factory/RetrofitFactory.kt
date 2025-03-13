package br.com.fiap.satoshi.factory

import br.com.fiap.satoshi.service.CryptoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL: String = "https://criptomaniac-app.vercel.app/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCryptoService(): CryptoService{

        return retrofitFactory.create(CryptoService::class.java)

    }

}