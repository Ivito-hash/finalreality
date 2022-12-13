package cl.uchile.dcc.finalreality.controller.State;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class State {
    private GameCharacter gameCharacter;

    public void setGameCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    void changeState(State state) {
        gameCharacter.setState(state);
    }
    void error() {
        System.out.println("No valid state"); //No me dejo usar Invalid State :/

    }

    public void burn() {
        error();
    }

    public void normal() {
        error();
    }

    public void paralize() {
        error();
    }

    public void poisoned() {
        error();
    }

    public boolean isBurn() {
        return false;
    }
    public boolean isNormal() {
        return false;
    }
    public boolean isParalize() {
        return false;
    }
    public boolean isPoisoned() {
        return false;
    }
}
