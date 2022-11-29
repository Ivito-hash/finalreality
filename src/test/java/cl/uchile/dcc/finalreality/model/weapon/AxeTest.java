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

class AxeTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Axe Javelin;
    Axe MithrilJavelin;
    Axe Partisane;
    Axe Obelisk;
    /*==========================Characters==========================*/
    BlackMage Vivi;
    Engineer Cid;
    Knight Steiner;
    Thief Zidane;
    WhiteMage Garnet;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*===================================Weapons===================================*/
        Javelin = new Axe("Javelin", 18, 20);
        MithrilJavelin = new Axe("Javelin", 18, 20);
        Partisane = new Axe("Partisane", 25, 20);
        Obelisk = new Axe("Obelisk", 52, 40);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void testGets() {
        assertEquals(MithrilJavelin.getName(), Javelin.getName());
        assertEquals("Partisane", Partisane.getName());
        assertNotEquals(Javelin.getName(), Obelisk.getName());
        assertNotEquals("Javelin", Obelisk.getName());
        assertEquals(MithrilJavelin.getDamage(), Javelin.getDamage());
        assertEquals(25, Partisane.getDamage());
        assertNotEquals(Javelin.getDamage(), Obelisk.getDamage());
        assertNotEquals(25, Obelisk.getDamage());
        assertEquals(MithrilJavelin.getWeight(), Javelin.getWeight());
        assertEquals(20, Partisane.getWeight());
        assertNotEquals(Javelin.getWeight(), Obelisk.getWeight());
        assertNotEquals(20, Obelisk.getWeight());
    }

    @Test
    void testEquals() {
        assertEquals(MithrilJavelin, Javelin);
        assertNotEquals(Partisane, Obelisk);
    }

    @Test
    void testToString() {
        assertEquals(Javelin.toString(), "Axe{name='"+Javelin.getName()+"', damage="+Javelin.getDamage()+", weight="+Javelin.getWeight()+"}");
        assertEquals(MithrilJavelin.toString(), Javelin.toString());
        assertNotEquals(Obelisk.toString(), Partisane.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Javelin.hashCode(), Objects.hash(Axe.class, Javelin.getName(), Javelin.getDamage(), Javelin.getWeight()));
        assertEquals(Javelin.hashCode(), MithrilJavelin.hashCode());
        assertNotEquals(Obelisk.hashCode(), Partisane.hashCode());
    }
}