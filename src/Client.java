import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	String host = "127.0.0.1";
	int port = 8080;
	BufferedReader input;
	PrintWriter output;

	public Client() throws UnknownHostException, IOException
	{
		Socket socket = new Socket(host, port);
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String dataFromServer = input.readLine();
		System.out.println("Data from server: " + dataFromServer);
		output = new PrintWriter(socket.getOutputStream(), true);
		output.println("You sent: " + dataFromServer);
	}
	
	public static void main(String[] args) throws IOException
	{
		new Client();
	}
}