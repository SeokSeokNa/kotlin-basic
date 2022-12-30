package lec04

fun main() {
    /*리스트 만들기*/
    val numbers = listOf(100, 200) //불변리스트 만들기
    val numbers2 = mutableListOf(100, 200) //가변 리스트 만들기
    val emptyList =  emptyList<Int>() //빈 리스트 만들기 (타입 추론이 불가하기에 타입을 명시해야함)
    printNumbers(emptyList())//해당 파라미터에 리스트가 Int형이라고 명시해서 따로 타입을 명시하지않은 빈 리스트를 넣어도됨

    //가변 리스트에 값 추가하기
    numbers2.add(300)

    //리스트에 요소를 배열처럼 접근가능
    println(numbers[0])
    println(numbers[0])

    for (number in numbers) {
        println(number)
    }

    //리스트에 인덱스와 값을 한번에 뽑을 수 있음
    for ((idx, value) in numbers.withIndex()) {
        println("$idx $value")
    }

    /*Set 사용하기*/
    val set = setOf(100, 200)
    val mutableSetOf = mutableSetOf(100, 200)
    for ((idx, value) in mutableSetOf.withIndex()) {
        println("$idx $value")
    }

    /*Map 사용하기*/
    val oldMap = mutableMapOf<Int , String>()
    oldMap.put(1,"MONDAY")
    oldMap[2] = "TUESDAY" //배열처럼 값을 넣을수 있음
    //불변 map을 만드는 방법2
    mapOf(1 to "Monday" , 2 to "Tuesday")

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }
}

private fun printNumbers(number: List<Int>) {

}