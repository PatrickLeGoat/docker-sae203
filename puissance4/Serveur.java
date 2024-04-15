import java.io.*;
import java.net.*;

/*
 * Serveur.java
 *
 * Created on 6 mars 2004, 14:28
 */

/**
 *
 * @author  Michael Perrin
 */

public class Serveur extends ServeurClient {
	
	ServerSocket ss;
	Socket clientSocket;
	
	/** Creates a new instance of Serveur for a specified game "jeu" */
	public Serveur(Jeu jeu) {
		
		super(jeu);
		
		try {
			ss = new ServerSocket(PORT);
			System.out.println("J'attends qu'un client se connecte");
			jeu.plateau.setVisible(false); // hides the game until somebody gets connected
			clientSocket = ss.accept();
			System.out.println("Un client s'est connecte");
			jeu.plateau.setVisible(true); // shows the game
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			// Sends the game size to the client
			out.println(jeu.opts.getGameHeight());
			out.println(jeu.opts.getGameWidth());
			
		}
		catch(IOException e) {
			System.out.println("Oops, la creation du serveur plante");
		}
	}
	
	/** Closes the connection */	
	void closeSocket() {
	
		try {
			this.clientSocket.close();
			ss.close();
		}
		catch (IOException e) {
			System.out.println("Erreur lors de la fermeture des sockets");
		}
		
	}
	
}
