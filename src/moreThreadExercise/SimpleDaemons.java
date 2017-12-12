package moreThreadExercise;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{
	@Override
	public void run() {
		try {
			while(true) {
				TimeUnit.MICROSECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			}
		}catch (InterruptedException e) {
			System.out.println("sleep() interrupted");
			// TODO: handle exception
		}
	}
	public static void main(String[] args) throws Exception {
		for(int i=0;i<10;i++) {
			Thread daemon=new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("all dasmon started");
		TimeUnit.MICROSECONDS.sleep(175);
	}

}
