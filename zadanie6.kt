package com.example.dyrka1
/**
 * autor:Patryk Czopek
 */

/**
 * Function returns the complementary DNA for the given oligonucleotide (sense strand of DNA).
 * Parameters:
 * - nucleotides (String) - string that represents a sense strand of DNA in nucleotides
 * Returns:
 * - complementList (String) - string that represents the complementary DNA
 * Exceptions:
 * - if a nucleotide isn't 'A', 'T', 'C', 'G'
 */
fun komplement(nucleotides: String): String{
    if (nucleotides.isEmpty()){
        throw IllegalArgumentException("Sequence cannot be empty.")
    }
    val complementList = mutableListOf<Char>()
    //iteracja po podanym string
    for (i in nucleotides) {
        val complementNucleotide = when {
            i == 'A' -> 'T'
            i == 'T' -> 'A'
            i == 'C' -> 'G'
            i == 'G' -> 'C'
            else -> throw IllegalArgumentException("Invalid nucleotide: $i")
        }
        complementList.add(complementNucleotide)
    }
    return complementList.joinToString("")
}

/**
 * Function returns the messenger RNA for the given oligonucleotide (antisense strand of DNA).
 * Parameters:
 * - nucleotides (String) - string that represents an antisense strand of DNA in nucleotides
 * Returns:
 * - rnaList (String) - string that represents the mRNA sequence
 * Exceptions:
 * - if a nucleotide isn't 'A', 'T', 'C', 'G'
 */
fun transkrybuj(nucleotides: String): String{
    if (nucleotides.isEmpty()){
        throw IllegalArgumentException("Sequence cannot be empty.")
    }
    val rnaList = mutableListOf<Char>()
    for (i in nucleotides) {
        val rnaNucleotide = when{
            i == 'A' -> 'U'
            i == 'T' -> 'A'
            i == 'C' -> 'G'
            i == 'G' -> 'C'
            else -> throw IllegalArgumentException("Invalid nucleotide: $i")
        }
        rnaList.add(rnaNucleotide)
    }
    return rnaList.joinToString("")
}

fun main() {
    //podstawowe wywołanie
    var sequence = "ATCGAAAGCT"
    println("Sense strand: $sequence")
    println("Complementary DNA: ${komplement(sequence)}")
    println("Messenger RNA: ${transkrybuj(komplement(sequence))}")

    //asercje
    sequence="ATCG"
    check(komplement(sequence)=="TAGC"){"Function returned wrong complementary DNA sequence."}
    check(transkrybuj(komplement(sequence))=="AUCG"){"Function returned wrong complementary DNA sequence."}

    //zły string dla obu funkcji
    try{
        println("\nDNA sense strand is AUCGU.")
        sequence= komplement("AUCGU")
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }

    try{
        println("\nDNA complementary strand is AUCGU.")
        sequence= komplement("AUCGU")
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }
    //pusty string dla obu funkcji
    try{
        println("\nDNA sense strand is empty.")
        sequence= komplement("")
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }

    try{
        println("\nDNA complementary strand is empty.")
        sequence= komplement("")
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }
}