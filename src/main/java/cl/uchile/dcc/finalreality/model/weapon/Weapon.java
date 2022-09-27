package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public class Weapon {

  //ola
  private final String name;
  private final int damage;
  private final int weight;
  private final WeaponType type;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  public Weapon(final String name, final int damage, final int weight,
      final WeaponType type) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
  }

  /**
   * Returns the name of the weapon.
   */
  private String getName() {
    return name;
  }

  /**
   * Returns the damage to the weapon.
   */
  private int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the type of the weapon.
   */
  private WeaponType getType() {
    return type;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Weapon weapon)) {
      return false;
    }
    return hashCode() == weapon.hashCode()
        && name.equals(weapon.name)
        && damage == weapon.damage
        && weight == weapon.weight
        && type == weapon.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, name, damage, weight, type);
  }

  @Override
  public String toString() {
    return "Weapon{name='%s', damage=%d, weight=%d, type=%s}"
        .formatted(name, damage, weight, type);
  }
}
