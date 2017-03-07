package shiger;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * java的图形编程
 * 抽象窗口工具集 AWT 定义了多种类和接口用于用户图形界面设计
 * 由Component组件派生若干用于不同用途的界面组件
 * 组件-> 容器组件(可以包含其它组件的组件，窗口，对话框)    非容器组件(按钮、复选框)
 */
public class  Win2  {
	public static void main(String[] args) {
		JFrame frame = new JFrame("这是我的第一个窗口");
		//窗口左上角，相对于屏幕左上角的偏移量
//		frame.setBounds(300,200, 300, 400);
		//窗口居中显示
	
		int width = 300;
		int height = 400;
		int x=0,y=0;
		Toolkit tk = Toolkit.getDefaultToolkit();//获得系统工具包
		Dimension d = tk.getScreenSize();//获得屏幕尺寸
		//d.width  d.height//屏幕的宽和高
		x = (d.width-width)/2;
		y = (d.height-height)/2;
		frame.setBounds(x,y,width,height);
		//设置点击窗口关闭按钮时的操作为结束整个应用程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(null);//删除原有的组件布局,之后添加的组件就可以设置大小和位置
		
		JButton bt = new JButton("按钮");
		//按钮相对于父窗口的左上角坐标和按钮的宽、高
		bt.setContentAreaFilled(true);
		bt.setBounds(50,50,80,30);
//		TextField tf=new TextField(12);
//		tf.setVisible(true);
//		tf.setText("hello java~~");
//		tf.setEnabled(true);	
		
		System.out.println("hello");
		frame.add(bt);

		frame.setVisible(true);//设置可见
	}
}
