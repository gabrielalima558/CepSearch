package com.example.gabriela.cepsearchapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gabriela.cepsearchapp.model.Address
import com.example.gabriela.cepsearchapp.viewmodel.CepViewModel
import com.example.gabriela.cepsearchapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var itens: Address
    private val viewModel: CepViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(CepViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSearch.setOnClickListener {
            viewModel.searchCep(editTextCep.text.toString())
            viewModel.infoAddress().observe(this, Observer { list ->
                list?.let {
                    itens = list
                    Log.e("TESTANDO", itens.cep)
                    textView.text =itens.logradouro
                }
            })
        }


    }
}
