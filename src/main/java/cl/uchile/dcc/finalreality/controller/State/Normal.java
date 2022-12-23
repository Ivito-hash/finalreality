package cl.uchile.dcc.finalreality.controller.State;

public class Normal extends State {

    public void paralize() {
        this.changeState(new Paralized());
    }

    public void burn() {
        this.changeState(new Burned());
    }

    public void poisoned() {
        this.changeState(new Poisoned());
    }

    @Override
    public boolean isNormal() {
        return true;
    }
}
