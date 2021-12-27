package designPattern.statepattern;

public class RunningState extends LiftState {

    public RunningState(Lift lift) {
        super(lift);
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        // 运行动作
        System.out.println("电梯上下运行中...");
    }

    @Override
    public void stop() {
        // 停止动作
        // 1、转化为停止状态
        this.mLift.setState(mLift.getStoppingState());
        // 2、停止动作
        this.mLift.stop();
    }
}
