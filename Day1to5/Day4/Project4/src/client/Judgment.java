package client;
/*
 * 实验判断类
 * 包含一个存储棋子的集合
 * 能判断在某个方向上连子数是否超过5
 * 能添加棋子
 */
import java.awt.Color;
import java.util.ArrayList;


public class Judgment
{
	private ArrayList<Chess> list=new ArrayList<Chess>();
	//public int max=10;
	public int min;//棋盘开始的坐标像素
	public int max;//棋盘的结束的坐标像素
	
	//在构造判断类对象时，根据棋盘的线条确定min和max的位置
	public Judgment(int min,int max){
		this.min=min;
		this.max=max;
	}
	
	
	public boolean contains(Chess c)  //判断集合中是否已有c棋子
	{
		return list.contains(c);
	}
	
	public ArrayList<Chess> getList()
	{
		return list;
	}

	public boolean add(Chess c)
	{
		if(contains(c)==true) //若集合中有c棋子则添加棋子失败，返回false
			return false;
		list.add(c); //若集合中没有c棋子则将c add到集合中，并返回true
		return true;
	}
	
//	public static void main(String[] args)
//	{
//		Judgment m=new Judgment();
//		Chess c=new Chess(2,3);
//		boolean flag=m.add(c);
//		System.out.println(flag?"添加成功！":"添加失败!");
//		
//	    flag=m.add(c);
//		System.out.println(flag?"添加成功！":"添加失败!");	
//	}

//	public boolean isWin()
//	{
//		if(sameChess1()>=5)
//			return true;
//		if(sameChess2()>=5)
//			return true;
//		if(sameChess3()>=5)
//				return true;
//		if(sameChess4()>=5)
//			return true;
//		return false;
//	}
	
	Step[] arr={new Step(0,1),new Step(1,0),new Step(01,1),new Step(1,-1)};
	
	public boolean isWinNew()
	{
		for(int i=0;i<4;i++)
		{
			if(sameChess(arr[i])>=5)
			{
				return true;
			}
		}
		return false;
	}
	/*
	 *  -: xStep=0 yStep=1
	 *  |: xStep=1 yStep=0
	 *  \: xStep=1 yStep=1
	 *  /: xStep=-1 yStep=1
	 */
	
	public int sameChess(Step s)
	{   int xStep=s.x,yStep=s.y;
	    Chess last=list.get(list.size()-1); //获得最后一次下棋的棋子
	    int x=last.getX();
		int y=last.getY();
		int num=1;

		for(int i=0;i<2;i++)
		{
			for(int ix=xStep,iy=yStep;
			   (x-ix>=min && x-ix<max) && (y-iy>=min && y-iy<max);
			   ix+=xStep,iy+=yStep)
			   {
				   Chess c=new Chess(x-ix,y-iy);
				   //Chess o=list.get(list.indexOf(c)); //获得集合中的棋子
				   if(contains(c)==true && last.getCol().equals(list.get(list.indexOf(c)).getCol())) //判断棋子是否相同
				    	num++;
				    else
				    	break;
			   }
			xStep *=-1; //变化x的方向
			yStep *=-1; //变化y的方向
		}
		return num;
	}
	
	
	
	
	
	
	
//	// - 相同棋子数
//	public int sameChess1()
//	{
//		Chess last=list.get(list.size()-1);
//		int x=last.getX();
//		int y=last.getY();
//		int num=1;
//		//last左边的一个棋子Chess(x,y-1)
//		//判断Chess(x,y-1)是否在list中，若在，计数+1
//		//继续判断Chess(x,y-2)是否在list中，若不在则左侧查找结束
//		/*
//		 * i从1开始，左侧棋子纵坐标从y-1开始
//		 * 左侧棋子的纵坐标是>=0,y-i>=0
//		 */
//		
//		for(int i=1;y-i>=0;i++)
//		{
//			Chess c=new Chess(x,y-i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//			
//		//在last的右侧继续循环查找棋子
//		for(int i=1;y+i<10;i++)
//		{
//			Chess c=new Chess(x,y+i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//		
//		return num;
//		
//	}
//	
//	// | 相同棋子数
//	public int sameChess2()
//	{
//		Chess last=list.get(list.size()-1);
//		int x=last.getX();
//		int y=last.getY();
//		int num=1;
//		
//		//last上边的一个棋子Chess(x-1,y),横坐标减，纵坐标不变
//		for(int i=1;x-i>=0;i++)
//		{
//			Chess c=new Chess(x-i,y);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//			
//		//在last的下边继续循环查找棋子，横坐标加，纵坐标不变
//		for(int i=1;x+i<10;i++)
//		{
//			Chess c=new Chess(x+i,y);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//		return num;
//		
//	}
//	
//	// / 相同棋子数
//	public int sameChess3()
//	{
//		Chess last=list.get(list.size()-1);
//		int x=last.getX();
//		int y=last.getY();
//		int num=1;
//		
//		//last右上边的一个棋子Chess,横坐标减，纵坐标加
//		for(int i=1;x-i>=0 && y+i<max;i++)
//		{
//			Chess c=new Chess(x-i,y+i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//			
//		//在last的左下边继续循环查找棋子，横坐标加，纵坐标减
//		for(int i=1;x+i<10 && y-i>=0;i++)
//		{
//			Chess c=new Chess(x+i,y-i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//		return num;
//		
//	}
//	// \ 相同棋子数
//	public int sameChess4()
//	{
//		Chess last=list.get(list.size()-1);
//		int x=last.getX();
//		int y=last.getY();
//		int num=1;
//		
//		//last左上边的一个棋子Chess,横坐标减，纵坐标减
//		for(int i=1;x-i>=0 && y-i>=0;i++)
//		{
//			Chess c=new Chess(x-i,y-i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//			
//		//在last的右下边继续循环查找棋子，横坐标加，纵坐标加
//		for(int i=1;x+i<10 && y+i<=10;i++)
//		{
//			Chess c=new Chess(x+i,y+i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//		return num;		
//	}

    public static void main(String[] args) 
    {
//    	Judgment m=new Judgment();
//    	Chess c=new Chess(2,3);
//    	m.add(c);
//    	c=new Chess(2,0);
//    	m.add(c);
//    	c=new Chess(2,1);
//    	m.add(c);
    		
    	/*int num =m.sameChess1();
    	System.out.println(num);*/
    	
//    	int num=m.sameChess(new Step(1,0));
//    	System.out.println(num);
//    	System.out.println(m.isWin()==true?"胜":"输");
    	
//    	Chess o=new Chess(2,2); //生成新棋子
//    	System.out.println(m.contains(o)); //2,2棋子是否存在list
//    	int index=m.list.indexOf(c); //找到2，2棋子的索引
//    	System.out.println(index);
//    	System.out.println(m.list.get(index)); //通过索引找到list中的棋子
    	
//    	Judgment m=new Judgment();
//    	Chess c=new Chess(2,2,Color.black);
//    	m.add(c);
//    	c=new Chess(4,2,Color.black); 
//    	m.add(c);
//    	c=new Chess(0,2,Color.white); 
//    	m.add(c);
//    	c=new Chess(3,2,Color.black); 
//    	m.add(c);
//    	c=new Chess(6,2,Color.black); 
//    	m.add(c);
//    	c=new Chess(5,2,Color.white); 
//    	m.add(c);
//    	System.out.println(m.isWinNew());
    } 
}
class Step
{
	int x,y;
	public Step(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}