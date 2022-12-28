package lec02

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FilePrinter {

    fun readFile() { // 코틀린에서는 익셉션 발생여부를 명시적으로 표시하는 checked Exception 과 표시하지 않는 UnCheckedException 구분하지 않고 모두 UnCheckedException으로 간주
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    fun readFileTryWithResources(path: String) {
        BufferedReader(FileReader(path)).use { reader -> //코틀린에서는 try with resources 문법이 사라지고 "use" 를 사용하여 처리함
            println(reader.readLine())
        }
    }
}