package multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<CallableTask> list = List.of(new CallableTask("task1"),
                new CallableTask("task2"), new CallableTask("task3"));
        List<Future<String>> futures = executorService.invokeAll(list);
        for (Future<String> future : futures) System.out.println(future.get());
        executorService.shutdown();
    }
}
