package multithreading;

import java.sql.SQLOutput;
import java.util.concurrent.*;

class CallableTask implements Callable<String> {
    private String name;
    public CallableTask(String name) {
        this.name = name;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return name;
    }
}
public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> welcomeFuture = executorService.submit(new CallableTask("Hello"));
        System.out.println("CallableTask Executed");
        String welcomeMessage = welcomeFuture.get();
        System.out.println(welcomeMessage);// printed after 28 minutes
        System.out.println("\n Main end");
        executorService.shutdown();
    }
}
