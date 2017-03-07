package Day4;

import java.awt.Color;

/*
 * 棋子类
 * 包含棋子横纵坐标的属性，第几行第几列
 * 能判断两个棋子是否相等，同行同列为相等
 */

public class Chess 
{
	

	private int x,y; //像素点，画棋子时左上角坐标
	private static int size=30; //棋子的直径，静态的属性
	private Color col; //棋子颜色
	
	//获得棋子的直径，静态方法用来访问静态属性值，直到使用类名访问即可
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



}
