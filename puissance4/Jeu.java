import java.io.*;
import java.util.StringTokenizer;

public class Jeu {
	Grille plateau;		
	byte[][] matJeu;	
	int nbCoups;		
	boolean enCours;	
	boolean joueur;		
	int[] historique;	
	Options opts;		
	Computer deep;	
	boolean lock;  
	
	public Jeu(boolean optTrue) {
		if (optTrue)
			opts = new Options(this);
		nbCoups = 0;
		enCours = true;
	}

	
	public boolean joueurGagne(boolean joueur, int ligneM, int colM) {  
		byte jVal = 1; 
		if (joueur)
			jVal = 2;
		
		if (horiGagne(jVal, ligneM, colM) || vertGagne(jVal, ligneM, colM) || diag1Gagne(jVal, ligneM, colM) || diag2Gagne(jVal, ligneM, colM))
			return true;
		
		return false;
	}
	
	
	public boolean horiGagne(byte jVal, int ligneM, int colM) {
		int nbAlign = 0;  
		int colMin = colM - 3;
		if (colMin <= 0)
			colMin = 0;
		
		int colMax = colM + 3;
		if (colMax >= opts.getGameWidth())
			colMax = opts.getGameWidth() - 1;
		
		for (int i = colMin; i <= colMax; i++) {
			if (this.matJeu[ligneM][i] == jVal)
				nbAlign++;
			else
				nbAlign = 0;

			if (nbAlign == 4)
				return true;
		}
		return false;
	}
	
	
	public boolean vertGagne(byte jVal, int ligneM, int colM) {
		int nbAlign = 0;  
		int ligneMin = ligneM - 3;
		if (ligneMin <= 0)
			ligneMin = 0;
		
		int ligneMax = ligneM + 3;
		if (ligneMax >= opts.getGameHeight())
			ligneMax = opts.getGameHeight() - 1;
		
		
		for (int i = ligneMin; i <= ligneMax; i++) {
			if (this.matJeu[i][colM] == jVal)
				nbAlign++;
			else
				nbAlign = 0;
		
			if (nbAlign == 4)
				return true;
		}
		return false;
	}
	
	public boolean diag1Gagne(byte jVal, int ligneM, int colM) {
		int nbAlign = 0;
		int ligneMin = ligneM;
		int ligneMax = ligneM;
		int colMin = colM;
		int colMax = colM;
		
		int compteur = 0;
		while (ligneMax + 1 < opts.getGameHeight() && colMax + 1 < opts.getGameWidth() && compteur <= 2) {  //On va en bas a droite du plateau
			ligneMax++;
			colMax++;
			compteur++;   // on ne va que 3 cases en bas a droite au maximum
		}
		
		compteur = 0;
		while (ligneMin >= 1 && colMin >= 1 && compteur <= 2) {  //On va en haut a gauche du plateau de jeu
			ligneMin--;
			colMin--;
			compteur++;   // on ne va que 3 cases en bas a droite au maximum
		}
		
		ligneM = ligneMin;
		colM = colMin;
		do {
			if (this.matJeu[ligneM][colM] == jVal)
				nbAlign++;
			else
				nbAlign = 0;
			
			if (nbAlign == 4)
				return true;
				
			ligneM++;
			colM++;
			
		} while (ligneM <= ligneMax && colM <= colMax);
		
		return false;
	}
	
	public boolean diag2Gagne(byte jVal, int ligneM, int colM) {
		int nbAlign = 0;
		int ligneMin = ligneM;
		int ligneMax = ligneM;
		int colMin = colM;
		int colMax = colM;
		
		int compteur = 0;
		while (ligneMax + 1 < opts.getGameHeight() && colMin >= 1 && compteur <= 2) {  //On va en bas a gauche du plateau
			ligneMax++;
			colMin--;
			compteur++;   // on ne va que 3 cases en bas a droite au maximum
		}
		
		compteur = 0;
		while (ligneMin >= 1 && colMax + 1 < opts.getGameWidth() && compteur <= 2) {  //On va en haut a droite du plateau de jeu
			ligneMin--;
			colMax++;
			compteur++;   // on ne va que 3 cases en bas a droite au maximum
		}
		
		ligneM = ligneMax;
		colM = colMin;
		do {
			if (this.matJeu[ligneM][colM] == jVal)
				nbAlign++;
			else
				nbAlign = 0;
			
			if (nbAlign == 4)
				return true;
			
			ligneM--;
			colM++;
					
		} while (ligneM >= ligneMin && colM <= colMax);
		
		return false;
	}
	
		
	public void jouer(int col) {
		boolean coupValable;	
		int ligne = 0;		
		
		coupValable = false;
			
		ligne = this.searchLine(col);
		coupValable = this.coupValable(ligne, col);
		
		if (coupValable)
			validerCoup(ligne, col);
		
	}

	
	public void validerCoup(int ligne, int col) {
		
		if (!joueur) {
			this.matJeu[ligne - 1][col - 1] = 1;  // 1 designe dans la matrice un pion du joueur "false"
			Case cc = (Case)plateau.pane.getComponent((opts.getGameWidth()) * (ligne - 1) + (col - 1));
			cc.modifierVal(1);
		} else {
			this.matJeu[ligne - 1][col - 1] = 2;  // 2 designe dans la matrice un pion du joueur "true"
			Case cc = (Case)plateau.pane.getComponent((opts.getGameWidth()) * (ligne - 1) + (col - 1));
			cc.modifierVal(2);
		}

		boolean gagne = this.joueurGagne(joueur, ligne - 1, col - 1);
		if (gagne) {
			if (opts.netOn)
				networkPlay(col, false);
			enCours = false; // La partie est terminee
			if (!joueur)
				Saisie.infoMsgOk("Le joueur 1 a gagne", "Bravo");
			else
				Saisie.infoMsgOk("Le joueur 2 a gagne", "Bravo");
		}
		
		nbCoups++;  
		if (nbCoups >= opts.getGameHeight() * opts.getGameWidth() && !gagne) {
			if (opts.netOn)
				networkPlay(col, false);
			Saisie.infoMsgOk("Aucun des 2 joueurs n'a su gagner... : partie nulle", "Partie nulle");
			enCours = false;  
		}
		
		historique[nbCoups - 1] = col;
		joueur = !joueur;
		if (joueur) {
			plateau.statusBar.setText("Le joueur 2 joue");
			plateau.statusBar.setIcon(plateau.pionV);
		}
		else {
			plateau.statusBar.setText("Le joueur 1 joue");
			plateau.statusBar.setIcon(plateau.pionR);
		}
		if (!enCours) {		// Proposition de faire une nouvelle partie
			int ok = Saisie.question_ouinon("La partie est terminee, voulez-vous en faire une nouvelle ?", "Nouvelle partie");
			if (ok == 0)
				nouveauJeu();
		}
		else {
			
			if (opts.netOn)
				networkPlay(col, true);
		}
			
				
	}
	
	public boolean coupValable(int ligne, int col) {
		
		if (ligne == -1) {
			Saisie.erreurMsgOk("Vous ne pouvez pas jouer ce coup : la colonne est remplie", "Coup invalide");
			return false;
		}
		
		if (!enCours) {
			Saisie.erreurMsgOk("La partie est terminee, vous ne pouvez plus jouer", "Erreur : partie terminee");
			return false;
		}
		
		if (lock) {
			Saisie.erreurMsgOk("Ce n'est pas a vous de jouer", "Erreur");
			return false;
		}
		
		return true;
	}
	
	public int searchLine(int col) {
		for (int i = opts.getGameHeight(); i >= 1; i--) {
			if (matJeu[i - 1][col - 1] == 0)
				return i;
		}
		return -1; 
	}
	
	
	
	
	public void networkPlay(int col, boolean wait) {
		
		if (!wait) {
			opts.sc.envoyerCoup(col); // le serveur envoie le coup au client ou inversement
			opts.sc.closeSocket();
		}
		else if (opts.serveur && nbCoups % 2 == 1 || !opts.serveur && nbCoups % 2 == 0) {
			opts.sc.envoyerCoup(col); // le serveur envoie le coup au client ou inversement
			lock = true;  // pas le droit de jouer localement tant que le joueur distant n'a pas joue
			NetworkThread nt = new NetworkThread(opts.sc, this);
			nt.start();
		}
		
	}
	
	public static void nouveauJeu() {
		Jeu j = new Jeu(true);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Jeu partie = new Jeu(true);
		
	}
}
