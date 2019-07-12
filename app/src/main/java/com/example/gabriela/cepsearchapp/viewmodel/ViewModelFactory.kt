package com.example.gabriela.cepsearchapp.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.gabriela.cepsearchapp.api.CepApi
import com.example.gabriela.cepsearchapp.api.InicializadorDoRetrofit
import com.example.gabriela.cepsearchapp.repository.CepRepository

object ViewModelFactory: ViewModelProvider.NewInstanceFactory() {

    private val retrofit = InicializadorDoRetrofit.retrofit

    private val cepApi = CepApi(retrofit)

    private val cepRepository = CepRepository(cepApi)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CepViewModel(cepRepository) as T
    }
}