
public class TestAutoboxing {

	Integer i;
	int j;

	public static void main(String[] args) {
		TestAutoboxing t = new TestAutoboxing();
		t.go();
	}

	public void go() {
		j = i;
		System.out.println(j);
		System.out.println(i);
	}
}
