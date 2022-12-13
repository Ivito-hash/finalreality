package cl.uchile.dcc.finalreality.controller.phases;


import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * This represents the Enemy Action phase.
 *
 * @author ~Ivo Fuenzalida~
 */
public class EnemyAction extends Phase {

    /**
     * When an enemy do his action his turn end, and change this phase to WaitTurn.
     */
    @Override
    public void toWaitTurn() {
        changePhase(new WaitTurn());
    }

    /**
     * When an enemy make an action to kill the last player character.
     * The enemy team win, and change this phase to EnemyWin.
     */
    @Override
    public void toEnemyWin() {
        changePhase(new EnemyWin());
    }

    /**
     * How this phase is an EnemyAction phase, this function returns True.
     */
    @Override
    public boolean isEnemyAction() {return true;}

    /**
     * How this phase is an EnemyAction phase, enemies can attack.
     */
    @Override
    public void tryToAttackCharacter(GameCharacter attackerCharacter, GameCharacter attackedCharacter) {
        controller.attackCharacter(attackerCharacter, attackedCharacter);
    }

    /**
     * Returns the name of the phase.
     */
    @Override
    public String getName() {return "Enemy Action Phase";}
}
