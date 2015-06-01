import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server
{
	//port to run the server on
	int port = 8080;
	PrintWriter out;
	BufferedReader in;
	
	public Server() throws IOException
	{
		//create new server listener on defined port
		ServerSocket listener = new ServerSocket(port);
		//server loop to accept connections
		while(true)
		{
			//listen from connection from client
			Socket socket = listener.accept();
			//print the client IP and port
			System.out.println("New Client Connected From: " + socket.getLocalAddress().toString().substring(1) + ":" + socket.getLocalPort());
			
			//client output stream to send data to
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out.println(new Date().toString());
			
			String dataFromClient = in.readLine();
			System.out.println("Data From Client: " + dataFromClient);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		new Server();
	}
}