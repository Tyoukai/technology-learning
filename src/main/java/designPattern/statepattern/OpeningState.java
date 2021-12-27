package designPattern.statepattern;

public class OpeningState extends LiftState  {

    public OpeningState(Lift lift) {
        super(lift);
    }

    @Override
    public void open() {
        // 执行开门动作
        System.out.println("执行开门动作");
    }

    @Override
    public void close() {
        // 执行关门动作
        // 1、转化为关门状态
        mLift.setState(mLift.getCloseingState());
        // 2、关门
        mLift.close();
    }

    @Override
    public void run() {
        // do noting
        // 开门状态，不能执行运行动作
    }

    @Override
    public void stop() {
        // do noting
        // 开门状态下，不执行停止动作
    }
}
