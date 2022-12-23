package cl.uchile.dcc.finalreality.controller.phases;


import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.WeaponInterface;

/**
 * This represents the Player Action phase.
 *
 * @author ~Ivo Fuenzalida~
 */
public class PlayerAction extends Phase {

    /**
     * When the player do his action his turn end, and change this phase to WaitTurn.
     */
    @Override
    public void toWaitTurn() {
        changePhase(new WaitTurn());
    }

    /**
     * When the player make an action to kill the last enemy.
     * The player wins, and change this phase to PlayerWin.
     */
    @Override
    public void toPlayerWin() {
        changePhase(new PlayerWin());
    }

    /**
     * How this phase is an PlayerAction phase, this function returns True.
     */
    @Override
    public boolean isPlayerAction() {return true;}


    /**
     * How this phase is an PlayerAction phase, players can attack.
     */
    @Override
    public void tryToAttackCharacter(GameCharacter attackerCharacter, GameCharacter attackedCharacter) {
        controller.attackCharacter(attackerCharacter, attackedCharacter);
    }

    /**
     * How this phase is an PlayerAction phase, the player can change his characters weapons.
     */
    @Override
    public void tryToEquipPlayerCharacter(PlayerCharacter playerCharacter, WeaponInterface weapon) {
        controller.equipPlayerCharacter(playerCharacter, weapon);
    }

    /**
     * Returns the name of the phase.
     */
    @Override
    public String getName() {return "Player Action Phase";}
}
