fun main() {
    val result = arrayListOf<Any>()
    println("Permainan Hopimpa")
    println("Mulai Bermain")
    println("Pilihan Jawaban: ")
    println("1. Hitam")
    println("2. Putih")
    println("===================================================================")
    for (i in 1..5) {
        println("$i. Pemain $i")
        val resultPlayer = inputAnswer()
        result.add(resultPlayer)
    }
    var putih = 0
    var hitam = 0
    for (res in result) {
        if (res == "1") {
            hitam+=1
        } else {
            putih+=1
        }
    }
    println("Hasil: ")
    if (hitam > putih){
        elimination(result = result, valueResult = "2")
    } else {
        elimination(result = result, valueResult = "1")
    }
}
fun inputAnswer (): String{
    var tempResult: String
    var status: Boolean
    do {
        print("Masukkan jawaban: ")
        tempResult= readLine().toString()
        if (tempResult == "1" || tempResult == "2") {
            status = true
        } else {
            status = false
            println("Jawaban salah, pemain hanya boleh memasukkan jawaban '1' atau '2'")
        }
    } while (!status)
    return tempResult
}
fun elimination (result: ArrayList<Any>, valueResult: String) {
    for ((index, value) in result.withIndex()) {
        if (value == valueResult) {
            val indexNew = index+1
            println("Pemain $indexNew Tereliminasi  ")
        }
    }
}