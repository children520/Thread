package moreThreadExercise;

import java.util.Stack;

public class quene {
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
	public static void main(String[] args) {
		quene quene1=new quene();
		quene1.QueuePush(5);
		quene1.QueuePush(6);
		quene1.QueuePush(7);
		quene1.QueuePop(5);
		
	}
	public void QueuePush(int i) {
		stack1.push(i);
		System.out.println("����Ϊ:"+stack1);
		
	}
	public void QueuePop(int i) {
		if(stack1.isEmpty()&&stack2.isEmpty()) {
			System.out.println("����stack��û������");
		}
		else if(!stack1.isEmpty()) {
			System.out.println("ɾ��ǰ��Ԫ��Ϊ"+stack1);
			if(stack1.peek()==i) {
				stack1.pop();
				System.out.println("ɾ����Ķ���Ϊ"+stack1);
			}
			else {
				for(int x=-1;x<=stack1.size();x++) {
					if(stack1.peek()==i) {
						stack1.pop();
						break;
						}
					stack2.push(stack1.pop());
					
					}
				for(int j=0;j<=stack2.size();j++) {
					stack1.push(stack2.pop());
					
					}
				
				
				}
			System.out.println("ɾ����Ķ���Ϊ��"+stack1);
			}
		
	}
}
