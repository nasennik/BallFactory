import factory.basket.Basket;
import factory.model.ball.*;
import factory.sort.HeapSort;
import factory.sort.MergeSort;
import factory.sort.SortType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {
    private List<Ball> balls;
    private Basket<Ball> basket;
    private HeapSort heapSort;

    @BeforeEach
    public void SetUp() {

        basket = new Basket<>();

        basket.addBall(new VolleyBall(4, BallColor.WHITE, 10));
        basket.addBall(new SoccerBall(5, BallColor.BLUE, 20));
        basket.addBall(new VolleyBall(3, BallColor.RED, 5));
        basket.addBall(new BasketBall(7, BallColor.YELLOW, 30));
        basket.addBall(new VolleyBall(2, BallColor.BLUE, 3));
        basket.addBall(new SoccerBall(6, BallColor.GREEN, 25));
        basket.addBall(new VolleyBall(1, BallColor.YELLOW, 2));
        basket.addBall(new BasketBall(4, BallColor.RED, 15));
        basket.addBall(new SoccerBall(5, BallColor.GREEN, 8));
        basket.addBall(new BasketBall(3, BallColor.BLUE, 12));

        balls = basket.getBalls();
        heapSort = new HeapSort();

    }

    @Test
    public void testSortBySize() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getSize);
        basket.sort(SortType.HEAP_SORT, comparator);
        heapSort.sort(balls, comparator);

        for (int i = 0; i < basket.getBalls().size() - 1; i++) {
            assertEquals(true, comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }
    @Test
    public void testSortByType() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getBallType);
        basket.sort(SortType.HEAP_SORT, comparator);
        heapSort.sort(basket.getBalls(), comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertEquals(true, comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }
    @Test
    public void testSortByColor() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getBallColor);
        basket.sort(SortType.HEAP_SORT, comparator);
        heapSort.sort(balls, comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertEquals(true, comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }
    @Test
    public void testSortByPrice() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getPrice);
        basket.sort(SortType.HEAP_SORT, comparator);
        heapSort.sort(balls, comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertEquals(true, comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortWithEmptyBasket() {
        // Create an empty basket
        Basket emptyBasket = new Basket();

        Comparator<Ball> comparator = Comparator.comparing(Ball::getPrice);
        heapSort.sort(emptyBasket.getBalls(), comparator);

        // Check that the list of balls in the basket is still empty
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
        heapSort.sort(oneBallBasket.getBalls(), comparator);

        // Check that the list of balls in the basket contains a single ball
        assertEquals(1, oneBallBasket.getBalls().size());

        // Check that the ball is the same as the original ball
        assertEquals(new VolleyBall(4, BallColor.WHITE, 10), oneBallBasket.getBalls().get(0));
    }

}