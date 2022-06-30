fun main() {

    val bot = Player().apply { name = "robot" }
    val player = Player().apply { name = "player" }

    //println("Masukan nama kamu :")

    //val namePlayer = readLine()
    //println("Hi, $namePlayer !! Selamat Bermain")

    //println("Pilih (Gunting, Batu, Kertas)")
    //print("Input : ")

//    val player = readLine()

    val winner = SuitRule.suit(player, bot)
    println("player: ${player.type}")
    println("robot: ${bot.type}")
    println("winner: ${winner?.name ?: "draw"}")
}


class Player {
    var name: String = ""
    var type: SuitType = SuitType.values().random()

    fun suit(): SuitType {
        return type;
    }
}

enum class SuitType {
    KERTAS, GUNTING, BATU
}

object SuitRule {
    fun suit(player1: Player, player2: Player): Player?{
        val suit1 = player1.suit()
        val suit2 = player2.suit()
        return when {
            suit1 == SuitType.KERTAS &&
            suit2 == SuitType.GUNTING -> {
                player2
            }
            suit1 == SuitType.GUNTING &&
            suit2 == SuitType.BATU -> {
                player2
            }
            suit1 == SuitType.BATU &&
            suit2 == SuitType.KERTAS -> {
                player2
            }
            suit1 == SuitType.GUNTING &&
            suit2 == SuitType.KERTAS -> {
                player1
            }
            suit1 == SuitType.BATU &&
            suit2 == SuitType.GUNTING -> {
                player1
            }
            suit1 == SuitType.KERTAS &&
            suit2 == SuitType.BATU -> {
                player1
            }
            else -> null
        }
    }
}

