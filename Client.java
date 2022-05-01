import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// A client sends messages to the server, the server spawns a thread to communicate with the client.
// Each communication with a client is added to an array list so any message sent gets sent to every other client
// by looping through it.

public class Client {

    // A client has a socket to connect to the server and a reader and writer to receive and send messages respectively.
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private static String username;
    private static String userID;
    
    private static  String commandIdentifier = "c/";

    public Client(Socket socket, String username) {
        try {
            this.socket = socket;
            this.username = username;
            int a = username.indexOf("/");
            this.userID = username.substring(0, a);
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            // Gracefully close everything.
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    // Sending a message isn't blocking and can be done without spawning a thread, unlike waiting for a message.
    public void sendMessage() {
        try {
            // Initially send the username of the client.
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            // Create a scanner for user input.
            Scanner scanner = new Scanner(System.in);
            // While there is still a connection with the server, continue to scan the terminal and then send the message.
            while (socket.isConnected()) {
                String messageToSend = scanner.nextLine();
                bufferedWriter.write(userID + "#" + messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            // Gracefully close everything.
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    // Listening for a message is blocking so need a separate thread for that.
    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroupChat;
                // While there is still a connection with the server, continue to listen for messages on a separate thread.
                while (socket.isConnected()) {
                    try {
                        // Get the messages sent from other users and print it to the console.
                        msgFromGroupChat = bufferedReader.readLine();
                        if(msgFromGroupChat.equals(userID + " login successful"))
                        {
                            sendMessage(" understood");
                        }
                        if(msgFromGroupChat.contains(userID+"#"+"update id"))// if the first input is wrong yhe client object
                        {// gets instentiated with that wrong input and server sends a message with sending a message in the
                         //form of userID+"#"+"update name"+ true id.
                            setName(msgFromGroupChat.substring(userID.length()+10));
                        }
                        System.out.println(msgFromGroupChat);
                    } catch (IOException e) {
                        // Close everything gracefully.
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    // Helper method to close everything so you don't have to repeat yourself.
    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        // Note you only need to close the outer wrapper as the underlying streams are closed when you close the wrapper.
        // Note you want to close the outermost wrapper so that everything gets flushed.
        // Note that closing a socket will also close the socket's InputStream and OutputStream.
        // Closing the input stream closes the socket. You need to use shutdownInput() on socket to just close the input stream.
        // Closing the socket will also close the socket's input stream and output stream.
        // Close the socket after closing the streams.
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
    public void sendMessage(String myMessageString) {
        try {// when Client automatically sends a command it uses a command identifier with this server understands this message is
            // a command and for making it specialised for a client it adds userID.
            String messageToSend = myMessageString;
            bufferedWriter.write(commandIdentifier+userID + "#" + messageToSend);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            // Gracefully close everything.
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    public void sendFriendRequest(String friendName, String friendID )
    {
        String commandCode = "01";// first created command with the code 01.
        String command = commandCode+friendName+"/"+friendID;
        sendMessage(command);
    }
    public static String getCommandIdentifier()
    {
        return commandIdentifier;
    }
    public static String getUserID()
    {
        return userID;
    }
    protected static void setName(String clientID) {
        userID = clientID;
    }
    // Run the program.
    public static void main(String[] args) throws IOException {

        // Get a username for the user and a socket connection.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ID and password for the group chat in the form of ID/password: ");
        String username = scanner.nextLine();
        // Create a socket to connect to the server.
        Socket socket = new Socket("localHost", 1234);

        // Pass the socket and give the client a username.
        Client client = new Client(socket, username);
    
        // Infinite loop to read and send messages.
        client.listenForMessage();
        client.sendMessage();
    }
}
