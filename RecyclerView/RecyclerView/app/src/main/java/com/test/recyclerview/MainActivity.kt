package com.test.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Dados a serem exibidos no RecyclerView
        val countries = listOf("Brasil", "Estados Unidos", "França", "Alemanha", "Japão")

        // Informações básicas sobre cada país. Mapeia o nome do país com suas informações.
        val countryInfo = mapOf(
            "Brasil" to "Capital: Brasília\nPopulação: 213 milhões\nContinente: América do Sul",
            "Estados Unidos" to "Capital: Washington, D.C.\nPopulação: 331 milhões\nContinente: América do Norte",
            "França" to "Capital: Paris\nPopulação: 67 milhões\nContinente: Europa",
            "Alemanha" to "Capital: Berlim\nPopulação: 83 milhões\nContinente: Europa",
            "Japão" to "Capital: Tóquio\nPopulação: 125 milhões\nContinente: Ásia"
        )

        // Inicializar o RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Configurar o LayoutManager (lista vertical)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configurar o Adapter, passando a lista de países e as informações de cada país
        recyclerView.adapter = MyAdapter(countries, countryInfo)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}