package lec01

import JavaMoney

fun main() {

    val money1 = JavaMoney(1_000L)
    val money2 = money1
    val money3 = JavaMoney(1_000L)

    if (money1 > money2) { //객체비교시 비교 연산자를 사용하면 자동으로 compareTo 를 호출해준다.
        println("Money1이 Money2보다 금액이 큽니다.")
    }

    println(money1 === money2) //객체의 주소값 비교시 "===" 를 사용
    println(money1 == money3) // 객체의 값을 비교시 "==" 를 사용 (자동으로 객체에 equals 메소드 호출함)

    //논리 연산자
    if (fun1() || fun2()) { //자바와 마찬가지로 "||" 연산에서는 앞에것이 참이면 뒤에것은 실행하지 않는다.
        println("Lazy 연산 수행")
    }

    val k_money1 = Money(1_000L)
    val k_money2 = Money(2_000L)
    println(k_money1 + k_money2) //코틀린에서는 연산자를 직접 오버라이딩 할 수 있다 !(Money 클래스에 구현해뒀음)

}



fun fun1(): Boolean {
    println("fun 1")
    return true;
}

fun fun2(): Boolean {
    println("fun2")
    return false
}