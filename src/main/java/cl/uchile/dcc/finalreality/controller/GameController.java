package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.controller.eventHandler.DeathEnemyHandler;
import cl.uchile.dcc.finalreality.controller.eventHandler.DeathPlayerCharacterHandler;
import cl.uchile.dcc.finalreality.controller.eventHandler.QueueCharacterHandler;
import cl.uchile.dcc.finalreality.controller.phases.Phase;
import cl.uchile.dcc.finalreality.controller.phases.StartGame;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Controller of the game.
 * Use the Observer Pattern.
 *
 * @author ~Ivo Fuenzalida~
 */

public class GameController {
    private final DeathPlayerCharacterHandler playerCharacterDeathHandler;
    private final DeathEnemyHandler enemyDeathHandler;
    private final QueueCharacterHandler characterQueueHandler;
    private final BlockingQueue<GameCharacter> turns;
    private final ArrayList<PlayerCharacter> playerCharacters;
    private final ArrayList<Enemy> enemies;
    private final int numberOfPlayerCharacters;
    private final int numberOfEnemies;
    private int playerCharactersAlive;
    private int enemiesAlive;
    private final HashMap<String, Integer> charactersPositionsByName;
    private final HashMap<String, Integer> enemyPositionsByName;
    private Phase phase;
    private final Random random;
    private Boolean turnTaken;
    private Boolean canTakeTurn;
    private GameCharacter activeGameCharacter;
    private final ArrayList<String> turnsLog;

    /**
     * Creates the controller for a new game.
     *
     * @param numberOfPlayerCharacters the number of PlayerCharacters for this game
     * @param numberOfEnemies the number of Enemies for this game
     */
    public GameController(int numberOfPlayerCharacters, int numberOfEnemies) {
        playerCharacterDeathHandler = new DeathPlayerCharacterHandler(this);
        enemyDeathHandler = new DeathEnemyHandler(this);
        characterQueueHandler = new QueueCharacterHandler(this);
        turns = new LinkedBlockingQueue<>();

        playerCharacters = new ArrayList<>(numberOfPlayerCharacters);
        enemies = new ArrayList<>(numberOfEnemies);
        this.numberOfPlayerCharacters = numberOfPlayerCharacters;
        this.numberOfEnemies = numberOfEnemies;
        playerCharactersAlive = 0;
        enemiesAlive = 0;

        charactersPositionsByName = new HashMap<>();
        enemyPositionsByName = new HashMap<>();

        setPhase(new StartGame());
        random = new Random();
        turnTaken = false;
        canTakeTurn = true;
        turnsLog = new ArrayList<>(10);
    }

    /**
     * Set the phases in the game.
     */
    public void setPhase(Phase phase) {
        this.phase = phase;
        phase.setGameController(this);
    }

    /**
     * Return the actual phase of the game.
     */
    public Phase getCurrentPhase() {
        return this.phase;
    }

    /**
     * Return the name of the actual phase of the game.
     */
    public String getCurrentPhaseName(){ return this.phase.getName();}

    /**
     * Returns a boolean value.
     * True if this phase is the current one, or False if it is not.
     */
    public boolean isPlayerAction() {return this.phase.isPlayerAction();}
    public boolean isEnemyAction() {return this.phase.isEnemyAction();}
    public boolean isPlayerWin() {return this.phase.isPlayerWin();}
    public boolean isEnemyWin() {return this.phase.isEnemyWin();}

    /**
     * Returns the number of alive player character's.
     */
    public int getPlayerCharactersAlive() { return playerCharactersAlive; }

    /**
     * Returns the number of alive enemies.
     */
    public int getEnemiesAlive() {return enemiesAlive;}

    /**
     * Add an PlayerCharacter to the playerCharacters array if there is space.
     */
    private void addToPlayerCharacters(PlayerCharacter character) {
        if (playerCharacters.size() < numberOfPlayerCharacters) {
            playerCharacters.add(character);
            playerCharactersAlive += 1;
            charactersPositionsByName.put(getNameFrom(character), getPlayerCharactersAlive());
            character.addSubscriberForDeath(playerCharacterDeathHandler);
            character.addSubscriberForAddToQueue(characterQueueHandler);
        }
    }

    /**
     * add an Enemy to the enemies array if there is space
     */
    private void addToEnemies(Enemy enemy) {
        if (enemies.size() < numberOfEnemies) {
            enemies.add(enemy);
            enemiesAlive += 1;
            enemyPositionsByName.put(getNameFrom(enemy), getEnemiesAlive());
            enemy.addSubscriberForDeath(enemyDeathHandler);
            enemy.addSubscriberForAddToQueue(characterQueueHandler);
        }
    }

    /**
     * Returns the player character's array.
     */
    public ArrayList<PlayerCharacter> getPlayerCharacters() { // Retorna el arreglo de los personajes del jugador
        return playerCharacters;
    }

    /**
     * Returns the enemies array.
     */
    public ArrayList<Enemy> getEnemies() { // Retorna el arreglo de los enemigos
        return enemies;
    }

    /**
     * Returns a PlayerCharacter from the playerCharacters array.
     */
    public PlayerCharacter getPlayerCharacter(int index) { // Retorna un personajes del jugador según el indice del arreglo
        return playerCharacters.get(index);
    }

    /**
     * Returns an Enemy from the enemies array.
     */
    public Enemy getEnemy(int index) { // Retorna un enemigo según el indice del arreglo
        return enemies.get(index);
    }

    /**
     * Returns the hashmaps with the position of the PlayerCharacters by their names.
     */
    public HashMap<String, Integer> getCharactersPositionsByName() {return charactersPositionsByName;}

    /**
     * Returns the hashmaps with the position of the enemies by their names.
     */
    public HashMap<String, Integer> getEnemyPositionsByName() {return enemyPositionsByName;}

    /**
     * Returns the indices from the playerCharacters array of the playerCharacters that are alive.
     */
    public ArrayList<Integer> getAlivePlayerCharactersIndex() {
        ArrayList<Integer> alivePlayerCharactersIndex = new ArrayList<>();
        for(int i=0; i<playerCharacters.size(); i++) {
            if(getPlayerCharacter(i).isAlive()) {
                alivePlayerCharactersIndex.add(i);
            }
        }
        return alivePlayerCharactersIndex;
    }

    /**
     * Returns the indices from the enemies array of the enemies that are alive.
     */
    public ArrayList<Integer> getAliveEnemiesIndex() {
        ArrayList<Integer> aliveEnemiesIndex = new ArrayList<>();
        for(int i=0; i<enemies.size(); i++) {
            if(getEnemy(i).isAlive()) {
                aliveEnemiesIndex.add(i);
            }
        }
        return aliveEnemiesIndex;
    }

    /**
     * Create a BlackMage for this game, and adds to the queue and array,
     * managed by the controller.
     */
    public void createBlackMage(String name, int maxHp, int maxMp, int defense) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            BlackMage blackMage = new BlackMage(name, maxHp, maxMp, defense, turns);
            addToPlayerCharacters(blackMage);
        }
    }

    /**
     * Create an Engineer for this game, and adds to the queue and array,
     * managed by the controller.
     */
    public void createEngineer(String name, int maxHp, int defense) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            Engineer engineer = new Engineer(name, maxHp, defense, turns);
            addToPlayerCharacters(engineer);
        }
    }

    /**
     * Create a Knight for this game, and adds to the queue and array,
     * managed by the controller.
     */
    public void createKnight(String name, int maxHp, int defense) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            Knight knight = new Knight(name, maxHp, defense, turns);
            addToPlayerCharacters(knight);
        }
    }

    /**
     * Create a Thief for this game, and adds to the queue and array,
     * managed by the controller.
     */
    public void createThief(String name, int maxHp, int defense) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            Thief thief = new Thief(name, maxHp, defense, turns);
            addToPlayerCharacters(thief);
        }
    }

    /**
     * Create a WhiteMage for this game, and adds to the queue and array,
     * managed by the controller.
     */
    public void createWhiteMage(String name, int maxHp, int maxMp, int defense) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            WhiteMage whiteMage = new WhiteMage(name, maxHp, maxMp, defense, turns);
            addToPlayerCharacters(whiteMage);
        }
    }

    /**
     * Create an Enemy for this game, and adds to the queue and array,
     * managed by the controller.
     */
    public void createEnemy(String name, int maxHp, int defense, int damage, int weight) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            Enemy enemy = new Enemy(name, maxHp, defense, damage, weight, turns);
            addToEnemies(enemy);
        }
    }


    /**
     * Creates an Axe.
     */
    public void createAxe(String name, int damage, int weight) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            Axe axe = new Axe(name, damage, weight);
        }
    }

    /**
     * Creates a Bow.
     */
    public void createBow(String name, int damage, int weight) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            Bow bow = new Bow(name, damage, weight);
        }
    }

    /**
     * Creates a Knife.
     */
    public void createKnife(String name, int damage, int weight) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            Knife knife = new Knife(name, damage, weight);
        }
    }

    /**
     * Creates a Staff.
     */
    public void createStaff(String name, int damage, int magicDamage, int weight) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            Staff staff = new Staff(name, damage, magicDamage, weight);
        }
    }

    /**
     * Creates a Sword.
     */
    public void createSword(String name, int damage, int weight) throws InvalidStatValueException {
        if (phase.isStartGame()) {
            Sword sword = new Sword(name, damage, weight);
        }
    }

    public String getNameFrom(GameCharacter character) { return character.getName(); }
    public int getHealthPointsFrom(GameCharacter character) {
        return character.getCurrentHp();
    }
    public int getDefenseFrom(GameCharacter character) {
        return character.getDefense();
    }
    public int getAttackDamageFrom(GameCharacter character) {
        return character.getDamageCharacter();
    }
    public WeaponInterface getWeaponFrom(PlayerCharacter character) {return character.getEquippedWeapon();}
    public int getWeaponDamageOff(WeaponInterface weapon) {return weapon.getDamage();}
    public int getWeaponWeightOff(WeaponInterface weapon) {return weapon.getWeight();}
    public int getWeightFrom(Enemy enemy) {
        return enemy.getWeight();
    }
    public int getManaFrom(Mage mage) {return mage.getCurrentMp();}

    public String getPlayerCharacterNameByIndex(int index) { return getNameFrom(getPlayerCharacter(index)); }
    public String getEnemyNameByIndex(int index) { return getNameFrom(getEnemy(index)); }
    public int getPlayerCharacterHealthByIndex(int index) { return getHealthPointsFrom(getPlayerCharacter(index)); }
    public int getEnemyHealthByIndex(int index) { return getHealthPointsFrom(getEnemy(index)); }
    public int getPlayerCharacterDefenseByIndex(int index) { return getDefenseFrom(getPlayerCharacter(index)); }
    public int getEnemyDefenseByIndex(int index) { return getDefenseFrom(getEnemy(index)); }
    public int getPlayerCharacterAttackByIndex(int index) { return getAttackDamageFrom(getPlayerCharacter(index)); }
    public int getEnemyAttackByIndex(int index) { return getAttackDamageFrom(getEnemy(index)); }
    public int getWeightOffEquippedWeaponFrom(PlayerCharacter character) { return getWeaponWeightOff(getWeaponFrom(character)); }
    public int getWeightOffEquipedWeaponByIndex(int index) { return getWeaponWeightOff(getWeaponFrom(getPlayerCharacter(index))); }
    public int getEnemyWeightByIndex(int index) { return getWeightFrom(getEnemy(index)); }

    public String getNameOffEquippedWeaponFrom(PlayerCharacter character) {
        WeaponInterface weapon = getWeaponFrom(character);
        String weaponName = "No weapon Equipped!";
        if(weapon != null) {
            weaponName = weapon.getName();
        }
        return weaponName;
    }
    public String getNameOffEquippedWeaponByIndex(int index) {
        WeaponInterface weapon = getWeaponFrom(getPlayerCharacter(index));
        String weaponName = "No weapon Equipped!";
        if(weapon != null) {
            weaponName = weapon.getName();
        }
        return weaponName;
    }

    public String getCharacterClassFrom(GameCharacter character) {return character.toString();}
    public String getCharacterClassByIndex(int index) { return getPlayerCharacter(index).toString(); }
    public String getEnemyClassByIndex(int index) { return getEnemy(index).toString(); }
    public String getWeaponClass(WeaponInterface weapon) {
        return weapon.toString();
    }

    public int getPartyHealthPoints() {
        int partyHealthPoints = 0;
        for(var character : getPlayerCharacters()) {
            partyHealthPoints += getHealthPointsFrom(character);
        }
        return partyHealthPoints;
    }
    public int getPartyDefense() {
        int partyDefense = 0;
        for(var character : getPlayerCharacters()) {
            partyDefense += getDefenseFrom(character);
        }
        return partyDefense;
    }
    public int getPartyAttackDamage() {
        int partyAttackDamage = 0;
        for(var character : getPlayerCharacters()) {
            partyAttackDamage += getAttackDamageFrom(character);
        }
        return partyAttackDamage;
    }
    public int getPartyWeight() {
        int partyWeight = 0;
        for(var character : getPlayerCharacters()) {
            partyWeight += getWeightOffEquippedWeaponFrom(character);
        }
        return partyWeight;
    }
    public boolean partyIsEquipped() {
        for(var character : getPlayerCharacters()) {
            if(character.getEquippedWeapon() == null) {
                return false;
            }
        }
        return true;
    }

    public void equipPlayerCharacter(PlayerCharacter playerCharacter, WeaponInterface weapon) {
        WeaponInterface currentWeapon = playerCharacter.getEquippedWeapon();
        if (currentWeapon == null) {
            playerCharacter.equip(weapon);
        }
        else if (!(currentWeapon.equals(weapon))) {
        }

        else {
            playerCharacter.equip(weapon);
        }
    }

    /**
     * Try to start the game, it only works if it is in the correct phase.
     */
    public void tryToStartGame() { phase.tryToStartGame();}

    /**
     * Adds the game characters to the turns queue.
     */
    public void startGame() {
        if (playerCharactersAlive == numberOfPlayerCharacters) {
            for (var playerCharacter : playerCharacters) {
                playerCharacter.waitTurn();
            }
            for (var enemy : enemies) {
                enemy.waitTurn();
            }
            phase.toWaitTurn();
        }
    }

    /**
     * Try to take a turn if the game is in the correct phase and
     * the character can take it.
     */
    public void tryToTakeTurn() {
        if(phase.isWaitTurn() && canTakeTurn) {
            canTakeTurn = false;
            phase.toTurn();
            tryToBeginTurn();
        }
    }

    /**
     * Return a boolean value, if the PlayerCharacter turnType return True,
     * else, if not, return False.
     */
    public boolean isPlayerCharacterTurn(GameCharacter character) {return character.turnType() == 1;}

    /**
     * Try to begin a turn, if the game is in the correct phase.
     */
    public void tryToBeginTurn() {phase.tryToBeginTurn();}

    /**
     * Select a GameCharacter from the turn queue, starting his a turn.
     */
    public void beginTurn() {
        if (!turnTaken) {
            turnTaken = true;
            activeGameCharacter = getActiveGameCharacter();
            if(activeGameCharacter.isAlive()) {
                addToTurnsLog(activeGameCharacter.getName() + " has begin his turn");
                if (isPlayerCharacterTurn(activeGameCharacter)) {
                    phase.toPlayerAction();
                }
                else {
                    phase.toEnemyAction();
                    PlayerCharacter randomAliveTarget = randomAlivePlayerCharacter();
                    tryToAttackCharacter(activeGameCharacter, randomAliveTarget);
                }
            }
            else {
                endTurn(activeGameCharacter);
            }
        }
    }

    /**
     * Select a random alive PlayerCharacter from the playerCharacter array.
     */
    public PlayerCharacter randomAlivePlayerCharacter() {
        while (true) {
            int randomInt = random.nextInt(numberOfPlayerCharacters);
            PlayerCharacter randomAlivePlayerCharacter = getPlayerCharacter(randomInt);
            if(randomAlivePlayerCharacter.isAlive()) {
                return randomAlivePlayerCharacter;
            }
        }
    }

    /**
     * Returns the GameCharacter who owns the turn.
     */
    public GameCharacter getActiveGameCharacter() {
        activeGameCharacter = turns.peek();
        return activeGameCharacter;
    }

    /**
     * Try to do an attack, if the game is in the correct phase.
     */
    public void tryToAttackCharacter(GameCharacter attackerCharacter, GameCharacter attackedCharacter) {
        phase.tryToAttackCharacter(attackerCharacter, attackedCharacter);
    }

    /**
     * Make a character attack another.
     */
    public void attackCharacter(GameCharacter attackerCharacter, GameCharacter attackedCharacter) {
        addToTurnsLog(attackerCharacter.getName() + " attacked " + attackedCharacter.getName() + "!");
        int oldHealthPoints = attackedCharacter.getCurrentHp();
        attackerCharacter.attack(attackedCharacter);
        int currentHealthPoints = attackedCharacter.getCurrentHp();
        addToTurnsLog("The attack did " + (oldHealthPoints-currentHealthPoints) + " damage!");
        endTurn(attackerCharacter);
    }

    /**
     * End the turn of a GameCharacter.
     */
    public void endTurn(GameCharacter character) {
        addToTurnsLog(character.getName() + " end his turn");
        canTakeTurn = true;
        turnTaken = false;
        turns.poll();
        phase.toWaitTurn();
        if (!turns.isEmpty()) {
            tryToTakeTurn();
        }
        character.waitTurn();
    }

    /**
     * Check if the player won the game.
     */
    public boolean playerWin() {
        return enemiesAlive == 0;
    }

    /**
     * Check if the enemy won the game.
     */
    public boolean enemyWin() {
        return playerCharactersAlive == 0;
    }

    /**
     * Method that executed when the DeathPlayerCharacterHandler is notified about a player character died.
     */
    public void onPlayerCharacterDeath(PlayerCharacter character) {
        playerCharactersAlive -= 1;
        turns.remove(character);
        addToTurnsLog(character.getName() + " died!");
        if (enemyWin()) {
            phase.toEnemyWin();
        }
    }

    /**
     * Method that executed when the DeathEnemyHandler is notified about an enemy died.
     */
    public void onEnemyDeath(Enemy enemy) {
        enemiesAlive -= 1;
        turns.remove(enemy);
        addToTurnsLog(enemy.getName() + " died!");
        if (playerWin()) {
            phase.toPlayerWin();
        }
    }

    /**
     * Returns a random weight for a enemy between 10 and 40.
     */
    public int getRandomEnemyWeight() {return random.nextInt(40 -10) + 10;}

    /**
     * Returns a random weight for a PlayerCharacter's weapon
     */
    public int getRandomWeaponWeight(int weaponDamage) {
        return random.nextInt(30 -10) + 10 + (5*weaponDamage/100);
    }

    /**
     * Function that generate random enemies stats based on player's party power
     * and creates enemies with that stats.
     */
    public void createRandomEnemies(int partyHealthPoints, int partyDefense, int partyAttackDamage) throws InvalidStatValueException {
        int enemyHealthPoints = partyHealthPoints/numberOfEnemies;
        int enemyDefense = partyDefense/numberOfEnemies;
        int enemyAttackDamage = partyAttackDamage/numberOfEnemies;
        int enemyWeight = getRandomEnemyWeight();
        int deltaHealthPoints, deltaDefense, deltaAttackDamage;
        for(int i=0; i<numberOfEnemies; i++) {
            deltaHealthPoints = random.nextInt(15 - -5) - 5;
            deltaDefense = random.nextInt(5 - -5) - 5;
            deltaAttackDamage = random.nextInt(15 - -5) -5;
            enemyHealthPoints += deltaHealthPoints;
            enemyDefense += deltaDefense;
            enemyAttackDamage += deltaAttackDamage;
            if(enemyHealthPoints<0) {
                enemyHealthPoints=1;
            }
            if(enemyDefense<0) {
                enemyDefense=0;
            }
            if(enemyAttackDamage<0){
                enemyAttackDamage=1;
            }
            createEnemy(
                    "Enemy" + (i+1),
                    enemyHealthPoints,
                    enemyDefense,
                    enemyAttackDamage,
                    enemyWeight);
        }
    }

    /**
     * Add a string to the turns log.
     */
    public void addToTurnsLog(String action) {
        if (turnsLog.size() >= 10) {
            turnsLog.remove(0);
        }
        turnsLog.add(action);
    }

    /**
     * Returns the turns log.
     */
    public ArrayList<String> getTurnsLog() {return turnsLog;}
}
