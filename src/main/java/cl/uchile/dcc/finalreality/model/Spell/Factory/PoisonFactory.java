package cl.uchile.dcc.finalreality.model.Spell.Factory;

import cl.uchile.dcc.finalreality.model.Spell.Poison;

/**
 * The Poison Spell Factory.
 *
 * @author ~Ivo Fuenzalida~
 */
public class PoisonFactory implements SpellFactory{
    public Poison create() {
        return new Poison();
    }
}
