package shiger;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * java��ͼ�α��
 * ���󴰿ڹ��߼� AWT �����˶�����ͽӿ������û�ͼ�ν������
 * ��Component��������������ڲ�ͬ��;�Ľ������
 * ���-> �������(���԰��������������������ڣ��Ի���)    ���������(��ť����ѡ��)
 */
public class  Win2  {
	public static void main(String[] args) {
		JFrame frame = new JFrame("�����ҵĵ�һ������");
		//�������Ͻǣ��������Ļ���Ͻǵ�ƫ����
//		frame.setBounds(300,200, 300, 400);
		//���ھ�����ʾ
	
		int width = 300;
		int height = 400;
		int x=0,y=0;
		Toolkit tk = Toolkit.getDefaultToolkit();//���ϵͳ���߰�
		Dimension d = tk.getScreenSize();//�����Ļ�ߴ�
		//d.width  d.height//��Ļ�Ŀ�͸�
		x = (d.width-width)/2;
		y = (d.height-height)/2;
		frame.setBounds(x,y,width,height);
		//���õ�����ڹرհ�ťʱ�Ĳ���Ϊ��������Ӧ�ó���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(null);//ɾ��ԭ�е��������,֮����ӵ�����Ϳ������ô�С��λ��
		
		JButton bt = new JButton("��ť");
		//��ť����ڸ����ڵ����Ͻ�����Ͱ�ť�Ŀ���
		bt.setContentAreaFilled(true);
		bt.setBounds(50,50,80,30);
//		TextField tf=new TextField(12);
//		tf.setVisible(true);
//		tf.setText("hello java~~");
//		tf.setEnabled(true);	
		
		System.out.println("hello");
		frame.add(bt);

		frame.setVisible(true);//���ÿɼ�
	}
}
