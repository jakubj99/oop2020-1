package wsb;

import wsb.threads.CallableSorter;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        List<Integer> list1 = generateList(10);
        List<Integer> list2 = generateList(100);
        List<Integer> list3 = generateList(1000);
        List<Integer> list4 = generateList(10000);

        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        Date start = new Date();
        Collection<Future<List<Integer>>> futureNumbers = singleExecutor.invokeAll(Arrays.asList(
                new CallableSorter(list1),
                new CallableSorter(list2),
                new CallableSorter(list3),
                new CallableSorter(list4)));

        ExecutorService multiExecutor = Executors.newFixedThreadPool(4);
        Date start2 = new Date();
        Collection<Future<List<Integer>>> futureNumbersSortedAtSametime = multiExecutor.invokeAll(Arrays.asList(
                new CallableSorter(list1),
                new CallableSorter(list2),
                new CallableSorter(list3),
                new CallableSorter(list4)
        ));

        singleExecutor.shutdown();
        System.out.println("Single thread sorting (ms): " + (new Date().getTime() - start.getTime()));
        multiExecutor.shutdown();
        System.out.println("Multi thread sorting (ms): " + (new Date().getTime() - start2.getTime()));

    }

    private static List<Integer> generateList(int size) {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() != size) {
            set.add(random.nextInt(Integer.MAX_VALUE));
        }
        return new ArrayList<>(set);
    }
}



