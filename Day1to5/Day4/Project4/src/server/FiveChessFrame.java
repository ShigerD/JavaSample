package server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.*;

public class FiveChessFrame extends JFrame //窗口中需要的组件，作为属性出现
{
	private Judgment judgment;
	
	private int lineLength=300; //棋盘线条的长度
	private int lineStart=50;   //棋盘线条的起始位置
	//private JButton bt;
	public FiveChessFrame(String title) throws IOException
	{
		super(title);
		judgment =new Judgment(lineStart,lineStart+lineLength);
		initFrame();
		//initComponent();
		
		this.setVisible(true); //设置看见	
		
		addListener();
		initNet();
		paint(this.getGraphics());
	}
	
	ServerSocket server=null;
	Socket client;
	ObjectInputStream ois=null;
	ObjectOutputStream oos=null;
	
	public void initNet() throws IOException
	{
		int port=12345;
		server=new ServerSocket(port);
		server.accept();
		System.out.println("接收到客户端的连接申请");
		oos=new ObjectOutputStream(client.getOutputStream());
		ois=new ObjectInputStream(client.getInputStream());
	}

	
	int x,y;
	boolean isBlack=true;
	public void addListener()
	{
		this.addMouseListener(
				/*匿名内部类*/
				new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e) //窗口出现鼠标点击事件时，想让它干什么
					{
						if(e.getButton()!=MouseEvent.BUTTON1) //若按下的不是左键
							return;
						//找到鼠标的位置
						 x=e.getX();
						 y=e.getY();
						 //修正x,y
						 int lineEnd=lineStart+lineLength;
						 if(!((x>=lineStart && x<=lineEnd) && (y>=lineStart && y<=lineEnd)))
							 return;
						 int i=(x-lineStart)/Chess.getSize(); //整除得到棋子在第几个行
						 x=i*Chess.getSize()+lineStart; //得到第几个行的左上角x坐标
						 
						 i=(y-lineStart)/Chess.getSize(); //整除得到棋子在第几个列
						 y=i*Chess.getSize()+lineStart; //得到第几个列的左上角y坐标
						 
						 //根据isBlack的值设置棋子的颜色
						 Color col=isBlack==true?Color.black:Color.white;
						 Chess c=new Chess(x,y,col); //初始化有颜色的棋子
						 
						 //Chess c=new Chess(x,y);
						 judgment.add(c); //将棋子加入Judgment的棋子集合中
						 
						 isBlack=!isBlack;
						 //在位置上画圆，在paint方法中，repaint方法会自动调用paint
						 repaint();
					}
				}
				);
		
	}
	
	public void initFrame()
	{
		int width=400;
		int height=400;
		int x=0,y=0;
		Toolkit tk=Toolkit.getDefaultToolkit(); //获得系统工具包
		Dimension d=tk.getScreenSize(); //获得屏幕尺寸
		// d.width  d.height //屏幕的宽和高
		x=(d.width-width)/2;
		y=(d.height-height)/2;
		this.setBounds(x,y,width,height);
		//设置点击窗口关闭按钮时的操作为结束整个应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	}
	public void initComponent()
	{
		JButton bt=new JButton("Button");
		bt.setBounds(50,50,80,30);
		this.add(bt);
	}
	
	//重绘方法，当窗口曝光时系统会自动调用该方法
	public void paint(Graphics g)
	{
		g.clearRect(0,0,this.getWidth(),this.getHeight());
		//g.drawLine(20,100,20,200);
		//g.drawOval(x,y,30,30);
		//g.fillOval(x,y,30,30);
		
		//首先判断鼠标是否超出棋盘范围
		int lineEnd=lineStart+lineLength;
		int chessSize=Chess.getSize();
		for(int i=lineStart;i<=lineEnd;i+=chessSize)
		{
			g.drawLine(lineStart,i,lineEnd,i);
			g.drawLine(i,lineStart,i,lineEnd);
		}
		
		Color old=g.getColor(); //保存原有设备颜色
		ArrayList<Chess> list=judgment.getList();
		
		for(int i=0;i<list.size();i++)
		{
			Chess c=list.get(i);
			g.setColor(c.getCol()); //根据棋子颜色设置画笔颜色
			g.fillOval(c.getX(),c.getY(),30,30);
			g.setColor(Color.black); //画黑色边框
			g.drawArc(c.getX(),c.getY(),30,30,0,360);
		}
		g.setColor(old); //还原设备颜色
	}
	
	public static void main(String[] args) throws IOException
	{
		new FiveChessFrame("五子棋窗口");
	}

}
