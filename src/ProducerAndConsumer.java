import java.util.PriorityQueue;

public class ProducerAndConsumer {
	private int queueSize = 10;
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

	public static void main(String[] args) {
		ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
		Consumer consumer = producerAndConsumer.new Consumer();
		Producer producer = producerAndConsumer.new Producer();
		producer.start();
		consumer.start();
	}

	class Producer extends Thread {
		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					if (queue.size() == queueSize) {
						try {
							System.out.println("��Ʒ���������ȴ�����");
							queue.wait();
						} catch (InterruptedException e) {
							queue.notify();
							e.printStackTrace();
						}
					}
					queue.offer(1);
					queue.notify();
					System.out.println("����һ���²�Ʒ������" + (queueSize - queue.size()) + "����λ");
				}
			}
		}
	}

	class Consumer extends Thread {
		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					if (queue.size() == 0) {
						try {
							System.out.println("��Ʒ���пգ��ȴ�����");
							queue.wait();
						} catch (InterruptedException e) {
							queue.notify();
							e.printStackTrace();
						}
					}
					queue.poll();
					queue.notify();
					System.out.println("����һ���²�Ʒ������" + queue.size() + "����Ʒ");
				}
			}
		}
	}
}
