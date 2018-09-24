package com.abaranov.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.abaranov.utils.CardHelper.MAX_ON_DESK;

@Getter
public class Board {
    Stack<Card> cards = new Stack<>();
    List<Card> cardsOnBoard = new ArrayList<>(MAX_ON_DESK);
}
