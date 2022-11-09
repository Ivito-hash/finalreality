package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import cl.uchile.dcc.finalreality.model.weapon.WeaponInterface;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public abstract class Weapon implements WeaponInterface {
  protected final String name;
  protected int damage;
  protected int weight;
  protected WeaponType type;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  public Weapon(@NotNull String name, int damage, int weight,
      WeaponType type) throws InvalidStatValueException{
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
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

  /**
   * Returns the type of the weapon.
   */
  public WeaponType getType() {
    return type;
  }

  @Override
  public WeaponInterface equipBlackMage(BlackMage BM) {
    return null;
  }

  @Override
  public WeaponInterface equipEngineer(Engineer E) {
    return null;
  }

  @Override
  public WeaponInterface equipKnight(Knight K) {
    return null;
  }

  @Override
  public WeaponInterface equipThief(Thief T) {
    return null;
  }

  @Override
  public WeaponInterface equipWhiteMage(WhiteMage WM) {
    return null;
  }
}
