package br.com.fiap.satoshi.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.satoshi.viewmodel.HomeViewModel

//class HomeViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return HomeViewModel(application) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
