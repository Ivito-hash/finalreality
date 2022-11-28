package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

class AbstractMageCharacterTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*==========================Characters==========================*/
    BlackMage Vivi;
    WhiteMage Garnet;
    WhiteMage Daga;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
        Daga = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void getCurrentMp() {
        assertEquals(Daga.getCurrentMp(), Garnet.getCurrentMp());
        assertNotEquals(Vivi.getCurrentMp(), Garnet.getCurrentMp());
    }

    @Test
    void getMaxMp() {
        assertEquals(Daga.getMaxMp(), Garnet.getMaxMp());
        assertNotEquals(Vivi.getMaxMp(), Garnet.getMaxMp());
    }

    @Test
    void setCurrentMp() throws InvalidStatValueException {
        Vivi.setCurrentMp(30);
        assertEquals(Vivi.getCurrentMp(),30);
        assertThrows(InvalidStatValueException.class, ()->Vivi.setCurrentMp(-1));
    }
}