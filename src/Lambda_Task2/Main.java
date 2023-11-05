package Lambda_Task2;

public class Main {
    public static void main(String[] args) {
        Worker.OnTaskListenerDone listener = System.out::println;
        Worker.OnTaskErrorListener errorListener = System.err::println;

        Worker worker = new Worker(listener, errorListener);
        worker.start();
    }
}
