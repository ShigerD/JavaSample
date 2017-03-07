package Day3;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class test2 extends JFrame //窗口中需要的组件，作为属性出现
{
	private JButton bt;
	public test2(String title)
	{
		super(title);
		
		initFrame();
		//initComponent();
		
		this.setVisible(true); //设置看见	
		
		addListener();
		
		paint(this.getGraphics());
	}
	
	int x,y;
	public void addListener()
	{
		this.addMouseListener(
				/*匿名内部类*/
				new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
						if(e.getButton()!=MouseEvent.BUTTON1)
							return;
						 x=e.getX();
						 y=e.getY();
						 repaint();
					}
				}
				);
		
	}
	
	public void initFrame()
	{
		int width=300;
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
		g.drawLine(20,100,20,200);
		//g.drawOval(x,y,30,30);
		g.fillOval(x-10,y-10,20,20);
	}
	public static void main(String[] args)
	{
		new test2("这是我的第二个窗口");
	}
}
