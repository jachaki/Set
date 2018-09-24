package com.abaranov;

import com.abaranov.domain.Board;
import com.abaranov.domain.Player;
import com.abaranov.domain.SetOfCards;
import com.abaranov.exception.LogicException;
import com.abaranov.exception.PlayerException;
import com.abaranov.utils.CardHelper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>();
    private Player currentPlayer;

    public void initBoard() {
        board = new Board();
        CardHelper.initBoard(board.getCards(), board.getCardsOnBoard());
    }

    public void initPlayers(int count) {
        if (count <= 0) {
            throw new PlayerException("Wrong player count. Value = " + count);
        }

        for (int i = 0; i < count; i++) {
            players.add(new Player(String.valueOf(i)));
        }

        setCurrentPlayer(players.get(0));
    }

    public SetOfCards findSet() {
        if (currentPlayer == null) {
            throw new PlayerException("Current player is null");
        }

        SetOfCards set = currentPlayer.findSet(board.getCardsOnBoard());
        boolean isSet = CardHelper.checkSet(set);
        if (isSet) {
            return set;
        } else {
            throw new LogicException("Check set failed");
        }
    }
}
