package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerCharacterTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Bow ShortBow;
    Knife Dagger;
    Staff Rod;
    Sword Broadsword;
    /*==========================Characters==========================*/
    BlackMage Vivi;
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
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
        /*=================================Equipment=================================*/
        Vivi.equip(Rod);
        Cid.equip(ShortBow);
        Steiner.equip(Broadsword);
        Zidane.equip(Dagger);
        Garnet.equip(Rod);
    }

    @Test
    void getEquippedWeapon() {
        assertEquals(Rod, Vivi.getEquippedWeapon());
        assertEquals(ShortBow, Cid.getEquippedWeapon());
        assertEquals(Broadsword, Steiner.getEquippedWeapon());
        assertEquals(Dagger, Zidane.getEquippedWeapon());
        assertEquals(Rod, Garnet.getEquippedWeapon());
        assertNotEquals(Vivi.getEquippedWeapon(), Cid.getEquippedWeapon());
        assertEquals(Vivi.getEquippedWeapon(), Garnet.getEquippedWeapon());
    }

    @Test
    void waitTurn() {
    }
}