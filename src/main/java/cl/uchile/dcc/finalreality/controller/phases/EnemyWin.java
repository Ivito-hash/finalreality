package cl.uchile.dcc.finalreality.controller.phases;


/**
 * This represents the Enemy Win phase.
 *
 * @author ~Ivo Fuenzalida~
 */
public class EnemyWin extends Phase {

    /**
     * How this phase is an EnemyWin phase, this function returns True.
     */
    @Override
    public boolean isEnemyWin() {return true;}

    /**
     * Returns the name of the phase.
     */
    @Override
    public String getName() {return "Enemy Win Phase";}
}
