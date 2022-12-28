package lec01

fun validateScoreIsNotNegative(score: Int) { //결과값 void(Unit) 생략
    if (score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

fun validateScoreIsNotNegative2(score: Int) { //결과값 void(Unit) 생략
    if (score !in 0..100) { // "in" 조건문을 이용해  점수가 0이상 100이하인지 판단할 수 있게됨
        throw IllegalArgumentException("${score}의 범위는 0부터 100입니다.")
    }
}

/*
    Statement : 프로그램의 문장 전체를 뜻함, 하나의 값으로 도출되지않음
    Expression : 하나의 값으로 도출되는 문장

    Statement 안에 Expression이 포함되어있다.
 */
fun getPassOrFail(score: Int):String {
    return if (score >= 50) { // 코틀린에서 if-else는 "Expression" 이다 , 자바에서는 Expression 형태로 반환하기 위해 3항연산자가 필요한데 코틀린에서는 필요가 없다.
         "P"
    } else {
         "F"
    }
}

/*
    if - else if - else 형태 역시 코틀린에서는 "Expression" 이다.
 */
fun getGrade(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

/*
    코틀린에서는 switch 문법이 사라지고 when 문법이 생겨났다.
 */
fun getGradeWithSwitch(score: Int): String {
//    return when (score / 10) {
//        9 -> "A"
//        8 -> "B"
//        7 -> "C"
//        else -> "D"
//    }

    return when (score) { //범위로 판단할 경우 in 절을 같이 사용하여 만들 수 있음
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int) {
    when (number) {
        1,0,-1 -> println("맞는 숫자") //여러개의 조건을 동시에 검사 가능 ("," 로 구분하여)
        else -> println("1,0,-1 이 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    when  { //when 안에 비교할 값이 들어있으면 그걸 가지고 판단하고 아니면 밑에 문장자체로 판단하고 리턴한다.
        number == 0 -> println("주어진 숫자는 0입니다.")
        number %2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}


