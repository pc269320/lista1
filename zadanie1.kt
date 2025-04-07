package com.example.dyrka1
/**
 * autor:Patryk Czopek
 */

import kotlin.math.sqrt // importujemy pierwiastek kwadratowy z pakietu math

/**
 * Function heron() applies the Heron's formula to calculate the area of a triangle with
 * given side lengths of a, b and c.
 * Parameters:
 * - a, b, c (Double) - lengths of the triangle's sides
 * Returns:
 * - area of triangle (Double)
 * Exceptions:
 * - if lengths are <=0
 * - if a triangle with given parameters doesn't exist
 */
fun heron(a: Double, b: Double, c: Double): Double{
    // rzucanie wyjątków dla ujemnych boków (lub równych zero)
    if (a <= 0 || b <= 0 || c <= 0){
        throw IllegalArgumentException("The lengths have to be over 0.")
    }

    // sprawdzenie czy trójkąt o podanych bokach może istnieć
    if (a + b <= c || a + c <= b || b + c <= a){
        throw IllegalArgumentException("You can't construct a triangle with these parameters.")
    }

    // wzór Herona
    val p = (a + b + c) / 2 // połowa obwodu do wzoru
    return sqrt(p * (p - a) * (p - b) * (p - c))
}

//testy funkcji
fun main(){
    var result = heron(3.0, 4.0, 5.0)
    check(result == 6.0){"The result should be equal to 6.0"}

    result = heron(5.0, 12.0, 13.0)
    check(result == 30.0){"The result should be equal to 30.0"}

    result = heron(5.0, 5.0, 6.0)
    check(result == 12.0){"The result should be equal to 12.0"}
    println("Successfully passed assertion.")

    //sprawdzenie złych długości boków
    try{
        println("\nTriangle with sides equal to 1.0, 2.0 and 3.0.")
        heron(1.0, 2.0, 3.0)
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }

    try{
        println("\nTriangle with sides equal to 0.0, 2.0 and 4.0.")
        heron(0.0, 2.0, 4.0)
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }
}
