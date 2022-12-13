package cl.uchile.dcc.finalreality.controller.eventHandler;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Interface about handlers, that works how creator of events.
 * @author ~Ivo Fuenzalida~
 */

public interface Handler extends PropertyChangeListener {

    /**
     * Override of the PropertyChangeListener interface method.
     * It is called when a change is notified, receives the event that suffered the modification.
     * (In this case what it does is call the controller's tryToTakeTurn method)
     */
    @Override
    public default void propertyChange(PropertyChangeEvent evt) {
    }
}
