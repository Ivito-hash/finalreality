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

class EngineerTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Axe Javelin;
    Bow ShortBow;
    Knife Dagger;
    Staff Rod;
    Sword Broadsword;
    /*==========================Characters==========================*/
    Engineer Cid;
    Engineer Shido;
    Engineer Barret;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*=================================Characters=================================*/
        Cid = new Engineer("Cid", 85, 18, queue);
        Shido = new Engineer("Cid", 85, 18, queue);
        Barret = new Engineer("Barret", 100, 20, queue);
        /*===================================Weapons===================================*/
        Javelin = new Axe("Javelin", 18, 20, WeaponType.AXE);
        ShortBow = new Bow("Short Bow", 10, 10, WeaponType.BOW);
        Dagger = new Knife("Dagger", 12, 23, WeaponType.KNIFE);
        Rod = new Staff("Rod", 11, 23, 21, WeaponType.STAFF);
        Broadsword = new Sword("Broad Sword", 12, 18, WeaponType.SWORD);
    }

    @Test
    void testEquals() {
        assertTrue(Shido.equals(Cid));
        assertEquals(Shido, Cid);
        assertFalse(Barret.equals(Cid));
        assertNotEquals(Barret, Cid);
    }

    @Test
    void equip() {
        Cid.equip(ShortBow);
        assertEquals(ShortBow.equipEngineer(Cid), Cid.equippedWeapon);
        assertNotEquals(Javelin.equipEngineer(Cid), Cid.equippedWeapon);
    }

    @Test
    void testToString() {
        assertEquals(Cid.toString(), "Engineer{maxHp="+Cid.getMaxHp()+", defense="+Cid.getDefense()+", name='"+Cid.getName()+"'}");
        assertEquals(Shido.toString(), "Engineer{maxHp="+Shido.getMaxHp()+", defense="+Shido.getDefense()+", name='"+Shido.getName()+"'}");
        assertEquals(Barret.toString(), "Engineer{maxHp="+Barret.getMaxHp()+", defense="+Barret.getDefense()+", name='"+Barret.getName()+"'}");
        assertEquals(Shido.toString(), Cid.toString());
        assertNotEquals(Barret.toString(), Cid.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Cid.hashCode(), Objects.hash(Engineer.class, Cid.getName(), Cid.getMaxHp(), Cid.getDefense()));
        assertEquals(Shido.hashCode(), Objects.hash(Engineer.class, Shido.getName(), Shido.getMaxHp(), Shido.getDefense()));
        assertEquals(Barret.hashCode(), Objects.hash(Engineer.class, Barret.getName(), Barret.getMaxHp(), Barret.getDefense()));
        assertEquals(Cid.hashCode(), Shido.hashCode());
        assertNotEquals(Barret.hashCode(), Cid.hashCode());
    }
}