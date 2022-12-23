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

class BlackMageTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Axe Javelin;
    Bow ShortBow;
    Knife Dagger;
    Staff Rod;
    Sword Broadsword;
    /*==========================Characters==========================*/
    BlackMage Vivi;
    BlackMage BlackMagician;
    BlackMage MatiasToro;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        BlackMagician = new BlackMage("Vivi", 60, 48, 12, queue);
        MatiasToro = new BlackMage("Matias Toro", 85, 56, 14, queue);
        /*===================================Weapons===================================*/
        Javelin = new Axe("Javelin", 18, 20);
        ShortBow = new Bow("Short Bow", 10, 10);
        Dagger = new Knife("Dagger", 12, 23);
        Rod = new Staff("Rod", 11, 23, 21);
        Broadsword = new Sword("Broad Sword", 12, 18);
    }

    @Test
    void equip() {
        assertNull(Vivi.getEquippedWeapon());
        Vivi.equip(Rod);
        assertNull(BlackMagician.getEquippedWeapon());
        BlackMagician.equip(Dagger);
        assertNotEquals(Vivi.getEquippedWeapon(), BlackMagician.getEquippedWeapon());
        Vivi.equip(Dagger);
        assertEquals(Vivi.getEquippedWeapon(), BlackMagician.getEquippedWeapon());
        assertEquals(Vivi.getEquippedWeapon(), Dagger);
        assertNotEquals(Vivi.getEquippedWeapon(), Rod);
        Vivi.equip(Javelin);
        assertNull(Vivi.getEquippedWeapon());
        assertNotEquals(Vivi.getEquippedWeapon(), BlackMagician.getEquippedWeapon());
        Vivi.equip(ShortBow);
        assertNull(Vivi.getEquippedWeapon());
        BlackMagician.equip(Broadsword);
        assertEquals(Vivi.getEquippedWeapon(), BlackMagician.getEquippedWeapon());

    }

    @Test
    void testEquals() {
        assertEquals(BlackMagician, Vivi);
        assertNotEquals(MatiasToro, Vivi);
    }

    @Test
    void testToString() {
        assertEquals(Vivi.toString(), "BlackMage{name='"+Vivi.getName()+"', maxHp="+Vivi.getMaxHp()+", maxMp="+Vivi.getMaxMp()+", defense="+Vivi.getDefense()+"}");
        assertEquals(BlackMagician.toString(), Vivi.toString());
        assertNotEquals(MatiasToro.toString(), Vivi.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Vivi.hashCode(), Objects.hash(BlackMage.class, Vivi.getName(), Vivi.getMaxHp(), Vivi.getMaxMp(), Vivi.getDefense()));
        assertEquals(Vivi.hashCode(), BlackMagician.hashCode());
        assertNotEquals(MatiasToro.hashCode(), Vivi.hashCode());
    }
}