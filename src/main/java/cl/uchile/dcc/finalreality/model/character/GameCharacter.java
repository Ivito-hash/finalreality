package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.controller.State.State;
import cl.uchile.dcc.finalreality.controller.eventHandler.Handler;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public interface GameCharacter {

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's current HP.
   */
  int getCurrentHp();

  /**
   * Returns this character's max HP.
   */
  int getMaxHp();

  /**
   * Sets this character's current HP to {@code newHp}.
   */
  void setCurrentHp(int hp) throws InvalidStatValueException;

  /**
   * Returns this character's defense.
   */
  int getDefense();

  /**
   * @return int value that represents this character class.
   * if the value is 1, it is a playerCharacter turn.
   * if the value is 0, it is an enemy turn.
   */
  int turnType();

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Adds this character to the turns queue.
   */
  void addToQueue();

  /**
   * Returns a boolean value depending on the character condition.
   * (True if the character is alive and false if the character is dead.)
   */
  boolean isAlive();

  /**
   * Returns this character's attack damage.
   */
  int getDamageCharacter();

  /**
   * The character performs an attack
   */
  void attack(GameCharacter character);

  /**
   * The character get damaged
   */
  void attackedBy(int damage);

  /**
   * Adds a subscriber to this character's death event
   * (the subscriber is the DeathHandler)
   */
  void addSubscriberForDeath(Handler deathHandler);

  /**
   * Adds a subscriber to this character's add to queue event
   * (the subscriber is the addToQueueHandler)
   */
  void addSubscriberForAddToQueue(Handler addToQueueHandler);

  void setState(State state);
  State getState();
  void burn();
  void normal();
  void poisoned();
  void paralize();
  boolean isBurn();
  boolean isNormal();
  boolean isParalize();
  boolean isPoisoned();
}
