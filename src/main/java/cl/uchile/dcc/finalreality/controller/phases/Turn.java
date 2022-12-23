package cl.uchile.dcc.finalreality.controller.phases;


/**
 * This represents the Turn phase.
 *
 * @author ~Ivo Fuenzalida~
 */
public class Turn extends Phase {

    /**
     * When a turn start and the player goes first, change this phase to PlayerAction.
     */
    @Override
    public void toPlayerAction() {
        changePhase(new PlayerAction());
    }

    /**
     * When a turn start and the enemy's goes first, change  this phase to EnemyAction.
     */
    @Override
    public void toEnemyAction() {
        changePhase(new EnemyAction());
    }

    /**
     * When a turn start the turn owner could be dead.
     * Change this phase to WaitTurn, to wait for a new turn.
     */
    @Override
    public void toWaitTurn() {
        changePhase(new WaitTurn());
    }

    /**
     * How this phase is a Turn phase, this function returns True.
     */
    @Override
    public boolean isTurn() {return true;}

    /**
     * How this phase is a Turn phase, begin a turn.
     */
    @Override
    public void tryToBeginTurn() {controller.beginTurn();}

    /**
     * Returns the name of the phase.
     */
    @Override
    public String getName() {return "Turn Phase";}
}
