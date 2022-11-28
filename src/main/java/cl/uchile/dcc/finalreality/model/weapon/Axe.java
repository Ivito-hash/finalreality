/*
 * "Final Reality" (c) by R8V and ~Ivo Fuenzalida~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * Axe Class.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public class Axe extends Weapon {

  /**
   * Creates a new axe.
   *
   * @param name
   *     the axe's name
   * @param damage
   *     the axe's damage
   * @param weight
   *     the axe's weight
   */
  public Axe(final @NotNull String name, final int damage, final int weight)
             throws InvalidStatValueException {
    super(name, damage, weight);
  }

  /**
   * An axe will be equipped on a Knight.
   */
  @Override
  public void equipKnight(Knight knight) {
    knight.setEquippedWeapon(this);
  }

  /**
   * An axe will be equipped on Engineer.
   */
  @Override
  public void equipEngineer(Engineer engineer) {
    engineer.setEquippedWeapon(this);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Axe)) {
      return false;
    }
    final Axe weapon = (Axe) o;
    return getName().equals(weapon.getName())
            && getDamage() == weapon.getDamage()
            && getWeight() == weapon.getWeight();
  }

  @Override
  public String toString() {
    return "Axe";
  }

  @Override
  public int hashCode() {
    return Objects.hash(Axe.class, getName(), getDamage(), getWeight());
  }
}
