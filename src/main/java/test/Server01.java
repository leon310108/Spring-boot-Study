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

//��������
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����������ʧ��");
		}
	}

//�������Ӵ���
	public void receive() {
		try {
			Socket client=serverSocket.accept();
			 System.out.println("���ӷ������ɹ�����...");

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
                 writer.println("HTTP/1.0 404 Not found");// ����Ӧ����Ϣ,������Ӧ��
                 writer.println();// ���� HTTP Э��, ���н�����ͷ��Ϣ
                 writer.close();
                 client.close();
//			System.out.println("һ���ͻ��˽���������...");
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

//ֹͣ����
	public void stop() {

	}
}
