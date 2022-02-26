//RPC_HelloWorld.java
package rpc_helloworld;
import java.net.MalformedURLException:
import java.net.URL:
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
public class RPC_HelloWorld {
	public static void main(String[] args) {
		try {
			//Refer to wedl document
  			URL url = new URL ("http://localhost:7779/ws/hello?wsdl");
  			//Refer to wsdl document
  			QName qname - new QName ("http://rpc_helloworld/", "HelloWorldImplService");
  			Service service = Service.create (url, qname);
  			HelloWorld hello = service.getPort (HelloWorld.class);
  			System.out.println (hello.getHelloWorld("Hello World!"));
  		} 	
		catch (MalformedURLException ex) {  
    		System.out.println("WSDL document url error: " + ex);
		}
	}
}



//HelloWorld.java
package rpe helloworld;
import javax.jus. WebMethod;
import javax.jus.WebService:
import javax.jus.soap.SOAFBinding:
import javax.jws.soap.SOAFBinding.Style:
@WebService 
@SOAPBinding(style-Style.RPC)
public interface HelloWorld (
	@WebMethod String getHllelloWorld(String name);
}



//HelloWorldImpl.java
package rpc_helloworld;
import javax.jws.WebService:
@WebService (endpoint Interface = "rpc_helloworld.HelloWorld") 
public class HelloWorldImpl implements HelloWorld {
	@Override
	public String getHelloWorld (String name) {
  		return name;
  	}
}



//Publisher.java
package rpc_helloworld;
import javax.xml.ws.Endpoint:
public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish ("http://localhost:7779/ws/hello", new HelloWorldImpl());
	}
}
