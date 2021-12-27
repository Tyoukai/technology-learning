package designPattern.statepattern;

public class ClosingState extends LiftState {

    public ClosingState(Lift lift) {
        super(lift);
    }

    @Override
    public void open() {
        // 执行开门动作
        // 1、变化为开门状态
        this.mLift.setState(mLift.getOpenningState());
        // 2、开门
        this.mLift.open();
    }

    @Override
    public void close() {
        System.out.println("执行关门动作");
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
        // 停止动作
        // 1、转化为停止状态
        this.mLift.setState(mLift.getStoppingState());
        // 2、停止
        this.mLift.stop();
    }
}
