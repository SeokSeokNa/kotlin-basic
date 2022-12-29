package lec03

interface Swimable {

    val swimAbility: Int
      get() = 1 //기본값으로 설정하고 다른값을 쓰고싶다면 상속한 하위클래스에서 구현하면된다.

    fun act(){
        println(swimAbility) //해당 프로퍼티를 하위 클래스에서 구현해줄것이라 생각하고 인터페이스에서는 자유롭게 사용 가능하게한다.
        println("어푸 어푸")
    }
}