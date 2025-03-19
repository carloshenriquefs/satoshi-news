package br.com.fiap.satoshi.model

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.satoshi.service.CryptoService
import br.com.fiap.satoshi.utils.UserPreferences
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginViewModel(context: Context) : ViewModel() {

    private val userPreferences = UserPreferences(context)

    private val cryptoService: CryptoService = Retrofit.Builder()
        .baseUrl("https://criptomaniac-app.vercel.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptoService::class.java)

    fun login(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(email, password)
                val token =
                    cryptoService.logIn(loginRequest)
                userPreferences.saveAuthToken(token.toString())
                onSuccess()
            } catch (e: Exception) {
                onError(e.message ?: "Login failed")
            }
        }
    }

    fun getToken(): String? {
        return userPreferences.getAuthToken()
    }
}