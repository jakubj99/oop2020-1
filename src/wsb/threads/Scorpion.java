package wsb.threads;


public class Scorpion extends Task9a {
    @Override
    public void run() {
        super.run();
        finishHim();
    }

    public void finishHim() {
        System.out.println("Scorpion's finisher");
    }
}
