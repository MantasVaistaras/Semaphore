import java.util.concurrent.Semaphore;

public class Singleton {
	private static Singleton instance = new Singleton();
	private int sharedData = 0;
	Semaphore semaphore = new Semaphore(1);
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	
	public void increment() {
		//using Semaphore instead of "synchronized" for the practice purposes. It should do the same job
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sharedData++;
		semaphore.release();
		
	}
	
	public int getSharedData() {
		return sharedData;
	}

}
