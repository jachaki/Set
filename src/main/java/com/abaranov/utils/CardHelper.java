package com.abaranov.utils;

import com.abaranov.domain.Card;
import com.abaranov.domain.SetOfCards;
import com.abaranov.domain.enums.Colour;
import com.abaranov.domain.enums.Fill;
import com.abaranov.domain.enums.Quantity;
import com.abaranov.domain.enums.Shape;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CardHelper {
    public static final int MAX_CAPACITY = 81;
    public static final int MAX_ON_DESK = 9;

    public static void initBoard(Stack<Card> cards, List<Card> cardsOnBoard) {
        cards.clear();
        cardsOnBoard.clear();

        initCards(cards);
        shuffleCards(cards);
        initCardsOnTheBoard(cards, cardsOnBoard);
    }

    public static void initCards(Stack<Card> cards) {
        for (Colour colour : Colour.values()) {
            for (Shape shape : Shape.values()) {
                for (Quantity quantity : Quantity.values()) {
                    for (Fill fill : Fill.values()) {
                        cards.push(new Card(shape, colour, quantity, fill));
                    }
                }
            }
        }
    }

    static void shuffleCards(Stack<Card> cards) {
        Collections.shuffle(cards);
    }

    public static void initCardsOnTheBoard(Stack<Card> cards, List<Card> cardsOnBoard) {
        for (int i = 0; i < MAX_ON_DESK; i++) {
            cardsOnBoard.add(cards.pop());
        }
    }

    public static boolean checkSet(SetOfCards set) {
        List<Card> cardSet = set.getCards();

        boolean result = checkSetElement(cardSet.stream().map(Card::getFill).distinct().count());
        result &= checkSetElement(cardSet.stream().map(Card::getColour).distinct().count());
        result &= checkSetElement(cardSet.stream().map(Card::getQuantity).distinct().count());
        result &= checkSetElement(cardSet.stream().map(Card::getShape).distinct().count());


        return result;

    }

    private static boolean checkSetElement(long count) {
        return count == 1 || count == 3;
    }

}
