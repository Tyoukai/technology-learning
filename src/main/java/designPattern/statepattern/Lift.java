package designPattern.statepattern;

public class Lift {

    private LiftState openningState;
    private LiftState closingState;
    private LiftState runningState;
    private LiftState stoppingState;

    // 定义当前电梯状态
    private LiftState mCurState;

    public Lift() {
        openningState = new OpeningState(this);
        closingState = new ClosingState(this);
        runningState = new RunningState(this);
        stoppingState = new StoppingState(this);
    }

    public void open() {
        mCurState.open();
    }

    /**
     * 执行关门动作
     */
    public void close() {
        mCurState.close();
    }

    /**
     * 执行运行动作
     */

    public void run() {
        mCurState.run();
    }

    /**
     * 执行停止动作
     */
    public void stop() {
        mCurState.stop();
    }

    // ##################设置当前电梯状态#####################

    /**
     * 设置当前电梯状态
     *
     * @param state
     */
    public void setState(LiftState state) {
        this.mCurState = state;
    }

    public LiftState getOpenningState() {
        return openningState;
    }

    public LiftState getCloseingState() {
        return closingState;
    }

    public LiftState getRunningState() {
        return runningState;
    }

    public LiftState getStoppingState() {
        return stoppingState;
    }

}
