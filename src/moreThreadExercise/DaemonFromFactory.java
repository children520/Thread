package moreThreadExercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable{
	@Override
	public void run() {
		try {
			while(true) {
				TimeUnit.MICROSECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			}
		}catch (InterruptedException e) {
			System.out.println("interrupted");
			// TODO: handle exception
		}
	}
	public static void main(String[] args) throws Exception{
		ExecutorService executorService=Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<10;i++) {
			executorService.execute(new DaemonFromFactory());
			
		}
		System.out.println("all daemons started");
		TimeUnit.MICROSECONDS.sleep(500);
		
	}

}
