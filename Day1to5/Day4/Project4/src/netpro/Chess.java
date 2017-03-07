package netpro;

import java.awt.Color;
import java.io.Serializable;

/*
 * 棋子类
 * 包含棋子横纵坐标的属性，第几行第几列
 * 能判断两个棋子是否相等，同行同列为相等
 */

public class Chess implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x,y;
	private static int size=30;
	private Color col;
	
	public static int getSize()
	{
		return size;
	}
	
	public Chess(int x,int y)
	{
		this.x=x;
		this.y=y;	
		col=Color.black;
	}
	
	public Chess(int x, int y,Color c) 
	{
		this.x = x;
		this.y = y;
		col=c;
	}
	
	public Color getCol() 
	{
		return col;
	}

	public void setCol(Color col)
	{
		this.col = col;
	}

	public boolean equals(Object o)
	{
		if(this==o)
			return true;
		if(o==null)
			return false;
		if(o instanceof Chess)
		{
			Chess och=(Chess)o;
			if(this.x==och.x && this.y==och.y)
				return true;
			else
				return false;
		}
		return false;
	}
//   public static void main(String[] args)
//   {
//	   Chess c1=new Chess(3,5);
//	   Chess c2=new Chess(3,5);
//	   System.out.println(c1.equals(c2));
//   }
   
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

	@Override
	public String toString() {
		return "Chess [col=" + col + ", x=" + x + ", y=" + y + "]";
	}

	

}
