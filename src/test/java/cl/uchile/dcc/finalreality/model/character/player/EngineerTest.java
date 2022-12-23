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
        Javelin = new Axe("Javelin", 18, 20);
        ShortBow = new Bow("Short Bow", 10, 10);
        Dagger = new Knife("Dagger", 12, 23);
        Rod = new Staff("Rod", 11, 23, 21);
        Broadsword = new Sword("Broad Sword", 12, 18);
    }

    @Test
    void equip() {
        assertNull(Cid.getEquippedWeapon());
        Cid.equip(Javelin);
        assertNull(Shido.getEquippedWeapon());
        Shido.equip(ShortBow);
        assertNotEquals(Cid.getEquippedWeapon(), Shido.getEquippedWeapon());
        Cid.equip(ShortBow);
        assertEquals(Cid.getEquippedWeapon(), Shido.getEquippedWeapon());
        Cid.equip(Rod);
        assertNull(Cid.getEquippedWeapon());
        assertNotEquals(Cid.getEquippedWeapon(), Shido.getEquippedWeapon());
        Cid.equip(Broadsword);
        assertNull(Cid.getEquippedWeapon());
        Shido.equip(Dagger);
        assertEquals(Cid.getEquippedWeapon(), Shido.getEquippedWeapon());
    }

    @Test
    void testEquals() {
        assertEquals(Shido, Cid);
        assertNotEquals(Barret, Cid);
    }

    @Test
    void testToString() {
        assertEquals(Cid.toString(), "Engineer{name='"+Cid.getName()+"', maxHp="+Cid.getMaxHp()+", defense="+Cid.getDefense()+"}");
        assertEquals(Shido.toString(), Cid.toString());
        assertNotEquals(Barret.toString(), Cid.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Cid.hashCode(), Objects.hash(Engineer.class, Cid.getName(), Cid.getMaxHp(), Cid.getDefense()));
        assertEquals(Cid.hashCode(), Shido.hashCode());
        assertNotEquals(Barret.hashCode(), Cid.hashCode());
    }
}