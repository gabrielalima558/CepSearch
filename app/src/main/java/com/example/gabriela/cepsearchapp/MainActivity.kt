package com.example.gabriela.cepsearchapp

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.gabriela.cepsearchapp.viewmodel.CepViewModel
import com.example.gabriela.cepsearchapp.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private val viewModel: CepViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(CepViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.searchCep("06086070")
    }
}
