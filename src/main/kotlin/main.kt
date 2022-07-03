fun main() {
    println("====================================")
    println("GAMETERMINAL VERSION")
    println("====================================")
    println("Pilih Game: ")
    println("1. Hopimpa")
    println("2. Suit Jepang")
    println("")
    print("Pilihan: ")
    var status = false
    do {
        val pilihan = readLine()
        if (pilihan == "1") {
            status = true
            val suit = SuitJepang()
            suit.suitJepang()
        } else if (pilihan == "2") {
            println("Permainan Hopimpa")
            println("Mulai Bermain")
            println("Pilihan Jawaban: ")
            println("1. Hitam")
            println("2. Putih")
            println("===================================================================")
            print("Masukkan jumlah pemain: ")
            var statusPemain = true
            lateinit var jumlahPemain: String
            do {
                jumlahPemain = readLine().toString()
                statusPemain = true
                for (item in jumlahPemain) {
                    if (!item.isDigit()) {
                        statusPemain = false
                    }
                }
                if (!statusPemain || jumlahPemain.toInt() <= 2) {
                    println("Error, input jumlah pemain harus berbentuk angka atau jumlahnya lebih dari 2")
                    print("Masukkan kembali jumlah pemain: ")
                    statusPemain = false
                } else {
                    statusPemain = true
                }
            } while (!statusPemain)
            println("===================================================================")
            val hopimpa = HopimpaClass(jumlahPemain.toInt())
            hopimpa.hopimpa()
            status = true
        } else {
            println("Error, pilihan hanya boleh diisi dengan 1 atau 2")
            print("Masukkan kembali pilihan: ")
        }
    } while (!status)
}