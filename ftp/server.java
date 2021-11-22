import java.io.*;
import java.net.*;

class server {
	public static void main(String[] args) {
		try {
			while(true){
				ServerSocket ss=new ServerSocket(1010);
				Socket s1=ss.accept();
				System.out.println("Server socket is Created...");
				System.out.println("test1");
				DataInputStream fromserver=new DataInputStream(s1.getInputStream());
				System.out.println("test2");
				String option=fromserver.readLine();
				if(option.equalsIgnoreCase("upload")){
					System.out.println("upload test");
					String filefromclient=fromserver.readLine();
					File clientfile=new File(filefromclient);
					FileOutputStream fout=new FileOutputStream(clientfile);
					int ch;
					while((ch=fromserver.read())!=-1){
						fout.write((char)ch);
					}
					fout.close();
				}
				if(option.equalsIgnoreCase(" download")){
					System.out.println(" download test");
					String filefromclient=fromserver.readLine();
					File clientfile=new File(filefromclient);
					FileInputStream fis=new FileInputStream(clientfile);
					PrintStream out=new PrintStream(s1.getOutputStream());
					int n=fis.read();
					while(n!=-1)
					{
						out.print((char)n);
						n=fis.read();
					}
					fis.close();
					out.close();
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

}