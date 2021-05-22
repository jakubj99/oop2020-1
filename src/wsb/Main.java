package wsb;

import wsb.threads.RandomNumber;
import wsb.threads.Winner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Collection<Future<Winner>> futures = executor.invokeAll(Arrays.asList(
                new RandomNumber(() -> System.out.println("#1")),
                new RandomNumber(() -> System.out.println("#2")),
                new RandomNumber(() -> System.out.println("#3")),
                new RandomNumber(() -> System.out.println("#4")),
                new RandomNumber(() -> System.out.println("#5"))
        ));
        System.out.println("And the winner is ");
        futures.stream().map(winnerFuture -> {
            try {
                return winnerFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException(e);
            }
        }).max(Comparator.comparingDouble(Winner::getScore))
                .ifPresent(winner -> winner.getFinisher().finishHim());
        executor.shutdown();
    }
}



