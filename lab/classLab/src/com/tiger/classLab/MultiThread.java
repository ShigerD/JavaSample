package com.tiger.classLab;

public class MultiThread extends Thread {

	public MultiThread(){
		
	}
	public MultiThread(String name){
		super(name);
	}
	private int ticket=100;
	public void run()
	{
		for (int i = ticket; i >0; i--) {
			ticket--;
			System.out.println(Thread.currentThread().getName()+ticket);
		}
	}
}
