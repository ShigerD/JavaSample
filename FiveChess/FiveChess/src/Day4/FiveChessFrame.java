package Day4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class FiveChessFrame extends JFrame //
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4722811245844760133L;

	/**
	 * 
	 */
	

	private Judgment judgment;
	
	private int lineLength=300; //
	private int lineStart=50;   //
	//private JButton bt;
	public FiveChessFrame(String title)
	{
		super(title);
		judgment =new Judgment(lineStart,lineStart+lineLength);
		initFrame();
		//initComponent();
		
		this.setVisible(true); //	
		
		addListener();
		
		paint(this.getGraphics());
	}
	
	int x,y;
	boolean isBlack=true;
	public void addListener()
	{
		this.addMouseListener(
				/*匿名内部�?*/
				new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e) //
					{
						if(e.getButton()!=MouseEvent.BUTTON1) //
							return;
						//
						 x=e.getX();
						 y=e.getY();
						 //修正x,y
						 int lineEnd=lineStart+lineLength;
						 if(!((x>=lineStart && x<=lineEnd) && (y>=lineStart && y<=lineEnd)))
							 return;
						 int i=(x-lineStart)/Chess.getSize(); //
						 x=i*Chess.getSize()+lineStart; //
						 
						 i=(y-lineStart)/Chess.getSize(); //
						 y=i*Chess.getSize()+lineStart; //
						 
						 //
						 Color col=isBlack==true?Color.black:Color.white;
						 Chess c=new Chess(x,y,col); //
						 
						 //Chess c=new Chess(x,y);
						 judgment.add(c); //
						 
						 isBlack=!isBlack;
						 //
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
		Toolkit tk=Toolkit.getDefaultToolkit(); //
		Dimension d=tk.getScreenSize(); //
		// d.width  d.height //
		x=(d.width-width)/2;
		y=(d.height-height)/2;
		this.setBounds(x,y,width,height);
		//
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	}
	public void initComponent()
	{
		JButton bt=new JButton("Button");
	//	bt.setBounds(50,50,80,30);
	//	this.add(bt);
	}
	
	//
	public void paint(Graphics g)
	{
		g.clearRect(0,0,this.getWidth(),this.getHeight());
		//g.drawLine(20,100,20,200);
		//g.drawOval(x,y,30,30);
		//g.fillOval(x,y,30,30);
		
		//
		int lineEnd=lineStart+lineLength;
		int chessSize=Chess.getSize();
		for(int i=lineStart;i<=lineEnd;i+=chessSize)
		{
			g.drawLine(lineStart,i,lineEnd,i);
			g.drawLine(i,lineStart,i,lineEnd);
		}
		
		Color old=g.getColor(); //
		ArrayList<Chess> list=judgment.getList();
		
		for(int i=0;i<list.size();i++)
		{
			Chess c=list.get(i);
			g.setColor(c.getCol()); //
			g.fillOval(c.getX(),c.getY(),30,30);
			g.setColor(Color.black); //
			g.drawArc(c.getX(),c.getY(),30,30,0,360);
		}
		g.setColor(old); //
	}
	
	public static void main(String[] args)
	{
		new FiveChessFrame("����" +
				"������");
	}

}
