package com.innowise.factory.basket;

import com.innowise.factory.model.ball.Ball;

import java.util.ArrayList;
import java.util.List;

public class Basket<T extends Ball> {

    private List<T> basketContent;

    public Basket() {
        basketContent = new ArrayList<>();
    }

    public boolean addBall(T ball) {
        if (ball == null) {
            return false;
        }else {
            basketContent.add(ball);
            return true;
        }
    }

    public void removeBall(T ball) {
        basketContent.remove(ball);
    }

    public List<T> getBasketContent() {
        return basketContent;
    }

}


