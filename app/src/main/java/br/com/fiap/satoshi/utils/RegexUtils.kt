package br.com.fiap.satoshi.utils

object RegexUtils {
    val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)\$".toRegex()
    val passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$".toRegex()

    fun isValidEmail(email: String): Boolean {
        return email.matches(emailRegex)
    }

    fun isValidPassword(password: String): Boolean {
        return password.matches(passwordRegex)
    }
}
