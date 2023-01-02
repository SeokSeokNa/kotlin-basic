package lec04

/*
    코틀린에서는 자바와 다르게 함수 자체를 변수에 할당하거나 파라미터로 넘겨줄 수 있음
 */

fun main() {

    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박박", 10_000),
    )

    //함수이름이 없음 (이름없는 함수 == 람다)
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean { // "(Fruit) -> Boolean" 파라미터와 반환타입은 생략이 가능함
        return fruit.name == "사과"
    }

    //화살표 함수 사용시 리턴 키워드가 없어도 마지막줄 결과가 반환값이 된다.
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" } // "(Fruit) -> Boolean" 파라미터와 반환타입은 생략이 가능함

    //람다 함수 호출방법 2가지
    isApple(fruits[0])
    isApple.invoke(fruits[0])

    //isApple 변수에는 함수가 들어있기에 filterFruits 함수에 파라미터에 맞는 함수로 파라미터로 사용가능하다
    val filterFruits = filterFruits(fruits, isApple)

    //함수를 받는 파라미터가 맨 마지막에 있을경우는 소괄호를 생각하고 함수형 파라미터를 바로 쓸수있다.
    filterFruits(fruits ,{ fruit -> fruit.name == "사과" })
    filterFruits(fruits) { fruit -> fruit.name == "사과" }
    //함수형 파라미터의 매개변수가 하나라면 "it" 으로 통칭하고 화살표생략 가능
    filterFruits(fruits) { it.name == "사과" }

    /*
    코틀린에서는 Closure 를 이용하여 non-final 변수 역시 람다에서 조작가능하다!! -> 자바에서는 사용불가
 */
    var test = "asd"
    val lamdaTest =  {
        test = "bbb"
        println(test)
    }
    lamdaTest()

}

private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean) //"filter" 파라미터를 보면 코틀린에서는 함수자체를 파라미터로 넣을수 있다는걸 알 수 있음
        : List<Fruit> {

    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }

    return results
}

