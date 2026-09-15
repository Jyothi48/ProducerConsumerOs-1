package task1;

public class ProducerConsumer {
	public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Producer and Consumer completed successfully.");
    }

}
