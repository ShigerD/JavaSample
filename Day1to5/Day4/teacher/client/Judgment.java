package client;
 

import java.awt.Color;
import java.util.ArrayList;

/*
 * 实现判断类
 * 包含一个存储棋子的集合
 * 能判断集合中是否已有指定的棋子
 * 能判断在某个方向上连子数是否超过5
 * 能添加棋子
 */
public class Judgment {
	private ArrayList<Chess> list = new ArrayList<Chess>();
	
	public int min =0;//棋盘开始的坐标像素
	public int max =10;//棋盘结束的坐标像素
	
	public int xMin,xMax,yMin,yMax;
	
	//在构造判断类对象时，根据棋盘的线条确定max和min的位置
	public Judgment(int min, int max){
		this.max = max;
		this.min = min;
	}	
	
	public Judgment(int xMin, int xMax, int yMin, int yMax) {
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
	}


	public ArrayList<Chess> getList(){
		return list;
	}
	
	public boolean contains(Chess c){//判断集合中是否已有c棋子
		return list.contains(c);
	}
	public boolean add(Chess c){
		if(contains(c) == true)//若集合中有c棋子则添加棋子失败，返回false
			return false;
		list.add(c);//若集合中没有c棋子则将c add到集合中，并返回true
		return true;
	}
	public boolean isWin(){
		if(sameChess1()>=5)
			return true;
		if(sameChess2() >= 5)
			return true;
		if(sameChess3() >= 5)
			return true;
		if(sameChess4() >= 5)
			return true;
		return false;
	}
//	  --:xStep=0  yStep=1    |:xStep=1  yStep=0    \:xStep=1  yStep=1    /:xStep=-1 yStep=1
	Step[] arr = {new Step(0,1),new Step(1,0),new Step(1,1),new Step(1,-1)};
	public boolean isWinNew(){

		for(int i=0; i<4; i++){
			if(sameChess(arr[i])>=5)
				return true;
		}
		return false;
	}
	public int sameChess(Step s){
		int xStep = s.x*Chess.getSize(), yStep=s.y*Chess.getSize();
		Chess last = list.get(list.size()-1);//获得最后一次下棋的棋子
		int x = last.getX();    int y = last.getY();
		int num = 1;		
		for(int i=0; i<2; i++){
			for( int ix=xStep,iy=yStep;
			     (x-ix>=0 && x-ix<max) && (y-iy>=0 && y-iy<max);
			     ix+=xStep,iy+=yStep)
			{
				Chess c = new Chess(x-ix,y-iy);
				boolean flag = contains(c);
//				if(contains(c)==true && last.getCol().equals(list.get(list.indexOf(c)).getCol()))//判断棋子的颜色是否相同
				Color col = null;
				if(flag == true)
					col = list.get(list.indexOf(c)).getCol();
				if(flag==true && last.getCol().equals(col))
					num++;
				else
					break;
			}
			xStep *= -1;//变化x的方向
			yStep *= -1;//变化y的方向
		}
		return num;
	}
	//- 相同棋子数
	public int sameChess1(){
		Chess last = list.get(list.size()-1);//获得最后一次下棋的棋子
		int x = last.getX();
		int y = last.getY();
		int num = 1;
		//last左边的一个棋子Chess(x,y-1)
		//判断Chess(x,y-1)是否在list中，若在，计数+1
		//继续判断Chess(x,y-2)是否在list中，若不在则左侧查找结束
		/*
		 * i从1开始，左侧棋子纵坐标从y-1开始
		 * 左侧棋子的纵坐标是>=0  y-i>=0 
		 */
		for(int i=1; y-i>=0 ;i++){
			Chess c = new Chess(x+0,y+(-i));
			if(contains(c)==true)
				num++;
			else
				break;
		}
		
		//在last的右侧继续循环查找棋子
		for(int i=1; y+i < 10;i++){
			Chess c = new Chess(x+0,y+i);
			if(contains(c) == true)
				num++;
			else
				break;
		}
		return num;
	}
	//| 相同棋子数
	public int sameChess2(){
		Chess last = list.get(list.size()-1);//获得最后一次下棋的棋子
		int x = last.getX();
		int y = last.getY();
		int num = 1;
		//last上边的一个棋子Chess(x-1,y)，横坐标减，纵坐标不变
		for(int i=1; x-i>=0 ;i++){
			Chess c = new Chess(x-i,y);
			if(contains(c)==true)
				num++;
			else
				break;
		}
		
		//在last的下侧继续循环查找棋子 横坐标减，纵坐标不变
		for(int i=1; x+i < 10;i++){
			Chess c = new Chess(x+i,y);
			if(contains(c) == true)
				num++;
			else
				break;
		}
		return num;
	}
	//  / 相同棋子数
	public int sameChess3(){
		Chess last = list.get(list.size()-1);//获得最后一次下棋的棋子
		int x = last.getX();
		int y = last.getY();
		int num = 1;
		//last右上边的一个棋子Chess(x-1,y)，横坐标减，纵坐标加
		for(int i=1; x-i>=0&&y+i<max ;i++){
			Chess c = new Chess(x-i,y+i);
			if(contains(c)==true)
				num++;
			else
				break;
		}
		
		//在last的左下侧继续循环查找棋子 横坐标加，纵坐标减
		for(int i=1; x+i<10 && y-i>=0;i++){
			Chess c = new Chess(x+i,y-i);
			if(contains(c) == true)
				num++;
			else
				break;
		}
		return num;
	}
	//  \ 相同棋子数
	public int sameChess4(){
		Chess last = list.get(list.size()-1);//获得最后一次下棋的棋子
		int x = last.getX();
		int y = last.getY();
		int num = 1;
		//last左上边的一个棋，横坐标减，纵坐标减
		for(int i=1; x-i>=0&&y-i>=0 ;i++){
			Chess c = new Chess(x-i,y-i);
			if(contains(c)==true)
				num++;
			else
				break;
		}
		
		//在last的右下侧继续循环查找棋子 横坐标加，纵坐标加
		for(int i=1; x+i<10 && y+i<10;i++){
			Chess c = new Chess(x+i,y+i);
			if(contains(c) == true)
				num++;
			else
				break;
		}
		return num;
	}
}

class Step{
	int x, y;
	public Step(int x, int y){
		this.x = x;
		this.y = y;
	}
}
