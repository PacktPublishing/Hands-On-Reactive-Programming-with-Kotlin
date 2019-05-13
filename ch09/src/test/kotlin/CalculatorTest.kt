import org.junit.Test

import org.junit.Assert.*

class CalculatorTest {

    @Test
    fun add() {
        val calculator = Calculator()

        val received = calculator.add(3,4)
        val expetced = 7

        assertEquals(expetced, received)
    }

    @Test
    fun multiply() {
    }

    @Test
    fun subtract() {
    }
}