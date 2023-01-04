[![CI](https://github.com/tkgregory/debug-demo/actions/workflows/ci.yml/badge.svg)](https://github.com/tkgregory/debug-demo/actions/workflows/ci.yml)

Battleship game to demonstrate debugging. 

Check out the YouTube video for full details. 👇<br/>
[<img src="YouTube thumbail.png" width="500"/>](https://youtu.be/IeUZZoZE3sU)

## How to play

Run the `main` method inside [BattleshipGame](src/main/java/com/tomgregory/BattleshipGame.java) to initiate these steps:

1. Setup a square board with one battleship
2. Create a player
3. Play the game until the ship is sunk or player runs out of turns

The battleship location is revealed at the end.

## Bugs to find

Use IntelliJ IDEA debug to solve these issues:

1. Why does the board only add horizontal but not vertical battleships?
2. Why do we never get message *Ship sunk!* when log output shows 3 direct hits?
3. Why do we sometimes see `java.lang.ArrayIndexOutOfBoundsException`?
