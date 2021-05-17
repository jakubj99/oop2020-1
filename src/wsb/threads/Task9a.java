package wsb.threads;

public class Task9a implements Runnable {

    @Override
    public void run() {
        System.out.println("Counting from 10 to 0");
        for (int i = 10; i >= 0 ; i--) {
            if (i == 0){
                System.out.println("done with counting");
            } else {
                System.out.println(i);
            }
            secondPast();
        }
    }

    private void secondPast() {
        try {
            Thread.sleep(1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
