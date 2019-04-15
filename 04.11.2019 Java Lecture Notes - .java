// 04/11/2019 Java Class Lecture Notes - 

// Must be ready to accept the connection
public class CS3913 {
	static int portNum = 7;
	public static void main(String[] args) {
		try {
			Socket s = new Socket("https://www.google.com", 80);
		if (s.isConnected()) {

		} 
		else{
			System.out.println("Welp... that didn't work.");
		}


		ServerSocket ss = null;
		int id = 0;
		try {
			ss = new ServerSocket(portNum);
			System.out.println("Waiting for connection on port" + portNum);
			while (true) {
				Socket client = ss.accept();
				System.out.println("connection number: " + (++id) + "From: "+ client.getInetAddress());
				Scanner sin = new Scanner(client.getInputStream());
				Print Stream sout = new PrintStream(client.getOutputStream());
				sout.print("Welcome to my Echo server!\r\n");
				String line = "";
				while (!line.equalsIgnoreCase("EXIT")){
					line = sin.nextLine();
					System.out.println("client (" + id+ ") said: "+line);
					sout.println(line);
				}
				client.close();
				System.out.println("Client ("+id+") disconnected.");
			}
		}
		catch (IOException e){
			System.out.println("Could not get the socket to listen to");
		}
	}
}

class ProcessConnection extends Thread {
	Socket client;
	int id;
	ProcessConnection(Socket news, int newId) {
		client = news;
		id = newid;

	}

	public void run() {
		try {
		// 	ss = new ServerSocket(portNum);
		// 	System.out.println("Waiting for connection on port" + portNum);
		// 	while (true) {
		// 		Socket client = ss.accept();
				System.out.println("connection number: " + (++id) + "From: "+ client.getInetAddress());
				Scanner sin = new Scanner(client.getInputStream());
				Print Stream sout = new PrintStream(client.getOutputStream());
				sout.print("Welcome to my Echo server!\r\n");
				String line = "";
				while (!line.equalsIgnoreCase("EXIT")){
					line = sin.nextLine();
					System.out.println("client (" + id+ ") said: "+line);
					sout.println(line);
				}
				client.close();
				System.out.println("Client ("+id+") disconnected.");
			}
		}
	}
}