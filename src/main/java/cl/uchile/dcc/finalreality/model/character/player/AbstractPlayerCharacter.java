/*
 * "Final Reality" (c) by R8V and ~Ivo Fuenzalida~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponInterface;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * <p>All player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link Weapon}.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements
    PlayerCharacter {

  private WeaponInterface equippedWeapon;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
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
  protected AbstractPlayerCharacter(@NotNull String name, int maxHp, int defense,
                                    @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    this.equippedWeapon = null;
  }

  /**
   * Return equipped weapon by character.
   */
  @Override
  public WeaponInterface getEquippedWeapon() {
    return equippedWeapon;
  }

  /**
   * Set weapon to player character.
   */
  @Override
  public void setEquippedWeapon(WeaponInterface weapon) {
    this.equippedWeapon = weapon;
  }

  /**
   * Returns this player character's attack damage depending on whether a weapon is equipped.
   */
  @Override
  public int getDamageCharacter() {
    if (this.equippedWeapon == null) {
      return 0;
    } else {
      return this.equippedWeapon.getDamage();
    }
  }

  @Override
  public int turnType() {
    return 1;
  }

  /**
   * Create the standby instance of the character.
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
              /* command = */ this::addToQueue,
              /* delay = */ getEquippedWeapon().getWeight() / 10,
              /* unit = */ TimeUnit.SECONDS);
  }
}