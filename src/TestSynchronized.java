
public class TestSynchronized {

	class Foo extends Thread {
		private String name;

		public Foo(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			synchronized (Foo.class) {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					printName();
				}
			}

		}

		void printName() {
			System.out.println(name);
		}
	}

	public static void main(String[] args) {

		TestSynchronized test = new TestSynchronized();
		Foo f1 = test.new Foo("li");
		Foo f2 = test.new Foo("yin");
		f1.start();
		f2.start();
	}
}
