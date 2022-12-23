package cl.uchile.dcc.finalreality.model.Spell.Factory;

import cl.uchile.dcc.finalreality.model.Spell.Thunder;

/**
 * The Thunder Spell Factory.
 *
 * @author ~Ivo Fuenzalida~
 */
public class ThunderFactory implements SpellFactory{
    public Thunder create() {
        return new Thunder();
    }
}
