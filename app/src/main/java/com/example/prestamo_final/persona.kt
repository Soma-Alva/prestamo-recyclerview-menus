package com.example.prestamo_final

class persona {

    var nombre: String = ""
    var telefono: Int = 0
    var apellido: String = ""
    var sexo: String = ""
    var cedula: String = ""
    var ocupacion: String = ""
    var direccion: String = ""

    constructor(
        nombre: String,
        apellido: String,
        sexo: String,
        telefono: Int,
        cedula: String,
        ocupacion: String,
        direccion: String
    ) {
        this.nombre = nombre
        this.apellido = apellido
        this.sexo = sexo
        this.telefono = telefono
        this.cedula = cedula
        this.ocupacion = ocupacion
        this.direccion = direccion
    }
}