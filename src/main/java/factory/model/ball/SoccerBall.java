package factory.model.ball;

public class SoccerBall extends Ball {

    public SoccerBall(int size, BallColor color, int price) {
        super(size, color, price);
    }

    @Override
    public BallType getBallType() {
        return BallType.SOCCER;
    }


}
