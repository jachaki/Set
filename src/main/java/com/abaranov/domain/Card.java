package com.abaranov.domain;

import com.abaranov.domain.enums.Colour;
import com.abaranov.domain.enums.Fill;
import com.abaranov.domain.enums.Quantity;
import com.abaranov.domain.enums.Shape;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Card {
    Shape shape;
    Colour colour;
    Quantity quantity;
    Fill fill;
}
