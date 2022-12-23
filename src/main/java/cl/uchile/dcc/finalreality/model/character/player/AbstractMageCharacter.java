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
import cl.uchile.dcc.finalreality.model.Spell.Factory.SpellFactory;
import cl.uchile.dcc.finalreality.model.Spell.SpellInterface;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;

import cl.uchile.dcc.finalreality.model.weapon.WeaponInterface;
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

public abstract class AbstractMageCharacter extends AbstractPlayerCharacter implements Mage {

  protected  int maxMp;
  protected int currentMp;
  private SpellFactory spellFactory;

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
  protected AbstractMageCharacter(@NotNull String name, int maxHp, int maxMp,
          int defense, @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, maxMp, "Max MP");
    this.currentMp = maxMp;
    this.maxMp = maxMp;
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
   * Set the character's current MP.
   */
  public void setCurrentMp(int currentMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, currentMp, "Current MP");
    Require.statValueAtMost(maxMp, currentMp, "Current MP");
    this.currentMp = currentMp;
  }

  /**
   * Set the factory spell.
   */
  public void setFactory(SpellFactory spellFactory) {
    this.spellFactory = spellFactory;
  }

  /**
   * Get the factory spell.
   */
  public SpellFactory getFactory() {
    return this.spellFactory;
  }

  /**
   * Cast a spell from a Mage to another GameCharacter.
   */
  public void castSpell(GameCharacter gameCharacter) throws InvalidStatValueException {
    SpellInterface spell = SpellFactory.create();
    WeaponInterface weapon = getEquippedWeapon();
    int dealtDamage = weapon.getMagicDamage();
    int mp = spell.cast(gameCharacter, dealtDamage);
    setCurrentMp(getCurrentMp() - mp);
  }
}