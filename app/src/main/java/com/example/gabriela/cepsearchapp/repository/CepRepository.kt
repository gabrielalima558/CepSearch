package com.example.gabriela.cepsearchapp.repository

import android.arch.lifecycle.MutableLiveData
import com.example.gabriela.cepsearchapp.api.CepApi
import com.example.gabriela.cepsearchapp.model.Address

class CepRepository(private val api: CepApi) {

    val addressData = MutableLiveData<Address>()

    fun searchCep(cep: String) = api.getAddress(cep){ data ->
        addressData.postValue(data)
    }
}