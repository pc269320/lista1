package com.example.dyrka1
/**
 * autor:Patryk Czopek
 */

/**
 * Function wspolne() returns the numbers that appear in both lists.
 * Parameters:
 * - xList, yList (List<Int>) - lists of Int values
 * Returns:
 * - commonElements (List<Int>) - list of common elements from both lists
 * Exceptions:
 * - if any of the lists is empty
 */
fun wspolne(xList: List<Int>, yList: List<Int>): List<Int>{
    //wyjątek dla pustej listy
    if (xList.isEmpty() || yList.isEmpty()){
        throw IllegalArgumentException("Lists cannot be empty.")
    }

    val commonElements = mutableListOf<Int>() //pusta lista na wspólne elementy
    val yListCopy = yList.toMutableList() // kopia zapasowa + mutable list

    // iterujemy po każdym elemencie listy x i usuwamy każde jego wystąpienie w liście y,
    // po czym kopiujemy tą wartość do commonElements
    for (element in xList){
        if (yListCopy.remove(element)){
            commonElements.add(element)
        }
    }
    return commonElements
}

//testy funkcji
fun main(){
    //poprawne dane, mają część wspólną
    var result = wspolne(listOf(1, 2, 2, 3), listOf(2, 2, 5))
    check(result == listOf(2, 2)){"Expected elements 2, 2. Got $result"}

    //poprawne dane, nie mają części wspólnej
    result = wspolne(listOf(1, 1, 1, 1), listOf(5, 5, 5))
    check(result.isEmpty()){"Expected empty list. Got $result"}

    //poprawne dane, te same listy
    result = wspolne(listOf(1, 1, 1, 1), listOf(1, 1, 1, 1))
    check(result == listOf(1, 1, 1, 1)){"Expected an exact copy of the original list. Got $result"}

    //poprawne dane, same jedynki, ale jedna lista jest krótsza

    //poprawne dane, te same listy
    result = wspolne(listOf(1, 1, 1), listOf(1, 1, 1, 1))
    check(result == listOf(1, 1, 1)){"Expected elements 1, 1, 1. Got $result"}

    //pusta lista
    try{
        println("One of the lists given as an argument is empty.")
        result = wspolne(emptyList(), listOf(1, 2, 3))
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }
}