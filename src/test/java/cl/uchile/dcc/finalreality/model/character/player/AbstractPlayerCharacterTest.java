package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerCharacterTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Bow ShortBow;
    Knife Dagger;
    Staff Rod;
    Sword Broadsword;
    Staff OakRod;
    /*==========================Characters==========================*/
    BlackMage Vivi;
    Engineer Cid;
    Knight Steiner;
    Thief Zidane;
    WhiteMage Garnet;
    /*=============================Lists=============================*/
    List<String> nombres;
    List<String> cola;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*===================================Weapons===================================*/
        ShortBow = new Bow("Short Bow", 10, 20, WeaponType.BOW);
        Dagger = new Knife("Dagger", 12, 10, WeaponType.KNIFE);
        Rod = new Staff("Rod", 11, 23, 30, WeaponType.STAFF);
        Broadsword = new Sword("Broad Sword", 12, 40, WeaponType.SWORD);
        OakRod = new Staff("Oak Rod", 16, 42, 50, WeaponType.STAFF);
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
        /*===================================QUEUE===================================*/
        nombres = new ArrayList<String>();
        nombres.add("Zidane");
        nombres.add("Cid");
        nombres.add("Garnet");
        nombres.add("Steiner");
        nombres.add("Vivi");
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
    void waitTurn() throws InterruptedException {
        Vivi.equip(OakRod);
        Vivi.waitTurn();
        Cid.waitTurn();
        Steiner.waitTurn();
        Zidane.waitTurn();
        Garnet.waitTurn();
        // Waits for 6 seconds to ensure that all characters have finished waiting
        Thread.sleep(6000);
        cola = new ArrayList<String>();
        while (!queue.isEmpty()) {
            // Pops and prints the names of the characters of the queue to illustrate the turns
            // order
            cola.add(queue.poll().getName());
        }
        assertEquals(cola, nombres);
    }
}