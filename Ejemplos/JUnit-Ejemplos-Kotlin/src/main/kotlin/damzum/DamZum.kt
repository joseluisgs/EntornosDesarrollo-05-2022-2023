package damzum

import kotlin.math.roundToInt

private var deposito = 0.0
private var email = ""


/***************
 * 1. Cuenta
 ***************/
fun registrarCuenta(emailRegistro: String, cantidadInicial: String = "0.0"): Boolean {
    // Preparación de entradas
    require(isEmailValido(emailRegistro)) { "El email no es válido" }
    require(isDoubleValido(cantidadInicial)) { "La debe ser un un numero decimal válido mayor a 0" }
    val cant = getDouble(cantidadInicial)
    require(getDouble(cantidadInicial) >= 0) { "La cantidad inicial debe ser mayor o igual a 0" }

    email = emailRegistro
    deposito = cant
    return true
}

fun recibirDinero(emailOrigen: String, cantidad: String): Boolean {
    require(isDoubleValido(cantidad)) { "La debe ser un un numero decimal válido mayor a 0" }
    require(isEmailValido(emailOrigen)) { "El email no es válido" }
    val cant = getDouble(cantidad)
    require(cant in 0.5..500.0) { "La cantidad debe ser mayor o igual a 0.5 y menor o igual a 500" }

    deposito += cant
    return true
}

fun enviarDinero(emailDestino: String, cantidad: String): Boolean {
    require(isDoubleValido(cantidad)) { "La debe ser un un numero decimal válido mayor a 0" }
    val cant = getDouble(cantidad)
    require(cant <= deposito) { "La cantidad a enviar debe ser menor o igual a $deposito" }
    require(isEmailValido(emailDestino)) { "El email no es válido" }
    require(cant in 0.5..500.0) { "La cantidad debe ser mayor o igual a 0.5 y menor o igual a 500" }

    deposito -= cant
    return true
}

fun isEmailValido(email: String): Boolean {
    val rgexEmail = """[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}""".toRegex()
    return rgexEmail.matches(email)
}

fun isDoubleValido(cantidad: String): Boolean {
    val rgexDouble = """[0-9]+(\.[0-9]{1,2})?""".toRegex()
    return rgexDouble.matches(cantidad)
}

fun getDouble(cantidad: String): Double {
    return (cantidad.toDouble() * 100).roundToInt() / 100.0
}

fun consultarSaldo(email: String): Double {
    require(isEmailValido(email)) { "El email no es válido" }
    return deposito
}
