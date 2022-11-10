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
        Javelin = new Axe("Javelin", 18, 20, WeaponType.AXE);
        ShortBow = new Bow("Short Bow", 10, 10, WeaponType.BOW);
        Dagger = new Knife("Dagger", 12, 23, WeaponType.KNIFE);
        Rod = new Staff("Rod", 11, 23, 21, WeaponType.STAFF);
        Broadsword = new Sword("Broad Sword", 12, 18, WeaponType.SWORD);
    }

    @Test
    void testEquals() {
        assertTrue(Daga.equals(Garnet));
        assertEquals(Daga, Garnet);
        assertFalse(Eiko.equals(Garnet));
        assertNotEquals(Eiko, Garnet);
    }

    @Test
    void equip() {
        Garnet.equip(Rod);
        assertEquals(Rod.equipWhiteMage(Garnet), Garnet.equippedWeapon);
        assertNotEquals(Dagger.equipWhiteMage(Garnet), Garnet.equippedWeapon);
    }

    @Test
    void testToString() {
        assertEquals(Garnet.toString(), "WhiteMage{maxHp="+Garnet.getMaxHp()+", maxMp="+Garnet.getMaxMp()+", defense="+Garnet.getDefense()+", name='"+Garnet.getName()+"'}");
        assertEquals(Daga.toString(), "WhiteMage{maxHp="+Daga.getMaxHp()+", maxMp="+Daga.getMaxMp()+", defense="+Daga.getDefense()+", name='"+Daga.getName()+"'}");
        assertEquals(Eiko.toString(), "WhiteMage{maxHp="+Eiko.getMaxHp()+", maxMp="+Eiko.getMaxMp()+", defense="+Eiko.getDefense()+", name='"+Eiko.getName()+"'}");
        assertEquals(Daga.toString(), Garnet.toString());
        assertNotEquals(Eiko.toString(), Garnet.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Garnet.hashCode(), Objects.hash(WhiteMage.class, Garnet.getName(), Garnet.getMaxHp(), Garnet.getMaxMp(), Garnet.getDefense()));
        assertEquals(Daga.hashCode(), Objects.hash(WhiteMage.class, Daga.getName(), Daga.getMaxHp(), Daga.getMaxMp(), Daga.getDefense()));
        assertEquals(Eiko.hashCode(), Objects.hash(WhiteMage.class, Eiko.getName(), Eiko.getMaxHp(), Eiko.getMaxMp(), Eiko.getDefense()));
        assertEquals(Garnet.hashCode(), Daga.hashCode());
        assertNotEquals(Eiko.hashCode(), Garnet.hashCode());
    }
}