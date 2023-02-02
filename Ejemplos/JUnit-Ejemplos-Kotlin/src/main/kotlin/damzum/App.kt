package damzum

fun main() {
    println("DamZum")
    println("======")
    do {
        val opcion = menuApp()
        when (opcion) {
            1 -> initRegistrarCuenta()
            2 -> initRecibirDinero()
            3 -> intEnviarDinero()
            4 -> initConsultarSaldo()
        }
    } while (opcion != 0)
    println()
    println("Hasta pronto")
}

fun initConsultarSaldo() {
    println()
    println("Consultar saldo")
    println("---------------")
    println("Introduce el email:")
    val email = readln()
    try {
        val saldo = consultarSaldo(email)
        println("El saldo es: $saldo")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        println()
    }
}


fun intEnviarDinero() {
    println()
    println("Enviar dinero")
    println("=============")
    println("Introduce el email del destinatario:")
    val emailDestino = readln()
    println("Introduce la cantidad a enviar:")
    val cantidad = readln()
    try {
        enviarDinero(emailDestino, cantidad)
        println("Dinero enviado correctamente")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        println()
    }
}

fun initRecibirDinero() {
    println()
    println("Recibir dinero")
    println("==============")
    println("Introduce el email del remitente:")
    val emailOrigen = readln()
    println("Introduce la cantidad a recibir:")
    val cantidad = readln()
    try {
        val resultado = recibirDinero(emailOrigen, cantidad)
        if (resultado) {
            println("Dinero recibido correctamente")
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        println()
    }
}

fun initRegistrarCuenta() {
    println("Registrar cuenta")
    println("===============")
    println("Introduce tu email:")
    val email = readln()
    println("Introduce la cantidad inicial:")
    val cantidad = readln()
    try {
        registrarCuenta(email, cantidad)
        println("Cuenta registrada correctamente")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        println()
    }
}

fun menuApp(): Int {
    do {
        println("1. Registrar cuenta")
        println("2. Recibir dinero")
        println("3. Enviar dinero")
        println("4. Consultar saldo")
        println("0. Salir")
        print("Opción: ")
        val opcion = readln()
        if (opcion in "0".."4") {
            return opcion.toInt()
        }
    } while (true)
}
