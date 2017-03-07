import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;


public class Test2 extends JFrame{
	//窗口中需要的组件，作为属性出现
	private JButton bt;
	private Judgment judgment;
	public Test2(String title){
		super(title);
		judgment = new Judgment();
		initFrame();
//		initComponent();
		addListener();
		this.setVisible(true);	
	}
	
	public void initFrame(){
		int width = 300;
		int height = 400;
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
	public void initComponent(){
		bt = new JButton("按钮");
		bt.setBounds(50,50,80,30);
		this.add(bt);
	}
	int x, y;
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
						//修正x,y
						judgment.add(new Chess(x,y));//将棋子加入Judgment的棋子集合中
						//在位置上画圆,在paint方法中,repaint方法会自动调用paint
						repaint();
					}
				}
				);
	}
	//重绘方法，当窗口曝光时系统会自动调用该方法
	public void paint(Graphics g){
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawLine(20, 100, 20, 200);
//		g.drawOval(x, y, 30, 30);
		
		ArrayList<Chess> list = judgment.getList();
		for(int i=0; i<list.size(); i++){
			Chess c = list.get(i);
			g.fillOval(c.getX(),c.getY(), 30, 30);
		}
	}
	public static void main(String[] args) {
		new Test2("这是我的第二个窗口");
	}
}
