package factory.model.ball;


public class BasketBall extends Ball {

    public BasketBall(int size, BallColor color, int price) {
        super(size, color, price);
    }

    @Override
    public BallType getBallType() {
        return BallType.BASKETBALL;
    }

}
