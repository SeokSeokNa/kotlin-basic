package lec03

class Penguin(
    species: String
) : Animal(species , 2) , Swimable , Flyable{

    private val wingCount: Int = 2;

    override fun move() {
        println("펭귄이 움직인다~")
    }

    //코틀린에서 프로퍼티에 대해 오버라이딩을 하기위해서는 해당 프로퍼티가 추상 프로퍼티가 아니라면 open 키워드를 붙혀줘야한다.(Animal 클래스에 legCount 프로퍼티에 open 키워드를 붙혀줬음)
    //상위 클래스의 프로퍼티에 있는 getter 를 오버라이딩 하기
    /*
       공식문서에 따르면 override 한 경우 public private 등 접근지시자를 딱히 명시해주지 않으면 '상위 멤버'의 접근 지시자를 따라간다고 되어 있음
     */
    public override val legCount: Int
      get() = super.legCount + this.wingCount



    //상속받은 인터페이스의 메소드 구현하기
    override fun act() {
        super<Swimable>.act() // 자바에서는 해당인터페이스.super.메소드명() 으로 불러오는데 코틀린에서는 super<인터페이스타입>.메소드명() 으로 불러온다.
        super<Flyable>.act()
    }

    //상속받은 Swimable의 프로퍼티를 구현함
    override val swimAbility: Int
        get() = 3
}