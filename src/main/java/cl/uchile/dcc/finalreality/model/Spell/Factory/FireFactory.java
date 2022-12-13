package cl.uchile.dcc.finalreality.model.Spell.Factory;

import cl.uchile.dcc.finalreality.model.Spell.Fire;

/**
 * The Fire Spell Factory.
 *
 * @author ~Ivo Fuenzalida~
 */
public class FireFactory implements SpellFactory {
    public Fire create() {
        return new Fire();
    }
}
