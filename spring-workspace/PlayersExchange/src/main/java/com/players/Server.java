package com.players;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void startServer() throws IOException  
    { 
        // server is listening on port 5056 
        ServerSocket ss = new ServerSocket(5056); 
          
        // running infinite loop for getting 
        // client request 
        while (true)  
        { 
            Socket s = null; 
              
            try 
            { 
                // socket object to receive incoming client requests 
                s = ss.accept(); 
                  
                System.out.println("A new client is connected : " + s); 
                  
                // obtaining input and out streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                  
                System.out.println("Assigning new thread for this client"); 
  
                // create a new thread object 
                Thread t = new Handler(s, dis, dos); 
  
                // Invoking the start() method 
                t.start(); 
                
            } 
            catch (Exception e){ 
                s.close(); 
                e.printStackTrace(); 
            } 
        } 
    } 
	
	private static void client() throws IOException {
	      // getting localhost ip 
        InetAddress ip = InetAddress.getByName("localhost"); 
  
        System.out.println("IP: " + ip);
        // establish the connection with server port 5056 
        Socket s = new Socket(ip, 5056);
	}
}
