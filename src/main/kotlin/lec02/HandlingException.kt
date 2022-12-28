package lec02

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다.")
    }
}

fun parseIntOrThrow2(str: String): Int? {
    return try { // try catch 구문도 코틀린에서는 Expression 취급가능하다.
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}