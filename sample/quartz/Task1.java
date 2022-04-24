package quartz;

public class Task1 implements Runnable {
	private String name;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("task 1 minute running.");
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
