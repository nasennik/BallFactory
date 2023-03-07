package test;

import factory.basket.Basket;
import factory.model.ball.Ball;
import factory.model.ball.BallColor;
import factory.model.ball.BasketBall;
import factory.model.ball.VolleyBall;
import factory.sort.HeapSort;
import factory.sort.MergeSort;
import factory.sort.SortType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private List<Ball> balls;
    private Basket<Ball> basket;
    private MergeSort mergeSort;

    @BeforeEach
    public void SetUp() {
        basket = new Basket<>();

        basket.addBall(new VolleyBall(4, BallColor.WHITE, 10));
        basket.addBall(new BasketBall(5, BallColor.BLUE, 20));
        basket.addBall(new VolleyBall(3, BallColor.RED, 5));
        basket.addBall(new BasketBall(7, BallColor.YELLOW, 30));
        basket.addBall(new VolleyBall(2, BallColor.BLUE, 3));
        basket.addBall(new BasketBall(6, BallColor.GREEN, 25));
        basket.addBall(new VolleyBall(1, BallColor.YELLOW, 2));
        basket.addBall(new BasketBall(4, BallColor.RED, 15));
        basket.addBall(new VolleyBall(5, BallColor.GREEN, 8));
        basket.addBall(new BasketBall(3, BallColor.BLUE, 12));

        balls = basket.getBalls();

        mergeSort = new MergeSort();

    }

    @Test
    public void testSortBySize() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getSize);
        basket.sort(SortType.MERGE_SORT, comparator);
        mergeSort.sort(balls, comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertEquals(true, comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortByType() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getBallType);
        basket.sort(SortType.MERGE_SORT, comparator);
        mergeSort.sort(balls, comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertEquals(true, comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortByColor() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getBallColor);
        basket.sort(SortType.MERGE_SORT, comparator);
        mergeSort.sort(balls, comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertTrue ( comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }


    @Test
    public void testSortByPrice() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getPrice);
        basket.sort(SortType.MERGE_SORT, comparator);
        mergeSort.sort(balls, comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertTrue(comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortWithEmptyBasket() {

        Basket emptyBasket = new Basket();

        Comparator<Ball> comparator = Comparator.comparing(Ball::getPrice);
        mergeSort.sort(emptyBasket.getBalls(), comparator);

        assertEquals(0, emptyBasket.getBalls().size());
    }

    @Test
    public void testSortWithSingleBallBasket() {
        // Create a basket with a single ball
        //List<Ball> balls = new ArrayList<>();
        Basket<Ball> oneBallBasket = new Basket();

        oneBallBasket.addBall(new VolleyBall(4, BallColor.WHITE, 10));

        // Sort the list of balls in the basket using heap sort
        // HeapSort<Ball> sorter = new HeapSort<>();
        Comparator<Ball> comparator = Comparator.comparing(Ball::getPrice);
        mergeSort.sort(oneBallBasket.getBalls(), comparator);

        // Check that the list of balls in the basket contains a single ball
        assertEquals(1, oneBallBasket.getBalls().size());

        // Check that the ball is the same as the original ball
        assertEquals(new VolleyBall(4, BallColor.WHITE, 10), oneBallBasket.getBalls().get(0));
    }

}