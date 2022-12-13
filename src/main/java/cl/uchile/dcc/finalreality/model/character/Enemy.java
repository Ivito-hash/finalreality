package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
   *
   * @param name
   *     the enemy's name
   * @param maxHp
   *     the enemy's health
   * @param defense
   *     the enemy's defense
   * @param damage
   *     the enemy's damage
   * @param weight
   *     the enemy's weight
   * @param turnsQueue
   *     the queue with all the characters waiting for their turn
   *
   */
  public Enemy(@NotNull final String name, int maxHp, int defense, int damage,
               final int weight, @NotNull final BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    Require.statValueAtLeast(1, damage, "Damage");
    this.damage = damage;
    this.weight = weight;
  }

  /**
   * Returns the damage to this enemy.
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return hashCode() == enemy.hashCode()
        && getName().equals(enemy.getName())
        && getMaxHp() == enemy.getMaxHp()
        && getDefense() == enemy.getDefense()
        && getDamage() == enemy.getDamage()
        && getWeight() == enemy.getWeight();
  }

  @Override
  public String toString() {
    return "Enemy{name='%s', maxHp=%d, defense=%d, damage=%d, weight=%d}"
            .formatted(getName(), getMaxHp(), getDefense(), getDamage(), getWeight());
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, getName(), getMaxHp(), getDefense(), getDamage(), getWeight());
  }

  @Override
  public int turnType() {
    return 0;
  }

  /**
   * Create the standby instance of the character.
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
              /* command = */ this::addToQueue,
              /* delay = */ getWeight() / 10,
              /* unit = */ TimeUnit.SECONDS);
  }

  /**
   * Returns this enemy's attack damage depending on their state.
   */
  @Override
  public int getDamageCharacter() {
    if (!this.isAlive()) {
      return 0;
    }
    else {
      return this.getDamage();
    }
  }
}
