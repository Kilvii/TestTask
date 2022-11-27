package entity

abstract class Creature(
    var _health: Int?,
    var _defense: Int?,
    var _attack: Int?,
    var _damage: IntRange?
    ){

    val hpLimit = 50
    private val attAndDefLimit = 20
    private val diceRange = IntRange(1,6)

    init {
        if ( _health!! <= 0 || _defense!! <= 0 || _attack!! <= 0){
            throw Exception("An object property cannot be less than or equal to 0!")
        }
        if( _health!! > hpLimit){
            throw Exception("The property (_health) cannot be longer than $hpLimit")
        }
        if( _attack!! > attAndDefLimit || _defense!! > attAndDefLimit){
            throw Exception("The property (_attack) or (_defense) cannot be longer than $attAndDefLimit")
        }
        if( _damage?.start!! < 0 || _damage?.endInclusive!! < 0 ){
            throw Exception("The value of the (_damage) property cannot be less than 0")
        }
        if( _damage!!.first >= _damage!!.last){
            throw Exception("The value of the (_damage) property is set incorrectly")
        }
    }

    fun dealDamage(enemy: Creature) {
        var attackModifier = (_attack?.minus(enemy._defense!!))?.plus(1)
        if (attackModifier != null) {
            if(attackModifier <= 0){
                attackModifier = 1
            }
        }

        var success = false
        for(i in 1..attackModifier!!){
            if(rollTheDice(diceRange) == 5 ||rollTheDice(diceRange) == 6){
                success = true
            }
        }

        if(success){
            val hit = _damage?.random()
            enemy._health = hit?.let { enemy._health?.minus(it) }
            println("\nSuccessful hit!\nDealt $hit damage to the $enemy")
            if(death(enemy)){
                println("Killed $enemy")
            }
        }
        else{
            return println("\nMiss on character $enemy")
        }
    }

    private fun rollTheDice(range:IntRange): Int {
        return range.random()
    }
    private fun death(subject: Creature): Boolean {
        if(subject._health!! <= 0){
            subject._health = null
            subject._attack = null
            subject._defense = null
            subject._damage = null
            return true
        }
        return false
    }

}