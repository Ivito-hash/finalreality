package cl.uchile.dcc.finalreality.model.Spell;


import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class Poison implements SpellInterface {
    @Override
    public int cast(GameCharacter gameCharacter, int dealtDamage)  {
        gameCharacter.poisoned();
        return 45;
    }
}