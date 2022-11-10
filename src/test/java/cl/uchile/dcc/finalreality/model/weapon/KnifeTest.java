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
        Dagger = new Knife("Dagger", 12, 23, WeaponType.KNIFE);
        MithrilDagger = new Knife("Dagger", 12, 23, WeaponType.KNIFE);
        ButterflyDagger = new Knife("Butterfly Dagger", 16, 23, WeaponType.KNIFE);
        Masamune = new Knife("Masamune", 62, 47, WeaponType.KNIFE);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void testEquals() {
        assertTrue(MithrilDagger.equals(Dagger));
        assertEquals(MithrilDagger, Dagger);
        assertFalse(ButterflyDagger.equals(Dagger));
        assertNotEquals(ButterflyDagger, Dagger);
        assertFalse(Masamune.equals(Dagger));
        assertNotEquals(Masamune, Dagger);
        assertFalse(Masamune.equals(ButterflyDagger));
        assertNotEquals(Masamune, ButterflyDagger);
    }

    @Test
    void testToString() {
        assertEquals(Dagger.toString(), "Knife{name='" + Dagger.getName() + "', damage=" + Dagger.getDamage() + ", weight=" + Dagger.getWeight() + ", type=" + Dagger.getType() + "}");
        assertEquals(MithrilDagger.toString(), "Knife{name='" + MithrilDagger.getName() + "', damage=" + MithrilDagger.getDamage() + ", weight=" + MithrilDagger.getWeight() + ", type=" + MithrilDagger.getType() + "}");
        assertEquals(ButterflyDagger.toString(), "Knife{name='" + ButterflyDagger.getName() + "', damage=" + ButterflyDagger.getDamage() + ", weight=" + ButterflyDagger.getWeight() + ", type=" + ButterflyDagger.getType() + "}");
        assertEquals(Masamune.toString(), "Knife{name='" + Masamune.getName() + "', damage=" + Masamune.getDamage() + ", weight=" + Masamune.getWeight() + ", type=" + Masamune.getType() + "}");
        assertEquals(MithrilDagger.toString(), Dagger.toString());
        assertNotEquals(Masamune.toString(), ButterflyDagger.toString());
    }

    @Test

    void testHashCode() {
        assertEquals(Dagger.hashCode(), Objects.hash(Knife.class, Dagger.getName(), Dagger.getDamage(), Dagger.getWeight(), Dagger.getType()));
        assertEquals(MithrilDagger.hashCode(), Objects.hash(Knife.class, MithrilDagger.getName(), MithrilDagger.getDamage(), MithrilDagger.getWeight(), MithrilDagger.getType()));
        assertEquals(ButterflyDagger.hashCode(), Objects.hash(Knife.class, ButterflyDagger.getName(), ButterflyDagger.getDamage(), ButterflyDagger.getWeight(), ButterflyDagger.getType()));
        assertEquals(Masamune.hashCode(), Objects.hash(Knife.class, Masamune.getName(), Masamune.getDamage(), Masamune.getWeight(), Masamune.getType()));
        assertEquals(Dagger.hashCode(), MithrilDagger.hashCode());
        assertNotEquals(Masamune.hashCode(), ButterflyDagger.hashCode());
    }

    @Test
    void equipBlackMage() {
        assertNotNull(Dagger.equipBlackMage(Vivi));
        assertNotNull(MithrilDagger.equipBlackMage(Vivi));
        assertNotNull(ButterflyDagger.equipBlackMage(Vivi));
        assertNotNull(Masamune.equipBlackMage(Vivi));
        assertEquals(Dagger, Dagger.equipBlackMage(Vivi));
        assertEquals(MithrilDagger.equipBlackMage(Vivi), Dagger.equipBlackMage(Vivi));
        assertNotEquals(Masamune.equipBlackMage(Vivi), ButterflyDagger.equipBlackMage(Vivi));
    }

    @Test
    void equipEngineer() {
        assertNull(Dagger.equipEngineer(Cid));
        assertNull(MithrilDagger.equipEngineer(Cid));
        assertNull(ButterflyDagger.equipEngineer(Cid));
        assertNull(Masamune.equipEngineer(Cid));
    }

    @Test
    void equipKnight() {
        assertNotNull(Dagger.equipKnight(Steiner));
        assertNotNull(MithrilDagger.equipKnight(Steiner));
        assertNotNull(ButterflyDagger.equipKnight(Steiner));
        assertNotNull(Masamune.equipKnight(Steiner));
        assertEquals(Dagger, Dagger.equipKnight(Steiner));
        assertEquals(MithrilDagger.equipKnight(Steiner), Dagger.equipKnight(Steiner));
        assertNotEquals(Masamune.equipKnight(Steiner), ButterflyDagger.equipKnight(Steiner));
    }

    @Test
    void equipThief() {
        assertNotNull(Dagger.equipThief(Zidane));
        assertNotNull(MithrilDagger.equipThief(Zidane));
        assertNotNull(ButterflyDagger.equipThief(Zidane));
        assertNotNull(Masamune.equipThief(Zidane));
        assertEquals(Dagger, Dagger.equipThief(Zidane));
        assertEquals(MithrilDagger.equipThief(Zidane), Dagger.equipThief(Zidane));
        assertNotEquals(Masamune.equipThief(Zidane), ButterflyDagger.equipThief(Zidane));
    }

    @Test
    void equipWhiteMage() {
        assertNull(Dagger.equipWhiteMage(Garnet));
        assertNull(MithrilDagger.equipWhiteMage(Garnet));
        assertNull(ButterflyDagger.equipWhiteMage(Garnet));
        assertNull(Masamune.equipWhiteMage(Garnet));
    }
}