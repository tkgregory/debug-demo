package com.tomgregory;

public class BattleshipGame {
    private static final int NUMBER_OF_TURNS = 50;
    private static final int GRID_SIZE = 10;
    private Board board;

    public static void main(String[] args) {
        BattleshipGame battleshipGame = new BattleshipGame();
        battleshipGame.setupBoard();
        battleshipGame.play();
        battleshipGame.reveal();
    }

    public void setupBoard() {
        System.out.println("Setting up game");
        board = new Board(GRID_SIZE);
    }

    public void play() {
        Player player = new Player(board);
        System.out.println("Commence bombardment!");

        int turnIndex = 0;
        while (turnIndex < NUMBER_OF_TURNS && !board.isSunk()) {
            player.takeTurn(turnIndex);
            turnIndex++;
        }

        if (board.isSunk()) {
            System.out.println("Ship sunk!");
        } else {
            System.out.println("Ship survived!");
        }
    }

    public void reveal() {
        board.reveal();
    }
}
