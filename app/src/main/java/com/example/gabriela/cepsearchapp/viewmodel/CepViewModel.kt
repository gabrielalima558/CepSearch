package com.example.gabriela.cepsearchapp.viewmodel

import android.arch.lifecycle.ViewModel
import com.example.gabriela.cepsearchapp.repository.CepRepository

class CepViewModel(private val repository: CepRepository): ViewModel() {

    fun searchCep(cep: String) = repository.searchCep(cep)

    fun infoAddress() = repository.addressData
}