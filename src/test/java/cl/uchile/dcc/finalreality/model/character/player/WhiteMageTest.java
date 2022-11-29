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

class WhiteMageTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Axe Javelin;
    Bow ShortBow;
    Knife Dagger;
    Staff Rod;
    Sword Broadsword;
    /*==========================Characters==========================*/
    WhiteMage Garnet;
    WhiteMage Daga;
    WhiteMage Eiko;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*=================================Characters=================================*/
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
        Daga = new WhiteMage("Garnet", 70, 46, 14, queue);
        Eiko = new WhiteMage("Eiko", 65, 42, 13, queue);
        /*===================================Weapons===================================*/
        Javelin = new Axe("Javelin", 18, 20);
        ShortBow = new Bow("Short Bow", 10, 10);
        Dagger = new Knife("Dagger", 12, 23);
        Rod = new Staff("Rod", 11, 23, 21);
        Broadsword = new Sword("Broad Sword", 12, 18);
    }

    @Test
    void equip() {
        assertNull(Garnet.getEquippedWeapon());
        Garnet.equip(Rod);
        assertNull(Eiko.getEquippedWeapon());
        Eiko.equip(Rod);
        assertNotEquals(Javelin, Eiko.getEquippedWeapon());
        assertEquals(Garnet.getEquippedWeapon(), Eiko.getEquippedWeapon());
        Garnet.equip(Javelin);
        assertNull(Garnet.getEquippedWeapon());
        assertNotEquals(Garnet.getEquippedWeapon(), Eiko.getEquippedWeapon());
        Garnet.equip(ShortBow);
        assertNull(Garnet.getEquippedWeapon());
        Eiko.equip(Broadsword);
        assertNull(Eiko.getEquippedWeapon());
        Eiko.equip(Dagger);
        assertEquals(Garnet.getEquippedWeapon(), Eiko.getEquippedWeapon());
    }

    @Test
    void testEquals() {
        assertEquals(Daga, Garnet);
        assertNotEquals(Eiko, Garnet);
    }

    @Test
    void testToString() {
        assertEquals(Garnet.toString(), "WhiteMage{name='"+Garnet.getName()+"', maxHp="+Garnet.getMaxHp()+", maxMp="+Garnet.getMaxMp()+", defense="+Garnet.getDefense()+"}");
        assertEquals(Daga.toString(), Garnet.toString());
        assertNotEquals(Eiko.toString(), Garnet.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Garnet.hashCode(), Objects.hash(WhiteMage.class, Garnet.getName(), Garnet.getMaxHp(), Garnet.getMaxMp(), Garnet.getDefense()));
        assertEquals(Garnet.hashCode(), Daga.hashCode());
        assertNotEquals(Eiko.hashCode(), Garnet.hashCode());
    }
}