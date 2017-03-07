package Day4;
/*

 */
import java.awt.Color;
import java.util.ArrayList;


public class Judgment
{
	private ArrayList<Chess> list=new ArrayList<Chess>();
	//public int max=10;
	public int min;//妫嬬洏寮�濮嬬殑鍧愭爣鍍忕礌
	public int max;//妫嬬洏鐨勭粨鏉熺殑鍧愭爣鍍忕礌
	
	//鍦ㄦ瀯閫犲垽鏂被瀵硅薄鏃讹紝鏍规嵁妫嬬洏鐨勭嚎鏉＄‘瀹歮in鍜宮ax鐨勪綅缃�
	public Judgment(int min,int max){
		this.min=min;
		this.max=max;
	}
	
	
	public boolean contains(Chess c)  //鍒ゆ柇闆嗗悎涓槸鍚﹀凡鏈塩妫嬪瓙
	{
		return list.contains(c);
	}
	
	public ArrayList<Chess> getList()
	{
		return list;
	}

	public boolean add(Chess c)
	{
		if(contains(c)==true) //鑻ラ泦鍚堜腑鏈塩妫嬪瓙鍒欐坊鍔犳瀛愬け璐ワ紝杩斿洖false
			return false;
		list.add(c); //鑻ラ泦鍚堜腑娌℃湁c妫嬪瓙鍒欏皢c add鍒伴泦鍚堜腑锛屽苟杩斿洖true
		return true;
	}
	
//	public static void main(String[] args)
//	{
//		Judgment m=new Judgment();
//		Chess c=new Chess(2,3);
//		boolean flag=m.add(c);
//		System.out.println(flag?"娣诲姞鎴愬姛锛�":"娣诲姞澶辫触!");
//		
//	    flag=m.add(c);
//		System.out.println(flag?"娣诲姞鎴愬姛锛�":"娣诲姞澶辫触!");	
//	}

//	public boolean isWin()
//	{
//		if(sameChess1()>=5)
//			return true;
//		if(sameChess2()>=5)
//			return true;
//		if(sameChess3()>=5)
//				return true;
//		if(sameChess4()>=5)
//			return true;
//		return false;
//	}
	
	Step[] arr={new Step(0,1),new Step(1,0),new Step(01,1),new Step(1,-1)};
	
	public boolean isWinNew()
	{
		for(int i=0;i<4;i++)
		{
			if(sameChess(arr[i])>=5)
			{
				return true;
			}
		}
		return false;
	}
	/*
	 *  -: xStep=0 yStep=1
	 *  |: xStep=1 yStep=0
	 *  \: xStep=1 yStep=1
	 *  /: xStep=-1 yStep=1
	 */
	
	public int sameChess(Step s)
	{   int xStep=s.x,yStep=s.y;
	    Chess last=list.get(list.size()-1); //鑾峰緱鏈�鍚庝竴娆′笅妫嬬殑妫嬪瓙
	    int x=last.getX();
		int y=last.getY();
		int num=1;

		for(int i=0;i<2;i++)
		{
			for(int ix=xStep,iy=yStep;
			   (x-ix>=min && x-ix<max) && (y-iy>=min && y-iy<max);
			   ix+=xStep,iy+=yStep)
			   {
				   Chess c=new Chess(x-ix,y-iy);
				   //Chess o=list.get(list.indexOf(c)); //鑾峰緱闆嗗悎涓殑妫嬪瓙
				   if(contains(c)==true && last.getCol().equals(list.get(list.indexOf(c)).getCol())) //鍒ゆ柇妫嬪瓙鏄惁鐩稿悓
				    	num++;
				    else
				    	break;
			   }
			xStep *=-1; //鍙樺寲x鐨勬柟鍚�
			yStep *=-1; //鍙樺寲y鐨勬柟鍚�
		}
		return num;
	}
	
	
	
	
	
	
	
//	// - 鐩稿悓妫嬪瓙鏁�
//	public int sameChess1()
//	{
//		Chess last=list.get(list.size()-1);
//		int x=last.getX();
//		int y=last.getY();
//		int num=1;
//		//last宸﹁竟鐨勪竴涓瀛怌hess(x,y-1)
//		//鍒ゆ柇Chess(x,y-1)鏄惁鍦╨ist涓紝鑻ュ湪锛岃鏁�+1
//		//缁х画鍒ゆ柇Chess(x,y-2)鏄惁鍦╨ist涓紝鑻ヤ笉鍦ㄥ垯宸︿晶鏌ユ壘缁撴潫
//		/*
//		 * i浠�1寮�濮嬶紝宸︿晶妫嬪瓙绾靛潗鏍囦粠y-1寮�濮�
//		 * 宸︿晶妫嬪瓙鐨勭旱鍧愭爣鏄�>=0,y-i>=0
//		 */
//		
//		for(int i=1;y-i>=0;i++)
//		{
//			Chess c=new Chess(x,y-i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//			
//		//鍦╨ast鐨勫彸渚х户缁惊鐜煡鎵炬瀛�
//		for(int i=1;y+i<10;i++)
//		{
//			Chess c=new Chess(x,y+i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//		
//		return num;
//		
//	}
//	
//	// | 鐩稿悓妫嬪瓙鏁�
//	public int sameChess2()
//	{
//		Chess last=list.get(list.size()-1);
//		int x=last.getX();
//		int y=last.getY();
//		int num=1;
//		
//		//last涓婅竟鐨勪竴涓瀛怌hess(x-1,y),妯潗鏍囧噺锛岀旱鍧愭爣涓嶅彉
//		for(int i=1;x-i>=0;i++)
//		{
//			Chess c=new Chess(x-i,y);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//			
//		//鍦╨ast鐨勪笅杈圭户缁惊鐜煡鎵炬瀛愶紝妯潗鏍囧姞锛岀旱鍧愭爣涓嶅彉
//		for(int i=1;x+i<10;i++)
//		{
//			Chess c=new Chess(x+i,y);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//		return num;
//		
//	}
//	
//	// / 鐩稿悓妫嬪瓙鏁�
//	public int sameChess3()
//	{
//		Chess last=list.get(list.size()-1);
//		int x=last.getX();
//		int y=last.getY();
//		int num=1;
//		
//		//last鍙充笂杈圭殑涓�涓瀛怌hess,妯潗鏍囧噺锛岀旱鍧愭爣鍔�
//		for(int i=1;x-i>=0 && y+i<max;i++)
//		{
//			Chess c=new Chess(x-i,y+i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//			
//		//鍦╨ast鐨勫乏涓嬭竟缁х画寰幆鏌ユ壘妫嬪瓙锛屾í鍧愭爣鍔狅紝绾靛潗鏍囧噺
//		for(int i=1;x+i<10 && y-i>=0;i++)
//		{
//			Chess c=new Chess(x+i,y-i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//		return num;
//		
//	}
//	// \ 鐩稿悓妫嬪瓙鏁�
//	public int sameChess4()
//	{
//		Chess last=list.get(list.size()-1);
//		int x=last.getX();
//		int y=last.getY();
//		int num=1;
//		
//		//last宸︿笂杈圭殑涓�涓瀛怌hess,妯潗鏍囧噺锛岀旱鍧愭爣鍑�
//		for(int i=1;x-i>=0 && y-i>=0;i++)
//		{
//			Chess c=new Chess(x-i,y-i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//			
//		//鍦╨ast鐨勫彸涓嬭竟缁х画寰幆鏌ユ壘妫嬪瓙锛屾í鍧愭爣鍔狅紝绾靛潗鏍囧姞
//		for(int i=1;x+i<10 && y+i<=10;i++)
//		{
//			Chess c=new Chess(x+i,y+i);
//		    if(contains(c)==true)
//		    	num++;
//		    else
//		    	break;
//		}
//		return num;		
//	}

    public static void main(String[] args) 
    {
//    	Judgment m=new Judgment();
//    	Chess c=new Chess(2,3);
//    	m.add(c);
//    	c=new Chess(2,0);
//    	m.add(c);
//    	c=new Chess(2,1);
//    	m.add(c);
    		
    	/*int num =m.sameChess1();
    	System.out.println(num);*/
    	
//    	int num=m.sameChess(new Step(1,0));
//    	System.out.println(num);
//    	System.out.println(m.isWin()==true?"鑳�":"杈�");
    	
//    	Chess o=new Chess(2,2); //鐢熸垚鏂版瀛�
//    	System.out.println(m.contains(o)); //2,2妫嬪瓙鏄惁瀛樺湪list
//    	int index=m.list.indexOf(c); //鎵惧埌2锛�2妫嬪瓙鐨勭储寮�
//    	System.out.println(index);
//    	System.out.println(m.list.get(index)); //閫氳繃绱㈠紩鎵惧埌list涓殑妫嬪瓙
    	
//    	Judgment m=new Judgment();
//    	Chess c=new Chess(2,2,Color.black);
//    	m.add(c);
//    	c=new Chess(4,2,Color.black); 
//    	m.add(c);
//    	c=new Chess(0,2,Color.white); 
//    	m.add(c);
//    	c=new Chess(3,2,Color.black); 
//    	m.add(c);
//    	c=new Chess(6,2,Color.black); 
//    	m.add(c);
//    	c=new Chess(5,2,Color.white); 
//    	m.add(c);
//    	System.out.println(m.isWinNew());
    } 
}
class Step
{
	int x,y;
	public Step(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}