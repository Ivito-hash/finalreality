package cl.uchile.dcc.finalreality.controller.phases;


import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.WeaponInterface;

/**
 * This represents the Start Game phase.
 *
 * @author ~Ivo Fuenzalida~
 */
public class StartGame extends Phase{

    /**
     * When the game begins, change this phase to WaitTurn.
     */
    @Override
    public void toWaitTurn() {
        changePhase(new WaitTurn());
    }

    /**
     * How this phase is an StartGame phase, this function returns True.
     */
    @Override
    public boolean isStartGame() {return true;}

    /**
     * How this phase is an StartGame phase, start the game.
     */
    @Override
    public void tryToStartGame() {controller.startGame();}

    /**
     * How this phase is an StartGame phase, the player can equip his characters.
     */
    @Override
    public void tryToEquipPlayerCharacter(PlayerCharacter playerCharacter, WeaponInterface weapon) {
        controller.equipPlayerCharacter(playerCharacter, weapon);
    }

    /**
     * Returns the name of the phase.
     */
    @Override
    public String getName() {return "Start Game Phase";}
}
