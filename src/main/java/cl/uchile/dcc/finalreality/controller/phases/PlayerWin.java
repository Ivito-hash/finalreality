package cl.uchile.dcc.finalreality.controller.phases;


/**
 * This represents the Player Win phase.
 *
 * @author ~Ivo Fuenzalida~
 */
public class PlayerWin extends Phase {

    /**
     * How this phase is an PlayerWin phase, this function returns True.
     */
    @Override
    public boolean isPlayerWin() {return true;}

    /**
     * Returns the name of the phase.
     */
    @Override
    public String getName() {return "Player Win Phase";}
}
