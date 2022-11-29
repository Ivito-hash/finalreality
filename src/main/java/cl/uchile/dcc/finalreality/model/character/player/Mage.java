package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A {@link AbstractMageCharacter} that can use mana.
 *
 * @author ~Ivo Fuenzalida~
 */

public interface Mage {
  /**
  * Returns the chracters's mana.
  */
  int getMaxMp();

  /**
  * Returns the chracters's mana.
  */
  int getCurrentMp();

  /**
  * Set the chracters's mana.
  */
  void setCurrentMp(int mana) throws InvalidStatValueException;
}
