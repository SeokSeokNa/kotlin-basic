package lec05

import lec04.Fruit

/*
    typealias : 파라미터의 타입이나 반환타입을 편하게 별칭으로 사용 가능하게함
    as Import : 서로다른 패키지에 있지만 이름이 같은 함수를 사용하고 싶을떄 (lec04.Fruit as 별칭)
*/
typealias 타입별칭 = (Fruit) -> Boolean

fun 별칭을사용(testParam: 타입별칭) {
    println("타입별칭을 사용")
}

/*
   구조분해 문법 사용
 */
data class Person(
    //데이터 클래스는 기본적으로 필드에 대해 "componentN" 함수를 만들어준다.
    //데이터 클래스가 아닌 클래스에서 componentN 함수를 만들고싶다면 직접 만들면된다.
    val name: String,
    val age: Int
)
class Person2(
    //데이터 클래스가 아닌 클래스에서 componentN 함수를 만들고싶다면 직접 만들면된다.
    val name: String,
    val age: Int
) {
    //componentN 을 사용하기위해 operator 키워드를 붙혀서 함수를 만들어야한다
    operator fun component1(): String {
        return this.name
    }
    operator fun component2(): Int {
        return this.age
    }
}


fun main() {
    val person = Person("ttt" , 100)
    // val name = "ttt" , val age = 100 과 같은 의미이다 (데이터 클래스의 componentN 함수를 이용해서 이렇게 가능하다.)
    // val name = person.component1() // 첫번째 프로퍼티 가져오기
    // val age = person.component2() // 두번째 프로퍼티 가져오기
    val(name , age) = person
    println("이름 ${name} , 나이 ${age}")
    val takeIfTest = takeIfTest(50)
    println(takeIfTest)
    val takeUnlessTest = takeUnlessTest(50)
    println(takeUnlessTest)
}

/*
    foreach에서 break 를 사용하고 싶다면 run 으로 한번 감싸고 return@run 을 사용하여 멈춰야한다.
    foreach에서 continue 를 사용하고 싶다면 run 으로 한번 감싸고 return@forEach 을 사용하여 멈춰야한다.
 */
fun forEachStop(list: List<Int>) {
    run {
        list.forEach { num ->
            if (num == 2) {
                println(num)
                return@forEach
            }
        }
    }
}

/*
 takeIf : 주어진 조건을 만족하면 해당값이 나옴 그렇치 않으면 null
 takeUnless : 주어진 조건을 만족하지 않을때 해당 값이 나옴
 */

fun takeIfTest(score: Int): Int? {
//    return if (score >= 50) {
//       score
//    } else {
//        null
//    }
    //위 Expression 표현식을 아래와 같이 고칠수 있음
    return score.takeIf { it >= 50 }
}

fun takeUnlessTest(score: Int): Int? {
//    return if (score >= 50) {
//       score
//    } else {
//        null
//    }
    //위 Expression 표현식을 아래와 같이 고칠수 있음
    return score.takeUnless { it >= 50 }
}