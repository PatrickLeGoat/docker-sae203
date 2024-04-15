
public class NetworkThread extends Thread {
	
	Jeu jeu;
	ServeurClient sc;
	
	/** Creates a new instance of NetworkThread */
	public NetworkThread(ServeurClient sc, Jeu j) {
		this.sc = sc;
		this.jeu = j;
	}
	
	public void run() {
		jeu.jouer(sc.attenteCoup());
	}
}
