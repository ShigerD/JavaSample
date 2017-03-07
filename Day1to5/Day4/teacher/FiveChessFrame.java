import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;


public class FiveChessFrame extends JFrame{
	//��������Ҫ���������Ϊ���Գ���
	private Judgment judgment ;
	
	private int lineLength = 300;//���������ĳ���
	private int lineStart = 50;  //������������ʼλ��
	
	public FiveChessFrame(String title){
		super(title);
		judgment = new Judgment(lineStart,lineStart+lineLength);
		initFrame();
		addListener();
		this.setVisible(true);	
	}
	
	public void initFrame(){
		int width = 450;
		int height = 450;
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
//	public void initComponent(){
//		bt = new JButton("��ť");
//		bt.setBounds(50,50,80,30);
//		this.add(bt);
//	}
	int x, y;
	boolean isBlack = true;//�ж��Ƿ��Ǻڷ�����
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
						int i = (x-lineStart)/Chess.getSize();//�����õ������ڵڼ�����
						x = i*Chess.getSize()+lineStart;//�õ��ڼ����е����Ͻ�x����
						
						i = (y-lineStart)/Chess.getSize();//�����õ������ڵڼ�����
						y = i*Chess.getSize()+lineStart;//�õ��ڼ����е����Ͻ�y����
						
						//����isBlack��ֵ����������ɫ
						Color col = isBlack==true?Color.black:Color.white;
						Chess c = new Chess(x,y,col);//��ʼ������ɫ������
						judgment.add(c);//�����Ӽ���Judgment�����Ӽ�����
						isBlack = !isBlack;
						//��λ���ϻ�Բ,��paint������,repaint�������Զ�����paint
						repaint();
						
						System.out.println(judgment.getList());
						//�ж���Ӯ
						if(judgment.isWinNew()== true){
							if(c.getCol() == Color.black)
								System.out.println("�ڷ�ʤ��");
							else
								System.out.println("�׷�ʤ��");
						}
					}
				}
				);
	}
	//�ػ淽�����������ع�ʱϵͳ���Զ����ø÷���
	public void paint(Graphics g){
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		int lineEnd = lineStart+lineLength;
		int chessSize = Chess.getSize();
		for(int i=lineStart; i<=lineEnd; i += chessSize){
			g.drawLine(lineStart,i,lineEnd, i);
			g.drawLine(i,lineStart,i,lineEnd );
		}
		
		Color old = g.getColor();//����ԭ���豸��ɫ
		
		ArrayList<Chess> list = judgment.getList();
		for(int i=0; i<list.size(); i++){
			Chess c = list.get(i);
			g.setColor(c.getCol());//����������ɫ���û�����ɫ
			g.fillOval(c.getX(),c.getY(), 30, 30);
			g.setColor(Color.black);//���ñ߿�Ϊ��ɫ
			g.drawArc(c.getX(),c.getY(), 30, 30,0,360);//���ڱ߿�
		}
		g.setColor(old);//��ԭ�豸��ɫ
	}
	public static void main(String[] args) {
		new FiveChessFrame("�����崰��");
	}
}



/*
������10.0.3.98
�˿ڣ�21
�û�����stu
���� ��  stu

*/












