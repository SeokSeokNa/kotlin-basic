package lec04


fun main() {

    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000),
    )

    /*
        리스트에 사용하면 편한 함수들
         1. filter : 원하는 것만 골라내고 싶을때
         2. filterIndexed : 원하는 것만 골라내면서 인덱스가 필요할때
         3. map : 리스트를 맵으로 만들고싶을때
         4. mapIndexed : 리스트를 맵으로 만들면서 인덱스도 필요할때
         5. mapNotNull : null이 아닌 요소들만 가지고 Map을 만들고 싶을때


         1. all : 모두 만족할 경우 True
         2. none : 모두 불만족할 경우 True
         3. any : 하나라도 만족하면 True
         4. Count : 개수를 뽑고싶을때
         5. sortedBy : 오름차순 정렬
         6. distinctBy: 특정값을 기준으로 중복을 제거
         7. first : 컬렉션의 첫번째 값을 가져옴(무조건 Null이 아니여야 한다)
         8. firstOrNull : 첫번째 값 또는 null을 가져옴
         9. last : 마지막 값을 가져옴(무조건 Null이 아니여야 한다)
         10. lastOrNull : 마지막값 또는 Null을 가져옴

         1. groupBy : 특정조건에 따라 여러그룹으로 나눠주는 메소드
         2. associateBy : Map을 만들때 value를 리스트가 아닌 원소로 하고싶을때

     */
    val all = fruits.all { fruit -> fruit.name == "사과" }
    println(all)
    val distinctBy = fruits.distinctBy { fruit -> fruit.name }
    distinctBy.forEach { fruit -> println(fruit.name) }

    val groupBy = fruits.groupBy { fruits -> fruits.name } //Map<String , List<Fruit>>
    for ((key, list) in groupBy) {
        println("$key")
        list.forEach { fruit -> println(" - "+fruit.name) }
    }

    val associateBy = fruits.associateBy { it.name }
    println(associateBy)
    val associateBy2 = fruits.associateBy({ it.name }) { it.price }
    println(associateBy2)
}


private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean) //"filter" 파라미터를 보면 코틀린에서는 함수자체를 파라미터로 넣을수 있다는걸 알 수 있음
        : List<Fruit> {

    return fruits.filter(filter)
}