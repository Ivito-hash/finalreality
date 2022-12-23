package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A example.
 *
 * @author ~Ivo Fuenzalida~
 */
public class main {

  /**
   * An example with all classes, type of weapons, a few enemies
   * and the queue system test.
   */
  public static void main(String[] args)
      throws InterruptedException, InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    /*====================Characters====================*/
    final Thief Zidane = new Thief("Zidane", 105, 21, queue);
    final BlackMage Vivi = new BlackMage("Vivi", 60, 48, 12, queue);
    final WhiteMage Garnet = new WhiteMage("Garnet", 70, 46, 14, queue);
    final WhiteMage Eiko = new WhiteMage("Eiko", 65, 42, 13, queue);
    final Knight Steiner = new Knight("Steiner", 120, 24, queue);
    final Knight Freya = new Knight("Freya", 100, 20, queue);
    final Engineer Cid = new Engineer("Cid", 85, 18, queue);
    /*======================Weapons======================*/
    final Knife Dagger = new Knife("Dagger", 12, 10);
    final Staff MageStaff = new Staff("Mage Staff", 12, 24, 16);
    final Staff Rod = new Staff("Rod", 11, 20, 30);
    final Sword Broadsword = new Sword("Broadsword", 40, 40);
    final Axe Javelin = new Axe("Javelin", 18, 20);
    final Staff GolemFlute = new Staff("Golem's Flute", 17, 21, 19);
    final Bow ShortBow = new Bow("Shortbow", 10, 20);
    final Staff OakRod = new Staff("Oak Rod", 16, 42, 50);
    /*======================Equipment======================*/
    Vivi.equip(OakRod);
    Cid.equip(ShortBow);
    Steiner.equip(Broadsword);
    Zidane.equip(Dagger);
    Garnet.equip(Rod);
    /*======================Enemies======================*/
    final Enemy MaskedMan = new Enemy("Masked Man", 188, 10, 8, 19, queue);
    final Enemy KingLeo = new Enemy("King Leo", 186, 10, 8, 19, queue);
    final Enemy Haagen = new Enemy("Haagen", 33, 10, 8, 19, queue);
    final Enemy Baku = new Enemy("Baku", 202, 10, 9, 19, queue);
    final Enemy Beatrix = new Enemy("Beatrix", 3630, 10, 22, 41, queue);
    /*========================QUEUE========================*/
    Vivi.waitTurn();
    Cid.waitTurn();
    Steiner.waitTurn();
    Zidane.waitTurn();
    Garnet.waitTurn();
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(queue.poll().toString());
    }
  }
}
