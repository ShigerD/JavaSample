package wyf.wyf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hello");
		try{
			ServerSocket ss=new ServerSocket(8888);
			System.out.println("Listerning...");
			while(true){
				Socket  socket=ss.accept();
				System.out.println("Client Connected...");
				DataOutputStream dout=new DataOutputStream(socket.
						getOutputStream());
				Date d=new Date();
				dout.writeUTF("Hello Server:"+d.toLocaleString());
				
				DataInputStream din=new DataInputStream(socket.
						getInputStream());
				System.out.println(din.readUTF());
								
				dout.close(); 
				socket.close();
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
