package task1;
import java.util.LinkedList;
import java.util.Queue;
public class SharedBuffer {
	 private final Queue<Integer> buffer = new LinkedList<>();
	    private final int capacity = 5;

	    public synchronized void produce(int item) {
	        try {
	            while (buffer.size() == capacity) {
	                wait();
	            }

	            buffer.add(item);
	            System.out.println("Producer produced: " + item);
	            System.out.print("Buffer: ");
	            for (int value : buffer) {
	                System.out.print(value + " ");
	            }
	            System.out.println();

	            notifyAll();

	        } catch (InterruptedException e) {
	            System.out.println(e);
	        }
	    }

	    public synchronized void consume() {
	        try {
	            while (buffer.isEmpty()) {
	                wait();
	            }

	            int item = buffer.remove();
	            System.out.println("Consumer consumed: " + item);
	            System.out.print("Buffer: ");
	            for (int value : buffer) {
	                System.out.print(value + " ");
	            }
	            System.out.println();

	            notifyAll();

	        } catch (InterruptedException e) {
	            System.out.println(e);
	        }
	    }
}
