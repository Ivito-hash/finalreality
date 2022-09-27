package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public class Enemy extends AbstractCharacter {

  private final int damage;
  private final int weight;

  /**
   * Creates a new enemy with a name, a damage, a weight and
   * the queue with the characters ready to play.
   */
  public Enemy(@NotNull final String name, int maxHp, int defense, int damage,
               final int weight, @NotNull final BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    Require.statValueAtLeast(0, damage, "Damage");
    this.damage = damage;
    this.weight = weight;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the damage to this enemy.
   */
  public int getDamage() {
    return damage;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
        && name.equals(enemy.name)
        && maxHp == enemy.maxHp
        && defense == enemy.defense
        && damage == enemy.damage
        && weight == enemy.weight;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, name, maxHp, defense, damage, weight);
  }
}
