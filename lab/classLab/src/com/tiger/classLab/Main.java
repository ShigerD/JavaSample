package com.tiger.classLab;

public class Main {
	private void class_test(){
		Cat smallCat=new Cat();
		smallCat.setColor("black");
		String catColor=smallCat.getColor();
		System.out.println("catcolor:"+catColor);
		smallCat.speak();
		
		Tiger tiger=new Tiger();
		tiger.speak();
	}

	private void threadViaExtendsThread(){
		
		MultiThread th1=new MultiThread("v1");
		MultiThread th2=new MultiThread("v22");
		MultiThread th3=new MultiThread("v333");
		th1.start();
		th2.start();
		th3.start();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("helloworld");
		
		MultiThreadViaRunableImplement a = new MultiThreadViaRunableImplement("�߳�1");
		MultiThreadViaRunableImplement b =new MultiThreadViaRunableImplement("�߳�2");
		new Thread(a,"1....").start();
		new Thread(a,"2....").start();
	
		
		
	}
	


}
