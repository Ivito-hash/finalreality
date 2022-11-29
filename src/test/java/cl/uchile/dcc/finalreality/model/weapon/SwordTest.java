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
        Broadsword = new Sword("Broad Sword", 12, 18);
        PracticeSword = new Sword("Broad Sword", 12, 18);
        BloodySword = new Sword("Bloody Sword", 20, 18);
        Excalibur = new Sword("Excalibur", 77, 41);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void testGets() {
        assertEquals(PracticeSword.getName(), Broadsword.getName());
        assertEquals("Bloody Sword", BloodySword.getName());
        assertNotEquals(Broadsword.getName(), Excalibur.getName());
        assertNotEquals("Broad Sword", Excalibur.getName());
        assertEquals(PracticeSword.getDamage(), Broadsword.getDamage());
        assertEquals(20, BloodySword.getDamage());
        assertNotEquals(Broadsword.getDamage(), Excalibur.getDamage());
        assertNotEquals(20, Excalibur.getDamage());
        assertEquals(PracticeSword.getWeight(), Broadsword.getWeight());
        assertEquals(18, BloodySword.getWeight());
        assertNotEquals(Broadsword.getWeight(), Excalibur.getWeight());
        assertNotEquals(18, Excalibur.getWeight());
    }

    @Test
    void testEquals() {
        assertTrue(PracticeSword.equals(Broadsword));
        assertEquals(PracticeSword, Broadsword);
        assertFalse(Excalibur.equals(BloodySword));
        assertNotEquals(Excalibur, BloodySword);
    }

    @Test
    void testToString() {
        assertEquals(Broadsword.toString(), "Sword{name='"+Broadsword.getName()+"', damage="+Broadsword.getDamage()+", weight="+Broadsword.getWeight()+"}");
        assertEquals(PracticeSword.toString(), Broadsword.toString());
        assertNotEquals(Excalibur.toString(), BloodySword.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Broadsword.hashCode(), Objects.hash(Sword.class, Broadsword.getName(), Broadsword.getDamage(), Broadsword.getWeight()));
        assertEquals(Broadsword.hashCode(), PracticeSword.hashCode());
        assertNotEquals(Excalibur.hashCode(), BloodySword.hashCode());
    }
}