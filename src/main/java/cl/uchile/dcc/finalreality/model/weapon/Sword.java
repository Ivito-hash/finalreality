/*
 * "Final Reality" (c) by R8V and ~Ivo Fuenzalida~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * Sword Class.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public class Sword extends Weapon {

  /**
   * Creates a new sword.
   *
   * @param name
   *     the sword's name
   * @param damage
   *     the sword's damage
   * @param weight
   *     the sword's weight
   */
  public Sword(final @NotNull String name, final int damage, final int weight)
               throws InvalidStatValueException {
    super(name, damage, weight);
  }

  /**
   * A sword will be equipped on a Knight.
   */
  @Override
  public void equipKnight(Knight knight) {
    knight.setEquippedWeapon(this);
  }

  /**
   * A sword will be equipped on a Thief.
   */
  @Override
  public void equipThief(Thief thief) {
    thief.setEquippedWeapon(this);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Sword weapon)) {
      return false;
    }
    return getName().equals(weapon.getName())
           && getDamage() == weapon.getDamage()
           && getWeight() == weapon.getWeight();
  }

  @Override
  public String toString() {
    return "Sword{name='%s', damage=%d, weight=%d}"
        .formatted(getName(), getDamage(), getWeight());
  }

  @Override
  public int hashCode() {
    return Objects.hash(Sword.class, getName(), getDamage(), getWeight());
  }
}
