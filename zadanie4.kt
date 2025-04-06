package com.example.dyrka1
/**
 * autor:Patryk Czopek
 */

/**
 * Function that returns the values of first n numbers of the Fibonacci sequence using for loop.
 * Parameters:
 * - n (Int) - value of how many numbers of the sequence the user wants
 * Returns:
 * - fibonacciList (List<Int>) - first n numbers of the Fibonacci sequence
 * Exceptions:
 * - if n<=0
 */
fun fibonacciLoop(n: Int): List<Int>{
    //warunki początkowe
    if (n <= 0) {
        throw IllegalArgumentException("Parameter n has to be a positive integer.")
    }

    val fibonacciList = mutableListOf<Int>() //mutable list na wyniki
    //początek ciągu fibonacciego
    var a = 0
    var b = 1
    for (i in 1..n) {
        fibonacciList.add(a)
        a = b. also { b += a }
    }
    return fibonacciList
}

/**
 * Function that returns the values of first n numbers of the Fibonacci sequence using recursion.
 * Parameters:
 * - n (Int) - value of how many numbers of the sequence the user wants
 * Returns:
 * - fibonacciList (List<Int>) - first n numbers of the Fibonacci sequence
 * Exceptions:
 * - if n<=0
 */
fun fibonacciRecursion(n: Int): List<Int>{
    //warunki początkowe
    if (n <= 0) {
        throw IllegalArgumentException("Parameter n has to be a positive integer.")
    }

    /**
     * Function used for the recursion to occur and to calculate the values of the sequence.
     * Parameters:
     * - n (Int) - length of sequence
     * - a, b (Int) - starting numbers (0 and 1 to start the sequence correctly)
     * Returns:
     * - List<Int> - Fibonacci sequence starting with a
     */
    fun fib(n: Int, a: Int, b: Int): List<Int> {
        //koniec rekurencji
        if (n == 0) {
            return emptyList()
        }
        //rekurencja
        val nextValue = fib(n - 1, b, a + b)
        return listOf(a) + nextValue
    }
    //zaczynamy od 0, 1
    return fib(n, 0, 1)
}

fun main(){
    //poprawne wywołanie
    var n = 4
    var fibonacciListLoop = fibonacciLoop(n)
    check(fibonacciListLoop==listOf(0, 1, 1, 2))
    var fibonacciListRecursion = fibonacciRecursion(n)
    check(fibonacciListRecursion==listOf(0, 1, 1, 2))

    //wywołanie obu funkcji i porównanie list
    n = 10
    fibonacciListLoop = fibonacciLoop(n)
    println("Fibonacci sequence using loop for n=$n: $fibonacciListLoop")
    fibonacciListRecursion = fibonacciRecursion(n)
    println("Fibonacci sequence using recursion for n=$n: $fibonacciListRecursion")
    check(fibonacciListLoop==fibonacciListRecursion){"The lists of both Fibonacci sequences are not the same."}

    //n=0 dla for loop
    try{
        println("\nValue of n is zero.")
        n=0
        fibonacciListLoop = fibonacciLoop(n)
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }

    //n=0 dla rekursji
    try{
        println("\nValue of n is zero.")
        n=0
        fibonacciListRecursion = fibonacciRecursion(n)
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }
}