package cl.uchile.dcc.finalreality.controller.eventHandler;

import cl.uchile.dcc.finalreality.controller.GameController;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import java.beans.PropertyChangeEvent;

/**
 * Enemy´s death handler.
 * This work as a subscriber of Enemy´s death events.
 *
 * @author ~Ivo Fuenzalida~
 */
public class DeathEnemyHandler implements Handler {
    private final GameController controller;

    /**
     * Constructor of EnemyDeathHandler.
     */
    public DeathEnemyHandler(GameController controller) {
        this.controller = controller;
    }

    /**
     * Call the controller's onEnemyDeath method.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.onEnemyDeath((Enemy) evt.getNewValue());
    }
}
