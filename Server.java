package Network;

import java.io.*;
import java.lang.ModuleLayer.Controller;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Register++ server class.
 */
public class Server {

    public static void main(String[] args)throws IOException, ClassNotFoundException {
        new Server().runServer();
    }
    public void runServer() throws IOException, ClassNotFoundException
    {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server ready");
        Socket socket = serverSocket.accept();
        int counter = 0;
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        
        while(socket.isConnected() && counter < 10)
        {   
            Object myobj = objectInputStream.readObject();
            if(myobj instanceof String)
            {
                String mystr = (String)myobj;
                System.out.println(mystr);
            }
            
            // if(objectInputStream.readObject()!=null){
            //     System.out.println("not null");
            //     String a = (String)objectInputStream.readObject();
            //     if(a instanceof String)
            //     {
            //         System.out.println("String id received: " + a);
            //     }
            // }


        }

        socket.close();
        serverSocket.close();
    }
   
}
