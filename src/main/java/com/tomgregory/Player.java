package com.tomgregory;

import java.awt.*;
import java.util.Random;

public class Player {
    private final boolean[][] previousAttacks;
    private final Board board;

    public Player(Board board) {
        this.board = board;
        previousAttacks = new boolean[board.getGridSize()][board.getGridSize()];
    }

    public void takeTurn(int turn) {
        Point attackPoint = getAttackPoint();
        System.out.printf("Turn %s: %s,%s", turn + 1, attackPoint.x, attackPoint.y);

        if (board.attack(attackPoint)) {
            System.out.print(" direct hit!");
        }
        System.out.println();
    }

    private Point getAttackPoint() {
        Point attackPoint = randomGridPoint();
        while (previousAttacks[attackPoint.x][attackPoint.y]) {
            attackPoint = randomGridPoint();
        }
        previousAttacks[attackPoint.x][attackPoint.y] = true;
        return attackPoint;
    }

    private Point randomGridPoint() {
        return new Point(randomInteger(board.getGridSize() - 1), randomInteger(board.getGridSize() - 1));
    }

    private static int randomInteger(int maxValue) {
        return new Random().nextInt(maxValue);
    }
}
