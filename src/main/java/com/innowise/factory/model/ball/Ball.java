package com.innowise.factory.model.ball;

import java.util.Objects;

public class Ball {
    private int size;
    private BallColor ballColor;
    private int price;
    private BallType ballType;

    public Ball(BallType ballType, int size, BallColor ballColor, int price) {
        this.ballType = ballType;
        this.size = size;
        this.ballColor = ballColor;
        this.price = price;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BallColor getBallColor() {
        return ballColor;
    }

    public void setBallColor(BallColor ballColor) {
        this.ballColor = ballColor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    @Override
    public String toString() {
        return "Ball: " + ballType +
                " size=" + size +
                ", ballColor=" + ballColor +
                ", price=" + price ;
    }
}
