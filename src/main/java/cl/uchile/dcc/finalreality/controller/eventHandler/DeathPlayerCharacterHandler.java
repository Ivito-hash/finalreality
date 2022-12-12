package cl.uchile.dcc.finalreality.controller.eventHandler;

import java.beans.PropertyChangeEvent;

/**
 * PlayerCharacter´s death handler.
 * The PlayerCharacterDeathHandler class work as a subscriber of PlayerCharacter´s death events
 *
 * @author ~Ivo Fuenzalida~
 */
public class DeathPlayerCharacterHandler implements Handler {
    private final GameController controller;

    /**
     * Constructor of PlayerCharacterDeathHandler.
     * Association between the real subscriber a.k.a PlayerCharacter's death handler, and the game controller
     */
    public DeathPlayerCharacterHandler(GameController controller) {
        this.controller = controller;
    }

    /**
     * Override of the PropertyChangeListener interface method.
     * It is called when a change is notified, receives the event that suffered the modification.
     * (In this case what it does is call the controller's onPlayerCharacterDeath method)
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.onPlayerCharacterDeath((IPlayerCharacter) evt.getNewValue());
    }
}
