import entity.Monster
import entity.Player

fun main() {

    //TODO( health = 50 - limit for example )
    val player = Player(50,20,20,1..10)
    println("Player:")
    println("HP: ${player._health}")
    println("ATT: ${player._attack}")
    println("DEF: ${player._defense}")
    println("DAM: ${player._damage?.first}-${player._damage?.last}")

    val monster = Monster(30,10,15,2..15)
    println("\nMonster:")
    println("HP: ${monster._health}")
    println("ATT: ${monster._attack}")
    println("DEF: ${monster._defense}")
    println("DAM: ${monster._damage?.first}-${monster._damage?.last}")

    do{
        player.dealDamage(monster)
        if(monster._health == null ){
            break
        }
        monster.dealDamage(player)
        if(player._health == null ){
            break
        }
        player.heal()
    }while (monster._health!! > 0 || player._health!! > 0)


}