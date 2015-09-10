import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestAnnotation {
	@Test(id = 0, description = "获得姓名")
	public void getName() {

	}

	@Test(id = 1, description = "获得性别")
	public void getSex() {

	}

	//@Test(id = 3, description = "获得ID")
	public void getId() {

	}

	public static void testTracker(List<Integer> jobs, Class<?> c) {
		for (Method m : c.getDeclaredMethods()) {
			Test test = m.getAnnotation(Test.class);
			if (test != null) {
				System.out.println("job" + test.id() + "完成");
				jobs.remove(Integer.valueOf(test.id()));
			}
		}
		for (int i : jobs) {
			System.out.println("job" + i + "未完成");
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
