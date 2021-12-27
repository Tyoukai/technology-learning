package designPattern.statepattern;

public class Main {
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(new ClosingState(lift));
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
