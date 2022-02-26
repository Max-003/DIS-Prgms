//nameserver.java
import java.net.*;
import java.io.*;
import java.util.*;
class dns{
	public static void main(String args[]){
		int n;
		BufferedReader i=new BufferedReader(new InputStreamReader(System.in));
		do{
			System.out.println("\nSelect : 1.Dns   2.Reverse-Dns   3.Exit\n");
			System.out.print("Select an option..");
			n=Integer.parseInt(System.console().readLine());
			if(n==1){
				try{
					System.out.print("Type Host Name - ");
					String h=i.readLine();
					InetAddress a;
					a=InetAddress.getByName(h);
					System.out.println("Host name : "+a.getHostName());
					System.out.println("Ip address : "+a.getHostAddress());
				}
				catch(IOException ioex){
					ioex.printStackTrace();
				}
			}
			if(n==2){
				try{
					System.out.print("Type Ip Address - ");
					String ip=i.readLine();
					InetAddress ia=InetAddress.getByName(ip);
					System.out.println("Ip address : "+ip);
					System.out.println("Host name : "+ia.getHostName());
				}
				catch(IOException ioex){
					ioex.printStackTrace();
				}
			}
		}while(!(n==3));
	}
}
