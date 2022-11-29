package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;

/**
 * This represents a weapon from the game.
 * A weapon can be used by the player.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public interface WeaponInterface {

  /**
  * Returns the name of the weapon.
  */
  String getName();

  /**
  * Returns the damage to the weapon.
  */
  int getDamage();

  /**
  * Returns the weight of the weapon.
  */
  int getWeight();

  /**
   * method [equipBlackMage] equip weaponto a Black Mage.
   */
  void equipBlackMage(BlackMage blackmage);

  /**
   * method [equipEngineer] equip weapon to Engineer.
   */
  void equipEngineer(Engineer engineer);

  /**
   * method [equipKnight] equip weapon to a Knight.
   */
  void equipKnight(Knight knight);

  /**
   * method [equipThief] equip weapon to a Thief.
   */
  void equipThief(Thief thief);

  /**
   * method [equipWhiteMage] equip weapon to a White Mage.
   */
  void equipWhiteMage(WhiteMage whitemage);

  /**
   * method [toString]
   * returns a String with the class of this weapon.
   */
}
