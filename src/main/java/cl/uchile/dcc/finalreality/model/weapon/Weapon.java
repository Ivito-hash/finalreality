package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public abstract class Weapon implements WeaponInterface {
  private final String name;
  private final int damage;
  private final int weight;

  /**
   * Creates a weapon with a name, a base damage, and speed.
   */
  public Weapon(final @NotNull String name, final int damage, final int weight)
                throws InvalidStatValueException {
    Require.statValueAtLeast(1, damage, "Damage");
    Require.statValueAtLeast(1, weight, "Weight");
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  /**
   * Returns the name of the weapon.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the damage to the weapon.
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public void equipBlackMage(BlackMage blackmage) {
    blackmage.setEquippedWeapon(null);
  }

  @Override
  public void equipEngineer(Engineer engineer) {
    engineer.setEquippedWeapon(null);
  }

  @Override
  public void equipKnight(Knight knight) {
    knight.setEquippedWeapon(null);
  }

  @Override
  public void equipThief(Thief thief) {
    thief.setEquippedWeapon(null);
  }

  @Override
  public void equipWhiteMage(WhiteMage whitemage) {
    whitemage.setEquippedWeapon(null);
  }
}
