package zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

public class CreateSession {  
	  
    public static void main(String[] args) {  
        //zk集群的地址  
        String ZKServers = "123.150.135.65:2181";  
      
        /** 
         * 创建会话 
         * new SerializableSerializer() 创建序列化器接口，用来序列化和反序列化 
         */  
        ZkClient zkClient = new ZkClient(ZKServers,10000,10000,new SerializableSerializer());  
          
        System.out.println("conneted ok!");  
          
    }  
}  
