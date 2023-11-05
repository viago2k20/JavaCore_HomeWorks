package Lambda_Task2;

public class Worker {
    private final OnTaskListenerDone callback;
    private final OnTaskErrorListener errorCallback;
    int error = 33;

    public Worker(OnTaskListenerDone callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == error) {
                errorCallback.onError("Task " + i + " error");
            } else {
                callback.OnDone("Task " + i + " is done");
            }
        }
    }

    @FunctionalInterface
    public interface OnTaskListenerDone {
        void OnDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String error);
    }
}
