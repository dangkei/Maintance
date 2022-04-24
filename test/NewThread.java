import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stubD
				System.out.println("this is a new Thread!!");
			}
			
		}).run();
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("this is invoke from executor!");
				
			}});
		executor.shutdown();
	}

}
