package com.test.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// O Adapter é responsável por adaptar os dados e "inflar" os layouts no RecyclerView
class MyAdapter(private val items: List<String>, private val countryInfo: Map<String, String>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // A ViewHolder é responsável por "guardar" as referências das views para cada item da lista
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.item_text)
    }

    // Inflar o layout para cada item da lista. Esse método é chamado sempre que um novo item é exibido.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // "Inflar" o layout XML (item_list.xml) e criar um ViewHolder
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    // "Bind" (associar) os dados a cada item da lista. Aqui os dados do país são inseridos no TextView.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Nome do país para o item atual
        val countryName = items[position]
        holder.textView.text = countryName

        // Definir um clique para cada item da lista
        holder.itemView.setOnClickListener {
            // Recupera o contexto da view para iniciar a nova Activity
            val context = holder.itemView.context
            // Cria uma Intent para abrir a DetailActivity
            val intent = Intent(context, DetailActivity::class.java)
            // Passar o nome do país e suas informações através da Intent
            intent.putExtra("COUNTRY_NAME", countryName)
            intent.putExtra("COUNTRY_INFO", countryInfo[countryName])
            // Iniciar a nova Activity
            context.startActivity(intent)
        }
    }

    // Retornar a quantidade de itens da lista. Isso ajuda o RecyclerView a saber quantos itens ele deve exibir.
    override fun getItemCount() = items.size
}