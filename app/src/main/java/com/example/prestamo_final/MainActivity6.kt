package com.example.prestamo_final

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.prestamo_final.databinding.ActivityMain2Binding
import com.example.prestamo_final.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {
    private lateinit var binding: ActivityMain6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner: Spinner = binding.spinnerSexo
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.sexo,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        val posicion = datosPublicos.posicionSelect

        val nombre = datosPublicos.listaPersona[posicion].nombre
        val apellido = datosPublicos.listaPersona[posicion].apellido
        val cedula = datosPublicos.listaPersona[posicion].cedula
        val direccion = datosPublicos.listaPersona[posicion].direccion
        val telefono = datosPublicos.listaPersona[posicion].telefono
        val ocupacion = datosPublicos.listaPersona[posicion].ocupacion

        binding.editTextNombre.setText(nombre)
        binding.editTextApellido.setText(apellido)
        binding.editTextCedula.setText(cedula)
        binding.editTextDireccion.setText(direccion)
        binding.editTextTelefono.setText(telefono.toString().toInt().toString())
        binding.editTextOcupacion.setText(ocupacion)
        //binding.spinnerSexo.setSelection(datosPublicos.listaPersona[posicion].sexo.toInt())
        validando()
    }

    fun validando(){
        binding.buttonAct.setOnClickListener {
            if(binding.editTextNombre.text.toString().isEmpty()
                || binding.editTextApellido.text.toString().isEmpty()
                || binding.editTextTelefono.text.toString().isEmpty()
                || binding.editTextCedula.text.toString().isEmpty()
                || binding.editTextOcupacion.text.toString().isEmpty()
                || binding.editTextDireccion.text.toString().isEmpty()
            ){
                Toast.makeText(this, "Hay campos que no estan llenos", Toast.LENGTH_LONG).show()
            }else{
                val posicion = datosPublicos.posicionSelect
                val personaEditada =
                    persona(binding.editTextNombre.text.toString(), binding.editTextApellido.text.toString(), binding.spinnerSexo.selectedItem.toString(), binding.editTextTelefono.text.toString().toInt(), binding.editTextCedula.text.toString(), binding.editTextOcupacion.text.toString(), binding.editTextDireccion.text.toString())

                datosPublicos.listaPersona[posicion] = personaEditada
                finish()
                Toast.makeText(this, "Cliente Actualizado", Toast.LENGTH_SHORT).show()

                MainActivity3.updateAdapter()
            }
        }
    }
    class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
            val spinner: Spinner = findViewById(R.id.spinnerSexo)
            spinner.onItemSelectedListener = this
        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }
    }
}
