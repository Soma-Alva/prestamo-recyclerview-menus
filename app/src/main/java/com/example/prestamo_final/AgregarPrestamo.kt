package com.example.prestamo_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.prestamo_final.databinding.ActivityAgregarPrestamoBinding

class AgregarPrestamo : AppCompatActivity() {
    private lateinit var binding: ActivityAgregarPrestamoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarPrestamoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val posicion = datosPublicos.posicionSelect

        val nombre = datosPublicos.listaPersona[posicion].nombre
        val apellido = datosPublicos.listaPersona[posicion].apellido
        val cedula = datosPublicos.listaPersona[posicion].cedula
        val direccion = datosPublicos.listaPersona[posicion].direccion
        val telefono = datosPublicos.listaPersona[posicion].telefono
        val ocupacion = datosPublicos.listaPersona[posicion].ocupacion

        binding.textViewNombre2.setText(nombre)
        binding.textViewApellido2.setText(apellido)
        binding.textViewCedula2.setText(cedula)
        binding.textViewDireccion2.setText(direccion)
        binding.textViewTelefono2.setText(telefono.toString().toInt().toString())
        binding.textViewOcupacion2.setText(ocupacion)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_agregar_prestamo, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.agregar_prestamo) {
            val lanzar = Intent(this, MainActivity4::class.java)
            startActivity(lanzar)
            Toast.makeText(this,"Formulario del prestamo", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}