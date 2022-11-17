package calculadora

import org.junit.jupiter.api.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue


// Ordena los test por orden puesto
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
// Para que no se instancie la clase por cada test // BeforeAll y AfterAll
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculadoraTest {

    @BeforeAll
    fun setUpSuite() {
        println("Iniciando la suite de test")
    }

    @AfterAll
    fun tearDownSuite() {
        println("Finalizando la suite de test")
    }

    // quiero hacer algo antes de cada test
    @BeforeEach
    fun setUpTest() {
        println("Antes de cada test")
    }

    // quiero hacer algo despues de cada test
    @AfterEach
    fun tearDownTest() {
        println("Despues de cada test")
    }

    @Test
    fun sumarTest() {
        // comparar valor devuleto, con valor esperado
        assert(sumar(1, 1) == 2)
        assertTrue(sumar(1, 1) == 2)
        // Este es el que más me gusta porque aporta más información si falla
        assertEquals(2, sumar(1, 1))
    }

    @Test
    @Order(1) // Fijamos un orden de ejecución
    fun restarTest() {
        // comparar valor esperado, con valor devuelto

        // si quiero probar todos los casos posibles
        assertAll(
            { assert(restar(1, 1) == 0) },
            { assertTrue(restar(1, 1) == 0) },
            { assertEquals(-2, restar(-1, 1)) }
        )
    }

    @Test
    fun multiplicarTest() {
        // comparar valor esperado, con valor devuelto

        // si quiero probar todos los casos posibles
        assertAll(
            { assertEquals(2, multiplicar(1, 2)) },
            { assertEquals(0, multiplicar(0, 2)) },
            { assertEquals(0, multiplicar(2, 0)) },
            { assertEquals(0, multiplicar(0, 0)) },
            { assertEquals(-2, multiplicar(-1, 2)) },
            { assertEquals(-2, multiplicar(2, -1)) },
            { assertEquals(2, multiplicar(-1, -2)) },
            { assertEquals(2, multiplicar(-2, -1)) }
        )
    }

    @Test
    fun dividirTest() {
        // comparar valor esperado, con valor devuelto
        assertAll(
            { assertEquals(0, dividir(1, 2)) },
            { assertEquals(0, dividir(0, 2)) },
            { assertEquals(2, dividir(2, 1)) },
            { assertEquals(1, dividir(2, 2)) },
            { assertEquals(1, dividir(3, 2)) },
            { assertEquals(2, dividir(4, 2)) },
            { assertEquals(5, dividir(17, 3)) },
            { assertEquals(-2, dividir(2, -1)) },
            { assertEquals(-1, dividir(2, -2)) },
            { assertEquals(-5, dividir(17, -3)) },
        )
    }

    @Test
    @Order(2) // Fijamos un orden de ejecución
    fun dividirExceptionTest() {
        // comparar valor esperado, con valor devuelto
        assertAll(
            { assertThrows<ArithmeticException> { dividir(1, 0) } },
            { assertThrows<ArithmeticException> { dividir(0, 0) } },
            { assertThrows<ArithmeticException> { dividir(-1, 0) } },
            {
                val res = assertThrows<ArithmeticException> { dividir(5, 0) }
                assertEquals("No se puede dividir 5 / 0", res.message)
            },
        )
    }

    @Test
    fun isParTest() {
        // comparar valor esperado, con valor devuelto
        assertAll(
            { assertEquals(false, isPar(3)) },
            { assertEquals(true, isPar(2)) },
        )
    }

    @Test
    fun isImparTest() {
        // comparar valor esperado, con valor devuelto
        assertAll(
            { assertEquals(true, isImpar(3)) },
            { assertEquals(false, isImpar(2)) },
        )
    }

    @Test
    fun isPrimoTest() {
        // comparar valor esperado, con valor devuelto
        assertAll(
            { assertEquals(false, isPrimo(0)) },
            { assertEquals(false, isPrimo(1)) },
            { assertEquals(true, isPrimo(2)) },
            { assertEquals(true, isPrimo(3)) },
            { assertEquals(false, isPrimo(4)) },
            { assertEquals(false, isPrimo(63)) },
            { assertEquals(false, isPrimo(91)) },
            { assertEquals(true, isPrimo(17)) },
        )
    }

    @Test
    fun factorialTest() {
        // comparar valor esperado, con valor devuelto
        assertAll(
            { assertEquals(1, factorial(0)) },
            { assertEquals(1, factorial(1)) },
            { assertEquals(2, factorial(2)) },
            { assertEquals(6, factorial(3)) },
            { assertEquals(24, factorial(4)) },
            { assertEquals(120, factorial(5)) },
            { assertEquals(720, factorial(6)) },
            { assertEquals(5040, factorial(7)) },
            { assertEquals(40320, factorial(8)) },
            { assertEquals(362880, factorial(9)) },
            { assertEquals(3628800, factorial(10)) },
        )
    }


}