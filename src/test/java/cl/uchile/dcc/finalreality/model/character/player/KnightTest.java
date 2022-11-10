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

class KnightTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Axe Javelin;
    Bow ShortBow;
    Knife Dagger;
    Staff Rod;
    Sword Broadsword;
    /*==========================Characters==========================*/
    Knight Steiner;
    Knight Freya;
    Knight Cloud;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*=================================Characters=================================*/
        Steiner = new Knight("Steiner", 120, 24, queue);
        Freya = new Knight("Steiner", 120, 24, queue);
        Cloud = new Knight("Cloud", 110, 18, queue);
        /*===================================Weapons===================================*/
        Javelin = new Axe("Javelin", 18, 20, WeaponType.AXE);
        ShortBow = new Bow("Short Bow", 10, 10, WeaponType.BOW);
        Dagger = new Knife("Dagger", 12, 23, WeaponType.KNIFE);
        Rod = new Staff("Rod", 11, 23, 21, WeaponType.STAFF);
        Broadsword = new Sword("Broad Sword", 12, 18, WeaponType.SWORD);
    }

    @Test
    void testEquals() {
        assertTrue(Freya.equals(Steiner));
        assertEquals(Freya, Steiner);
        assertFalse(Cloud.equals(Steiner));
        assertNotEquals(Cloud, Steiner);
    }

    @Test
    void equip() {
    }

    @Test
    void testToString() {
        assertEquals(Steiner.toString(), "Knight{maxHp="+Steiner.getMaxHp()+", defense="+Steiner.getDefense()+", name='"+Steiner.getName()+"'}");
        assertEquals(Freya.toString(), "Knight{maxHp="+Freya.getMaxHp()+", defense="+Freya.getDefense()+", name='"+Freya.getName()+"'}");
        assertEquals(Cloud.toString(), "Knight{maxHp="+Cloud.getMaxHp()+", defense="+Cloud.getDefense()+", name='"+Cloud.getName()+"'}");
        assertEquals(Freya.toString(), Steiner.toString());
        assertNotEquals(Cloud.toString(), Steiner.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Steiner.hashCode(), Objects.hash(Knight.class, Steiner.getName(), Steiner.getMaxHp(), Steiner.getDefense()));
        assertEquals(Freya.hashCode(), Objects.hash(Knight.class, Freya.getName(), Freya.getMaxHp(), Freya.getDefense()));
        assertEquals(Cloud.hashCode(), Objects.hash(Knight.class, Cloud.getName(), Cloud.getMaxHp(), Cloud.getDefense()));
        assertEquals(Steiner.hashCode(), Freya.hashCode());
        assertNotEquals(Cloud.hashCode(), Steiner.hashCode());
    }
}