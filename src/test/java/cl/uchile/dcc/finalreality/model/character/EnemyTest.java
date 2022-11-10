package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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
    Enemy Beatrix;
    /*=============================Lists=============================*/
    List<String> nombres;
    List<String> cola;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*============================Enemies============================*/
        Baku = new Enemy("Baku", 188, 10, 8, 30, queue);
        MaskedMan = new Enemy("Baku", 188, 10, 8, 30, queue);
        Haagen = new Enemy("Haagen", 66, 8, 7, 15, queue);
        Beatrix = new Enemy("Beatrix", 630, 10, 22, 40, queue);
        /*===================================QUEUE===================================*/
        nombres = new ArrayList<>();
        nombres.add("Haagen");
        nombres.add("Baku");
        nombres.add("Beatrix");
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
        assertEquals(MaskedMan, Baku);
        assertNotEquals(Haagen, Baku);
        assertEquals(MaskedMan.equals(Beatrix), Haagen.equals(Baku));
        assertNotEquals(MaskedMan.equals(Baku), Haagen.equals(Baku));
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
    void waitTurn() throws InterruptedException {
        Baku.waitTurn();
        Haagen.waitTurn();
        Beatrix.waitTurn();
        // Waits for 6 seconds to ensure that all characters have finished waiting
        Thread.sleep(6000);
        cola = new ArrayList<>();
        while (!queue.isEmpty()) {
            // Pops and prints the names of the characters of the queue to illustrate the turns
            // order
            cola.add(queue.poll().getName());
        }
        assertEquals(cola, nombres);
    }
}