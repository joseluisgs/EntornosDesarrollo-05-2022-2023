package dni

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DniKtTest {

    private val dniValido = "16723614S"
    private val dniInvalido = "99999999A"

    @Test
    fun esDNIValido() {
        assertAll(
            { assertTrue(esDNIValido(dniValido)) },
            { assertFalse(esDNIValido(dniInvalido)) }
        )
    }

    @Test
    fun esDNIValidoExcepcion() {
        assertThrows<IllegalArgumentException> {
            esDNIValido("1234567890")
        }
    }

    @Test
    fun esDNIValidoExcepcionYComprueboMensajeExcepcion() {
        val res = assertThrows<IllegalArgumentException> {
            esDNIValido("1234567890")
        }
        assertEquals("El DNI debe tener 8 números y letra en mayúscula", res.message)
    }
}