package lec02

fun main() {
    val numbers = listOf(1L,2L,3L)

    //향상된 for문 사용법
    for (number in numbers) {
        println(number)
    }

    for (i in 1..3) { // 특정범위 반복
        println(i)
    }

    for (i in 3 downTo 1) { //1씩 빼서 출력해보기
        println(i)
    }

    for (i in 1..5 step 2) {// 2씩 올라가면서 출력
        println(i)
    }

    //while 문
    var i = 1
    while (i <= 3) {
        println(i)
        i++;
    }
}