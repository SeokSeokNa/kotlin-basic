package lec04

fun main() {

    val array = arrayOf(100, 200)

    for (i in array.indices) { //indices 를 이용하여 배열의 lastIndex 까지 반복할 수 있음
        println("${i} ${array[i]}")
    }

    for ((idx , value) in array.withIndex()) { //withIndex 를 이용하여 배열의 Index 및 value 까지 한번에 얻어올 수 있다.
        println("$idx $value")
    }

    //배열에 쉽게 값을 추가할 수 있음
    array.plus(300)
}