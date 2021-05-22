package wsb.threads;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumber implements Callable<Winner> {

    final Finisher finisher;

    public RandomNumber(Finisher finisher) {
        this.finisher = finisher;
    }

    @Override
    public Winner call() {
        for (int i = 3; i >= 0; i--) {
            if (i == 0) {
                System.out.println("0");
            } else {
                System.out.println(i);
            }
            secondPast();
        }
        return new Winner(new Random().nextDouble(), finisher);
    }

    private void secondPast() {
        try {
            Thread.sleep(1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
