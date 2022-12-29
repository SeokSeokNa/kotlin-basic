package lec03

//class Person constructor(name: String , age:Int){ //코틀린에서는 생성자를 클래스명 옆에 정의한다. (여기부분에 정의한 생성자를 주생성자 라고 부른다(primary constructor)
//class Person (name: String , age:Int){ // 생성자를 표시하는 "constructor" 키워드는 생략 가능하다.
class Person (name: String , var age:Int){ // 생성자에서 프로퍼티를 바로 정의할 수 있다 ( 이렇게되면 클래스 블록안에 필드를 따로 선언안해도 됨)

    //클래스가 초기화되는 시점에 딱 한번 호출되는 부분을 init 이라고 한다.(생성자가 호출되는 시점에 딱 한번 호출됨)
    init {
        if (this.age <= 0) {
            throw  IllegalArgumentException("나이는 ${age} 일 수 없습니다.");
        }
        println("초기화 블록")
    }

    /*
        코틀린에서는 필드만 정의해주면 getter , setter 를 자동으로 만들어준다
         * 프로퍼티 = 필드 + getter + setter
     */
    /*
        "field" 키워드 사용이유(backing field)
         - 외부에서 해당클래스에 name필드를 호출하게되면 내가만든 custom getter가 호출된다, 이때 field 키워드 대신 name을 그대로 쓰게되면 내부에서도 또 name이 호출 -> get() 이 호출 -> name이 호출 -> get() 호출 ....
           하면서 무한루프에 걸리게된다!!
           즉 , 무한루프를 막기위해 백킹필드를 사용해야한다, 이 백킹필드는 자기자신을 직접가르켜 get이 호출되지않고 자기자신 자체가 호출된다.
           하지만 생각보다 백킹필드는 잘 안쓰이고 함수로 처리하던지 커스텀 getter 로 처리한다.

         val name = name
            get() = field.uppercase()
         val upperCaseName: String
          get() = this.name.uppercase()
     */

    /*
        custom setter
        setter를 지양하기에 커스텀 setter도 잘 안쓰인다.
        var name = name
          set(value) { //value는 외부에서 호출할때 넣어줬던 파라미터값
              field = value.uppercase()//field는 자기자신(name)
          }
     */




//    var age = age//생성자로부터 받아온 파라미터 값을 주입

    //생성자 오버로딩
    //주 생성자를 제외한 나머지 생성자는 모두 부 생성자이다(secondary constructor)
    //부 생성자는 최종적으로 무조건 주 생성자를 호출해야한다.
    constructor(name: String) : this(name, 1) { // 부 생성자에는 block을 넣어 코드를 집어넣을 수 있음!!!
        println("첫 번째 부생성자")
    }
    constructor() :this("홍길동") {
        println("두 번째 부생성자")
    }

//    fun isAdult(): Boolean {
//        return this.age >= 20
//    }

    //custom getter
    //프로퍼티를 만들어서 해당 필드를 getter로 호출 했을때 동작할것을 적어주면된다.
    //커스텀 getter 를 사용할지 함수형태로 사용할지에 대한 결정은 해당필드가 속성을 나타내면 커스텀 아니면 함수로 사용하도록 하자
    val isAdult: Boolean
//      get() {
//          return this.age >= 20
//      }
        get() = this.age >= 20 //Expression 으로 표현


}