package com.example.prestamo_final

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
import java.text.SimpleDateFormat
import java.util.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        // MIS VARAIBLES
        // val temp = plazoTXT.setText("12")
        //val plazoTexto = plazoTXT.text
        // val plazo = plazoTexto.toInt()
        val plazoTXT: EditText = findViewById(R.id.editTextPlazo)
        val spinner: Spinner = findViewById(R.id.spinner2) // interes
        val montoTXT: EditText = findViewById(R.id.editTextMonto)

        val textFechaActual: EditText = findViewById(R.id.editTextDate)
        val textFechaFin: EditText = findViewById(R.id.editTextDate2)

        //calcularMonto(10000, 20, 10)

        plazoTXT.addTextChangedListener {
            if(plazoTXT.text.toString().isEmpty() || montoTXT.text.toString().isEmpty()){

            }else{
                val plazoTexto = plazoTXT.text.toString()
                val plazo = plazoTexto.toInt()

                val spinnerTexto = spinner.selectedItem.toString()
                val interes = spinnerTexto.toFloat() / 100

                val montoTexto = montoTXT.text.toString()
                val monto = montoTexto.toInt()

                val sdf = SimpleDateFormat("dd/M/yyyy")
                val currentDate = sdf.format(Date())
                val fecha: Date = sdf.parse(currentDate)
                sumarMes(fecha, plazo)
                calcularMonto(monto, interes, plazo)
            }
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                if(plazoTXT.text.toString().isEmpty() || montoTXT.text.toString().isEmpty()){

                }else{
                    val plazoTexto = plazoTXT.text.toString()
                    val plazo = plazoTexto.toInt()

                    val spinnerTexto = spinner.selectedItem.toString()
                    val interes = spinnerTexto.toFloat() / 100

                    val montoTexto = montoTXT.text.toString()
                    val monto = montoTexto.toInt()

                    val sdf = SimpleDateFormat("dd/M/yyyy")
                    val currentDate = sdf.format(Date())
                    val fecha: Date = sdf.parse(currentDate)
                    sumarMes(fecha, plazo)
                    calcularMonto(monto, interes, plazo)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        textFechaActual.setText(currentDate)

        //textFechaFinal.setText(fecha.toString())
        //========fin fecha============
        //val spinner: Spinner = findViewById(R.id.spinner2)

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.interes,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_secundario, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.cancelar) {
            finish()
        }
        if(item.itemId==R.id.check) {
            //guardar datos
            val cuotas: TextView = findViewById(R.id.textView20)
            val montoTotal: TextView = findViewById(R.id.textView19)

            datosPublicos.listaPrestamo.add(prestamo(montoTotal.text.toString().toFloat(),cuotas.text.toString().toInt()))
            Toast.makeText(this, "Guardado", Toast.LENGTH_LONG).show()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
            val spinner: Spinner = findViewById(R.id.spinner2)
            spinner.onItemSelectedListener = this
        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }
    }
    fun sumarMes(fecha: Date?, meses: Int): Date? {
        val calendar = Calendar.getInstance()
        calendar.time = fecha // Configuramos la fecha que se recibe
        calendar.add(Calendar.MONTH, meses) // numero de horas a añadir, o restar en caso de horas<0
        val textFechaFinal: EditText = findViewById(R.id.editTextDate2)


        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(calendar.getTime())
        textFechaFinal.setText(currentDate)

        return calendar.getTime()
    }

    fun calcularMonto(monto: Int, interes: Float, plazo: Int){
        /*
        formula
        (10000 * 0.20) + monto = cuanto va pagar de mas
        cuanto va pagar de mas / plazo = esto saca la cuota
        */
        val imprimirMonto: TextView = findViewById(R.id.textView19)
        val imprimirCuota: TextView = findViewById(R.id.textView20)

        val ganancia = monto * interes
        val pago = ganancia + monto
        val cuota = pago / plazo

        imprimirMonto.setText(pago.toString())
        imprimirCuota.setText(cuota.toInt().toString())
    }

}