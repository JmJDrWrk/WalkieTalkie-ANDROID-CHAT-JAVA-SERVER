import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Listener extends Thread{
	String identifier;
	Socket client;
	DataInputStream dtin;
	DataOutputStream dtout; 
	Socket other_client;
	
	public Listener(String identifier, Socket client, Socket other_client) throws IOException {
		this.identifier = identifier;
		this.client = client;
		this.other_client = other_client;
		this.dtin = new DataInputStream(client.getInputStream());
		this.dtout = new DataOutputStream(other_client.getOutputStream());
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println("\n\tesperando mensaje desde" + identifier);
				String msg = dtin.readUTF();
				System.out.println("\tmensaje de cliente "+ identifier +"recibido\n\t\tenviando respuesta\n\t\t\t" + msg);
				dtout.writeUTF(msg);
				dtout.flush();
				System.out.println("\t\trespuesta enviada-->");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}
