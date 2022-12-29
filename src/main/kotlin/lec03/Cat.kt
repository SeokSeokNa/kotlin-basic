package lec03

class Cat(
    species: String
) : Animal(species , 4){ //클래스에서 " : " 의미는 상속을 뜻한다.  괄호 한칸뛰고 상속키워드를 써줘야한다.(상속 받을때 상위 클래스의 생성자를 호출해줘야한다)


    //메소드 오버라이딩
    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~")
    }
}