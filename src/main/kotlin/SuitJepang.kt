class SuitJepang() {
    fun suitJepang() {

        val bot = Player().apply { name = "Robot" }
        val player = Player().apply { name = "Player" }

        println("Permainan Suit Jepang (Gunting, Batu, Kertas)")
//        println("Masukan nama kamu :")

//        val namePlayer = readLine()
//        player.name = namePlayer
//        println("Hi, $namePlayer !! Selamat Bermain")

        println("Pilih")
        println("1. Kertas")
        println("2. Gunting")
        println("3. Batu")
        print("Input : ")

        val input = readLine()?.toInt()
        val type = SuitType.getType(input)
        player.type = type

        val winner = SuitRule.suit(player, bot)
        println("Player: ${player.type}")
        println("Robot: ${bot.type}")
        println("Winner: ${winner?.name ?: "draw"}")
    }

    class Player {
        var name: String? = null
        var type: SuitType? = null

        fun suit(): SuitType {
            return type ?: run {
                val choose = SuitType.values().random()
                type = choose
                choose
            }
        }
    }

    enum class SuitType(val id: Int) {
        KERTAS(1), GUNTING(2), BATU(3);

        companion object {
            fun getType(id: Int?): SuitType? {
                return SuitType.values().find { it.id == id }
            }
        }
    }

    object SuitRule {
        fun suit(player1: Player, player2: Player): Player? {
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
}



