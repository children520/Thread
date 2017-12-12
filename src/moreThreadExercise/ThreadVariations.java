package moreThreadExercise;

import java.util.concurrent.TimeUnit;

class InnerThread1{
	private int countDown=5;
	private Inner inner;
	private class Inner extends Thread{
		Inner(String name){
			super(name);
			start();
		}
		@Override
		public void run() {
			try {
				while(true) {
					System.out.println(this);
					if(--countDown==0)
						return;
					sleep(10);
				}
			}catch (InterruptedException e) {
				System.out.println("interrupted");
				// TODO: handle exception
			}
		}
		@Override
		public String toString() {
			return getName()+":"+countDown;
		}
	}
	public InnerThread1(String  name) {
		inner=new Inner(name);
	}
}
class InnerThread2{
	private int countDown=5;
	private Thread t;
	public InnerThread2(String name) {
		t=new Thread(name) {
			@Override
			public void run() {
				try {
					while(true) {
						System.out.println(this);
						if(--countDown==0)
							return;
						sleep(10);
					}
				}catch (InterruptedException e) {
					System.out.println("sleep() interrupted");
					// TODO: handle exception
				}
			}
			@Override
			public String toString() {
				return getName()+":"+countDown;
				
			}
		};
		t.start();
	}
}
class InnerRunnable1{
	private int countDown=5;
	private InnerThread1 innerThread1;
	private class Inner implements Runnable{
		Thread t;
		Inner(String name){
			t=new Thread(this,name);
			t.start();
		}
		@Override
		public void run() {
			try {
				while(true) {
					System.out.println(this);
					if(--countDown==0)
						return;
					TimeUnit.SECONDS.sleep(10);
				}
			}catch (InterruptedException e) {
				System.out.println("sleep() interrupted");// TODO: handle exception
			}
		}
		@Override
		public String toString() {
			return t.getName()+":"+countDown;
		}
	}
}
public class ThreadVariations {

}
