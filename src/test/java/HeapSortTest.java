import com.innowise.factory.basket.Basket;
import com.innowise.factory.model.ball.*;
import com.innowise.factory.sort.SortType;
import com.innowise.factory.sort.Sorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {
    private List<Ball> basketContent;
    private Comparator<Ball> comparator;
    private Sorter<Ball> sorter;

    @BeforeEach
    public void SetUp() {

        Basket<Ball> basket = new Basket<>();
        basket.addBall(new Ball(BallType.VOLLEYBALL,4, BallColor.WHITE, 10));
        basket.addBall(new Ball(BallType.SOCCER,7, BallColor.BLUE, 34));
        basket.addBall(new Ball(BallType.BASKETBALL,9, BallColor.GREEN, 56));
        basket.addBall(new Ball(BallType.VOLLEYBALL,6, BallColor.YELLOW, 80));
        basket.addBall(new Ball(BallType.SOCCER,5, BallColor.WHITE, 11));
        basket.addBall(new Ball(BallType.BASKETBALL,2, BallColor.BLUE, 56));
        basket.addBall(new Ball(BallType.VOLLEYBALL,3, BallColor.WHITE, 48));
        basket.addBall(new Ball(BallType.SOCCER,1, BallColor.BLUE, 67));
        basket.addBall(new Ball(BallType.BASKETBALL,10, BallColor.GREEN, 89));
        basket.addBall(new Ball(BallType.VOLLEYBALL,5, BallColor.YELLOW, 22));
        basketContent = basket.getBasketContent();

        sorter = new Sorter<>(basket);

    }

    @Test
    public void testSortBySize() {

        comparator = Comparator.comparing(Ball::getSize);
        sorter.sort(SortType.HEAP_SORT, comparator);

        for (int i = 0; i < basketContent.size() - 1; i++) {
            assertTrue(comparator.compare(basketContent.get(i), basketContent.get(i + 1)) <= 0);
        }
    }
    @Test
    public void testSortByType() {

        comparator = Comparator.comparing(Ball::getBallType);
        sorter.sort(SortType.HEAP_SORT, comparator);

        for (int i = 0; i < basketContent.size() - 1; i++) {
            assertTrue(comparator.compare(basketContent.get(i), basketContent.get(i + 1)) <= 0);
        }
    }
    @Test
    public void testSortByColor() {

        comparator = Comparator.comparing(Ball::getBallColor);
        sorter.sort(SortType.HEAP_SORT, comparator);

        for (int i = 0; i < basketContent.size() - 1; i++) {
            assertTrue(comparator.compare(basketContent.get(i), basketContent.get(i + 1)) <= 0);
        }
    }
    @Test
    public void testSortByPrice() {

        comparator = Comparator.comparing(Ball::getPrice);
        sorter.sort(SortType.HEAP_SORT, comparator);

        for (int i = 0; i < basketContent.size() - 1; i++) {
            assertTrue(comparator.compare(basketContent.get(i), basketContent.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortWithEmptyBasket() {
        Basket<Ball> emptyBasket = new Basket<>();

        comparator = Comparator.comparing(Ball::getPrice);
        sorter.sort(SortType.HEAP_SORT, comparator);

        assertEquals(0, emptyBasket.getBasketContent().size());
    }

    @Test
    public void testSortWithSingleBallBasket() {
        Basket<Ball> oneBallBasket = new Basket<>();
        oneBallBasket.addBall(new Ball(BallType.VOLLEYBALL, 4, BallColor.RED, 8));

        comparator = Comparator.comparing(Ball::getPrice);
        sorter.sort(SortType.HEAP_SORT, comparator);


        assertEquals(1, oneBallBasket.getBasketContent().size());
    }

}