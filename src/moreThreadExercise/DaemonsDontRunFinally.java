package moreThreadExercise;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable{
	@Override
	public void run() {
		try {
			System.out.println("starting Adaemon");
			TimeUnit.SECONDS.sleep(1);
		}catch (InterruptedException e) {
			System.out.println("exiting via InterruptedException");
			// TODO: handle exception
		}finally {
			System.out.println("this should always run?");
		}
	}
}
public class DaemonsDontRunFinally {
	public static void main(String[] args) throws Exception{
		Thread t=new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}

}
