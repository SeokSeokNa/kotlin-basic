package lec03

fun main() {
    Derived(300)
    val penguin = Penguin("펭귄")
    println(penguin.act())
    println(penguin.legCount)
}

// 추상클래스가 아닌 일반 클래스를 상속받기 위해서는 상위클래스에 "open" 키워드를 꼭 붙혀줘야함
open class Base(
    open val number: Int = 100
) {
    init {
        println("Base Class")
        println(number) //값이 0이 나옴
        //상위 클래스가 인스턴스화 되는 시점에서 하위 클래스 프로퍼티에 접근하게 되면 아직 하위클래스는 인스턴스화가 되지 않은 시점이기에 Int형의 기본값이 0 이 나오게된다.
        //그래서 상위클래스를 설계할때 생성자 또는 init 블럭에서 사용되는 프로퍼티는 "open" 키워드를 사용하면 안된다.
        //open 키워드를 사용하므로써 해당 프로퍼티에 포함된 getter 까지 모두 오버라이딩 되버리기 떄문
    }
}

class Derived(
    override val number: Int
) : Base(number) {

    init {
        println("Derived Class")
    }
}