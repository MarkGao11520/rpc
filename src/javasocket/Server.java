package javasocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
	public static void main(String[] args) {
		Map<String, Object> services = new HashMap<String, Object>();
		services.put("javasocket.SayHelloService", new SayHelloServiceImpl());
		
		try {
			ServerSocket serverSocket = new ServerSocket(1234);
			while (true) {
				Socket socket = serverSocket.accept();
				ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
				String interfacename = inputStream.readUTF();
				String methodName = inputStream.readUTF();
				Class<?>[] paramterTypes = (Class<?>[]) inputStream.readObject();
				Object[] arguments = (Object[]) inputStream.readObject();
				
				System.out.println("interfacename:"+interfacename);
				System.out.println("methodName:"+methodName);
				for(Class class1:paramterTypes){
					System.out.println("paramterTypes:"+class1.getName());
				}
				for(Object object:arguments){
					System.out.println("arguments:"+object.toString());
				}
				
				Class serviceinterfaceclass = Class.forName(interfacename);
				System.out.println("serviceinterfaceclass:"+serviceinterfaceclass.getName());

				Object service = services.get(interfacename);
				
				System.out.println("service:"+service.getClass().getName());
				
				
				Method method = serviceinterfaceclass.getMethod(methodName, paramterTypes);
				
				System.out.println("method:"+method.getName());
				
				Object result = method.invoke(service, arguments);
				
				ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
				
				System.out.println("result:"+result);
				
				
				outputStream.writeObject(result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
