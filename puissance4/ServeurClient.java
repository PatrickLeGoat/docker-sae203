import java.io.*;
import java.net.*;

/*
 * ServeurClient.java
 *
 * Created on 6 mars 2004, 16:39
 */

/**
 *
 * @author  Michael Perrin
 */
 
abstract class ServeurClient {

	Jeu jeu;
	
	PrintWriter out;
	BufferedReader in;
	String entree;
	
	static final int PORT = 30000;
	
	/** Creates a new instance of ServeurClient */
	public ServeurClient(Jeu jeu) {
		this.jeu = jeu;
	}
	
	public int attenteCoup() {
		System.out.println("j'attends que l'autre joue");
		while(true) {
			try {
				entree = in.readLine();
				if (entree != null) {
					System.out.println("J'ai reeu un coup de la part de l'autre");
					jeu.lock = false; // on retire le lock pour pouvoir valider le coup reeu
					return Integer.parseInt(entree);
				}
			}
			catch(Exception e) {
				System.out.println("Pb dans l'attente de coup. Je quitte");
				System.exit(-1);
			}
		}
			
	}
	
	public void envoyerCoup(int col) {
		System.out.println("J'envoie le coup");
		out.println(col);
		System.out.println("C'est fait");
	}
	
	/** Closes the connection */	
	abstract void closeSocket();
	
}
