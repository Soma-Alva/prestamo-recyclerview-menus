package com.example.prestamo_final

import android.app.AlertDialog
import android.content.Intent
import android.graphics.drawable.Icon
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val titles = datosPublicos.listaPersona

    private lateinit var mListener: OnPersonClick

    interface OnPersonClick {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnPersonClick) {
        mListener = listener
    }

    fun removeItem(position: Int) {
        titles.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, titles.size)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v, mListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val per = datosPublicos.listaPersona[i]
        viewHolder.itemTitle.text = per.nombre
        viewHolder.itemCedula.text = per.cedula
        viewHolder.itemDireccion.text = per.direccion
        viewHolder.itemTelefono.text = per.telefono.toString()
        viewHolder.itemImage.setImageResource(R.drawable.ic_person_24)
        viewHolder.btnDelete.setOnClickListener {
            //create a dialog to confirm the delete
            val dialogBuilder = AlertDialog.Builder(viewHolder.itemView.context)
            dialogBuilder.setMessage("¿Está seguro de eliminar a ${per.nombre}?")
            dialogBuilder.setPositiveButton("Eliminar") { _, _ ->
                removeItem(i)
                Toast.makeText(viewHolder.itemView.context, "Cliente eliminado", Toast.LENGTH_SHORT).show()
            }
            dialogBuilder.setNegativeButton("Cancelar") { _, _ ->
                Toast.makeText(viewHolder.itemView.context, "Cancelado", Toast.LENGTH_SHORT).show()
            }
            val alert = dialogBuilder.create()
            alert.show()
        }

        viewHolder.btnEdit.setOnClickListener {
            val intent = Intent(viewHolder.itemView.context, MainActivity6::class.java)
            datosPublicos.posicionSelect = i
            viewHolder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View, listener: OnPersonClick) :
        RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView
        val itemTitle: TextView
        val itemTelefono: TextView
        val itemCedula: TextView
        val itemDireccion: TextView
        val btnDelete: Button = itemView.findViewById(R.id.borrar)
        val btnEdit: Button = itemView.findViewById(R.id.editar)

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemTelefono = itemView.findViewById(R.id.item_detal5)
            itemCedula = itemView.findViewById(R.id.item_detal6)
            itemDireccion = itemView.findViewById(R.id.item_detal7)

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}