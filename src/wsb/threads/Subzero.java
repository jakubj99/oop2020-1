package wsb.threads;

public class Subzero extends Task9a {
    @Override
    public void run() {
        super.run();
        finishHim();
    }

    public void finishHim() {
        System.out.println("Sub's finisher");
    }
}
