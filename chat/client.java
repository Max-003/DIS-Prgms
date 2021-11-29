import java.net.*;
import java.io.*;

class client{
	static String name="";

	public client(String n){
		name=n;
	}

	public static void main(String args[]) throws Exception{
		System.out.println("Connecting to server");
		System.out.println("Client connected to server");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Hey\t"+name+" u can start chating");
		while(true){
			Socket s=new Socket("localhost",1010);
			String n=br.readLine();
			OutputStream os=s.getOutputStream();
			os.write(n.getBytes());
			InputStream is=s.getInputStream();
			byte data[]=new byte[50];
			is.read(data);
			String mfc=new String(data);
			mfc=mfc.trim();
			System.out.println(mfc);
		}
	}
}