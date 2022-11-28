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
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A White Mage is a type of player character that can cast white magic.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public class WhiteMage extends AbstractMageCharacter {

  /**
   * Creates a new Black Mage.
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
  public WhiteMage(final @NotNull String name, final int maxHp, final int maxMp,
          final int defense, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, maxMp, defense, turnsQueue);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final WhiteMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && name.equals(that.name)
            && maxHp == that.maxHp
            && maxMp == that.maxMp
            && defense == that.defense;
  }

  public void equip(Weapon weapon) {
    equippedWeapon = (Weapon) weapon.equipWhiteMage(this);
  }

  @Override
  public String toString() {
    return "WhiteMage{maxHp=%d, maxMp=%d, defense=%d, name='%s'}"
            .formatted(maxHp, maxMp, defense, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, name, maxHp, maxMp, defense);
  }
}
