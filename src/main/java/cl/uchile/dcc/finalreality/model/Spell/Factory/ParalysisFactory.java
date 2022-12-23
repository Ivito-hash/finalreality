package cl.uchile.dcc.finalreality.model.Spell.Factory;

import cl.uchile.dcc.finalreality.model.Spell.Paralysis;

/**
 * The Paralysis Spell Factory.
 *
 * @author ~Ivo Fuenzalida~
 */
public class ParalysisFactory implements SpellFactory{
    public Paralysis create() {
        return new Paralysis();
    }
}
