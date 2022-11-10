package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Enemies============================*/
    Enemy Baku;
    Enemy MaskedMan;
    Enemy Haagen;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*============================Enemies============================*/
        Baku = new Enemy("Baku", 188, 10, 8, 19, queue);
        MaskedMan = new Enemy("Baku", 188, 10, 8, 19, queue);
        Haagen = new Enemy("Haagen", 33, 8, 7, 18, queue);
    }

    @Test
    void getWeight() {
        assertEquals(MaskedMan.getWeight(), Baku.getWeight());
        assertNotEquals(Haagen.getWeight(), Baku.getWeight());
    }

    @Test
    void getDamage() {
        assertEquals(MaskedMan.getDamage(), Baku.getDamage());
        assertNotEquals(Haagen.getDamage(), Baku.getDamage());
    }

    @Test
    void testEquals() {
        assertTrue(MaskedMan.equals(Baku));
        assertEquals(MaskedMan, Baku);
        assertFalse(Haagen.equals(Baku));
        assertNotEquals(Haagen, Baku);
    }

    @Test
    void testToString() {
        assertEquals(Baku.toString(), "Enemy{maxHp="+Baku.getMaxHp()+", defense="+Baku.getDefense()+", damage="+Baku.getDamage()+", weight="+Baku.getWeight()+", name='"+Baku.getName()+"'}");
        assertEquals(MaskedMan.toString(), "Enemy{maxHp="+MaskedMan.getMaxHp()+", defense="+MaskedMan.getDefense()+", damage="+MaskedMan.getDamage()+", weight="+MaskedMan.getWeight()+", name='"+MaskedMan.getName()+"'}");
        assertEquals(Haagen.toString(), "Enemy{maxHp="+Haagen.getMaxHp()+", defense="+Haagen.getDefense()+", damage="+Haagen.getDamage()+", weight="+Haagen.getWeight()+", name='"+Haagen.getName()+"'}");
        assertEquals(MaskedMan.toString(), Baku.toString());
        assertNotEquals(Haagen.toString(), Baku.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(Baku.hashCode(), Objects.hash(Enemy.class, Baku.getName(), Baku.getMaxHp(), Baku.getDefense(), Baku.getDamage(), Baku.getWeight()));
        assertEquals(MaskedMan.hashCode(), Objects.hash(Enemy.class, MaskedMan.getName(), MaskedMan.getMaxHp(), MaskedMan.getDefense(), MaskedMan.getDamage(), MaskedMan.getWeight()));
        assertEquals(Haagen.hashCode(), Objects.hash(Enemy.class, Haagen.getName(), Haagen.getMaxHp(), Haagen.getDefense(), Haagen.getDamage(), Haagen.getWeight()));
        assertEquals(Baku.hashCode(), MaskedMan.hashCode());
        assertNotEquals(Haagen.hashCode(), Baku.hashCode());
    }

    @Test
    void waitTurn() {
    }
}