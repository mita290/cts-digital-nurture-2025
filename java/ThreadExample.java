class MessagePrinter extends Thread {
    private String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - " + i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MessagePrinter thread1 = new MessagePrinter("Thread 1 is running");
        MessagePrinter thread2 = new MessagePrinter("Thread 2 is running");

        thread1.start();
        thread2.start();
    }
}
