package moreThreadExercise;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult implements Callable<String>{
	private int id;
	TaskWithResult(int id) {
		this.id=id;
	}
	@Override
	public String call() {
		return "result of TaskWithResult"+id;
	}
}
public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService executorService =Executors.newCachedThreadPool();
		ArrayList<Future<String>> results=new ArrayList<>();
		for(int i=0;i<10;i++) {
			results.add(executorService.submit(new TaskWithResult(i)));
		}
		for(Future<String> fs:results) {
			try {
				System.out.println(fs.get());
				
			}catch (InterruptedException e) {
				System.out.println(e);
				return;
				// TODO: handle exception
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				executorService.shutdown();
			}
		}
	}
	

}
