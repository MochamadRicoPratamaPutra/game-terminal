import kotlin.random.Random

fun main() {

    val bot = Player().apply { name = "robot" }
    val player = Player().apply { name = "player" }

    val winner = SuitRule.suit(player, bot)
    println("player: ${player.type}")
    println("robot: ${bot.type}")
    println("winner: ${winner?.name ?: "draw"}")
}
class Player {
    var name: String = ""
    var type: SuitType? = null

    fun suit(): SuitType {
        return type ?: SuitType.values().random()
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
            suit1 == SuitType.KERTAS &&
            suit2 == SuitType.BATU -> {
                player1
            }
            suit1 == SuitType.BATU &&
            suit2 == SuitType.GUNTING -> {
                player1
            }
            suit1 == SuitType.BATU &&
            suit2 == SuitType.KERTAS -> {
                player1
            }
            else -> null
        }
    }
}

//    class player(
//        var suit1 = Batu: String,
//        var Gunting: String,
//        var Kertas: String
//    ){
//        val randomInt = Random.nextInt(3)+1
//        val playerResource = when (randomInt){
//            1 -> "Batu"
//            2 -> "Gunting"
//            else -> "Kertas"
//
//        }
//    }
//    println()
