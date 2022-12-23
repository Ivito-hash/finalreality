/*
 * "Final Reality" (c) by R8V and ~Ivo Fuenzalida~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * Staff Class.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public class Staff extends Weapon {

  private final int magic;

  /**
   * Creates a new staff.
   *
   * @param name
   *     the staff's name
   * @param damage
   *     the staff's damage
   * @param magic
   *     the staff's magic damage
   * @param weight
   *     the staff's weight
   */
  public Staff(final @NotNull String name, final int damage, int magic,
               final int weight) throws InvalidStatValueException {
    super(name, damage, weight);
    Require.statValueAtLeast(1, magic, "Magic");
    this.magic = magic;
  }

  /**
   * Returns the ability damage to the weapon.
   */
  @Override
  public int getMagicDamage() {
    return magic;
  }

  /**
   * A staff will be equipped on a WhiteMage.
   */
  @Override
  public void equipWhiteMage(WhiteMage whitemage) {
    whitemage.setEquippedWeapon(this);
  }

  /**
   * A staff will be equipped on a BlackMage .
   */
  @Override
  public void equipBlackMage(BlackMage blackmage) {
    blackmage.setEquippedWeapon(this);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Staff weapon)) {
      return false;
    }
    return getName().equals(weapon.getName())
            && getDamage() == weapon.getDamage()
            && getWeight() == weapon.getWeight();
  }

  @Override
  public String toString() {
    return "Staff{name='%s', damage=%d, magic=%d, weight=%d}"
            .formatted(getName(), getDamage(), getMagicDamage(), getWeight());
  }

  @Override
  public int hashCode() {
    return Objects.hash(Staff.class, getName(), getDamage(), getMagicDamage(), getWeight());
  }
}
