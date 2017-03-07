package Day5;

public class test1
{
	public static void main(String[] args)  //主线程
	{
		Thread t1=new MyThread1(); //第一个线程
		t1.start();
		
		Runnable runable=new MyThread2(); //第二个线程
		Thread t2=new Thread(runable);
		t2.start();
		
		for(int i=0;i<100;i++)
		{
			System.out.println("main:"+i);
		}
		
	}

}
class MyThread1 extends Thread
{
	public void run()
	{
		for(int i=0;i<100;i++)
			System.out.println("myThread1:"+i);
	}
}
class MyThread2 implements Runnable
{
	public void run()
	{
		for(int i=0;i<100;i++)
			System.out.println("myThread2:"+i);
	}
}