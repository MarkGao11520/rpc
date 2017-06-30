package javasocket;

public class SayHelloServiceImpl implements SayHelloService {

	@Override
	public String sayHello(String helloArg) {
		// TODO Auto-generated method stub
		if(helloArg.equals("hello")){
			return"hello";
		}else{
			return "byebye";
		}
		
	}
	
//	public static void main(String[] args) {
//		String ip = "127.0.0.1";
//		int result = ip.hashCode();
//		System.out.println("result:"+result);
//		System.out.println(result%5);
//	}

}
