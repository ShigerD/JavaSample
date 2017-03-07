package netpro;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import netpro.Chess;

/*
 * 客户端
 * 1、要连接的服务器IP
 * 2、将数据传输到哪里  端口
 */
public class Client 
{
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException
	{
		String ip="127.0.0.1";
		int port=12345; //0-65535 习惯选择超过10000的端口号
		//申请连接IP服务器
		Socket client=new Socket(ip,port);
		
		//字节流
		OutputStream os=client.getOutputStream();
		InputStream is=client.getInputStream();
	
//		int b=is.read();  //读取服务器发送来的数据
//		System.out.println("客户端接收到服务器发送来的数据："+b);
//		os.write(12);  //发送给服务器的数据
//		System.out.println("客户端接给服务器发送的数据："+12);
		
		ObjectOutputStream oos=new ObjectOutputStream(os);
		ObjectInputStream ois=new ObjectInputStream(is);
		
		Object o=ois.readObject();
		System.out.println("客户端接收到服务器发送来的数据："+o);
		Chess c=new Chess(20,30,Color.white);
		oos.writeObject(c);
		System.out.println("客户端接给服务器发送的数据："+c);
		
		is.close();
		os.close();
		client.close();
		
		
	}

}
