package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

class ThiefTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Axe Javelin;
    Bow ShortBow;
    Knife Dagger;
    Staff Rod;
    Sword Broadsword;
    /*==========================Characters==========================*/
    Thief Zidane;
    Thief Yitan;
    Thief Yuffie;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*=================================Characters=================================*/
        Zidane = new Thief("Zidane", 105, 21, queue);
        Yitan = new Thief("Zidane", 105, 21, queue);
        Yuffie = new Thief("Yuffie", 98, 18, queue);
        /*===================================Weapons===================================*/
        Javelin = new Axe("Javelin", 18, 20);
        ShortBow = new Bow("Short Bow", 10, 10);
        Dagger = new Knife("Dagger", 12, 23);
        Rod = new Staff("Rod", 11, 23, 21);
        Broadsword = new Sword("Broad Sword", 12, 18);
    }

    @Test
    void equip() {
        assertNull(Zidane.getEquippedWeapon());
        Zidane.equip(Dagger);
        assertNull(Yitan.getEquippedWeapon());
        Yitan.equip(Broadsword);
        assertNotEquals(Zidane.getEquippedWeapon(), Yitan.getEquippedWeapon());
        Zidane.equip(Broadsword);
        assertEquals(Zidane.getEquippedWeapon(), Yitan.getEquippedWeapon());
        Yitan.equip(ShortBow);
        assertNotEquals(Zidane.getEquippedWeapon(), Yitan.getEquippedWeapon());
        Zidane.equip(Javelin);
        assertNull(Zidane.getEquippedWeapon());
        assertNotEquals(Zidane.getEquippedWeapon(), Yitan.getEquippedWeapon());
        Yitan.equip(Rod);
        assertEquals(Zidane.getEquippedWeapon(), Yitan.getEquippedWeapon());
    }

    @Test
    void testEquals() {
        assertEquals(Yitan, Zidane);
        assertNotEquals(Yuffie, Zidane);
    }

    @Test
    void testToString() {
        assertEquals(Zidane.toString(), "Thief{name='"+Zidane.getName()+"', maxHp="+Zidane.getMaxHp()+", defense="+Zidane.getDefense()+"}");
        assertEquals(Yitan.toString(), Zidane.toString());
        assertNotEquals(Yuffie.toString(), Zidane.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Zidane.hashCode(), Objects.hash(Thief.class, Zidane.getName(), Zidane.getMaxHp(), Zidane.getDefense()));
        assertEquals(Zidane.hashCode(), Yitan.hashCode());
        assertNotEquals(Yuffie.hashCode(), Zidane.hashCode());
    }
}