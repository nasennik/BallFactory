package factory.model.ball;

public class VolleyBall extends Ball {

    public VolleyBall(int size, BallColor color, int price) {
        super(size, color, price);
    }

    @Override
    public BallType getBallType() {
        return BallType.VOLLEYBALL;
    }

}
