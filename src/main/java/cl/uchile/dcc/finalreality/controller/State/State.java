package cl.uchile.dcc.finalreality.controller.State;

public class State {
    private State state;

    public void setState(State state) {
        this.state = state;
        this.state.setGameCharacter(this);
    }

    public State getState() {
        return this.state;
    }

    public void paralize() {
        state.paralize();
    }

}
