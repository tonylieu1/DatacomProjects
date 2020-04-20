import java.net.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.lang.reflect.Array;

public class SimpleServer {

	private ServerSocket listenSocket = null;
	private Socket connectSocket = null;

	public Socket getConnectSocket() {
		return connectSocket;
	}

	public SimpleServer(int portNo) {
		// add your code

	}

	public static void main(String[] args) throws IOException {

		int portNo;
		File outputFile;
		File dir = new File(".");

		if (args.length > 0) {
			portNo = Integer.parseInt(args[0]);
		} else {
			portNo = 10001;
		}
		if (args.length == 2) {
			outputFile = new File(args[1]);
		} else {
			outputFile = new File(dir.getCanonicalPath() + File.separator + "Files/testOutput");
		}
		OutputWriter out = new OutputWriter(outputFile);

		SimpleServer testServer = new SimpleServer(portNo);

		/* DO NOT CHANGE ABOVE THIS LINE in MAIN method other than the following values
		 * portNo can be changed to any number between 10000 and 11000
		 */

		/*
		 * Your code goes below. You can define new methods as necessary.
		 * 
		 * NOTE: You must use out.writeoutput method to write to the output
		 * file. The syntax is writeOutput(String line)
		 */
		OutputStream opStream = null;
		try {
			 int MAX_LEN = 100;
			 String localport = Integer.toString(portNo);
			 int localPortNum = Integer.parseInt(localport);
			 DatagramSocket mySocket = new DatagramSocket(localPortNum);
			 byte[] buffer = new byte[MAX_LEN];
			 
			 for(int numberlines = 0; numberlines < 5;numberlines++) {
			 DatagramPacket packet = new DatagramPacket(buffer, MAX_LEN);
			 mySocket.receive(packet);
			 byte [] ms = packet.getData();
			 ms = Arrays.copyOf(ms, packet.getLength());
			 packet.setData(ms);
			 String msgs1 =Arrays.toString(ms);
			 String words = new String(ms);
			 System.out.println(msgs1);
			 System.out.println(words);
			 out.writeOutput(words);
			 }
			
			 System.out.println("file tranfered");
			mySocket.close( );
			 System.out.println("the port is now close");  
			 
	}catch(Exception e) {
		e.printStackTrace();
	}
		 
		
	}
}