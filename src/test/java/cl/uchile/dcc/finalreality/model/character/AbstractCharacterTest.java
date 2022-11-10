package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCharacterTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Bow ShortBow;
    Knife Dagger;
    Staff Rod;
    Sword Broadsword;
    /*==========================Characters==========================*/
    BlackMage Vivi;
    BlackMage BlackMagician;
    Engineer Cid;
    Knight Steiner;
    Thief Zidane;
    WhiteMage Garnet;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*===================================Weapons===================================*/
        ShortBow = new Bow("Short Bow", 10, 10, WeaponType.BOW);
        Dagger = new Knife("Dagger", 12, 23, WeaponType.KNIFE);
        Rod = new Staff("Rod", 11, 23, 21, WeaponType.STAFF);
        Broadsword = new Sword("Broad Sword", 12, 18, WeaponType.SWORD);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        BlackMagician = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
        /*=================================Equipment=================================*/
        Vivi.equip(Rod);
        BlackMagician.equip(Rod);
        Cid.equip(ShortBow);
        Steiner.equip(Broadsword);
        Zidane.equip(Dagger);
        Garnet.equip(Rod);
    }

    @Test
    void getName() {
        assertEquals(Vivi.getName(),"Vivi");
        assertEquals(BlackMagician.getName(),"Vivi");
        assertEquals(Cid.getName(),"Cid");
        assertEquals(Steiner.getName(),"Steiner");
        assertEquals(Zidane.getName(),"Zidane");
        assertEquals(Garnet.getName(),"Garnet");
        assertEquals(BlackMagician.getName(),Vivi.getName());
        assertNotEquals(Steiner.getName(),Zidane.getName());
    }

    @Test
    void getCurrentHp() {
        assertEquals(BlackMagician.getCurrentHp(),Vivi.getCurrentHp());
        assertNotEquals(Cid.getCurrentHp(), Zidane.getCurrentHp());
    }

    @Test
    void getMaxHp() {
        assertEquals(BlackMagician.getMaxHp(),Vivi.getMaxHp());
        assertNotEquals(Cid.getMaxHp(), Zidane.getMaxHp());
    }

    @Test
    void getDefense() {
        assertEquals(BlackMagician.getDefense(),Vivi.getDefense());
        assertNotEquals(Cid.getDefense(), Zidane.getDefense());
    }

    @Test
    void setCurrentHp() {
    }

    @Test
    void addToQueue() {
    }
}