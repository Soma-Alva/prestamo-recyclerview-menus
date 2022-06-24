package com.example.prestamo_final

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterPrestamo: RecyclerView.Adapter<AdapterPrestamo.ViewHolder>()  {

    val titles = datosPublicos.listaPrestamo

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AdapterPrestamo.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.prestamo_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: AdapterPrestamo.ViewHolder, i: Int) {
        val prestamo = datosPublicos.listaPrestamo[i]
        val persona = datosPublicos.listaPersona[i]
        viewHolder.item_title.text = persona.nombre
        viewHolder.itemMonto.text = prestamo.monto.toString()
        viewHolder.itemCuota.text = prestamo.cuoto.toString()
        viewHolder.itemImage.setImageResource(R.drawable.ic_person_24)
    }

    override fun getItemCount(): Int {
        return titles.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemImage: ImageView
        val itemMonto: TextView
        val itemCuota: TextView
        val item_title: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemMonto = itemView.findViewById(R.id.item_detal6)
            itemCuota = itemView.findViewById(R.id.item_detal7)
            item_title = itemView.findViewById(R.id.item_title)

        }
    }

}