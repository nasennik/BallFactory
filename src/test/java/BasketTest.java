import com.innowise.factory.basket.Basket;
import com.innowise.factory.model.ball.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    private Basket<Ball> basket;

    @BeforeEach
    public void setUp() {
        basket = new Basket<>();
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
    }

    @Test
    public void testAdd10ElementsSizeMustBe10() {
        assertEquals(10, basket.getBasketContent().size());
    }

    @Test
    public void testElementRemovesSizeMustBeDecreased() {
        Ball volleyBall = new Ball(BallType.VOLLEYBALL, 10, BallColor.GREEN, 43);
        basket.addBall(volleyBall);
        assertEquals(11, basket.getBasketContent().size());
        basket.removeBall(volleyBall);
        assertEquals(10, basket.getBasketContent().size());
    }

    @Test
    public void testAddNullElementSizeMustNotChange() {
        basket.addBall(null);
        assertEquals(10, basket.getBasketContent().size());
    }


}