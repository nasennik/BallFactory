package com.innowise.factory.sort;

import com.innowise.factory.basket.Basket;
import com.innowise.factory.model.ball.Ball;

import java.util.Comparator;
import java.util.List;

public class Sorter<T extends Ball>{
    private Basket<T> basket;
    public Sorter(Basket<T> basket) {
        this.basket = basket;
    }

    public List<T> sort(SortType sortFunction, Comparator<T> comparator) {
       return sortFunction.getSortable().sort(basket.getBasketContent(), comparator);
    }

}
