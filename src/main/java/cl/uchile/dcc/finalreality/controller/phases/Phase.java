package cl.uchile.dcc.finalreality.controller.phases;

import cl.uchile.dcc.finalreality.controller.GameController;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.WeaponInterface;

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
    public void toPlayerSelect() {}

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
    public boolean isEnemyActionPhase() {return false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isEnemyWinPhase() {return false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isPlayerSelectPhase() {return false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isPlayerWinPhase() {return false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isStartGamePhase() {return false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isTurnPhase() {return  false;}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isWaitingForTurnPhase() {return false;}

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

