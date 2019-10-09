// Author:
// Ilham Bintang


package interview


/**
 * CASES:
 * Check a string is
 * a palindrome one or not.
 *
 * INPUT:
 * aba
 * malam
 * datang
 *
 *
 * OUTPUT:
 * VALID
 * INVALID
 */

// Solution 1
// Best approach using kotlin reversed function

internal fun isPalindrome1(s: String): Boolean {
    return s == s.reversed()
}

// Solution 2
// Approach with functional programming
// Run the iterator then get the reversed char and compare

internal fun isPalindrome2(s: String): Boolean {
    val iterator = s.iterator()
    var _reversed = ""
    while(iterator.hasNext()){
        val _char = iterator.next()
        _reversed = "$_char$_reversed"
    }
    return s == _reversed
}

fun main(vararg args: String) {
    val validate = listOf(
        "aba",
        "nakan",
        "malam",
        "saya",
        "apakah",
        "cinta"
    )

    println("=========With 1st Approach=========")
    validate.forEach {
        println("$it --> ${isPalindrome1(it)}")
    }

    println("=========With 2nd Approach=========")

    validate.forEach {
        println("$it --> ${isPalindrome2(it)}")
    }
}

