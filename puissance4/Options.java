public class Options {
	private int nbRow;			// Nombre de lignes
	private int nbCol;			// Nombre de colonnes
	boolean computerOn = false;	// Ordinateur active ou non
	boolean computerStarts = false;
	boolean netOn = false;
	boolean serveur = false;
	ServeurClient sc;
	Jeu jeu;
	
	public Options(Jeu j) {
		
		this.jeu = j;
		OptionsGUI optionsGUI = new OptionsGUI(this);
		
	}
	
	public Options(int nbRow, int nbCol, Jeu jeu) {
		this.jeu = jeu;
		setSize(nbRow, nbCol, true);
	}
	
	
	/** Regle les dimensions du jeu
	 * @param initSize Definit si le plateau de jeu doit etre initalise avec la taille entree
	 */
	public void setSize(int nbRow, int nbCol, boolean initSize) {
		this.nbRow = nbRow;
		this.nbCol = nbCol;
		if (initSize)
			initSize(nbRow, nbCol);
	}
	
	/** Initialise le plateau de jeu */
	public void initSize(int nbRow, int nbCol) {
		jeu.plateau = new Grille(nbRow, nbCol, jeu);
		jeu.plateau.setVisible(true);
		jeu.matJeu = new byte[nbRow][nbCol];
		jeu.historique = new int[nbRow * nbCol];
	}
	
	/** Retourne le nombre de colonnes du jeu */
	public int getGameWidth() {
		return nbCol;
	}
	
	/** Retourne le nombre de lignes du jeu */
	public int getGameHeight() {
		return nbRow;
	}
	
	
	public void initNetwork(boolean serveur, String ip) {
		try {
			netOn = true;
			this.serveur = serveur;
			if (!serveur) {
				sc = new Client(ip, jeu);
				
				// From here, the server will have sent the server game size, here is the code to receive the information
				String entree1 = null;
				while(entree1 == null)
					entree1 = sc.in.readLine();
				
				String entree2 = null;
				while(entree2 == null)
					entree2 = sc.in.readLine();
				
				int nbRow = Integer.parseInt(entree1);
				int nbCol = Integer.parseInt(entree2);
				
				setSize(nbRow, nbCol, true);
				
				jeu.lock = true;
				NetworkThread nt = new NetworkThread(sc, jeu);
				nt.start();
				
			}
			else {
				sc = new Serveur(jeu);
			}
		}
		catch(Exception e) {
			System.out.println("Erreur lors de creation du client ou du serveur");
		}
	}
	
}
