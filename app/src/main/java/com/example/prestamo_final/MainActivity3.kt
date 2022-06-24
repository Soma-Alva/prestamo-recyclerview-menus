package com.example.prestamo_final

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
       // val adapter = CustomAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : CustomAdapter.OnPersonClick{
            override fun onItemClick(position: Int) {
                val lanzar = Intent(getApplicationContext(), AgregarPrestamo::class.java)
                startActivity(lanzar)
                Toast.makeText(getApplicationContext(), "Registro del cliente", Toast.LENGTH_LONG).show()
            }
        })
    }
    companion object {
        val adapter = CustomAdapter()

        fun updateAdapter(){
            adapter.notifyDataSetChanged()
        }
    }
}