package cl.uchile.dcc.finalreality.model.Spell.Factory;

import cl.uchile.dcc.finalreality.model.Spell.Heal;

/**
 * The Heal Spell Factory.
 *
 * @author ~Ivo Fuenzalida~
 */
public class HealFactory implements SpellFactory{
    public Heal create() {
        return new Heal();
    }
}
