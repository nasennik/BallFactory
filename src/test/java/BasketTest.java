package test;

import factory.basket.Basket;
import factory.model.ball.*;
import factory.sort.HeapSort;
import factory.sort.SortType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    private Basket<Ball> basket;

    @BeforeEach
    public void setUp() {
        basket = new Basket<>();
        basket.addBall(new VolleyBall(4, BallColor.WHITE, 10));
        basket.addBall(new SoccerBall(5, BallColor.BLUE, 20));
        basket.addBall(new VolleyBall(3, BallColor.RED, 5));
        basket.addBall(new BasketBall(7, BallColor.YELLOW, 30));
        basket.addBall(new VolleyBall(2, BallColor.BLUE, 3));
        basket.addBall(new BasketBall(6, BallColor.GREEN, 25));
        basket.addBall(new SoccerBall(1, BallColor.YELLOW, 2));
        basket.addBall(new BasketBall(4, BallColor.RED, 15));
        basket.addBall(new SoccerBall(5, BallColor.GREEN, 8));
        basket.addBall(new BasketBall(3, BallColor.BLUE, 12));
    }

    @Test
    public void testAdd10ElementsSizeMustBe10() {
        assertEquals(10, basket.getBalls().size());
    }

    @Test
    public void testElementRemovesSizeMustBeDecreased() {
        VolleyBall volleyBall = new VolleyBall(10, BallColor.GREEN, 43);
        basket.addBall(volleyBall);
        assertEquals(11, basket.getBalls().size());
        basket.removeBall(volleyBall);
        assertEquals(10, basket.getBalls().size());
    }

    @Test
    public void testAddNullElementSizeMustNotChange() {
        basket.addBall(null);
        assertEquals(10, basket.getBalls().size());
    }


}