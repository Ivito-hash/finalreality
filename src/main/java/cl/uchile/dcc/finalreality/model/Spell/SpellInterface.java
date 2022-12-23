package cl.uchile.dcc.finalreality.model.Spell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * This represents a spell from the game.
 *
 * @author ~Ivo Fuenzalida~
 */
public interface SpellInterface {
    int cast(GameCharacter gameChracter, int dealtDamage) throws InvalidStatValueException;
}
