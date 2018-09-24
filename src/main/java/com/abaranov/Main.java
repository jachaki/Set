package com.abaranov;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.initBoard();
        game.initPlayers(1);

        game.findSet();


    }
}
