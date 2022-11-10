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

class WeaponTest {

    /*=============================Queue=============================*/
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*============================Weapons============================*/
    Axe Javelin;
    Axe MithrilJavelin;
    Bow ShortBow;
    Knife Dagger;
    Staff Rod;
    Sword Broadsword;
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
        ShortBow = new Bow("Short Bow", 10, 10, WeaponType.BOW);
        Dagger = new Knife("Dagger", 12, 23, WeaponType.KNIFE);
        Rod = new Staff("Rod", 11, 23, 21, WeaponType.STAFF);
        Broadsword = new Sword("Broad Sword", 12, 18, WeaponType.SWORD);
        /*=================================Characters=================================*/
        Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
        Cid = new Engineer("Cid", 85, 18, queue);
        Steiner = new Knight("Steiner", 120, 24, queue);
        Zidane = new Thief("Zidane", 105, 21, queue);
        Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    }

    @Test
    void getName() {
        assertEquals(Javelin.getName(),"Javelin");
        assertEquals(MithrilJavelin.getName(),"Javelin");
        assertEquals(ShortBow.getName(),"Short Bow");
        assertEquals(Dagger.getName(),"Dagger");
        assertEquals(Rod.getName(),"Rod");
        assertEquals(Broadsword.getName(),"Broad Sword");
        assertEquals(MithrilJavelin.getName(),Javelin.getName());
        assertNotEquals(Dagger.getName(),ShortBow.getName());
    }

    @Test
    void getDamage() {
        assertEquals(MithrilJavelin.getDamage(),Javelin.getDamage());
        assertNotEquals(Dagger.getDamage(), ShortBow.getDamage());
    }

    @Test
    void getWeight() {
        assertEquals(MithrilJavelin.getWeight(),Javelin.getWeight());
        assertNotEquals(Dagger.getWeight(), ShortBow.getWeight());
    }

    @Test
    void getType() {
        assertEquals(MithrilJavelin.getType(),Javelin.getType());
        assertNotEquals(Dagger.getType(), ShortBow.getType());
    }

    @Test
    void equipBlackMage() {
        assertNull(Javelin.equipBlackMage(Vivi));
        assertNull(MithrilJavelin.equipBlackMage(Vivi));
        assertNull(ShortBow.equipBlackMage(Vivi));
        assertNotNull(Dagger.equipBlackMage(Vivi));
        assertNotNull(Rod.equipBlackMage(Vivi));
        assertNull(Broadsword.equipBlackMage(Vivi));

        assertEquals(Rod, Rod.equipBlackMage(Vivi));
        assertNotEquals(Dagger.equipBlackMage(Vivi),Rod.equipBlackMage(Vivi));
    }

    @Test
    void equipEngineer() {
        assertNotNull(Javelin.equipEngineer(Cid));
        assertNotNull(MithrilJavelin.equipEngineer(Cid));
        assertNotNull(ShortBow.equipEngineer(Cid));
        assertNull(Dagger.equipEngineer(Cid));
        assertNull(Rod.equipEngineer(Cid));
        assertNull(Broadsword.equipEngineer(Cid));

        assertEquals(Javelin, Javelin.equipEngineer(Cid));
        assertEquals(MithrilJavelin.equipEngineer(Cid), Javelin.equipEngineer(Cid));
        assertNotEquals(Javelin.equipEngineer(Cid),ShortBow.equipEngineer(Cid));
    }

    @Test
    void equipKnight() {
        assertNotNull(Javelin.equipKnight(Steiner));
        assertNotNull(MithrilJavelin.equipKnight(Steiner));
        assertNull(ShortBow.equipKnight(Steiner));
        assertNotNull(Dagger.equipKnight(Steiner));
        assertNull(Rod.equipKnight(Steiner));
        assertNotNull(Broadsword.equipKnight(Steiner));

        assertEquals(Javelin, Javelin.equipKnight(Steiner));
        assertEquals(MithrilJavelin.equipKnight(Steiner), Javelin.equipKnight(Steiner));
        assertNotEquals(Javelin.equipKnight(Steiner),Dagger.equipKnight(Steiner));
    }

    @Test
    void equipThief() {
        assertNull(Javelin.equipThief(Zidane));
        assertNull(MithrilJavelin.equipThief(Zidane));
        assertNotNull(ShortBow.equipThief(Zidane));
        assertNotNull(Dagger.equipThief(Zidane));
        assertNull(Rod.equipThief(Zidane));
        assertNotNull(Broadsword.equipThief(Zidane));

        assertEquals(Dagger, Dagger.equipThief(Zidane));
        assertNotEquals(Dagger.equipThief(Zidane),Broadsword.equipThief(Zidane));
    }

    @Test
    void equipWhiteMage() {
        assertNull(Javelin.equipWhiteMage(Garnet));
        assertNull(MithrilJavelin.equipWhiteMage(Garnet));
        assertNull(ShortBow.equipWhiteMage(Garnet));
        assertNull(Dagger.equipWhiteMage(Garnet));
        assertNotNull(Rod.equipWhiteMage(Garnet));
        assertNull(Broadsword.equipWhiteMage(Garnet));

        assertEquals(Rod, Rod.equipWhiteMage(Garnet));
        assertNotEquals(Rod.equipWhiteMage(Garnet),Javelin.equipWhiteMage(Garnet));
    }
}