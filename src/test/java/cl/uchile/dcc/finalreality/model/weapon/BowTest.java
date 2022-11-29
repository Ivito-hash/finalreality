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

class BowTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Bow ShortBow;
    Bow PracticeBow;
    Bow LongBow;
    Bow StrenghtBow;
    /*==========================Characters==========================*/
    BlackMage Vivi;
    Engineer Cid;
    Knight Steiner;
    Thief Zidane;
    WhiteMage Garnet;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*===================================Weapons===================================*/
        ShortBow = new Bow("Short Bow", 10, 10);
        PracticeBow = new Bow("Short Bow", 10, 10);
        LongBow = new Bow("Long Bow", 14, 10);
        StrenghtBow = new Bow("Strenght Bow", 40, 20);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void testGets() {
        assertEquals(PracticeBow.getName(), ShortBow.getName());
        assertEquals("Long Bow", LongBow.getName());
        assertNotEquals(ShortBow.getName(), StrenghtBow.getName());
        assertNotEquals("Short Bow", StrenghtBow.getName());
        assertEquals(PracticeBow.getDamage(), ShortBow.getDamage());
        assertEquals(14, LongBow.getDamage());
        assertNotEquals(ShortBow.getDamage(), StrenghtBow.getDamage());
        assertNotEquals(14, StrenghtBow.getDamage());
        assertEquals(PracticeBow.getWeight(), ShortBow.getWeight());
        assertEquals(10, LongBow.getWeight());
        assertNotEquals(ShortBow.getWeight(), StrenghtBow.getWeight());
        assertNotEquals(10, StrenghtBow.getWeight());
    }

    @Test
    void testEquals() {
        assertEquals(PracticeBow, ShortBow);
        assertNotEquals(StrenghtBow, LongBow);
    }

    @Test
    void testToString() {
        assertEquals(ShortBow.toString(), "Bow{name='"+ShortBow.getName()+"', damage="+ShortBow.getDamage()+", weight="+ShortBow.getWeight()+"}");
        assertEquals(PracticeBow.toString(), ShortBow.toString());
        assertNotEquals(StrenghtBow.toString(), LongBow.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(ShortBow.hashCode(), Objects.hash(Bow.class, ShortBow.getName(), ShortBow.getDamage(), ShortBow.getWeight()));
        assertEquals(ShortBow.hashCode(), PracticeBow.hashCode());
        assertNotEquals(StrenghtBow.hashCode(), LongBow.hashCode());
    }
}