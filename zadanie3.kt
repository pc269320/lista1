package com.example.dyrka1
/**
 * autor:Patryk Czopek
 */

import kotlin.math.pow

/**
 * Function podzbiory() returns all possible subset combinations of the given set.
 * Parameters:
 * - xSet (List<String>) - lists of String values
 * Returns:
 * - subsets (List<List<String>>) - list of subsets as lists
 * Exceptions:
 * - if the set is empty
 * - if the number of subsets isn't 2 ^ xSet.size
 */
fun podzbiory(xSet: List<String>): List<List<String>> {
    //wyjątek dla pustej listy
    if (xSet.isEmpty()){
        throw IllegalArgumentException("List cannot be empty.")
    }

    val subsets = mutableListOf<List<String>>() //pusta mutable lista list
    //pusty podzbiór dla każdej listy
    subsets.add(emptyList())

    //ilość subsetów
    var numberOfSubsets = 1

    //iteracja po każdym elemencie listy
    for (element in xSet) {
        val size = subsets.size
        for (i in 0 until size) {
            val newSubset = subsets[i] + element
            subsets.add(newSubset)
            numberOfSubsets++
        }
    }
    //sprawdzenie czy dobra ilość podzbiorów
    check(numberOfSubsets == 2.0.pow(xSet.size).toInt()){"Got $numberOfSubsets subsets," +
            "expected ${2.0.pow(xSet.size).toInt()}"}
    return subsets
}

fun main() {
    //poprawne dane
    var subsets = podzbiory(listOf("a", "b", "c", "d"))
    println("Subsets:")
    for (podzbior in subsets) {
        println(podzbior)
    }

    //poprawne dane, powtórzenie elementu
    subsets = podzbiory(listOf("a", "b", "b"))
    println("\nSubsets:")
    for (podzbior in subsets) {
        println(podzbior)
    }

    //poprawne dane, jeden element
    subsets = podzbiory(listOf("a"))
    println("\nSubsets:")
    for (podzbior in subsets) {
        println(podzbior)
    }

    //pusta lista
    try{
        println("\nThe list is empty.")
        subsets = podzbiory(listOf())
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }
}