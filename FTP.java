//client.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
class first extends JFrame implements ActionListener {
	public JButton b,b1;
	public JLabel l;
	public  JLabel l1,lmsg1,lmsg2;
	first(){
		b=new JButton(" Upload");
		l=new JLabel(" Uplaod a file : ");
		lmsg1=new JLabel("");
		
		b1=new JButton(" Download");
		l1=new JLabel(" Downlaod a file");
		lmsg2=new JLabel("");
		
		setLayout(new GridLayout(2,3,10,10));
		add(l);add(b);add(lmsg1);add(l1);add(b1);add(lmsg2);
		b.addActionListener(this);
		b1.addActionListener(this);
		setVisible(true);
		setSize(600,500);
	}
	public  void actionPerformed(ActionEvent e){
	     try {
		if (b.getModel().isArmed()) {
			Socket s=new Socket("localhost",1010);
			System.out.println("Client connected to server");
			JFileChooser j=new JFileChooser();
			int val;
			val=j.showOpenDialog(first.this);
		                 String filename=j.getSelectedFile().getName();
		                 String path=j.getSelectedFile().getPath();
		                 PrintStream out=new PrintStream(s.getOutputStream());
		                 out.println("Upload");
		                 out.println(filename);
		                 FileInputStream fis=new FileInputStream(path);
		                 int n=fis.read();
		                 while (n!=-1){
			        out.print((char)n);n=fis.read();
		                 }
		                 fis.close(); out.close();lmsg1.setText(filename+" - uploaded");
		                 repaint();
		 }
		if (b1.getModel().isArmed()) {
			Socket s=new Socket("localhost",1010);
			System.out.println("Client connected to server");
			String remoteadd=s.getRemoteSocketAddress().toString();
			System.out.println(remoteadd);
			JFileChooser j1=new JFileChooser(remoteadd);
			int val;
			val=j1.showOpenDialog(first.this);
			String filename=j1.getSelectedFile().getName();
			String filepath=j1.getSelectedFile().getPath();
		
		 	System.out.println("File name:" +filename);
			PrintStream out=new PrintStream(s.getOutputStream());
			out.println(" Download");
			out.println(filepath);
	
			FileOutputStream fout=new FileOutputStream(filename);
			DataInputStream fromserver=new DataInputStream(s.getInputStream());
			int ch;
			while ((ch=fromserver.read())!=-1) {
				fout.write((char) ch);
			}
			fout.close();//s.close();
			lmsg2.setText(filename+" - downlaoded");
			repaint();
	     	        }
		} 
		
		catch (Exception ee) {
			System.out.println(ee);
		}
 	}
}
class client{
	 public static void main(String[] args){
		new first();
	}
}




//server.java
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
