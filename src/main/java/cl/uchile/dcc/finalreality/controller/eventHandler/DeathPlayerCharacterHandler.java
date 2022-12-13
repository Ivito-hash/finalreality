package cl.uchile.dcc.finalreality.controller.eventHandler;

import cl.uchile.dcc.finalreality.controller.GameController;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.beans.PropertyChangeEvent;

/**
 * PlayerCharacter´s death handler.
 * This work as a subscriber of PlayerCharacter´s death events.
 *
 * @author ~Ivo Fuenzalida~
 */
public class DeathPlayerCharacterHandler implements Handler {
    private final GameController controller;

    /**
     * Constructor of PlayerCharacterDeathHandler.
     */
    public DeathPlayerCharacterHandler(GameController controller) {
        this.controller = controller;
    }

    /**
     * Call the controller's onPlayerCharacterDeath method.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.onPlayerCharacterDeath((PlayerCharacter) evt.getNewValue());
    }
}
