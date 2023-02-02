package dni

fun esDNIValido(dni: String): Boolean {
    // Comprobamos las entradas
    val regex = """[0-9]{8}[A-Z]""".toRegex()
    require(regex.matches(dni)) { "El DNI debe tener 8 números y letra en mayúscula" }

    // diccionario de letras
    val letras = "TRWAGMYFPDXBNJZSQVHLCKE"
    val numero = dni.substring(0, 8).toInt()
    val letra = dni.last()
    val index = numero % 23

    return letra == letras[index]
}