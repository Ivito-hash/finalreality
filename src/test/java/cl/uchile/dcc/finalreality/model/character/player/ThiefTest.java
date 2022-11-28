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
        Javelin = new Axe("Javelin", 18, 20, WeaponType.AXE);
        ShortBow = new Bow("Short Bow", 10, 10, WeaponType.BOW);
        Dagger = new Knife("Dagger", 12, 23, WeaponType.KNIFE);
        Rod = new Staff("Rod", 11, 23, 21, WeaponType.STAFF);
        Broadsword = new Sword("Broad Sword", 12, 18, WeaponType.SWORD);
    }

    @Test
    void testEquals() {
        assertTrue(Yitan.equals(Zidane));
        assertEquals(Yitan, Zidane);
        assertFalse(Yuffie.equals(Zidane));
        assertNotEquals(Yuffie, Zidane);
    }

    @Test
    void equip() {
        Zidane.equip(Dagger);
        assertEquals(Dagger.equipThief(Zidane), Zidane.equippedWeapon);
        assertNotEquals(ShortBow.equipThief(Zidane), Zidane.equippedWeapon);
    }

    @Test
    void testToString() {
        assertEquals(Zidane.toString(), "Thief{maxHp="+Zidane.getMaxHp()+", defense="+Zidane.getDefense()+", name='"+Zidane.getName()+"'}");
        assertEquals(Yitan.toString(), "Thief{maxHp="+Yitan.getMaxHp()+", defense="+Yitan.getDefense()+", name='"+Yitan.getName()+"'}");
        assertEquals(Yuffie.toString(), "Thief{maxHp="+Yuffie.getMaxHp()+", defense="+Yuffie.getDefense()+", name='"+Yuffie.getName()+"'}");
        assertEquals(Yitan.toString(), Zidane.toString());
        assertNotEquals(Yuffie.toString(), Zidane.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Zidane.hashCode(), Objects.hash(Thief.class, Zidane.getName(), Zidane.getMaxHp(), Zidane.getDefense()));
        assertEquals(Yitan.hashCode(), Objects.hash(Thief.class, Yitan.getName(), Yitan.getMaxHp(), Yitan.getDefense()));
        assertEquals(Yuffie.hashCode(), Objects.hash(Thief.class, Yuffie.getName(), Yuffie.getMaxHp(), Yuffie.getDefense()));
        assertEquals(Zidane.hashCode(), Yitan.hashCode());
        assertNotEquals(Yuffie.hashCode(), Zidane.hashCode());
    }
}