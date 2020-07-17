package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.StringTokenizer;

public class Server01 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server01 server = new Server01();
		server.start();
	}

//启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}

//接受连接处理
	public void receive() {
		try {
			Socket client=serverSocket.accept();
			 System.out.println("连接服务器成功！！...");

             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(client.getInputStream()));

             // GET /test.jpg /HTTP1.1
             String line = reader.readLine();

             System.out.println("line: " + line);

             String resource = line.substring(line.indexOf('/'),
                     line.lastIndexOf('/') - 5);

             System.out.println("the resource you request is: "
                     + resource);

             resource = URLDecoder.decode(resource, "UTF-8");

             String method = new StringTokenizer(line).nextElement()
                     .toString();

             System.out.println("the request method you send is: "
                     + method);

             while ((line = reader.readLine()) != null) {
                 if (line.equals("")) {
                     break;
                 }
                 System.out.println("the Http Header is : " + line);
             }

             if ("post".equals(method.toLowerCase())) {
                 System.out.println("the post request body is: "
                         + reader.readLine());
             }


		
                 PrintStream writer = new PrintStream(
                         client.getOutputStream(), true);
                 writer.println("HTTP/1.0 404 Not found");// 返回应答消息,并结束应答
                 writer.println();// 根据 HTTP 协议, 空行将结束头信息
                 writer.close();
                 client.close();
//			System.out.println("一个客户端建立了连接...");
//			StringBuilder builder = new StringBuilder();
//	        InputStreamReader isr = new InputStreamReader(client.getInputStream(),"gbk");
//	        char[] charBuf = new char[1024];
//	        int mark;
//	        while ((mark = isr.read(charBuf)) != -1) {
//	            builder.append(charBuf, 0, mark);
//	            if (mark < charBuf.length) {
//	                break;
//	            }   
//	        }
//	        System.out.println(builder.toString());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

//停止服务
	public void stop() {

	}
}
