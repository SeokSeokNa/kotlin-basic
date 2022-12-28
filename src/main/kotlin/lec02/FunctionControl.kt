package lec02

fun main() {

    repeat("asd")
    repeat("asd" , useNewLine = false) //호출할 때 매개변수에 해당하는 값을 직접명시 해줄 수 있다.(named parameter 라고 불리움)

    //builder 를 사용하지 않아도 builder 처럼 특정변수값을 명시하여 파라미터 순서상관없이 사용가능하게 하는 장점이 있다.
    printNameAndGender(gender = "MALE" , name = "seok")

    printAll("A","B","C")

    val array = arrayOf("A" , "B" , "C")
    printAll(*array) //코틀린에서는  배열에 있는것들을 마치 "," 로 구분하여 사용하는 것 처럼 꺼내주는 역활을 하는 spread 연산자(*)를 사용해야한다.
}

//접근제어자 public은 생략가능하다.
// 반환타입이 추론이가능하고 "{}" 을 사용하지않고 "=" 을 사용했다면 반환타입 역시 생략가능하다.
public fun max(a: Int, b: Int) = if (a > b) a else b


//default parameter
// -> 매개변수에 값을 지정해주면 함수호출시 해당 변수에 값을 넣어주지 않아도 기본셋팅한 값으로 동작하게된다.
fun repeat(str: String,
           num: Int=3,
           useNewLine: Boolean=true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

//코틀린에서 가변인자 (자바로치면 String.. 변수명) 을 사용하려면 "vararg" 키워드를 사용하면 된다.
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}