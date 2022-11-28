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

class SwordTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Sword Broadsword;
    Sword PracticeSword;
    Sword BloodySword;
    Sword Excalibur;
    /*==========================Characters==========================*/
    BlackMage Vivi;
    Engineer Cid;
    Knight Steiner;
    Thief Zidane;
    WhiteMage Garnet;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*===================================Weapons===================================*/
        Broadsword = new Sword("Broad Sword", 12, 18, WeaponType.SWORD);
        PracticeSword = new Sword("Broad Sword", 12, 18, WeaponType.SWORD);
        BloodySword = new Sword("Bloody Sword", 20, 18, WeaponType.SWORD);
        Excalibur = new Sword("Excalibur", 77, 41, WeaponType.SWORD);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void testEquals() {
        assertTrue(PracticeSword.equals(Broadsword));
        assertEquals(PracticeSword, Broadsword);
        assertFalse(BloodySword.equals(Broadsword));
        assertNotEquals(BloodySword, Broadsword);
        assertFalse(Excalibur.equals(Broadsword));
        assertNotEquals(Excalibur, Broadsword);
        assertFalse(Excalibur.equals(BloodySword));
        assertNotEquals(Excalibur, BloodySword);
    }

    @Test
    void testToString() {
        assertEquals(Broadsword.toString(), "Sword{name='"+Broadsword.getName()+"', damage="+Broadsword.getDamage()+", weight="+Broadsword.getWeight()+", type="+Broadsword.getType()+"}");
        assertEquals(PracticeSword.toString(), "Sword{name='"+PracticeSword.getName()+"', damage="+PracticeSword.getDamage()+", weight="+PracticeSword.getWeight()+", type="+PracticeSword.getType()+"}");
        assertEquals(BloodySword.toString(), "Sword{name='"+BloodySword.getName()+"', damage="+BloodySword.getDamage()+", weight="+BloodySword.getWeight()+", type="+BloodySword.getType()+"}");
        assertEquals(Excalibur.toString(), "Sword{name='"+Excalibur.getName()+"', damage="+Excalibur.getDamage()+", weight="+Excalibur.getWeight()+", type="+Excalibur.getType()+"}");
        assertEquals(PracticeSword.toString(), Broadsword.toString());
        assertNotEquals(Excalibur.toString(), BloodySword.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Broadsword.hashCode(), Objects.hash(Sword.class, Broadsword.getName(), Broadsword.getDamage(), Broadsword.getWeight(), Broadsword.getType()));
        assertEquals(PracticeSword.hashCode(), Objects.hash(Sword.class, PracticeSword.getName(), PracticeSword.getDamage(), PracticeSword.getWeight(), PracticeSword.getType()));
        assertEquals(BloodySword.hashCode(), Objects.hash(Sword.class, BloodySword.getName(), BloodySword.getDamage(), BloodySword.getWeight(), BloodySword.getType()));
        assertEquals(Excalibur.hashCode(), Objects.hash(Sword.class, Excalibur.getName(), Excalibur.getDamage(), Excalibur.getWeight(), Excalibur.getType()));
        assertEquals(Broadsword.hashCode(), PracticeSword.hashCode());
        assertNotEquals(Excalibur.hashCode(), BloodySword.hashCode());
    }

    @Test
    void equipBlackMage() {
        assertNull(Broadsword.equipBlackMage(Vivi));
        assertNull(PracticeSword.equipBlackMage(Vivi));
        assertNull(BloodySword.equipBlackMage(Vivi));
        assertNull(Excalibur.equipBlackMage(Vivi));
    }

    @Test
    void equipEngineer() {
        assertNull(Broadsword.equipEngineer(Cid));
        assertNull(PracticeSword.equipEngineer(Cid));
        assertNull(BloodySword.equipEngineer(Cid));
        assertNull(Excalibur.equipEngineer(Cid));
    }

    @Test
    void equipKnight() {
        assertNotNull(Broadsword.equipKnight(Steiner));
        assertNotNull(PracticeSword.equipKnight(Steiner));
        assertNotNull(BloodySword.equipKnight(Steiner));
        assertNotNull(Excalibur.equipKnight(Steiner));
        assertEquals(Broadsword, Broadsword.equipKnight(Steiner));
        assertEquals(PracticeSword.equipKnight(Steiner), Broadsword.equipKnight(Steiner));
        assertNotEquals(Excalibur.equipKnight(Steiner), BloodySword.equipKnight(Steiner));
    }

    @Test
    void equipThief() {
        assertNotNull(Broadsword.equipThief(Zidane));
        assertNotNull(PracticeSword.equipThief(Zidane));
        assertNotNull(BloodySword.equipThief(Zidane));
        assertNotNull(Excalibur.equipThief(Zidane));
        assertEquals(Broadsword, Broadsword.equipThief(Zidane));
        assertEquals(PracticeSword.equipThief(Zidane), Broadsword.equipThief(Zidane));
        assertNotEquals(Excalibur.equipThief(Zidane), BloodySword.equipThief(Zidane));
    }

    @Test
    void equipWhiteMage() {
        assertNull(Broadsword.equipWhiteMage(Garnet));
        assertNull(PracticeSword.equipWhiteMage(Garnet));
        assertNull(BloodySword.equipWhiteMage(Garnet));
        assertNull(Excalibur.equipWhiteMage(Garnet));
    }
}