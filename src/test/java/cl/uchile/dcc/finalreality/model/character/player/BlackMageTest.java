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
        Javelin = new Axe("Javelin", 18, 20, WeaponType.AXE);
        ShortBow = new Bow("Short Bow", 10, 10, WeaponType.BOW);
        Dagger = new Knife("Dagger", 12, 23, WeaponType.KNIFE);
        Rod = new Staff("Rod", 11, 23, 21, WeaponType.STAFF);
        Broadsword = new Sword("Broad Sword", 12, 18, WeaponType.SWORD);
    }

    @Test
    void testEquals() {
        assertTrue(BlackMagician.equals(Vivi));
        assertEquals(BlackMagician, Vivi);
        assertFalse(MatiasToro.equals(Vivi));
        assertNotEquals(MatiasToro, Vivi);
    }

    @Test
    void equip() {
        Vivi.equip(Rod);
        assertEquals(Rod.equipBlackMage(Vivi), Vivi.equippedWeapon);
        assertNotEquals(Dagger.equipBlackMage(Vivi), Vivi.equippedWeapon);
    }

    @Test
    void testToString() {
        assertEquals(Vivi.toString(), "BlackMage{maxHp="+Vivi.getMaxHp()+", maxMp="+Vivi.getMaxMp()+", defense="+Vivi.getDefense()+", name='"+Vivi.getName()+"'}");
        assertEquals(BlackMagician.toString(), "BlackMage{maxHp="+BlackMagician.getMaxHp()+", maxMp="+BlackMagician.getMaxMp()+", defense="+BlackMagician.getDefense()+", name='"+BlackMagician.getName()+"'}");
        assertEquals(MatiasToro.toString(), "BlackMage{maxHp="+MatiasToro.getMaxHp()+", maxMp="+MatiasToro.getMaxMp()+", defense="+MatiasToro.getDefense()+", name='"+MatiasToro.getName()+"'}");
        assertEquals(BlackMagician.toString(), Vivi.toString());
        assertNotEquals(MatiasToro.toString(), Vivi.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Vivi.hashCode(), Objects.hash(BlackMage.class, Vivi.getName(), Vivi.getMaxHp(), Vivi.getMaxMp(), Vivi.getDefense()));
        assertEquals(BlackMagician.hashCode(), Objects.hash(BlackMage.class, BlackMagician.getName(), BlackMagician.getMaxHp(), BlackMagician.getMaxMp(), BlackMagician.getDefense()));
        assertEquals(MatiasToro.hashCode(), Objects.hash(BlackMage.class, MatiasToro.getName(), MatiasToro.getMaxHp(), MatiasToro.getMaxMp(), MatiasToro.getDefense()));
        assertEquals(Vivi.hashCode(), BlackMagician.hashCode());
        assertNotEquals(MatiasToro.hashCode(), Vivi.hashCode());
    }
}