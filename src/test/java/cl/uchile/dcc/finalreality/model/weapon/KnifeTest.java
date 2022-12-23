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

class KnifeTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Knife Dagger;
    Knife MithrilDagger;
    Knife ButterflyDagger;
    Knife Masamune;
    /*==========================Characters==========================*/
    BlackMage Vivi;
    Engineer Cid;
    Knight Steiner;
    Thief Zidane;
    WhiteMage Garnet;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*===================================Weapons===================================*/
        Dagger = new Knife("Dagger", 12, 23);
        MithrilDagger = new Knife("Dagger", 12, 23);
        ButterflyDagger = new Knife("Butterfly Dagger", 16, 23);
        Masamune = new Knife("Masamune", 62, 47);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void testGets() {
        assertEquals(MithrilDagger.getName(), Dagger.getName());
        assertEquals("Butterfly Dagger", ButterflyDagger.getName());
        assertNotEquals(Dagger.getName(), Masamune.getName());
        assertNotEquals("Dagger", Masamune.getName());
        assertEquals(MithrilDagger.getDamage(), Dagger.getDamage());
        assertEquals(16, ButterflyDagger.getDamage());
        assertNotEquals(Dagger.getDamage(), Masamune.getDamage());
        assertNotEquals(16, Masamune.getDamage());
        assertEquals(MithrilDagger.getWeight(), Dagger.getWeight());
        assertEquals(23, ButterflyDagger.getWeight());
        assertNotEquals(Dagger.getWeight(), Masamune.getWeight());
        assertNotEquals(23, Masamune.getWeight());
    }

    @Test
    void testEquals() {
        assertEquals(MithrilDagger, Dagger);
        assertNotEquals(Masamune, ButterflyDagger);
    }

    @Test
    void testToString() {
        assertEquals(Dagger.toString(), "Knife{name='"+Dagger.getName()+"', damage="+Dagger.getDamage()+", weight="+Dagger.getWeight()+"}");
        assertNotEquals(Masamune.toString(), "Knife{name='"+Dagger.getName()+"', damage="+MithrilDagger.getDamage()+", weight="+ButterflyDagger.getWeight()+"}");
        assertEquals(MithrilDagger.toString(), Dagger.toString());
        assertNotEquals(Masamune.toString(), ButterflyDagger.toString());
        assertNotNull(Dagger.toString());
    }

    @Test

    void testHashCode() {
        assertEquals(Dagger.hashCode(), Objects.hash(Knife.class, Dagger.getName(), Dagger.getDamage(), Dagger.getWeight()));
        assertEquals(Dagger.hashCode(), MithrilDagger.hashCode());
        assertNotEquals(Masamune.hashCode(), ButterflyDagger.hashCode());
    }
}