package lec03

import Movable

fun main() {
    println(Singleton.a)
    Singleton.a +=10
    println(Singleton.a)

    //코틀린에서 익명객체 사용방법 (인터페이스를 구현하는 object 를 사용하면 된다)
    moveSomething(object : Movable {
        override fun move() {
            println("무브 무브")
        }

        override fun fly() {
           println("날아 날아")
        }

    })


}

class Person2 private constructor(
    var name: String,
    var age: Int
) {

    //코틀린에서는 static이 없지만 "companion object" 를 사용하면 자바의 static 변수 , 함수 처럼 동작함
    //companion object(동행객체) 에 이름을 붙힐 수 있다(companion object 이름)
    //companion object 는 하나의 인스턴스이기 때문에 인터페이스를 구현할 수도 있다.
    companion object Factory : Log{
        //"const" 키워드는 상수를 사용할때 붙히는데 컴파일시에 변수가 할당된다.
        // 붙히지 않으면 런타임시에 변수가 할당된다.
        //기본타입 및 String에만 const 를 붙일수 있다.
        private const val MIN_AGE = 1

//        @JvmStatic // -> 자바에서 코틀린의 companion object를 접근하려면 해당 어노테이션을 붙혀야함 (Person2.newBaby() 형태로 자바에서 접근 가능)
                    // 해당 어노테이션을 사용하지 않고 companion object에 이름이 있다면 Person2.이름.newBaby() 형태로 접근 가능하다.
       fun newBaby(name: String): Person2 {
            return Person2(name , MIN_AGE)
        }

        //인터페이스를 상속받아 메소드를 구현함
        override fun log() {
            println("나는 Person2 클래스의 동행객체이다.")
        }
    }
}


// 코틀린에서 싱글톤 객체를 사용하려면 "object" 키워드만 붙혀주면 끝난다 !!!(매우간단)
object Singleton {
    var a: Int = 0
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}