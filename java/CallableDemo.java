import java.util.concurrent.*;
import java.util.*;

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            tasks.add(() -> {
                Thread.sleep(500);
                return "Result from Task " + taskId + " by " + Thread.currentThread().getName();
            });
        }

        List<Future<String>> futures = executor.invokeAll(tasks);

        for (Future<String> future : futures) {
            System.out.println(future.get()); 
        }

        executor.shutdown();
    }
}
