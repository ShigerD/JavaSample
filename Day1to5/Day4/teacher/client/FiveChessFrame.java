package client;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.*;


public class FiveChessFrame extends JFrame{
	//窗口中需要的组件，作为属性出现
	private Judgment judgment ;
	
	private int lineLength = 300;//棋盘线条的长度
	private int lineStart = 50;  //棋盘线条的起始位置
	
	public FiveChessFrame(String title) throws UnknownHostException, IOException{
		super(title);
		judgment = new Judgment(lineStart,lineStart+lineLength);
		initFrame();
		addListener();
		initNet();
		this.setVisible(true);	
	}
	Socket client;//属性
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	public void initNet() throws UnknownHostException, IOException{
		String host = "127.0.0.1";
		int port = 12345;
		
		client = new Socket(host,port);
		System.out.println("连接成功");
		InputStream is = client.getInputStream();
		OutputStream os = client.getOutputStream();
		oos = new ObjectOutputStream(os);
		ois = new ObjectInputStream(is);
	}
	 
	public void initFrame(){
		int width = 450;
		int height = 450;
		int x=0,y=0;
		Toolkit tk = Toolkit.getDefaultToolkit();//获得系统工具包
		Dimension d = tk.getScreenSize();//获得屏幕尺寸
		//d.width  d.height//屏幕的宽和高
		x = (d.width-width)/2;
		y = (d.height-height)/2;
		this.setBounds(x,y,width,height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	}
//	public void initComponent(){
//		bt = new JButton("按钮");
//		bt.setBounds(50,50,80,30);
//		this.add(bt);
//	}
	int x, y;
	boolean isBlack = true;//判断是否是黑方下棋
	public void addListener() {
		this.addMouseListener(//给窗口添加鼠标响应事件
				/*匿名内部类*/
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e){
						//窗口出现鼠标点击事件时，想让它干什么					
						if(e.getButton() != MouseEvent.BUTTON1)//若按下的不是左键
							return;
						//找到鼠标的位置
						x = e.getX();
						y = e.getY();
						//首先判断鼠标是否超出棋盘范围
						int lineEnd = lineStart+lineLength;
						if(!((x>=lineStart&&x<=lineEnd) && (y>=lineStart&&y<=lineEnd)))
							return;
						//修正x,y
						int i = (x-lineStart)/Chess.getSize();//整除得到棋子在第几个行
						x = i*Chess.getSize()+lineStart;//得到第几个行的左上角x坐标
						
						int j = (y-lineStart)/Chess.getSize();//整除得到棋子在第几个列
						y = j*Chess.getSize()+lineStart;//得到第几个列的左上角y坐标
						
						//根据isBlack的值设置棋子颜色
						Color col = isBlack==true?Color.black:Color.white;
						Chess c = new Chess(x,y,col);//初始化有颜色的棋子
						judgment.add(c);//将棋子加入Judgment的棋子集合中
						isBlack = !isBlack;
						//在位置上画圆,在paint方法中,repaint方法会自动调用paint
						repaint();
						
						System.out.println(judgment.getList());
						//判断输赢
						if(judgment.isWinNew()== true){
							if(c.getCol() == Color.black)
								System.out.println("黑方胜出");
							else
								System.out.println("白方胜出");
						}
					}
				}
				);
	}
	//重绘方法，当窗口曝光时系统会自动调用该方法
	public void paint(Graphics g){
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		int lineEnd = lineStart+lineLength;
		int chessSize = Chess.getSize();
		for(int i=lineStart; i<=lineEnd; i += chessSize){
			g.drawLine(lineStart,i,lineEnd, i);
			g.drawLine(i,lineStart,i,lineEnd );
		}
		
		Color old = g.getColor();//保存原有设备颜色
		
		ArrayList<Chess> list = judgment.getList();
		for(int i=0; i<list.size(); i++){
			Chess c = list.get(i);
			g.setColor(c.getCol());//根据棋子颜色设置画笔颜色
			g.fillOval(c.getX(),c.getY(), 30, 30);
			g.setColor(Color.black);//设置边框为黑色
			g.drawArc(c.getX(),c.getY(), 30, 30,0,360);//画黑边框
		}
		g.setColor(old);//还原设备颜色
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		new FiveChessFrame("五子棋窗口");
	}
}



/*
主机：10.0.3.98
端口：21
用户名：stu
密码 ：  stu

*/












