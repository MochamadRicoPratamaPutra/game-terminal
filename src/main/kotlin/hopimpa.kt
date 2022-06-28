fun main() {
    val result = arrayListOf<Any>()
//    var pemain1: String
//    var pemain2: String
//    var pemain3: String
    println("Mulai Bermain")
    for (i in 1..3) {
        println("$i. Masukkan pemain $i: ")
        println("Pilihan Jawaban: ")
        println("1. Hitam")
        println("2. Putih")
        print("Masukkan jawaban: ")
        var tempResult: String
//        do {
            tempResult= readLine().toString()
//            println(tempResult)
//        } while (tempResult != "1" || tempResult != "2")
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
    println("Hitam: $hitam Putih: $putih")
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