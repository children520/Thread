package moreThreadExercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiffOff{
	@Override
	public void run() {
		try {
			while(countDown-->0) {
				System.out.println(status());
				TimeUnit.MICROSECONDS.sleep(100);
			}
		}catch (InterruptedException e) {
			System.out.println("interrupted");
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++) {
			executorService.execute(new SleepingTask());
		}
		executorService.shutdown();
	}

}
