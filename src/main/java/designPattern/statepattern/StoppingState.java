package designPattern.statepattern;

public class StoppingState extends LiftState {

    public StoppingState(Lift lift) {
        super(lift);
    }

    @Override
    public void open() {
        // 开门动作
        // 1、开门状态
        this.mLift.setState(mLift.getOpenningState());
        // 2、执行开门动作
        this.mLift.open();
    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        // 运行动作
        // 1、运行状态
        this.mLift.setState(mLift.getRunningState());
        // 2、运行动作
        this.mLift.run();
    }

    @Override
    public void stop() {
        // 电梯停止动作
        System.out.println("电梯停止运行...");
    }
}
