package cl.uchile.dcc.finalreality.model.Spell;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import static java.lang.Math.max;
import static java.lang.Math.random;

public class Thunder implements SpellInterface {
    @Override
    public int cast(GameCharacter gameCharacter, int dealtDamage) throws InvalidStatValueException {
        int damage = dealtDamage - gameCharacter.getDefense() / 2;
        if (damage > 0) {
            gameCharacter.setCurrentHp(max(gameCharacter.getCurrentHp() - damage, 0));
        }
        int probabilidad = (int) (random() * 100 + 1);
        if (probabilidad >= 30) {
            gameCharacter.paralize();
        }
        return 15;
    }
}