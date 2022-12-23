package cl.uchile.dcc.finalreality.controller.phases;

import cl.uchile.dcc.finalreality.controller.GameController;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.WeaponInterface;

/**
 * This represents the phases of the game.
 * Use state pattern.
 *
 * @author ~Ivo Fuenzalida~
 */

public class Phase {
    protected GameController controller;
    public void setGameController(GameController controller) {
        this.controller = controller;
    }

    /**
     * Change the actual phase to another phase.
     */
    protected void changePhase(Phase phase) {
        controller.setPhase(phase);
    }

    /**
     * Change the actual phase to the Enemy Action phase.
     */
    public void toEnemyAction() {}

    /**
     * Change the actual phase to the Enemy Win phase.
     */
    public void toEnemyWin() {}

    /**
     * Change the actual phase to the Player Select phase.
     */
    public void toPlayerAction() {}

    /**
     * Change the actual phase to the Player Win phase.
     */
    public void toPlayerWin() {}

    /**
     * Change the actual phase to the Turn phase.
     */
    public void toTurn() {}

    /**
     * Change the actual phase to the Wait Turn phase.
     */
    public void toWaitTurn() {}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isEnemyAction() {return false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isEnemyWin() {return false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isPlayerAction() {return false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isPlayerWin() {return false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isStartGame() {return false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isTurn() {return  false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isWaitTurn() {return false;}

    /**
     * Functions than do something only if the game is in the correct phase.
     */
    public void tryToStartGame() { }
    public void tryToBeginTurn() {}
    public void tryToEquipPlayerCharacter(PlayerCharacter playerCharacter, WeaponInterface weapon) { }
    public void tryToAttackCharacter(GameCharacter attackerCharacter, GameCharacter attackedCharacter) { }

    /**
     * Returns the name of the phase
     */
    public String getName() {return "";}
}

