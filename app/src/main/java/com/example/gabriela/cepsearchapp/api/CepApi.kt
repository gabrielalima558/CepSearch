package com.example.gabriela.cepsearchapp.api

import android.util.Log
import com.example.gabriela.cepsearchapp.model.Address
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CepApi(retrofit: Retrofit) {

    private val service: CepService by lazy {
        retrofit.create(CepService::class.java)
    }


    fun getAddress(cep: String, callback: (Address) -> Unit ){
        val searchCep = service.getAddress(cep)

        searchCep.enqueue(object: Callback<Address>{
            override fun onFailure(call: Call<Address>, t: Throwable) {
                Log.e("erro", t.message)
            }

            override fun onResponse(call: Call<Address>, response: Response<Address>) {
                response.body()?.let(callback)
                Log.e("code", response.code().toString())
            }
        })

    }

}