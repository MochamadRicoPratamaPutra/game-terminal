fun main() {
    val result = arrayListOf<Any>()
//    var pemain1: String
//    var pemain2: String
//    var pemain3: String
    println("Permainan Hopimpa")
    println("Mulai Bermain")
    println("Pilihan Jawaban: ")
    println("1. Hitam")
    println("2. Putih")
    for (i in 1..3) {
        println("$i. Pemain $i")
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
        result.add(tempResult.toInt())
    }
    var putih = 0
    var hitam = 0
    for (res in result) {
        if (res == 1) {
            hitam+=1
        } else {
            putih+=1
        }
    }
    for (res in result) {
        println(res)
    }
    println("Hasil: ")
    if (hitam > putih){
        for ((index, value) in result.withIndex()) {
            if (value == 2) {
                val indexNew = index+1
                print("Pemain $indexNew Tereliminasi")
            }
        }
    } else {
        for ((index, value) in result.withIndex()) {
            if (value == 1) {
                val indexNew = index+1
                print("Pemain $indexNew Tereliminasi")
            }
        }
    }
}