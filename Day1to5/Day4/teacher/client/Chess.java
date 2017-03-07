package client;

import java.awt.Color;
import java.io.Serializable;

/*
 * 棋子类
 * 包含棋子横纵坐标的属性，第几行第几列
 * 能判断两个棋子是否相等,同行同列为相等
 */
public class Chess implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int x,y;       //像素点，画棋子时左上角坐标
	private static int size = 30; //棋子的直径,静态的属性
	private Color col;     //棋子颜色
	
	//获得棋子的直径，静态方法用来访问静态属性值, 直接使用类名访问即可
	public static int getSize(){  
		return size;
	}
	public Chess(int x, int y){
		this.x = x;
		this.y = y;
		col = Color.black;
	}
	public Chess(int x, int y,Color c){
		this.x = x;
		this.y = y;
		col = c;
	}
	
	public Color getCol() {
		return col;
	}
	public void setCol(Color col) {
		this.col = col;
	}
	public boolean equals(Object o){
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(o instanceof Chess){
			Chess och = (Chess)o;
			if(this.x == och.x && this.y == och.y)
				return true;
			else
				return false;
		}
		return false;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String toString(){
		return "["+x+","+y+"]->"+col;
	}
}
