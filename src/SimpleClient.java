
import java.net.*;
import java.nio.file.Files;
import java.io.*;
import java.util.*;

public class SimpleClient {

	String serverAddress;
	int portNo;
	Socket socket = null;
	
	public SimpleClient(String serverAddress, int portNo) {
		
	}
		// Your code goes here.
  
    

	public static void main(String[] args) throws IOException {

		File inputFile;
		File dir = new File(".");

		String serverIPAddr;
		int portNo;

		SimpleClient client;

		if (args.length > 2) {
			serverIPAddr = args[0];
			portNo = Integer.parseInt(args[1]);
			inputFile = new File(args[2]);
		} else {
			serverIPAddr = "127.0.0.1";
			portNo = 10001;
			inputFile = new File(dir.getCanonicalPath() + File.separator + "Files/testInput");
		}

		/* Read the data from File into an ArrayList */
		List<String> lines = Files.readAllLines(inputFile.toPath());

		client = new SimpleClient(serverIPAddr, portNo);

		/*
		 * DO NOT CHANGE ABOVE THIS LINE in MAIN method except for the following
		 * serverIPAddr and portNo values can be changed as necessary for
		 * testing
		 **/

		/*
		 * Your code goes below. You can define new methods as necessary.
		 * 
		 * NOTE: You must use out.writeoutput method to write to the output
		 * file. The syntax is writeOutput(String line)
		 */
	
		
		try {
    		InetAddress receiverHost = InetAddress.getByName("207.5.37.10");
    		String localPort = Integer.toString(portNo);
			 int receiverPort = Integer.parseInt(localPort);
			 	DatagramSocket mySocket = new DatagramSocket( );
			for(int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
			String msg = lines.get(lineNumber);
			 byte[] buffer = msg.getBytes();
			 DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverHost,
			 receiverPort);
			 byte [] ms = packet.getData();
			 mySocket.send(packet);
		
		}
			 
			 
			 mySocket.close( );
	}catch(Exception e) {}
    	
		
	}
}