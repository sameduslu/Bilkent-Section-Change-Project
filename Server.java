import java.io.*;
import java.lang.ModuleLayer.Controller;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Register++ server class.
 * Abdullah Samed Uslu shared this video with me and edited its source code. We got help from this video in both Server and Client classes
 * "Java Socket Programming - Multiple Clients Chat."YouTube,uploaded by WittCode,17 Agu. 2021,https://www.youtube.com/watch?v=gLfuZrrfKes
 * in this version it is assumed that two students called Ali Ozturk with 123 as id and abc as password
 * and Cengiz Turkoglu with 321 as id and abc as password.
 */
public class Server {
    private final ServerSocket serverSocket;
    
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }
    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.startServer();
    }


    public class ClientHandler implements Runnable {
        public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

        private Socket socket;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;
        private String inputIdAndPassword;
        private String clientID;
        private String clientPassword;

        public ClientHandler(Socket socket) {
            try {
                this.socket = socket;
                this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.bufferedWriter= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                int counter = 0; // counts the number of tries during logging in process.
                String previous = "";// the constructor of Client class holds the id and password in the first input
                // without checking its validity and previous holds the first input for further steps.
                String firstPassword = "";// the password version of the previous.
                do{
                    this.inputIdAndPassword = bufferedReader.readLine();
                    if(counter>0)
                    {
                        inputIdAndPassword = inputIdAndPassword.substring(previous.length());
                    }
                    this.nameAndIdSetter(inputIdAndPassword);
                    if(counter ==0){
                    previous = clientID + "#";// after a invalid input the messages that client send comes in the form of  //firstandwrong clientID# with this the if statement in the loops works precisely.
                    firstPassword = clientPassword;
                    }                        
                    
                    counter++;
                }while(!this.nameAndIdController());
                clientHandlers.add(this);
                if(counter>1){
                    broadcastMessage(previous+"update id"+clientID);// assigns the true userID by sending a specified message 
                                                                    //to that client.
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
        public boolean nameAndIdController()
        {
            //In the original program the database is going to be used in this method, but in order to test
            //functionability a  student ID and password(123,321 and abc) is used; so for the valid input, client must type: 123/abc or 321/abc. 
            boolean studentNameAndIdIsValid = false;
            if(this.clientID.equals("123")||this.clientID.equals("321"))
            {
                if(clientPassword.equals("abc"))
                {
                    studentNameAndIdIsValid = true;
                }
            }
            return studentNameAndIdIsValid;
        }
        public void nameAndIdSetter(String clientUsername)
        {
            int slashIndex = -1; // slashIndex is instentiated.
            // It is assumed that the clientUserName is in this form: Idnumber/Password
            for(int i = 0;i<clientUsername.length();i++)// It is assumed that the input value is in the correct form.
            {
                if(clientUsername.charAt(i)=='/')
                {
                    slashIndex = i;
                }
            }
            this.clientID = clientUsername.substring(0, slashIndex);
            this.clientPassword = clientUsername.substring(slashIndex+1);
        }
        public void friendRequestPerformer(String command)
        {
            int index = command.indexOf("/");
            String id = command.substring(0,index );
            String name = command.substring(index+1);
            boolean isRequestValid = false;
            // for test case I assumed 123/AliOzturk and 321/CengizTurkoglu are students.
            if(id.equals("123")&&name.equals("AliOzturk")){
                isRequestValid = true;
            }else if(id.equals("321")&&name.equals("CengizTurkoglu"))
            {
                isRequestValid = true;
            }
            broadcastMessage(isRequestValid+ " request");
        }



        @Override
        public void run() {
            String messageFromClient;
            // Continue to listen for messages while a connection with the client is still established.
            while (socket.isConnected()) {
                try {
                    // send the message to public message group
                    messageFromClient = bufferedReader.readLine();
                    if(messageFromClient.equals("123#understood"))
                    {
                        broadcastMessage("server test");
                    }
                    if(messageFromClient.contains(this.clientID+"#"+"c/"+"01"))//01 is code of request friend method 
                    {//so this if statement looks if the Client have sended a command with friend request mothod code.
                        broadcastMessage("friend request received");
                        friendRequestPerformer(messageFromClient.substring(clientID.length()+5));// +5 means length of "#"+"c/"+"01".
                    }
                    broadcastMessage(messageFromClient);
                } catch (IOException e) {
                    // Close everything gracefully.
                    closeEverything(socket, bufferedReader, bufferedWriter);
                    break;
                }
            }
        }
        
        public void broadcastMessage(String messageToSend) {
            for (ClientHandler clientHandler : clientHandlers) {
                try {
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();

                } catch (IOException e) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }
        }
        public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
            removeClientHandler();
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void removeClientHandler() {
            clientHandlers.remove(this);
            broadcastMessage("SERVER: " + inputIdAndPassword + " has left the chat!");
        }
    
    }
}
