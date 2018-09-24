package com.abaranov;

import com.abaranov.domain.Card;
import com.abaranov.utils.CardHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

import static com.abaranov.utils.CardHelper.MAX_CAPACITY;
import static com.abaranov.utils.CardHelper.MAX_ON_DESK;
import static org.junit.Assert.*;

public class CardHelperTest {

    @Test
    public void initAndShuffledDeck() {
        Stack<Card> cards = new Stack<>();
        CardHelper.initCards(cards);

        assertEquals(MAX_CAPACITY, cards.size());
    }

    @Test
    public void initCardsOnTheBoard() {
        Stack<Card> cards = new Stack<>();
        CardHelper.initCards(cards);

        ArrayList<Card> cardsOnBoard = new ArrayList<>();
        CardHelper.initCardsOnTheBoard(cards, cardsOnBoard);

        assertEquals(MAX_ON_DESK, cardsOnBoard.size());
    }
}