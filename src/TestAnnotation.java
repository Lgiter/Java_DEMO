import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestAnnotation {
	@Test(id = 0, description = "�������")
	public void getName() {

	}

	@Test(id = 1, description = "����Ա�")
	public void getSex() {

	}

	//@Test(id = 3, description = "���ID")
	public void getId() {

	}

	public static void testTracker(List<Integer> jobs, Class<?> c) {
		for (Method m : c.getDeclaredMethods()) {
			Test test = m.getAnnotation(Test.class);
			if (test != null) {
				System.out.println("job" + test.id() + "���");
				jobs.remove(Integer.valueOf(test.id()));
			}
		}
		for (int i : jobs) {
			System.out.println("job" + i + "δ���");
		}
	}

	public static void main(String[] args) {
		List<Integer> jobs = new ArrayList<>();
		jobs.add(0);
		jobs.add(1);
		jobs.add(2);
		testTracker(jobs, TestAnnotation.class);
	}

}
