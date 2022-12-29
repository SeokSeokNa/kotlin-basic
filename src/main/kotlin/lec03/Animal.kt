package lec03

// 추상클래스
abstract class Animal(
    protected val species: String,
    protected open val legCount: Int
) {

    abstract fun move()
}