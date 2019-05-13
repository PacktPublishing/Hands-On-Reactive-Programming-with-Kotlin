class Calculator {

    fun add (a : Int, b : Int) = a + b

    fun multiply (a : Int, b : Int) = a * b

    fun subtract (a : Int, b : Int) = a - b
}

fun main() {

    val obj = Calculator()

    val a = 3
    val b = 2

    println("$a + $b = " + obj.add(3,2))
}