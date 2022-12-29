package lec03

/*
    "internal" 를 바이트코드로 변환하면 public이기 때문에 자바모듈에서 코틀린의 internal 프로퍼티에 접근 가능함
    "protected" 는 자바나 코틀린이나 같은 패키지내에 존재하면 접근 가능하기에 자바에서 protected로 설정된 코틀린 프로퍼티에 접근가능하다.(같은 패키지내에 있다면)
 */
class Car (
    internal val name: String, //Internal은 자바의 default 접근제어자와 같다(같은 모듈내에서만 접근가능)
    private var owner: String, //프로퍼티의 getter , setter에 접근제어자를 붙히고 싶은경우
    _price: Int
    )
{
    //custom setter에 접근제어를 쓰고싶은경우
    var price = _price
      private set(value) {
          field = value
      }
}

class MyClass private constructor() // 클래스의 생성자에 접근지시어를 붙히고 싶다면 이런식으로 해야한다(따로 접근지시어를 쓰지 않으면 기본적으로 public이 설정되어있다)
                                    // constructor 키워드를 명시적으로 적어줘야한다.
