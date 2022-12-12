package cl.uchile.dcc.finalreality.controller.eventHandler;

import java.beans.PropertyChangeEvent;

/**
 * Enemy´s death handler.
 * The EnemyDeathHandler class work as a subscriber of Enemy´s death events
 *
 * @author ~Ivo Fuenzalida~
 */
public class DeathEnemyHandler implements Handler {
    private final GameController controller;

    /**
     * Constructor of EnemyDeathHandler.
     * Association between the real subscriber a.k.a Enemy's death handler, and the game controller
     */
    public DeathEnemyHandler(GameController controller) {
        this.controller = controller;
    }

    /**
     * Override of the PropertyChangeListener interface method.
     * It is called when a change is notified, receives the event that suffered the modification.
     * (In this case what it does is call the controller's onEnemyDeath method)
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.onEnemyDeath((Enemy) evt.getNewValue());
    }
}
