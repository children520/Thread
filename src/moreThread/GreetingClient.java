package moreThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GreetingClient {
	public static void main(String[] args) {
		String severName=args[0];
		int port=Integer.parseInt(args[1]);
		try {
			System.out.println("连接到主机:"+severName+",端口号:"+port);
			//创建一个流套接字并将其链接到指定主机的滴定端口号
			Socket client=new Socket(severName,port);
			//返回此套接字连接的端口的地址，未连接返回null
			System.out.println("远程主机地址:"+client.getRemoteSocketAddress());
			//返回此套接字的输出流
			OutputStream outToServer=client.getOutputStream();
			//创建新的数据输出流，将数据写入指定的基础输出流
			DataOutputStream out=new DataOutputStream(outToServer);
			//使用将一个字符串写入基础输出流修改后的UTF-8以机器无关的方式进行编码
			//表示此套接字的本地端点的SocketAddress，或表示该套接字的SocketAddress
			out.writeUTF("hello from"+client.getLocalSocketAddress());
			InputStream inFromServer=client.getInputStream();
			DataInputStream in=new DataInputStream(inFromServer);
			//a Unicode string.
			System.out.println("hello server:"+in.readUTF());
			client.close();
		}catch (IOException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

}
