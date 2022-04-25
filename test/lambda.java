
public class lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(() -> {
			System.out.println("First");
			System.out.println("Second");
		}).run();
	}
}
