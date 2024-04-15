/*
 * Client.java
 *
 * Created on 6 mars 2004, 12:39
 */

/**
 *
 * @author  Michael Perrin
 */

import java.io.*;
import java.net.*;

public class Client extends ServeurClient {
    
	InetAddress adr;
	Socket socket;
   
	/** Creates a new instance of Client */
	public Client(String adrServeur, Jeu jeu) {
	
		super(jeu);
		
		try {
			adr = InetAddress.getByName(adrServeur);
			socket = new Socket(adr, PORT);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
		catch(Exception e) {
			System.out.println("Serveur non trouv� ou erreur lors de la connexion au serveur.");
			System.out.println("V�rifiez que celui-ci existe.");
			System.exit(-1);
		}
	}
	
	/** Closes the connection */	
	void closeSocket() {
	
		try {
			socket.close();
		}
		catch (IOException e) {
			System.out.println("Erreur lors de la fermeture des sockets");
		}
		
	}
    	
}
