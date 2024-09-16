package me.dvsgn.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PCCP_1번_붕대_감기 {
    public static void main(String[] args) {
        var solution = new Solution();

        var bandage = new int[]{5, 1, 5};
        var health = 30;
        var attacks = new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        var result = solution.solution(bandage, health, attacks);

        System.out.println(result);
    }
}

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        var player = new GameCharacter(health, new Bandage(bandage[0], bandage[1], bandage[2]));
        var game = new Game(player, attacks);
        game.play();
        return player.getHealth();
    }
}

class Game {
    private final GameCharacter gameCharacter;
    private final List<Attack> attacks;
    private final int totalTurn;

    Game(GameCharacter gameCharacter, int[][] attacks) {
        this.gameCharacter = gameCharacter;
        this.attacks = Arrays.stream(attacks)
                .map(attack -> new Attack(attack[0], attack[1]))
                .collect(Collectors.toList());
        this.totalTurn = this.attacks.stream()
                .mapToInt(Attack::getTurn)
                .max()
                .orElseThrow();
    }

    public void play() {
        for (int turn = 1; turn <= totalTurn; turn++) {
            processTurn(turn);
            if (gameCharacter.isDead()) {
                break;
            }
        }
    }

    private void processTurn(int turn) {
        var attack = attacks.stream()
                .filter(a -> a.isTurn(turn))
                .findFirst()
                .orElse(null);

        if (attack != null) {
            gameCharacter.sufferDamage(attack.getDamage());
        }

        gameCharacter.heal(attack != null);
    }
}

class GameCharacter {
    private int health;
    private final int maxHealth;
    private final Bandage bandage;

    public GameCharacter(int health, Bandage bandage) {
        this.health = health;
        this.maxHealth = health;
        this.bandage = bandage;
    }

    public int getHealth() {
        return health;
    }

    public void sufferDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = -1;  // Character dies
        }
    }

    public boolean isDead() {
        return health == -1;
    }

    public void heal(boolean wasAttacked) {
        if (wasAttacked) {
            bandage.resetSuccess();
        } else if (health < maxHealth) {
            health += bandage.getHealingAmount();
            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }
}

class Bandage {
    private int success = 0;
    private final int castTime;
    private final int heal;
    private final int bonusHeal;

    public Bandage(int castTime, int heal, int bonusHeal) {
        this.castTime = castTime;
        this.heal = heal;
        this.bonusHeal = bonusHeal;
    }

    public void resetSuccess() {
        success = 0;
    }

    public int getHealingAmount() {
        success++;
        if (success == castTime) {
            resetSuccess();
            return heal + bonusHeal;
        }
        return heal;
    }
}

class Attack {
    private final int turn;
    private final int damage;

    public Attack(int turn, int damage) {
        this.turn = turn;
        this.damage = damage;
    }

    public boolean isTurn(int turn) {
        return this.turn == turn;
    }

    public int getDamage() {
        return damage;
    }

    public int getTurn() {
        return turn;
    }
}
