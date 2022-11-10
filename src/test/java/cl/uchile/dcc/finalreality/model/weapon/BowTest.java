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
        ShortBow = new Bow("Short Bow", 10, 10, WeaponType.BOW);
        PracticeBow = new Bow("Short Bow", 10, 10, WeaponType.BOW);
        LongBow = new Bow("Long Bow", 14, 10, WeaponType.BOW);
        StrenghtBow = new Bow("Strenght Bow", 40, 20, WeaponType.BOW);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void testEquals() {
        assertTrue(PracticeBow.equals(ShortBow));
        assertEquals(PracticeBow, ShortBow);
        assertFalse(LongBow.equals(ShortBow));
        assertNotEquals(LongBow, ShortBow);
        assertFalse(StrenghtBow.equals(ShortBow));
        assertNotEquals(StrenghtBow, ShortBow);
        assertFalse(StrenghtBow.equals(LongBow));
        assertNotEquals(StrenghtBow, LongBow);
    }

    @Test
    void testToString() {
        assertEquals(ShortBow.toString(), "Bow{name='"+ShortBow.getName()+"', damage="+ShortBow.getDamage()+", weight="+ShortBow.getWeight()+", type="+ShortBow.getType()+"}");
        assertEquals(PracticeBow.toString(), "Bow{name='"+PracticeBow.getName()+"', damage="+PracticeBow.getDamage()+", weight="+PracticeBow.getWeight()+", type="+PracticeBow.getType()+"}");
        assertEquals(LongBow.toString(), "Bow{name='"+LongBow.getName()+"', damage="+LongBow.getDamage()+", weight="+LongBow.getWeight()+", type="+LongBow.getType()+"}");
        assertEquals(StrenghtBow.toString(), "Bow{name='"+StrenghtBow.getName()+"', damage="+StrenghtBow.getDamage()+", weight="+StrenghtBow.getWeight()+", type="+StrenghtBow.getType()+"}");
        assertEquals(PracticeBow.toString(), ShortBow.toString());
        assertNotEquals(StrenghtBow.toString(), LongBow.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(ShortBow.hashCode(), Objects.hash(Bow.class, ShortBow.getName(), ShortBow.getDamage(), ShortBow.getWeight(), ShortBow.getType()));
        assertEquals(PracticeBow.hashCode(), Objects.hash(Bow.class, PracticeBow.getName(), PracticeBow.getDamage(), PracticeBow.getWeight(), PracticeBow.getType()));
        assertEquals(LongBow.hashCode(), Objects.hash(Bow.class, LongBow.getName(), LongBow.getDamage(), LongBow.getWeight(), LongBow.getType()));
        assertEquals(StrenghtBow.hashCode(), Objects.hash(Bow.class, StrenghtBow.getName(), StrenghtBow.getDamage(), StrenghtBow.getWeight(), StrenghtBow.getType()));
        assertEquals(ShortBow.hashCode(), PracticeBow.hashCode());
        assertNotEquals(StrenghtBow.hashCode(), LongBow.hashCode());
    }

    @Test
    void equipBlackMage() {
        assertNull(ShortBow.equipBlackMage(Vivi));
        assertNull(PracticeBow.equipBlackMage(Vivi));
        assertNull(LongBow.equipBlackMage(Vivi));
        assertNull(StrenghtBow.equipBlackMage(Vivi));
    }

    @Test
    void equipEngineer() {
        assertNotNull(ShortBow.equipEngineer(Cid));
        assertNotNull(PracticeBow.equipEngineer(Cid));
        assertNotNull(LongBow.equipEngineer(Cid));
        assertNotNull(StrenghtBow.equipEngineer(Cid));
        assertEquals(ShortBow, ShortBow.equipEngineer(Cid));
        assertEquals(PracticeBow.equipEngineer(Cid), ShortBow.equipEngineer(Cid));
        assertNotEquals(StrenghtBow.equipEngineer(Cid), LongBow.equipEngineer(Cid));
    }

    @Test
    void equipKnight() {
        assertNull(ShortBow.equipKnight(Steiner));
        assertNull(PracticeBow.equipKnight(Steiner));
        assertNull(LongBow.equipKnight(Steiner));
        assertNull(StrenghtBow.equipKnight(Steiner));
    }

    @Test
    void equipThief() {
        assertNotNull(ShortBow.equipThief(Zidane));
        assertNotNull(PracticeBow.equipThief(Zidane));
        assertNotNull(LongBow.equipThief(Zidane));
        assertNotNull(StrenghtBow.equipThief(Zidane));
        assertEquals(ShortBow, ShortBow.equipThief(Zidane));
        assertEquals(PracticeBow.equipThief(Zidane), ShortBow.equipThief(Zidane));
        assertNotEquals(StrenghtBow.equipThief(Zidane), LongBow.equipThief(Zidane));
    }

    @Test
    void equipWhiteMage() {
        assertNull(ShortBow.equipWhiteMage(Garnet));
        assertNull(PracticeBow.equipWhiteMage(Garnet));
        assertNull(LongBow.equipWhiteMage(Garnet));
        assertNull(StrenghtBow.equipWhiteMage(Garnet));
    }
}