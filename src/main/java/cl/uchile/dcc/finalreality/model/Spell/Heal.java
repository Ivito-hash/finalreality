package cl.uchile.dcc.finalreality.model.Spell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import static java.lang.Math.min;

public class Heal implements SpellInterface {
    @Override
    public int cast(GameCharacter gameCharacter, int dealtDamage) throws InvalidStatValueException {
        int heal = (int) (gameCharacter.getMaxHp() * 0.3);
        gameCharacter.setCurrentHp(min(heal + gameCharacter.getCurrentHp(),
                gameCharacter.getMaxHp()));
        gameCharacter.setState(new Normal());
        return 15;
    }
}