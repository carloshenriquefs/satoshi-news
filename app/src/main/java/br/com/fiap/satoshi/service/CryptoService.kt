package br.com.fiap.satoshi.service

import br.com.fiap.satoshi.model.AlertsResult
import br.com.fiap.satoshi.model.CryptoDetail
import br.com.fiap.satoshi.model.CryptoSustainable
import br.com.fiap.satoshi.model.DataNewsLetter
import br.com.fiap.satoshi.model.DataProfitable
import br.com.fiap.satoshi.model.DataSustainable
import br.com.fiap.satoshi.model.LoginRequest
import br.com.fiap.satoshi.model.Newsletter
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface CryptoService {

    @POST("/auth/login")
    fun logIn(@Body cryptoLogin: LoginRequest): String

    @GET("/crypto/top-profitable?take=3")
    fun getTopProfitable(): Call<DataProfitable>

    @GET("/crypto/top-sustainable")
    fun getTopSustainable(): Call<DataSustainable>

    @GET("/crypto/detail")
    fun getDetail(@Query("coinId") coinId: String): Call<CryptoDetail>

    @GET("alerts")
    fun getAllAlerts(): Call<AlertsResult>

    @GET("/posts?limit=2")
    fun getPost(): Call<DataNewsLetter>

    @GET("conversion")
    fun getAllConversion(): Call<CryptoSustainable>
}