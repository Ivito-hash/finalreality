/*
 * "Final Reality" (c) by R8V and ~Ivo Fuenzalida~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a mage character.
 *
 * <p>The mage characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a Mana poitns value,
 * a queue of {@link GameCharacter}s that are waiting for their turn ({@code turnsQueue}),
 * and can equip a {@link Weapon}.
 *
 * @author ~Ivo Fuenzalida~
 */

public abstract class AbstractMageCharacter extends AbstractPlayerCharacter {

  public final int maxMp;
  public int currentMp;

  /**
   * Creates a new Mage.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param maxMp
   *     the character's max mp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractMageCharacter(final @NotNull String name, final int maxHp, int maxMp,
          final int defense, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max MP");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  /**
   * Returns the character's current MP.
   */
  public int getCurrentMp() {
    return currentMp;
  }

  /**
   * Returns the character's max MP.
   */
  public int getMaxMp() {
    return maxMp;
  }

  /**
   * Sets the character's current MP.
   */
  public void setCurrentMp(final int currentMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, currentMp, "Current MP");
    Require.statValueAtMost(maxMp, currentMp, "Current MP");
    this.currentMp = currentMp;
  }
}