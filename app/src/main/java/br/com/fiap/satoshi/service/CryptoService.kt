package br.com.fiap.satoshi.service

import br.com.fiap.satoshi.model.AlertsResult
import br.com.fiap.satoshi.model.CryptoSustainable
import br.com.fiap.satoshi.model.DataProfitable
import br.com.fiap.satoshi.model.DataSustainable
import br.com.fiap.satoshi.model.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface CryptoService {

    @POST("/auth/login")
    fun logIn(@Body cryptoLogin: LoginRequest): String

    @GET("/crypto/top-profitable")
    fun getTopProfitable(@Header("Authorization") token: String): Call<DataProfitable>

    @GET("/crypto/top-sustainable")
    fun getTopSustainable(@Header("Authorization") token: String): Call<DataSustainable>

    @GET("alerts")
    fun getAllAlerts(): Call<AlertsResult>

    @GET("conversion")
    fun getAllConversion(): Call<CryptoSustainable>

}