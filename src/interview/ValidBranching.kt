package interview

/**
 * CASES:
 * branching could be called valid unless the opening tags has closing tags. Verify if a string has
 * a valid one or not.
 *
 * INPUT:
 * (())()
 * ((()())
 *
 * OUTPUT:
 * VALID
 * INVALID
 */

// validate using math
internal fun String.isValid(): Boolean {
    if (length % 2 != 0 || startsWith(")") || endsWith("(")) {
        return false
    }
    var open = 0
    forEach {
        if (it == '(') {
            open++
        } else {
            open--
        }
    }
    return open == 0
}

// validate using recursion and then remove () each recursion
internal fun String.invalidate(): String? {
    if (this == "()") return ""
    return replaceFirst("()", "").takeIf {
        it.length >= 2 && it.contains("()")
    }?.invalidate()
}


fun main(vararg args: String) {
    val validate = listOf(
        "(())",
        "(()())",
        "(()())(",
        ")(()())(",
        "()((()()))((()()))",
        "(()(())())"
    )
    validate.forEach {
        println("$it --> ${it.isValid()}")
    }
    println("=========")

    validate.forEach {
        println("$it --> ${it.invalidate()?.isBlank() ?: false}")
    }
}

