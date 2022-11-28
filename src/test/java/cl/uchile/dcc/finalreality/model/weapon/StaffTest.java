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
        Rod = new Staff("Rod", 11, 23, 21, WeaponType.STAFF);
        MageStaff = new Staff("Rod", 11, 23, 21, WeaponType.STAFF);
        WitchWand = new Staff("Witch Wand", 12, 30, 21, WeaponType.STAFF);
        OakRod = new Staff("Oak Rod", 16, 42, 45, WeaponType.STAFF);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void testEquals() {
        assertTrue(MageStaff.equals(Rod));
        assertEquals(MageStaff, Rod);
        assertFalse(WitchWand.equals(Rod));
        assertNotEquals(WitchWand, Rod);
        assertFalse(OakRod.equals(Rod));
        assertNotEquals(OakRod, Rod);
        assertFalse(OakRod.equals(WitchWand));
        assertNotEquals(OakRod, WitchWand);
    }

    @Test
    void testToString() {
        assertEquals(Rod.toString(), "Staff{name='"+Rod.getName()+"', damage="+Rod.getDamage()+", magic="+Rod.getMagic()+", weight="+Rod.getWeight()+", type="+Rod.getType()+"}");
        assertEquals(MageStaff.toString(), "Staff{name='"+MageStaff.getName()+"', damage="+MageStaff.getDamage()+", magic="+MageStaff.getMagic()+", weight="+MageStaff.getWeight()+", type="+MageStaff.getType()+"}");
        assertEquals(WitchWand.toString(), "Staff{name='"+WitchWand.getName()+"', damage="+WitchWand.getDamage()+", magic="+WitchWand.getMagic()+", weight="+WitchWand.getWeight()+", type="+WitchWand.getType()+"}");
        assertEquals(OakRod.toString(), "Staff{name='"+OakRod.getName()+"', damage="+OakRod.getDamage()+", magic="+OakRod.getMagic()+", weight="+OakRod.getWeight()+", type="+OakRod.getType()+"}");
        assertEquals(MageStaff.toString(), Rod.toString());
        assertNotEquals(OakRod.toString(), WitchWand.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Rod.hashCode(), Objects.hash(Staff.class, Rod.getName(), Rod.getDamage(), Rod.getMagic(), Rod.getWeight(), Rod.getType()));
        assertEquals(MageStaff.hashCode(), Objects.hash(Staff.class, MageStaff.getName(), MageStaff.getDamage(), MageStaff.getMagic(), MageStaff.getWeight(), MageStaff.getType()));
        assertEquals(WitchWand.hashCode(), Objects.hash(Staff.class, WitchWand.getName(), WitchWand.getDamage(), WitchWand.getMagic(), WitchWand.getWeight(), WitchWand.getType()));
        assertEquals(OakRod.hashCode(), Objects.hash(Staff.class, OakRod.getName(), OakRod.getDamage(), OakRod.getMagic(), OakRod.getWeight(), OakRod.getType()));
        assertEquals(Rod.hashCode(), MageStaff.hashCode());
        assertNotEquals(OakRod.hashCode(), WitchWand.hashCode());
    }

    @Test
    void equipBlackMage() {
        assertNotNull(Rod.equipBlackMage(Vivi));
        assertNotNull(MageStaff.equipBlackMage(Vivi));
        assertNotNull(WitchWand.equipBlackMage(Vivi));
        assertNotNull(OakRod.equipBlackMage(Vivi));
        assertEquals(Rod, Rod.equipBlackMage(Vivi));
        assertEquals(MageStaff.equipBlackMage(Vivi), Rod.equipBlackMage(Vivi));
        assertNotEquals(OakRod.equipBlackMage(Vivi), WitchWand.equipBlackMage(Vivi));
    }

    @Test
    void equipEngineer() {
        assertNull(Rod.equipEngineer(Cid));
        assertNull(MageStaff.equipEngineer(Cid));
        assertNull(WitchWand.equipEngineer(Cid));
        assertNull(OakRod.equipEngineer(Cid));
    }

    @Test
    void equipKnight() {
        assertNull(Rod.equipKnight(Steiner));
        assertNull(MageStaff.equipKnight(Steiner));
        assertNull(WitchWand.equipKnight(Steiner));
        assertNull(OakRod.equipKnight(Steiner));
    }

    @Test
    void equipThief() {
        assertNull(Rod.equipThief(Zidane));
        assertNull(MageStaff.equipThief(Zidane));
        assertNull(WitchWand.equipThief(Zidane));
        assertNull(OakRod.equipThief(Zidane));
    }

    @Test
    void equipWhiteMage() {
        assertNotNull(Rod.equipWhiteMage(Garnet));
        assertNotNull(MageStaff.equipWhiteMage(Garnet));
        assertNotNull(WitchWand.equipWhiteMage(Garnet));
        assertNotNull(OakRod.equipWhiteMage(Garnet));
        assertEquals(Rod, Rod.equipWhiteMage(Garnet));
        assertEquals(MageStaff.equipWhiteMage(Garnet), Rod.equipWhiteMage(Garnet));
        assertNotEquals(OakRod.equipWhiteMage(Garnet), WitchWand.equipWhiteMage(Garnet));
    }
}