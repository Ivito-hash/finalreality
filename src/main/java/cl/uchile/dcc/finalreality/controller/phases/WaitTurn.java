package cl.uchile.dcc.finalreality.controller.phases;


/**
 * This represents the Wait Turn phase.
 *
 * @author ~Ivo Fuenzalida~
 */
public class WaitTurn extends Phase {

    /**
     * When a turn begin, change this phase to the Turn.
     */
    @Override
    public void toTurn() {
        changePhase(new Turn());
    }

    /**
     * How this phase is a WaiTurn phase, this function returns True.
     */
    @Override
    public boolean isWaitTurn() {return true;}

    /**
     * Returns the name of the phase.
     */
    @Override
    public String getName() {return "Waiting For Turn Phase";}
}
