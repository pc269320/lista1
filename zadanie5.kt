package com.example.dyrka1
/**
 * autor:Patryk Czopek
 */

/**
 * Function calculates the Collatz sequence for given starting integer c0.
 * Parameters:
 * - c0 (Int) - starting integer for the Collatz sequence
 * Returns:
 * - sequence List<Int> - Collatz sequence
 * Exceptions:
 * - if c0<=0
 */
fun collatzSequence(c0: Int): List<Int>{
    //sprawdzenie warunków początkowych
    if (c0 <= 0) {
        throw IllegalArgumentException("Parameter c0 has to be a positive integer.")
    }
    val sequence = mutableListOf(c0) //sekwencja
    var current = c0 //obecna wartość wyrażenia ciągu
    var maxValue = c0 //maksymalna wartość wyrażenia ciągu

    while (current != 1){
        if (current % 2 == 0){
            current /= 2
        }
        else{
            current= 3 * current + 1
        }
        sequence.add(current)
        if (current > maxValue){
            maxValue = current
        }
    }
    println("Maximum value of the sequence for starting point c0=$c0: $maxValue")
    println("Sequence length for starting point c0=$c0: ${sequence.size}")
    return sequence
}

fun main() {
    //podstawowe wywołanie funkcji
    var sequence = collatzSequence(5)
    println("Collatz sequence for c0=6: $sequence\n")
    sequence = collatzSequence(27)
    println("Collatz sequence for c0=19: $sequence\n")

    //asercje
    sequence= collatzSequence(4)
    check(sequence== listOf(4, 2, 1)){"The sequence is wrong"}
    sequence= collatzSequence(6)
    check(sequence== listOf(6, 3, 10, 5, 16, 8 ,4 ,2 ,1)){"The sequence is wrong"}

    //c0=0
    try{
        println("\nValue of c0 is zero.")
        sequence= collatzSequence(0)
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }
}