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
        Javelin = new Axe("Javelin", 18, 20, WeaponType.AXE);
        MithrilJavelin = new Axe("Javelin", 18, 20, WeaponType.AXE);
        Partisane = new Axe("Partisane", 25, 20, WeaponType.AXE);
        Obelisk = new Axe("Obelisk", 52, 40, WeaponType.AXE);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void testEquals() {
        assertTrue(MithrilJavelin.equals(Javelin));
        assertEquals(MithrilJavelin, Javelin);
        assertFalse(Partisane.equals(Javelin));
        assertNotEquals(Partisane, Javelin);
        assertFalse(Obelisk.equals(Javelin));
        assertNotEquals(Obelisk, Javelin);
        assertFalse(Obelisk.equals(Partisane));
        assertNotEquals(Obelisk, Partisane);
    }

    @Test
    void testToString() {
        assertEquals(Javelin.toString(), "Axe{name='"+Javelin.getName()+"', damage="+Javelin.getDamage()+", weight="+Javelin.getWeight()+", type="+Javelin.getType()+"}");
        assertEquals(MithrilJavelin.toString(), "Axe{name='"+MithrilJavelin.getName()+"', damage="+MithrilJavelin.getDamage()+", weight="+MithrilJavelin.getWeight()+", type="+MithrilJavelin.getType()+"}");
        assertEquals(Partisane.toString(), "Axe{name='"+Partisane.getName()+"', damage="+Partisane.getDamage()+", weight="+Partisane.getWeight()+", type="+Partisane.getType()+"}");
        assertEquals(Obelisk.toString(), "Axe{name='"+Obelisk.getName()+"', damage="+Obelisk.getDamage()+", weight="+Obelisk.getWeight()+", type="+Obelisk.getType()+"}");
        assertEquals(MithrilJavelin.toString(), Javelin.toString());
        assertNotEquals(Obelisk.toString(), Partisane.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Javelin.hashCode(), Objects.hash(Axe.class, Javelin.getName(), Javelin.getDamage(), Javelin.getWeight(), Javelin.getType()));
        assertEquals(MithrilJavelin.hashCode(), Objects.hash(Axe.class, MithrilJavelin.getName(), MithrilJavelin.getDamage(), MithrilJavelin.getWeight(), MithrilJavelin.getType()));
        assertEquals(Partisane.hashCode(), Objects.hash(Axe.class, Partisane.getName(), Partisane.getDamage(), Partisane.getWeight(), Partisane.getType()));
        assertEquals(Obelisk.hashCode(), Objects.hash(Axe.class, Obelisk.getName(), Obelisk.getDamage(), Obelisk.getWeight(), Obelisk.getType()));
        assertEquals(Javelin.hashCode(), MithrilJavelin.hashCode());
        assertNotEquals(Obelisk.hashCode(), Partisane.hashCode());
    }

    @Test
    void equipBlackMage() {
        assertNull(Javelin.equipBlackMage(Vivi));
        assertNull(MithrilJavelin.equipBlackMage(Vivi));
        assertNull(Partisane.equipBlackMage(Vivi));
        assertNull(Obelisk.equipBlackMage(Vivi));
    }

    @Test
    void equipEngineer() {
        assertNotNull(Javelin.equipEngineer(Cid));
        assertNotNull(MithrilJavelin.equipEngineer(Cid));
        assertNotNull(Partisane.equipEngineer(Cid));
        assertNotNull(Obelisk.equipEngineer(Cid));
        assertEquals(Javelin, Javelin.equipEngineer(Cid));
        assertEquals(MithrilJavelin.equipEngineer(Cid), Javelin.equipEngineer(Cid));
        assertNotEquals(Obelisk.equipEngineer(Cid), Partisane.equipEngineer(Cid));
    }

    @Test
    void equipKnight() {
        assertNotNull(Javelin.equipKnight(Steiner));
        assertNotNull(MithrilJavelin.equipKnight(Steiner));
        assertNotNull(Partisane.equipKnight(Steiner));
        assertNotNull(Obelisk.equipKnight(Steiner));
        assertEquals(Javelin, Javelin.equipKnight(Steiner));
        assertEquals(MithrilJavelin.equipKnight(Steiner), Javelin.equipKnight(Steiner));
        assertNotEquals(Obelisk.equipKnight(Steiner), Partisane.equipKnight(Steiner));
    }

    @Test
    void equipThief() {
        assertNull(Javelin.equipThief(Zidane));
        assertNull(MithrilJavelin.equipThief(Zidane));
        assertNull(Partisane.equipThief(Zidane));
        assertNull(Obelisk.equipThief(Zidane));
    }

    @Test
    void equipWhiteMage() {
        assertNull(Javelin.equipWhiteMage(Garnet));
        assertNull(MithrilJavelin.equipWhiteMage(Garnet));
        assertNull(Partisane.equipWhiteMage(Garnet));
        assertNull(Obelisk.equipWhiteMage(Garnet));
    }
}