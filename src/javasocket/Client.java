package javasocket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class Client {
		public static void main(String[] args) {
			String interfacename = SayHelloService.class.getName();
			try {
				Method method = SayHelloService.class.getMethod("sayHello", java.lang.String.class);
				Object[] arguments = {"hello1"};
				Socket socket = new Socket("127.0.0.1", 1234);
				
				ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
				outputStream.writeUTF(interfacename);
				outputStream.writeUTF(method.getName());
				outputStream.writeObject(method.getParameterTypes());
				outputStream.writeObject(arguments);
				
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				Object result = input.readObject();
				System.out.println(result.toString());
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
