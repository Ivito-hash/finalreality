package cl.uchile.dcc.finalreality.controller.eventHandler;

import cl.uchile.dcc.finalreality.controller.GameController;
import java.beans.PropertyChangeEvent;

/**
 * GameCharacter's add to queue handler.
 * This work as a subscriber of GameCharacter's added to queue events.
 *
 * @author ~Ivo Fuenzalida~
 */
public class QueueCharacterHandler implements Handler {
    private final GameController controller;

    /**
     * Constructor of QueueCharacterHandler.
     */
    public QueueCharacterHandler(GameController controller) {
        this.controller = controller;
    }

    /**
     * Call the controller's tryToTakeTurn method.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.tryToTakeTurn();
    }
}
