package vectores

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VectoresTest {

    var miVector = IntArray(5)

    @BeforeEach
    fun setUp() {
        miVector = intArrayOf(5, 1, 4, 2, 2)
    }

    @Test
    fun inversoTest() {
        val vectorInverso = intArrayOf(2, 2, 4, 1, 5)
        assertArrayEquals(vectorInverso, inverso(miVector))
    }

    @Test
    fun ordenarAscedenteTest() {
        val vectorOrdenado = intArrayOf(1, 2, 2, 4, 5)
        assertArrayEquals(vectorOrdenado, ordenarAscedente(miVector))
    }

    @Test
    fun ordenarDescedenteTest() {
        val vectorOrdenado = intArrayOf(5, 4, 2, 2, 1)
        assertArrayEquals(vectorOrdenado, ordenarDescedente(miVector))
    }

    @Test
    fun buscarElementoTestExiste() {
        val elemento = 4
        val posicion = 2
        assertEquals(posicion, buscarElemento(miVector, elemento))
    }

    @Test
    fun buscarElementoTestNoExiste() {
        val elemento = -99
        val posicion = -1
        assertEquals(posicion, buscarElemento(miVector, elemento))
    }

    @Test
    fun isPalindromoTest() {
        val vectorPalindromo = intArrayOf(1, 2, 3, 2, 1)
        assertAll(
            { assertTrue(isPalindromo(vectorPalindromo)) },
            { assertFalse(isPalindromo(miVector)) }
        )
    }

    @Test
    fun sonIguales() {
        val vectorSon = intArrayOf(5, 1, 4, 2, 2)
        val vectorNoSon = intArrayOf(1, 2, 3, 2, 1, 1)
        assertAll(
            { assertTrue(sonIguales(miVector, vectorSon)) },
            { assertFalse(sonIguales(miVector, vectorNoSon)) }
        )
    }

}