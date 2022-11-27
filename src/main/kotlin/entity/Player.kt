package entity

class Player(_health: Int?, _defense: Int?, _attack: Int?, _damage: IntRange?) : Creature(_health, _defense, _attack, _damage) {

    private var healCounter = 3

    fun heal() {
        if (healCounter == 0) {
            println("\nYou can't heal yourself anymore")
            return
        }
        if(_health != hpLimit){
            _health = _health?.plus((hpLimit / 2))
            if (_health!! > hpLimit) {
                _health = hpLimit
            }
            healCounter -= 1
            return println("\nYou have healed yourself to $_health.\nYou can cure yourself $healCounter more times")

        }
        else{
            return println("\nNo need to be treated.\nYou have full health")
        }
    }
}