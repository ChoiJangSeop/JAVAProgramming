package week13;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class MyThread {

		public static void main(String[] args) {
			
			BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(5);
			
			Thread producer = new Thread(new Producer(q));
			Thread consumer = new Thread(new Consumer(q));
			
			producer.start();
			consumer.start();
		}
}

class ProducerConsumerModel {
	static int element = 0;
}

class Producer extends ProducerConsumerModel  implements Runnable {
	
	private BlockingQueue<Integer> q;
	int data = 0;
	
	public Producer(BlockingQueue<Integer> _q) {
		this.q = _q;
	}
	
	public void run() {
		while(data<10) {
			try {
				Thread.sleep(300);
				if ( element < 5) {
					q.add(data);
					element++;
					System.out.println("Produced: " + data);
					data++;
					
				}
			
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}
}

class Consumer extends ProducerConsumerModel implements Runnable {
	
	private BlockingQueue<Integer> q;
	
	
	public Consumer(BlockingQueue<Integer> _q) {
		this.q = _q;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				
				
				if (element > 0) { 
					int data = q.take();
					System.out.println("Consumed: " + data);
					element--;
				}
			
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}
}
