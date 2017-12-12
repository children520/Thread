package moreThreadExercise;
	class Sleeper extends Thread{
		private int duration;
		public Sleeper(String name,int sleepTime) {
			super(name);
			duration=sleepTime;
			start();
		}
		@Override
		public void run() {
			try {
				sleep(duration);
			}catch (InterruptedException e) {
				System.out.println(getName()+"was interrupted"+"isInterrupted()"+isInterrupted());
				return;// TODO: handle exception
			}
			System.out.println(getName()+"has awakend");
		}
	}
	class Joiner extends Thread{
		private Sleeper sleeper;
		public Joiner(String name,Sleeper sleeper) {
			super(name);
			this.sleeper=sleeper;
			start();
		}
		@Override
		public void run() {
			try {
				sleeper.join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			System.out.println(getName()+"join completed");
		}
	}
public class joining {
		public static void main(String[] args) {
			Sleeper
				sleeper=new Sleeper("Sleepy", 1500),
				grumpy=new Sleeper("Grumpy", 1500);
			Joiner
				dopey=new Joiner("Dopey", sleeper),
				doc=new Joiner("Doc", grumpy);
			grumpy.interrupt();
			
		}

}
