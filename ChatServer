//client.java
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
        System.out.println("Hey "+name+" u can start chating");
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





//server.java
import java.net.*;
import java.io.*;
class A implements Runnable{	
    Thread t;
    Socket s;
    A(Socket x){
        s=x;
        t=new Thread(this);
        t.start();
    }
    public void run(){
        try{
            InputStream is=s.getInputStream();
            byte data[]=new byte[50];
            is.read(data);
            String mfc=new String(data);
            mfc=mfc.trim();
            System.out.println(mfc);
            System.out.println("Hey u can start chating");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String n=br.readLine();
            OutputStream os=s.getOutputStream();
            os.write(n.getBytes());
        }
        catch(Exception e){
             e.printStackTrace();
        }
    }
}
class server{
    static int c=0;
    public static void main(String args[]) throws Exception{
        System.out.println("Creating ServerSocket");
        ServerSocket ss=new ServerSocket(1010);
        System.out.println("ServerSocket is created");
        System.out.println("Waiting for the client");
        while(true){
          Socket s=ss.accept();
          new A(s);
        }
    }
}




//login.java
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
class login implements ActionListener {
    JFrame frame1; JTextField tf,tf1; JButton button;
    JLabel heading; JLabel label,label1;
    public static void main(String[] paramArrayOfString){
        new login();
    }
    public login(){
        this.frame1 = new JFrame("Login Page");
        this.tf = new JTextField(10);
        this.button = new JButton("Login");
        this.heading = new JLabel("Chat Server");
        this.heading.setFont(new Font("Impact", 1, 40));
        this.label = new JLabel("Enter you Login Name");
        this.label.setFont(new Font("Serif", 0, 24));
        JPanel localJPanel = new JPanel();
        this.button.addActionListener(this);
        localJPanel.add(this.heading); localJPanel.add(this.label);
        localJPanel.add(this.tf);
        localJPanel.add(this.button);
        this.heading.setBounds(30, 20, 280, 50);
        this.label.setBounds(20, 100, 250, 60);
        this.tf.setBounds(50, 150, 150, 30);
        this.button.setBounds(70, 190, 90, 30);
        this.frame1.add(localJPanel);
        localJPanel.setLayout(null);
        this.frame1.setSize(300,300);
        this.frame1.setVisible(true);
        this.frame1.setDefaultCloseOperation(3);
    }
    public void actionPerformed(ActionEvent paramActionEvent){
        String str = "";
        try{
            str = this.tf.getText();
            this.frame1.dispose();
            client c1= new client(str);
            c1.main(null);
        }
        catch(Exception localIOException){
        }
    }
}
