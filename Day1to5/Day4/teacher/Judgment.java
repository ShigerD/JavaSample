

import java.awt.Color;
import java.util.ArrayList;

/*
 * ʵ���ж���
 * ����һ���洢���ӵļ���
 * ���жϼ������Ƿ�����ָ��������
 * ���ж���ĳ���������������Ƿ񳬹�5
 * ���������
 */
public class Judgment {
	private ArrayList<Chess> list = new ArrayList<Chess>();
	
	public int max = 10;//���̵��������ֵ
	
	public ArrayList<Chess> getList(){
		return list;
	}
	
	public boolean contains(Chess c){//�жϼ������Ƿ�����c����
		return list.contains(c);
	}
	public boolean add(Chess c){
		if(contains(c) == true)//����������c�������������ʧ�ܣ�����false
			return false;
		list.add(c);//��������û��c������c add�������У�������true
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
		int xStep = s.x, yStep=s.y;
		Chess last = list.get(list.size()-1);//������һ�����������
		int x = last.getX();    int y = last.getY();
		int num = 1;		
		for(int i=0; i<2; i++){
			for( int ix=xStep,iy=yStep;
			     (x-ix>=0 && x-ix<10) && (y-iy>=0 && y-iy<10);
			     ix+=xStep,iy+=yStep)
			{
				Chess c = new Chess(x-ix,y-iy);
				Chess o = list.get(list.indexOf(c));//��ü����е�����
				if(contains(c)==true && last.getCol().equals(list.get(list.indexOf(c)).getCol()))//�ж����ӵ���ɫ�Ƿ���ͬ
					num++;
				else
					break;
			}
			xStep *= -1;//�仯x�ķ���
			yStep *= -1;//�仯y�ķ���
		}
		
		return num;
	}
	//- ��ͬ������
	public int sameChess1(){
		Chess last = list.get(list.size()-1);//������һ�����������
		int x = last.getX();
		int y = last.getY();
		int num = 1;
		//last��ߵ�һ������Chess(x,y-1)
		//�ж�Chess(x,y-1)�Ƿ���list�У����ڣ�����+1
		//�����ж�Chess(x,y-2)�Ƿ���list�У��������������ҽ���
		/*
		 * i��1��ʼ����������������y-1��ʼ
		 * ������ӵ���������>=0  y-i>=0 
		 */
		for(int i=1; y-i>=0 ;i++){
			Chess c = new Chess(x+0,y+(-i));
			if(contains(c)==true)
				num++;
			else
				break;
		}
		
		//��last���Ҳ����ѭ����������
		for(int i=1; y+i < 10;i++){
			Chess c = new Chess(x+0,y+i);
			if(contains(c) == true)
				num++;
			else
				break;
		}
		return num;
	}
	//| ��ͬ������
	public int sameChess2(){
		Chess last = list.get(list.size()-1);//������һ�����������
		int x = last.getX();
		int y = last.getY();
		int num = 1;
		//last�ϱߵ�һ������Chess(x-1,y)����������������겻��
		for(int i=1; x-i>=0 ;i++){
			Chess c = new Chess(x-i,y);
			if(contains(c)==true)
				num++;
			else
				break;
		}
		
		//��last���²����ѭ���������� ��������������겻��
		for(int i=1; x+i < 10;i++){
			Chess c = new Chess(x+i,y);
			if(contains(c) == true)
				num++;
			else
				break;
		}
		return num;
	}
	//  / ��ͬ������
	public int sameChess3(){
		Chess last = list.get(list.size()-1);//������һ�����������
		int x = last.getX();
		int y = last.getY();
		int num = 1;
		//last���ϱߵ�һ������Chess(x-1,y)������������������
		for(int i=1; x-i>=0&&y+i<max ;i++){
			Chess c = new Chess(x-i,y+i);
			if(contains(c)==true)
				num++;
			else
				break;
		}
		
		//��last�����²����ѭ���������� ������ӣ��������
		for(int i=1; x+i<10 && y-i>=0;i++){
			Chess c = new Chess(x+i,y-i);
			if(contains(c) == true)
				num++;
			else
				break;
		}
		return num;
	}
	//  \ ��ͬ������
	public int sameChess4(){
		Chess last = list.get(list.size()-1);//������һ�����������
		int x = last.getX();
		int y = last.getY();
		int num = 1;
		//last���ϱߵ�һ���壬����������������
		for(int i=1; x-i>=0&&y-i>=0 ;i++){
			Chess c = new Chess(x-i,y-i);
			if(contains(c)==true)
				num++;
			else
				break;
		}
		
		//��last�����²����ѭ���������� ������ӣ��������
		for(int i=1; x+i<10 && y+i<10;i++){
			Chess c = new Chess(x+i,y+i);
			if(contains(c) == true)
				num++;
			else
				break;
		}
		return num;
	}
	public static void main(String[] args) {
		Judgment m = new Judgment();
		Chess c = new Chess(2, 2,Color.black);
		m.add(c);
		c = new Chess(4,2,Color.black);
		m.add(c);
		c = new Chess(0, 2,Color.white);
		m.add(c);
		c = new Chess(3, 2,Color.black);
		m.add(c);
		c = new Chess(6, 2,Color.black);
		m.add(c);
		
		c = new Chess(5, 2,Color.black);
		m.add(c);
		
		System.out.println(m.isWinNew());
	}
}

class Step{
	int x, y;
	public Step(int x, int y){
		this.x = x;
		this.y = y;
	}
}
