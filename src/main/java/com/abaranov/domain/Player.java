package com.abaranov.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Player {
    private String name;



    public SetOfCards findSet(List<Card> cardsOnBoard) {
return null; //TODO BAR
    }
}
