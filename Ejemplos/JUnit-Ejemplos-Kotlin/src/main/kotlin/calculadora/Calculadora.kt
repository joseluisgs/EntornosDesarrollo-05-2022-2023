package calculadora

fun sumar(a: Int, b: Int): Int {
    return a + b
}

fun restar(a: Int, b: Int): Int {
    return a - b
}

fun multiplicar(a: Int, b: Int): Int {
    return a * b
}

fun dividir(a: Int, b: Int): Int {
    if (b == 0) {
        throw ArithmeticException("No se puede dividir $a / 0")
    }
    return a / b
}

fun isPar(a: Int): Boolean {
    return a % 2 == 0
}

fun isImpar(a: Int): Boolean {
    return a % 2 != 0
}

fun isPrimo(a: Int): Boolean {
    if (a <= 1) {
        return false
    }
    if (a == 2) {
        return true
    }
    if (a % 2 == 0) {
        return false
    }

    for (i in 3..a / 2 step 2) {
        if (a % i == 0) {
            return false
        }
    }
    return true
}

fun factorial(a: Int): Int {
    if (a == 0) {
        return 1
    }
    return a * factorial(a - 1)
}
