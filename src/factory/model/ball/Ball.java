package factory.model.ball;

import java.util.Objects;

public abstract class Ball {
    int size;
    BallColor ballColor;
    int price;

    public Ball(int size, BallColor ballColor, int price) {
        this.size = size;
        this.ballColor = ballColor;
        this.price = price;
    }

    public abstract BallType getBallType();

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


    @Override
    public String toString() {
        return  getBallType() +
                " size=" + size +
                ", ballColor=" + ballColor +
                ", price=" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return size == ball.size && price == ball.price && ballColor == ball.ballColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, ballColor, price);
    }
}
