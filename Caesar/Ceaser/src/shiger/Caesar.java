package shiger;

public class Caesar {
	
	String s;
	int key;
	//���캯��
	Caesar(String es,int n){
		s=es;
		key=n;
	}
	/*
	 * 
	 */
	public String process(){
		String es="";
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c>='a'&&c<='z'){
				c+=key%26;
				if(c<'a')c+=26;
				if(c>'z')c-=26;
			}
			else if(c>='A'&&c<='Z'){
				c+=key%26;
				if(c<'A') c+=26;
				if(c>='Z')c-=26;
			}
			es+=c;
		}
		return es;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="hello";
		Caesar c=new Caesar(s,2);
		String str=c.process();
		
		//System.out.println("���ܺ���ַ�����"+str+"\n");
		System.out.print("���ܺ���ַ�����"+str+"\n");
		Caesar c2=new Caesar(str,-2);
		String str2=c2.process();
		//System.out.println("jie�ܺ���ַ�����"+str2+"\n");
		System.out.print("jie�ܺ���ַ�����"+str2+"\n");

	}

}
