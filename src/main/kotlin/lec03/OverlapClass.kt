package lec03

fun main() {

}

class House(
    private val address: String,
    private val livingRoom: LivingRoom
) {
    //권장되는 중첩클래스 사용(바깥 클래스와 연결되지 않음)
    class LivingRoom(
        private val area: Double
    )

    //권장되지 않는 중첩클래스 사용(바깥 클래스와 연결됨)
    inner class LivingRoom2(
        private val area: Double
    ){
        val address: String
          get() = this@House.address //this@바깥클래스.필드
    }
}