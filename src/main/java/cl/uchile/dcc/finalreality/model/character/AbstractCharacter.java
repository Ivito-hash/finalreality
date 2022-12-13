package cl.uchile.dcc.finalreality.model.character;

import java.beans.PropertyChangeSupport;

import cl.uchile.dcc.finalreality.controller.State.State;
import cl.uchile.dcc.finalreality.controller.eventHandler.Handler;
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

  private final String name;
  protected int maxHp;
  private int currentHp;
  private final int defense;
  protected final BlockingQueue<GameCharacter> turnsQueue;
  protected ScheduledExecutorService scheduledExecutor;
  private final PropertyChangeSupport characterDeathEvent;
  private final PropertyChangeSupport addToQueueEvent;
  protected boolean isAlive;
  private State state;

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
    characterDeathEvent = new PropertyChangeSupport(this);
    addToQueueEvent = new PropertyChangeSupport(this);
    this.name = name;
    this.currentHp = maxHp;
    this.maxHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
    this.isAlive = true;
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

  public void setState(State state) {
    this.state = state;
    this.state.setGameCharacter(this);
  }

  public State getState() {
    return this.state;
  }

  public void burn() {
    state.burn();
  }

  public void normal() {
    state.normal();
  }

  public void paralize() {
    state.paralize();
  }

  public void poisoned() {
    state.poisoned();
  }

  public boolean isBurn() {
    return state.isBurn();
  }

  public boolean isNormal() {
    return state.isNormal();
  }

  public boolean isParalize() {
    return state.isParalize();
  }

  public boolean isPoisoned() {
    return state.isPoisoned();
  }

  /**
   * Returns a boolean value depending on if character is a live return True.
   * else, if character is dead, return False.
   */
  @Override
  public boolean isAlive() {
    return this.isAlive;
  }

  /**
   * The character realize an attack.
   */
  @Override
  public void attack(GameCharacter character) {
    if (this.isAlive() && character.isAlive()) {
      character.attackedBy(this.getDamageCharacter());
    }
  }

  /**
   * The character get damaged.
   */
  @Override
  public void attackedBy(int damage) {
    int receivedDamage = damage - this.getDefense();
    int currentHP = this.getCurrentHp();

    if (receivedDamage < 0) {
      receivedDamage = 0;
    }

    try {
      this.setCurrentHp(currentHP - receivedDamage);
    } catch (InvalidStatValueException e) {
      throw new RuntimeException(e);
    }

    if (this.getCurrentHp() <= 0) {
      this.isAlive = false;
      characterDeathEvent.firePropertyChange(
              "Character´s Death", null, this
      );
    }
  }

  /**
   * Adds this character's death event as a suscriber to the respective Death Handler.
   */
  @Override
  public void addSubscriberForDeath(Handler deathHandler) {
    characterDeathEvent.addPropertyChangeListener(deathHandler);
  }

  /**
   * Adds this character's queue event as a suscriber to the QueueCharacterHandler.
   */
  @Override
  public void addSubscriberForAddToQueue(Handler addToQueueHandler) {
    addToQueueEvent.addPropertyChangeListener(addToQueueHandler);
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
