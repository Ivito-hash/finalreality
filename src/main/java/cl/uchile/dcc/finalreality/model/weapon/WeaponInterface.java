package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
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
  * Returns the type of the weapon.
  */
  WeaponType getType();

  /**
   * method [equipBlackMage] check if a weapon can equip to a Black Mage.
   * return Boolean.
   */
  WeaponInterface equipBlackMage(BlackMage BM);

  /**
   * method [equipEngineer] check if a weapon can equip to Engineer.
   * return Boolean.
   */
  WeaponInterface equipEngineer(Engineer E);

  /**
   * method [equipKnight] check if a weapon can equip to a Knight.
   * return Boolean.
   */
  WeaponInterface equipKnight(Knight K);

  /**
   * method [equipThief] check if a weapon can equip to a Thief.
   * return Boolean.
   */
  WeaponInterface equipThief(Thief T);

  /**
   * method [equipWhiteMage] check if a weapon can equip to a White Mage.
   * return Boolean.
   */
  WeaponInterface equipWhiteMage(WhiteMage WM);

}
