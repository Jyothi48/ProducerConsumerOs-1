package task1;

public class Consumer extends Thread {
	 private SharedBuffer buffer;

	    public Consumer(SharedBuffer buffer) {
	        this.buffer = buffer;
	    }

	    public void run() {
	        for (int i = 1; i <= 10; i++) {
	            buffer.consume();
	        }
	    }
}
