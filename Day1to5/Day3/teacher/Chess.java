package 作业;

import java.awt.Color;

/*
 * 棋子类
 * 包含棋子横纵坐标的属性，第几行第几列
 * 能判断两个棋子是否相等,同行同列为相等
 */
public class Chess {
	private int x,y;
	private Color col;
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
}
