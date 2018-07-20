import java.net.*;
import java.io.*;
 
class Client
{
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    
 
    // constructor with port
    public Client(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = server.accept();
            System.out.println("Client accepted");
 
           
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    Socket returnSocket()
    {
        return this.socket;
    }
}
 
 

public class Server
{
    public static void chat(Socket s1, Socket s2)
    {
        try
        {
            DataInputStream in1 = null;
            DataInputStream in2 = null;
            // takes input from the client socket
            in1 = new DataInputStream(new BufferedInputStream(s1.getInputStream()));
            in2 = new DataInputStream(new BufferedInputStream(s2.getInputStream()));
            String line1 = "";
            String line2 = "";
            // reads message from client until "Over" is sent
            while (!(line1.equals("Over") || line2.equals("Over")))
            {
                try
                {
                    if((line1 = (String)in1.readUTF()))
                    if(line1 != "")
                        System.out.println("Client1: " + line1);
                    
                    if((line2 = in2.readUTF()))
                    if(line2 != "")
                        System.out.println("Client2: " + line2);
 
                    line1 = "";
                    line2 = "";
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
 
            // close connection
            s1.close();
            in1.close();
            s2.close();
            in2.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

    }
    public static void main(String args[])
    {
        Client client1 = new Client(5000);
        Client client2 = new Client(5001);
        chat(client1.returnSocket(),client2.returnSocket());
    }
}