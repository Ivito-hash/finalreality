package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Staff Rod;
    Staff MageStaff;
    Staff WitchWand;
    Staff OakRod;
    /*==========================Characters==========================*/
    BlackMage Vivi;
    Engineer Cid;
    Knight Steiner;
    Thief Zidane;
    WhiteMage Garnet;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*===================================Weapons===================================*/
        Rod = new Staff("Rod", 11, 23, 21);
        MageStaff = new Staff("Rod", 11, 23, 21);
        WitchWand = new Staff("Witch Wand", 12, 30, 21);
        OakRod = new Staff("Oak Rod", 16, 42, 45);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void testGets() {
        assertEquals(MageStaff.getName(), Rod.getName());
        assertEquals("Witch Wand", WitchWand.getName());
        assertNotEquals(Rod.getName(), OakRod.getName());
        assertNotEquals("Rod", OakRod.getName());
        assertEquals(MageStaff.getDamage(), Rod.getDamage());
        assertEquals(12, WitchWand.getDamage());
        assertNotEquals(Rod.getDamage(), OakRod.getDamage());
        assertNotEquals(12, OakRod.getDamage());
        assertEquals(MageStaff.getWeight(), Rod.getWeight());
        assertEquals(21, WitchWand.getWeight());
        assertNotEquals(Rod.getWeight(), OakRod.getWeight());
        assertNotEquals(21, OakRod.getWeight());
        assertEquals(MageStaff.getMagicDamage(), Rod.getMagicDamage());
        assertEquals(30, WitchWand.getMagicDamage());
        assertNotEquals(Rod.getMagicDamage(), OakRod.getMagicDamage());
        assertNotEquals(30, OakRod.getMagicDamage());
    }

    @Test
    void testEquals() {
        assertEquals(MageStaff, Rod);
        assertNotEquals(OakRod, WitchWand);
    }

    @Test
    void testToString() {
        assertEquals(Rod.toString(), "Staff{name='"+Rod.getName()+"', damage="+Rod.getDamage()+", magic="+Rod.getMagicDamage()+", weight="+Rod.getWeight()+"}");
        assertEquals(MageStaff.toString(), Rod.toString());
        assertNotEquals(OakRod.toString(), WitchWand.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Rod.hashCode(), Objects.hash(Staff.class, Rod.getName(), Rod.getDamage(), Rod.getMagicDamage(), Rod.getWeight()));
        assertEquals(Rod.hashCode(), MageStaff.hashCode());
        assertNotEquals(OakRod.hashCode(), WitchWand.hashCode());
    }
}