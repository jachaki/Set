package com.abaranov.domain;

import com.abaranov.exception.LogicException;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class SetOfCards {
    public static final int REQUIRED_CAPACITY = 3;

    private List<Card> cards;

    public SetOfCards(Card cardFirst, Card cardSecond, Card cardThird) {
        Set<Card> cardSetTemp = Stream.of(cardFirst, cardSecond, cardThird).collect(Collectors.toSet());

        int size = cardSetTemp.size();
        if (size != REQUIRED_CAPACITY) {
            throw new LogicException("SetOfCards contains only " + size + " cards");
        }

        cards = Collections.unmodifiableList(new ArrayList<>(cardSetTemp));
    }
}
