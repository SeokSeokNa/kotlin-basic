package lec05

/*
    Scope Function ?
     - 일시적으로 영역을 형성하는 함수 , {} 영역으로 되있는 함수들
     1. let - 람다의 결과를 반환 , 확장함수이다. , 람다안에서 파라미터로 "it" 사용 , 파라미터를 생략할 순 없지만 it 대신 다른이름을 사용할 수 있다.
             * 하나이상의 함수를 call chain 결과로 호출할때 사용
             * non-null 값에 대해서 code block을 실행시킬때
             * 일회성으로 제한된 영역에 지역변수를 만들때
     2. run - 람다의 결과를 반환 , 확장함수이다. , 람다안에서 파라미터로 "this" 사용 , 파라미터를 생략할 수 있고 this 대신 다른이름을 사용할 수 있다.
             * 객체 초기화와 반환값 계산을 동시에 할때
             * 객체를 만들고 바로 DB에 저장할때
     3. also - 객체 그 자체를 반환함 , 확장함수이다. , 람다안에서 파라미터로 "it" 사용 , 파라미터를 생략할 순 없지만 it 대신 다른이름을 사용할 수 있다.
             * call chain 중간에 값을 수정할 경우
     4. apply - 객체 그 자체를 반환함 , 확장함수이다. , 람다안에서 파라미터로 "this" 사용 , 파라미터를 생략할 수 있고 this 대신 다른이름을 사용할 수 있다.
             * call chain 중간에 값을 수정할 경우
     5. with - this로 사용해 접근하고 this 생략가능
             * 객체를 converting 해야하는데 한쪽에서 변경이 힘들게 설정되어있는 경우 (domain -> dto 변환시 사용 하면될듯)
 */

fun main() {
    mutableListOf("one", "two", "three")
        .also { println("The list elements before adding new one: $it") }
        .add("four")

}

fun printPerson(person: Person?) {
    person?.let {
        println(it.name)
        println(it.age)
    }
}