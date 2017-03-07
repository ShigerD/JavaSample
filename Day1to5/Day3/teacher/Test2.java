import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;


public class Test2 extends JFrame{
	//��������Ҫ���������Ϊ���Գ���
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
		Toolkit tk = Toolkit.getDefaultToolkit();//���ϵͳ���߰�
		Dimension d = tk.getScreenSize();//�����Ļ�ߴ�
		//d.width  d.height//��Ļ�Ŀ�͸�
		x = (d.width-width)/2;
		y = (d.height-height)/2;
		this.setBounds(x,y,width,height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	}
	public void initComponent(){
		bt = new JButton("��ť");
		bt.setBounds(50,50,80,30);
		this.add(bt);
	}
	int x, y;
	public void addListener() {
		this.addMouseListener(//��������������Ӧ�¼�
				/*�����ڲ���*/
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e){
						//���ڳ���������¼�ʱ����������ʲô					
						if(e.getButton() != MouseEvent.BUTTON1)//�����µĲ������
							return;
						//�ҵ�����λ��
						x = e.getX();
						y = e.getY();
						//����x,y
						judgment.add(new Chess(x,y));//�����Ӽ���Judgment�����Ӽ�����
						//��λ���ϻ�Բ,��paint������,repaint�������Զ�����paint
						repaint();
					}
				}
				);
	}
	//�ػ淽�����������ع�ʱϵͳ���Զ����ø÷���
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
		new Test2("�����ҵĵڶ�������");
	}
}
