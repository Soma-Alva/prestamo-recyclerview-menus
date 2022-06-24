package com.example.prestamo_final

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.prestamo_final.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
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

        validando()
    }

    fun validando() {
        binding.buttonAct.setOnClickListener {
            if (binding.editTextNombre.text.toString().isEmpty()
                || binding.editTextApellido.text.toString().isEmpty()
                || binding.editTextTelefono.text.toString().isEmpty()
                || binding.editTextCedula.text.toString().isEmpty()
                || binding.editTextOcupacion.text.toString().isEmpty()
                || binding.editTextDireccion.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Hay campos que no estan llenos", Toast.LENGTH_LONG).show()
            } else {
                datosPublicos.listaPersona.add(
                    persona(
                        binding.editTextNombre.text.toString(),
                        binding.editTextApellido.text.toString(),
                        binding.spinnerSexo.selectedItem.toString(),
                        binding.editTextTelefono.text.toString().toInt(),
                        binding.editTextCedula.text.toString(),
                        binding.editTextOcupacion.text.toString(),
                        binding.editTextDireccion.text.toString()
                    )
                )
                finish()
                Toast.makeText(this, "Cliente Guardado", Toast.LENGTH_LONG).show()
            }
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




