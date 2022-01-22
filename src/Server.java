import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Server {

	public static void main(String[] args) throws IOException {
		
		//Array de clientes
		ArrayList<Socket> clients = new ArrayList<Socket>();
		
		//Crear las propiedades del server
		String host = "192.168.25.11";
		
		int port = 6112;
		
		ServerSocket server = new ServerSocket(port);
		
		System.out.println("-->" + server.getLocalSocketAddress());
		//Ejecutar los clientes como hilos
		
		Socket client = null;
		while (clients.size()<2) {
			System.out.println("Esperando cliente");
			client = server.accept();
			clients.add(client);
			System.out.println("Cliente conectado\n" + "Numero de clientes conectados = " + clients.size());
		}
		
		

		
		
		
		DataInputStream dtin = new DataInputStream(client.getInputStream());
		byte[] msg = dtin.readAllBytes();
		String msgstr = new String(msg, StandardCharsets.UTF_8);
		System.out.println("--> " + msgstr);
	}

}
