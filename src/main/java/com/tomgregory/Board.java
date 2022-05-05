package com.tomgregory;

import java.awt.*;
import java.util.Random;

public class Board {
    private static final int BATTLESHIP_LENGTH = 3;
    private final boolean[][] grid;
    private int hitCount = 0;

    public Board(int gridSize) {
        grid = new boolean[gridSize][gridSize];
        addBattleship();
    }

    public boolean attack(Point attackPoint) {
        if (grid[attackPoint.x][attackPoint.y]) {
            hitCount++;
            return true;
        }
        return false;
    }

    public boolean isSunk() {
        return hitCount > BATTLESHIP_LENGTH;
    }

    public void reveal() {
        System.out.println("Revealing battleship location");
        StringBuilder gridVisualisation = new StringBuilder();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid.length; x++) {
                if (grid[x][y]) {
                    gridVisualisation.append("x ");
                } else {
                    gridVisualisation.append("o ");
                }
            }
            gridVisualisation.append(System.lineSeparator());
        }
        System.out.println(gridVisualisation);
    }

    public int getGridSize() {
        return grid.length;
    }

    private void addBattleship() {
        Point startPoint = randomGridPoint();
        Point endPoint = calculateEndPoint(startPoint);

        for (int x = startPoint.x; x < endPoint.x + 1; x++) {
            for (int y = startPoint.y; y < endPoint.y + 1; y++) {
                grid[x][y] = true;
            }
        }
    }

    private Point randomGridPoint() {
        return new Point(getRandomInteger(grid.length - 1), getRandomInteger(grid.length - 1));
    }

    private Point calculateEndPoint(Point startPoint) {
        return switch (getRandomInteger(1)) {
            case 0 -> getHorizontalEndPoint(startPoint);
            case 1 -> getVerticalEndPoint(startPoint);
            default -> throw new IllegalStateException("Unexpected value.");
        };
    }

    private Point getHorizontalEndPoint(Point startPoint) {
        return new Point(startPoint.x + BATTLESHIP_LENGTH - 1, startPoint.y);
    }

    private Point getVerticalEndPoint(Point startPoint) {
        return new Point(startPoint.x, startPoint.y + BATTLESHIP_LENGTH - 1);
    }

    private static int getRandomInteger(int maxValue) {
        return new Random().nextInt(maxValue);
    }
}
