package netpro;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import netpro.Chess;

public class Server
{
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		int port=12345;
		//启动服务器，并指明监听端口
		ServerSocket server=new ServerSocket(port);
		
		System.out.println("服务器端在等待客户端的连接。。。。。。。");
		//在指明端口监听，若有客户端发送连接请求，则生成对应的socket连接客户端
		Socket client=server.accept();
		
		OutputStream os=client.getOutputStream();
		InputStream is=client.getInputStream();
		
//		os.write(0);
//		System.out.println("服务器给客户端发送的数据："+0);
//		int i=is.read();
//		System.out.println("服务器从客户端读到的数据："+i);

		ObjectOutputStream oos=new ObjectOutputStream(os);
		ObjectInputStream ois=new ObjectInputStream(is);
		
		Chess c=new Chess(0,0,Color.black);
		oos.writeObject(c);
		System.out.println("服务器给客户端发送的数据："+c);
		Object o=ois.readObject();
		System.out.println("服务器从客户端读到的数据："+o);
		
		is.close();  //关闭输出流
		os.close();  //关闭输入流
		client.close();  //关闭客户端的连接
		server.close();  //关闭服务器
	}

}
