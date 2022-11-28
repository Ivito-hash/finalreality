package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public abstract class AbstractCharacter implements GameCharacter {

  protected final String name;
  private int currentHp;
  protected int maxHp;
  protected int defense;
  protected final BlockingQueue<GameCharacter> turnsQueue;
  protected ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
      @NotNull BlockingQueue<GameCharacter> turnsQueue) throws InvalidStatValueException {
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.name = name;
    this.currentHp = maxHp;
    this.maxHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
  }

  /**
   * Returns the name of the character.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Returns the current health points of the character.
   */
  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  /**
   * Returns the maximum health points of the character.
   */
  @Override
  public int getMaxHp() {
    return maxHp;
  }

  /**
   * Returns the value defense of the character.
   */
  @Override
  public int getDefense() {
    return defense;
  }

  /**
   * Set the system of health points.
   */
  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, hp, "Current HP");
    Require.statValueAtMost(maxHp, hp, "Current HP");
    currentHp = hp;
  }

  /**
   * Adds this character to the turns queue.
   */
  @Override
  public void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }
}
