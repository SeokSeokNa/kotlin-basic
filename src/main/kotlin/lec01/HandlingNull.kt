package lec01

import PersonJava
import java.lang.IllegalArgumentException

fun main() {

    val person = PersonJava("공부하는 개발자")
    println(startPersonA(person.name)) //코틀린에서 자바 코드를 가져다 쓸때 자바 클래스에 달려있는 어노테이션을 코틀린이 이해한다 (@Nullable , @NotNull)

    //println(startWith(""))

    val str: String? = null
    println(str?.length) //Safe call -> 해당 변수가 null일 경우 해당 처리 요청을 실행하지 않고 null로 처리해 반환하고 아닐경우 해당 처리 결과값을 반환하게된다!
    println(str?.length ?: 0) // Elvis 연산자 -> 해당변수가 null 일경우 뒤에 값으로 반환하고 아닐경우 해당 처리 결과값을 반환한다.
}

fun startsWithA1(str: String?): Boolean { //매개변수가 Null일수 있고 반환타입은 Null 허용을 하지 않는 경우

    //Elvis 연산자로 코드를 깔금하게 처리리
   return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다.")

//    if (str == null) {
//        throw IllegalArgumentException("null이 들어왔습니다.")
//    }
//    return str.startsWith("A")
}

fun startsWithA2(str: String?): Boolean? { //매개변수가 Null일수 있고 반환 타입도 null을 허용한 경우

    return str?.startsWith("A")

//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")
}

fun startsWithA3(str: String?): Boolean { //매개변수가 Null일수 있고 반환 타입도 null을 허용한 경우

    return str?.startsWith("A") ?: false


//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A")
}


fun startWith(str: String?): Boolean {
    return str!!.startsWith("A") //해당 매개변수가 절대 null일수 없는 경우 (그래도 null 값이 혹시나 들오게 되면 NPE가 발생하니 정말로 null 값이 아닌경우만 쓰도록 하자)
}

fun startPersonA(str: String): Boolean {
    return str.startsWith("A")
}