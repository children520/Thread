package moreThreadExercise;

public class BasicThreads {
	public static void main(String[] args) {
		Thread thread=new Thread(new LiffOff());
		thread.start();
		System.out.println("waiting for liftoff");
	}

}
