import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TestServer {

	public static void main(String[] args) throws IOException {
		
		try {
			//Crear las propiedades del server
			String host = "192.168.25.11";
			
			int port = 6112;
			
			ServerSocket server = new ServerSocket(port);
			
			System.out.println("-->" + server.getLocalSocketAddress());
			//Ejecutar los clientes como hilos
			
			Socket client = null;
			Socket client2 = null;
			System.out.println("Esperando cliente");
			client = server.accept();
			System.out.println("Cliente conectado");
			System.out.println("Esperando Cliente 2");
			client2 = server.accept();
			System.out.println("Cliente connectado");
			//System.out.println("Cliente conectado\n" + "Numero de clientes conectados = " + clients.size());
			
			//Teniendo los dos cliente... los pongo a escuchar
			
			Listener clientListener = new Listener("1",client,client2);
			Listener client2Listener = new Listener("2",client2,client);
				
			//Iniciando listeners
			
			clientListener.start();
			client2Listener.start();

	
		}catch(Exception e) {
			System.out.println("Server Error");
		}
		


	}

}
