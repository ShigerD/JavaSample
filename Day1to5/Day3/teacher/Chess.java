package ��ҵ;

import java.awt.Color;

/*
 * ������
 * �������Ӻ�����������ԣ��ڼ��еڼ���
 * ���ж����������Ƿ����,ͬ��ͬ��Ϊ���
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
