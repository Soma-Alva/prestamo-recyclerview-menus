package com.example.prestamo_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_cliente) {
            val lanzar = Intent(this, MainActivity2::class.java)
            startActivity(lanzar)
            Toast.makeText(this,"Formulario del cliente",Toast.LENGTH_SHORT).show()
        }
        if(item.itemId==R.id.menu_verCliente) {
            val l = Intent(this, MainActivity3::class.java)
            startActivity(l)
            Toast.makeText(this,"Clientes Registrados",Toast.LENGTH_SHORT).show()
        }
        if(item.itemId==R.id.menu_prestamo) {
            val l = Intent(this, MainActivity5::class.java)
            startActivity(l)
            Toast.makeText(this,"Lista de prestamos",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}