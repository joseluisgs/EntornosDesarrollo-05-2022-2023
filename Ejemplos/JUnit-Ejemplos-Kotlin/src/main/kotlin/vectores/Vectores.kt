package vectores

fun sonIguales(origen: IntArray, destino: IntArray): Boolean {
    if (origen.size != destino.size) {
        return false
    }
    for (i in origen.indices) {
        if (origen[i] != destino[i]) {
            return false
        }
    }
    return true
}

fun inverso(vector: IntArray): IntArray {
    val vectorInverso = IntArray(vector.size)
    for (i in vector.indices) {
        vectorInverso[i] = vector[vector.size - 1 - i]
    }
    return vectorInverso
}

fun ordenarAscedente(vector: IntArray): IntArray {
    val vectorOrdenado = vector.copyOf()
    for (i in vectorOrdenado.indices) {
        for (j in i + 1 until vectorOrdenado.size) {
            if (vectorOrdenado[i] > vectorOrdenado[j]) {
                val aux = vectorOrdenado[i]
                vectorOrdenado[i] = vectorOrdenado[j]
                vectorOrdenado[j] = aux
            }
        }
    }
    return vectorOrdenado
}

fun ordenarDescedente(vector: IntArray): IntArray {
    val vectorOrdenado = vector.copyOf()
    for (i in vectorOrdenado.indices) {
        for (j in i + 1 until vectorOrdenado.size) {
            if (vectorOrdenado[i] < vectorOrdenado[j]) {
                val aux = vectorOrdenado[i]
                vectorOrdenado[i] = vectorOrdenado[j]
                vectorOrdenado[j] = aux
            }
        }
    }
    return vectorOrdenado
}

fun buscarElemento(vector: IntArray, elemento: Int): Int {
    for (i in vector.indices) {
        if (vector[i] == elemento) {
            return i
        }
    }
    return -1
}

fun isPalindromo(vector: IntArray): Boolean {
    /*for (i in vector.indices) {
        if (vector[i] != vector[vector.size - 1 - i]) {
            return false
        }
    }
    return true*/
    return sonIguales(vector, inverso(vector))
}
