package br.com.fiap.satoshi.service

import br.com.fiap.satoshi.model.CryptoDetail
import br.com.fiap.satoshi.model.LoginRequest
import br.com.fiap.satoshi.model.DataProfitable
import br.com.fiap.satoshi.model.DataSustainable
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
    fun getTopProfitable(@Header("Authorization") token: String): Call<DataProfitable>

    @GET("/crypto/top-sustainable")
    fun getTopSustainable(@Header("Authorization") token: String): Call<DataSustainable>

    @GET("/crypto/detail")
    fun getDetail(@Header("Authorization") token: String, @Query("coinId") coinId: String): Call<CryptoDetail>

}