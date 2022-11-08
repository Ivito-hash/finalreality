package cl.uchile.dcc.finalreality.model.weapon;

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
}
