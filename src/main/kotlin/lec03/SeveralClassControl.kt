package lec03

fun main() {
    val dto1 = PersonDto("나원석", 100)
    val dto2 = PersonDto("나원석", 200)

    println(dto1 == dto2)
    println(dto1)
}

fun handleCountry(country: Country) {
    return when (country) {
        Country.KOREA -> println("KOREA")
        Country.AMERICA -> println("US")
    }
}

fun handleCar(car: HyundaiCar) {
    when (car) {
        is Avante -> println("Avante")
        is Sonata -> println("Sonata")
        is Grandeur ->  println("Grandeur")
    }
}

/*
    data 클래스는 자바의 DTO 와 동일하다
    해당 클래스를 만들면 getter , setter , equals , hashCode , toString을 자동으로 만들어준다.
 */
data class PersonDto(
    val name: String,
    val age: Int
)


/*
    코틀린에서 Enum 클래스 사용방법
 */
enum class Country(
    private val code: String
) {
    KOREA("KO"),
    AMERICA("US")
}

/*
    "sealed" 는 상속가능한 구조로 클래스를 만들고 싶으나 외부에서는 상속받지 못하게 하고싶을때 사용하는 키워드이다.(같은 패키지내에 클래스만 상속받게 하고싶을때)
    특징으로는 컴파일 타임때 하위클래스의 타입을 모두 기억하고 런타임때는 클래스 타입이 추가될 수 없다는 것이다.
 */
sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class Avante : HyundaiCar("아반떼" , 1_000L)
class Sonata : HyundaiCar("소나타" , 2_000L)
class Grandeur : HyundaiCar("그렌저" , 3_000L)