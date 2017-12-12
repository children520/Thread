package moreThreadExercise;

import java.util.concurrent.TimeUnit;

class Daemon implements Runnable{
	private Thread[] threads=new Thread[10];
	@Override
	public void run() {
		for(int i=0;i<threads.length;i++) {
			 threads[i]=new Thread(new DaemonSpawn());
			 threads[i].start();
			 System.out.println("DaemonSpawn"+i+"started.");
		}
		for(int i=0;i<threads.length;i++) {
			System.out.println("t["+i+"].isDaemon()= "+threads[i].isDaemon()+",");
		}
		while(true)
			Thread.yield();
	}
}
class DaemonSpawn implements Runnable{
		@Override
		public void run() {
			while(true)
				Thread.yield();
		}
	}
public class Daemons{
	public static void main(String[] args) throws Exception{
		Thread dThread=new Thread(new Daemon());
		dThread.setDaemon(true);
		dThread.start();
		System.out.println("d.isDaemon()="+dThread.isDaemon()+",");
		TimeUnit.SECONDS.sleep(1);
	}
}

