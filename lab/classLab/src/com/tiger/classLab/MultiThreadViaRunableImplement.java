package com.tiger.classLab;

public class MultiThreadViaRunableImplement implements Runnable{
	private int ticket=100;
	private String name;
	public MultiThreadViaRunableImplement(){
		
	}
	public MultiThreadViaRunableImplement(String name){
		this.name=name;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		//int i=ticket;
		while(ticket>0 ) {
			ticket--;
			System.out.println(Thread.currentThread().getName()+"...."+ticket);
		}
		System.out.println(Thread.currentThread().getName()+"..End");
	}

}
