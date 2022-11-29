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
        Javelin = new Axe("Javelin", 18, 20);
        ShortBow = new Bow("Short Bow", 10, 10);
        Dagger = new Knife("Dagger", 12, 23);
        Rod = new Staff("Rod", 11, 23, 21);
        Broadsword = new Sword("Broad Sword", 12, 18);
    }

    @Test
    void equip() {
        assertNull(Steiner.getEquippedWeapon());
        Steiner.equip(Javelin);
        assertNull(Freya.getEquippedWeapon());
        Freya.equip(Broadsword);
        assertNotEquals(Steiner.getEquippedWeapon(), Freya.getEquippedWeapon());
        Steiner.equip(Broadsword);
        assertEquals(Steiner.getEquippedWeapon(), Freya.getEquippedWeapon());
        Freya.equip(Dagger);
        assertNotEquals(Steiner.getEquippedWeapon(), Freya.getEquippedWeapon());
        Steiner.equip(Rod);
        assertNull(Steiner.getEquippedWeapon());
        assertNotEquals(Steiner.getEquippedWeapon(), Freya.getEquippedWeapon());
        Freya.equip(ShortBow);
        assertEquals(Steiner.getEquippedWeapon(), Freya.getEquippedWeapon());
    }

    @Test
    void testEquals() {
        assertEquals(Freya, Steiner);
        assertNotEquals(Cloud, Steiner);
    }

    @Test
    void testToString() {
        assertEquals(Steiner.toString(), "Knight{name='"+Steiner.getName()+"', maxHp="+Steiner.getMaxHp()+", defense="+Steiner.getDefense()+"}");
        assertEquals(Freya.toString(), Steiner.toString());
        assertNotEquals(Cloud.toString(), Steiner.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Steiner.hashCode(), Objects.hash(Knight.class, Steiner.getName(), Steiner.getMaxHp(), Steiner.getDefense()));
        assertEquals(Steiner.hashCode(), Freya.hashCode());
        assertNotEquals(Cloud.hashCode(), Steiner.hashCode());
    }
}