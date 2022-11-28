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
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * Bow Class.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public class Bow extends Weapon {

  /**
   * Creates a new bow.
   *
   * @param name
   *     the bow's name
   * @param damage
   *     the bow's damage
   * @param weight
   *     the bow's weight
   */
  public Bow(final @NotNull String name, final int damage, final int weight)
             throws InvalidStatValueException {
    super(name, damage, weight);
  }

  /**
   * A bow will be equipped on Engineer.
   */
  @Override
  public void equipEngineer(Engineer engineer) {
    engineer.setEquippedWeapon(this);
  }

  /**
   * A bow will be equipped on a Thief.
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
    if (!(o instanceof Bow)) {
      return false;
    }
    final Bow weapon = (Bow) o;
    return getName().equals(weapon.getName())
           && getDamage() == weapon.getDamage()
           && getWeight() == weapon.getWeight();
  }

  @Override
  public String toString() {
    return "Bow";
  }

  @Override
  public int hashCode() {
    return Objects.hash(Bow.class, getName(), getDamage(), getWeight());
  }
}
