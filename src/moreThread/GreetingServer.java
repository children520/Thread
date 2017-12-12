package moreThread;
/*ServerSocket为服务器程序提供一种监听客户端，并与他们建立连接的机制
 * 1，实例化一个ServerSocket对象,通过服务器端口通信
 * 2，调用accep(),一直等待，直到客户端连接到给定的端口
 * 3，客户端通过实例化socket对象，指定服务器和端口号请求连接
 * 4，建立时，进行通讯连接
 * 5，accept返回一个新的socket连接，连接到客户端的socket
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer extends Thread{
	private ServerSocket serverSocket;
	//创建绑定特定端口的服务器套接字
	public GreetingServer(int port) throws IOException{
		serverSocket =new ServerSocket(port);
		//通过指定超时值启用和禁用，此处为10秒
		serverSocket.setSoTimeout(10000);
	}
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("等待远程链接，端口号为:"+serverSocket.getLocalPort()+"....");
				//侦听并接受此套接字的链接
				Socket server=serverSocket.accept();
				//代表这个远程端点的一个代码SocketAddress套接字，如果尚未连接，则为{null}
				System.out.println("远程主机地址:"+server.getRemoteSocketAddress());
				DataInputStream in=new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out =new DataOutputStream(server.getOutputStream());
				out.writeUTF("谢谢连接我:"+server.getLocalSocketAddress()+"\nGoodbye");
				server.close();
				
			}catch (SocketTimeoutException s) {
				System.out.println("hello client");
				// TODO: handle exception
			}catch (IOException e) {
				e.printStackTrace();
				break;// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		int port=Integer.parseInt(args[0]);
		try {
			Thread t=new GreetingServer(port);
			t.run();
		}catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
