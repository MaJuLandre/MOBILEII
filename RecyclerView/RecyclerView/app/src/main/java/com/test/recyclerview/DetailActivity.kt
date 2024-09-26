package com.test.recyclerview

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail) // Define o layout da Activity

        // Recupera os dados enviados pela Intent na MainActivity.
        // O ?: "Nome não disponível" é uma segurança para evitar valores nulos (caso os dados não sejam passados corretamente)
        val countryName = intent.getStringExtra("COUNTRY_NAME") ?: "Nome não disponível"
        val countryInfo = intent.getStringExtra("COUNTRY_INFO") ?: "Informações não disponíveis"

        // Localiza as TextViews no layout da DetailActivity (activity_detail.xml) pelos IDs
        val textViewName: TextView = findViewById(R.id.textViewCountryName)
        val textViewInfo: TextView = findViewById(R.id.textViewCountryInfo)

        // Atribui o nome do país e suas informações às TextViews para serem exibidas na tela
        textViewName.text = countryName
        textViewInfo.text = countryInfo
    }
}