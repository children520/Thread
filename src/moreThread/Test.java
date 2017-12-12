package moreThread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Test{
	int breadcount;
	ExecutorService executorService =Executors.newCachedThreadPool();
	Fridge fridge=new Fridge();
	Saler saler=new Saler(fridge);
	Worker worker=new Worker(fridge);

	public Test() {
		executorService.execute(worker);
		executorService.execute(saler);
	}
	public static void main(String[] args) {
		new Test();
	}
}
class Bread{
	private int breadcount;
	public Bread(int breadcount) {
		this.breadcount=breadcount;
	}
	@Override
	public String toString() {
		return "�������Ϊ:"+breadcount;
	}
}
class Fridge{
	int random=new Random().nextInt(10);
	int time =new Random().nextInt(30);
	
	int storecount=0;
	Bread[] FridgeStore=new Bread[20];
	public synchronized void push(Bread bread) {
		while(storecount==FridgeStore.length) {
			try {
				this.wait();
			}
			catch (InterruptedException e) {
				System.out.println("��������");
			}
		}
	
	FridgeStore[storecount]=bread;
		this.storecount++;
			this.notify();
	}
	public synchronized void pop() {
		while(storecount==0) {
			try {
				this.wait();
			}catch (InterruptedException e) {
				System.out.println("û�����");
			}
		}
		this.storecount-=random; 
		this.notify();
		System.out.println("�������"+storecount+"��");
	}
}



class Worker implements Runnable{
	Fridge fridge=null;
	public Worker(Fridge fridge) {
		this.fridge=fridge;
		}
	@Override
	public void run() {
		System.out.println("�˿ͼ�����"+fridge.time+"�뵽��"+",��Ҫ"+fridge.random+"�����");
		for(int i=0;i<20;i++) {
			Bread bread=new Bread(i);
			fridge.push(bread);
			System.out.println("����"+bread);
			try {
				Thread.sleep(200);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	}
}
}

class Saler implements Runnable{
	Fridge fridge=null;
	public Saler(Fridge fridge) {
		this.fridge=fridge;	
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			Bread bread=new Bread(i);
			fridge.pop();
			System.out.println("����"+bread);
			try {
				Thread.sleep(200);
			}catch (InterruptedException e) {
				System.out.println("interrupted");
			}
		}
	}
}


