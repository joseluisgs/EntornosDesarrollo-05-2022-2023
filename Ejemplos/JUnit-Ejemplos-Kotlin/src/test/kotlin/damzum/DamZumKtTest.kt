package damzum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DamZumKtTest {

    var deposito = "100.0"
    var email = "test@junit.com"

    @BeforeEach
    fun setUp() {
        deposito = "100.0"
        email = "test@junit.com"
    }

    @Test
    fun registrarCuentaTest() {
        assertAll(
            { assertTrue(registrarCuenta(email, deposito)) },
            { assertTrue(registrarCuenta(email)) },
        )
    }

    @Test
    fun registrarCuentaEmailNoValidoTest() {
        val res = assertThrows(IllegalArgumentException::class.java) {
            registrarCuenta("testjunit.com", deposito)
        }
        assertEquals("El email no es válido", res.message)
    }

    @Test
    fun registrarCuentaCantidadNoValidaTest() {
        val res = assertThrows(IllegalArgumentException::class.java) {
            registrarCuenta(email, "-1.0")
        }
        assertEquals("La debe ser un un numero decimal válido mayor a 0", res.message)
    }

    @Test
    fun recibirDineroTest() {
        val res1 = recibirDinero(email, "0.50")
        val res2 = recibirDinero(email, "0.51")
        val res3 = recibirDinero(email, "499.99")
        val res4 = recibirDinero(email, "500.00")
        assertAll(
            { assertTrue(res1) },
            { assertTrue(res2) },
            { assertTrue(res3) },
            { assertTrue(res4) },
        )
    }

    @Test
    fun recibirEmailNoValidoTest() {
        val res = assertThrows(IllegalArgumentException::class.java) {
            recibirDinero("testjunit.com", deposito)
        }
        assertEquals("El email no es válido", res.message)
    }

    @Test
    fun recibirDineroTestCantidadNoValidaTest() {
        val res1 = assertThrows(IllegalArgumentException::class.java) {
            recibirDinero(email, "0.49")
        }
        val res2 = assertThrows(IllegalArgumentException::class.java) {
            recibirDinero(email, "500.01")
        }

        assertAll(
            { assertEquals("La cantidad debe ser mayor o igual a 0.5 y menor o igual a 500", res1.message) },
            { assertEquals("La cantidad debe ser mayor o igual a 0.5 y menor o igual a 500", res2.message) },
        )
    }

    @Test
    fun enviarDineroTest() {
        registrarCuenta(email, "0.50")
        val res1 = enviarDinero(email, "0.50")
        registrarCuenta(email, "100.00")
        val res2 = enviarDinero(email, "0.51")
        registrarCuenta(email, "500.00")
        val res3 = enviarDinero(email, "499.99")
        registrarCuenta(email, "500.00")
        val res4 = enviarDinero(email, "500.00")

        assertAll(
            { assertTrue(res1) },
            { assertTrue(res2) },
            { assertTrue(res3) },
            { assertTrue(res4) },
        )
    }

    @Test
    fun enviarDineroEmailNoValidoTest() {
        val res = assertThrows(IllegalArgumentException::class.java) {
            enviarDinero("testjunit.com", deposito)
        }
        assertEquals("El email no es válido", res.message)
    }

    @Test
    fun enviarDineroCantidadNoValidaTest() {
        registrarCuenta(email, "600.00")
        val res1 = assertThrows(IllegalArgumentException::class.java) {
            enviarDinero(email, "0.49")
        }

        val res2 = assertThrows(IllegalArgumentException::class.java) {
            enviarDinero(email, "500.01")
        }

        // No puedo enviar más dinero del que tengo
        registrarCuenta(email, "100.00")
        val res3 = assertThrows(IllegalArgumentException::class.java) {
            enviarDinero(email, "100.01")
        }

        assertAll(
            { assertEquals("La cantidad debe ser mayor o igual a 0.5 y menor o igual a 500", res1.message) },
            { assertEquals("La cantidad debe ser mayor o igual a 0.5 y menor o igual a 500", res2.message) },
            { assertEquals("La cantidad a enviar debe ser menor o igual a $deposito", res3.message) },
        )
    }

    @Test
    fun isEmailValidoTest() {
        assertAll(
            { assertTrue(isEmailValido(email)) },
            { assertFalse(isEmailValido("test.com")) },
            { assertFalse(isEmailValido("test@com")) },
            { assertFalse(isEmailValido("test@com.")) },
        )
    }

    @Test
    fun isDobleValidoTest() {
        assertAll(
            { assertTrue(isDoubleValido("0.50")) },
            { assertFalse(isDoubleValido("0,50")) },
            { assertTrue(isDoubleValido("14990.50")) },
            { assertFalse(isDoubleValido("14.990.50")) },
            { assertFalse(isDoubleValido("14,990.50")) },
        )
    }

    @Test
    fun getDouble() {
        assertAll(
            { assertEquals(0.50, getDouble("0.50")) },
            { assertEquals(14990.50, getDouble("14990.50")) },
            { assertEquals(14990.50, getDouble("14990.500")) },
            { assertEquals(14990.50, getDouble("14990.501")) },
            { assertEquals(14990.50, getDouble("14990.4999")) },
        )
    }

}