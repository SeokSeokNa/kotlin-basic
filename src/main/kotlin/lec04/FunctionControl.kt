package lec04

fun main() {
    val str="ABC"
    val lastChar = str.lastChar()
    println(lastChar)

    val add = 3.add(4)
    val infixResult = 3 add2 4
    println(infixResult) //중위함수 호출
}

/*확장함수*/
//원래 있던 멤버함수처럼 사용가능하게 함
//원본 클래스의 private , protected 멤버를 가져올 수 없다(캡슐화가 깨지기 떄문)
//확장함수 와 멤버함수의 함수명이 같다면 멤버함수가 우선호출됨
//확장함수는 현재타입을 기준으로 호출된다(상속을 받아 확장함수를 오버라이드 하여도 해당 확장함수 호출당시 호출하는 클래스의 타입에 따라 그 클래스의 확장함수가 호출됨)
//fun 확장하려는클래스.함수이름(파라미터): 리턴타입
fun String.lastChar(): Char {
    return this[this.length - 1] //this(여기서 수신객체라 불리움) 로 인스턴스에 접근함
}
//확장 함수는 프로퍼티로 사용도 가능(확장함수 + custom getter 형태)
val String.lastChar: Char
    get() = this[this.length - 1]

/*중위 함수*/
//중위함수는 새로운것이 아니고 함수를 호출하는 다른방법인 것
//"infix" 키워드를 함수에 붙히면됨(멤버함수 던 확장함수던)
fun Int.add(other: Int): Int {
    return this + other
}
infix fun Int.add2(other: Int): Int {
    return this + other
}

/* 지역함수
*  함수안에 함수가 들어있는것
*  코드가 깔끔하지 않아 잘 안쓰임
* */
