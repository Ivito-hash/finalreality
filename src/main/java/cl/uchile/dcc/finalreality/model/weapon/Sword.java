/*
 * "Final Reality" (c) by R8V and ~Ivo Fuenzalida~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Axe}s and {@code Bow}s.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Ivo Fuenzalida~
 */
public class Sword extends Weapon {

  /**
   * Creates a new bow.
   *
   * @param name
   *     the character's name
   * @param damage
   *     the character's max hp
   * @param weight
   *     the character's defense
   * @param type
   *     the queue with the characters waiting for their turn
   */
  public Sword(final @NotNull String name, final int damage, final int weight,
               final WeaponType type) {
    super(name, damage, weight, type);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Sword that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && name.equals(that.name)
            && damage == that.damage
            && weight == that.weight
            && type == that.type;
  }

  @Override
  public String toString() {
    return "Sword{name='%s', damage=%d, weight=%d, type=%s}"
            .formatted(name, damage, weight, type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Sword.class, name, damage, weight, type);
  }
}
