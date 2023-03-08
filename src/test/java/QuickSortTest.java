import factory.basket.Basket;
import factory.model.ball.*;
import factory.sort.HeapSort;
import factory.sort.MergeSort;
import factory.sort.QuickSort;
import factory.sort.SortType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    private List<Ball> balls;
    private Basket<Ball> basket;
    private QuickSort quickSort;

    @BeforeEach
    public void SetUp(){

        basket = new Basket<>();

        basket.addBall(new VolleyBall(4, BallColor.WHITE, 10));
        basket.addBall(new BasketBall(5, BallColor.BLUE, 20));
        basket.addBall(new VolleyBall(3, BallColor.RED, 5));
        basket.addBall(new SoccerBall(7, BallColor.YELLOW, 30));
        basket.addBall(new VolleyBall(2, BallColor.BLUE, 3));
        basket.addBall(new BasketBall(6, BallColor.GREEN, 25));
        basket.addBall(new SoccerBall(1, BallColor.YELLOW, 2));
        basket.addBall(new BasketBall(4, BallColor.RED, 15));
        basket.addBall(new VolleyBall(5, BallColor.GREEN, 8));
        basket.addBall(new SoccerBall(3, BallColor.BLUE, 12));

        balls = basket.getBalls();
        quickSort = new QuickSort();

    }

    @Test
    public void testSortBySize() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getSize);
        basket.sort(SortType.QUICK_SORT, comparator);
        quickSort.sort(balls, comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertTrue(comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortByType() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getBallType);
        basket.sort(SortType.QUICK_SORT, comparator);
        quickSort.sort(balls, comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertTrue(comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortByColor() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getBallColor);
        basket.sort(SortType.QUICK_SORT, comparator);
        quickSort.sort(balls, comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertTrue(comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }


    @Test
    public void testSortByPrice() {

        Comparator<Ball> comparator = Comparator.comparing(Ball::getPrice);
        basket.sort(SortType.QUICK_SORT, comparator);
        quickSort.sort(balls, comparator);

        for (int i = 0; i < balls.size() - 1; i++) {
            assertTrue(comparator.compare(balls.get(i), balls.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortWithEmptyBasket() {
        Basket<Ball> emptyBasket = new Basket<>();

        Comparator<Ball> comparator = Comparator.comparing(Ball::getPrice);
        quickSort.sort(emptyBasket.getBalls(), comparator);

        assertEquals(0, emptyBasket.getBalls().size());
    }

    @Test
    public void testSortWithSingleBallBasket() {

        Basket<Ball> oneBallBasket = new Basket<>();

        oneBallBasket.addBall(new VolleyBall(4, BallColor.WHITE, 10));

        Comparator<Ball> comparator = Comparator.comparing(Ball::getPrice);
        quickSort.sort(oneBallBasket.getBalls(), comparator);

        assertEquals(1, oneBallBasket.getBalls().size());
        assertEquals(new VolleyBall(4, BallColor.WHITE, 10), oneBallBasket.getBalls().get(0));
    }


}