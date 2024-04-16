**[Projet SAE 2.03 Equipe 09]{.underline}**

**[Titre du projet :]{.underline}**

Installation d'un jeu en réseau en java avec docker.

**[Membre de l'équipe :]{.underline}**

B2 - Elliot Lebreton

B1 - Clément Lemaire

B2 - Ladji Dianissy

**[But de la SAE:]{.underline}**

-   Proposer un service réseau ( ou autre ) à l'aide de docker.

-   Pour notre part nous avons pour projet de créer un jeu de société
    > (puissance 4) en ligne qui utilise l'adresse IP du réseau.

**[Étapes de conception:]{.underline}**

-   Création de l\'arborescence pour recevoir tous les fichiers rangés.

-   Création des branches main et gh-pages.

-   Écriture du code du jeu.

-   Écriture du code sur la partie réseau ( serveur et client ).

-   Écriture de la partie IHM qui permet d'afficher la grille de jeu et
    > la page d\'accueil.

**[Description des fichiers créés:]{.underline}**

-   dans le main:

    -   DockerFile: Permet de faire le pont entre les 2 joueurs ( comme
        > une antenne relais )

    -   Dossier puissance 4 avec tous les codes.

```{=html}
<!-- -->
```
-   dans le gh-pages:

    -   index.md: texte du compte-rendu

    -   config.yml: code du site web et thème de la page

**[Utilisation du jeu :]{.underline}**

Pour pouvoir jouer à notre jeu en ligne il faut un hôte et un client
présent sur le même serveur.

L'hôte met en route le jeu et sélectionne la case "hôte", il copie
l'adresse ip du réseau de son pc et le colle dans la partie prévue pour.

Le client lui coche la case "client" et colle l'adresse ip de l'hôte.

La particularité de notre puissance 4 est que l'hôte de la partie peut
choisir la taille de la grille pour jouer sur petit ou grand espace.

Une fois cela fait, il suffit d'appuyer sur entrée et de commencer à
jouer avec son ami.

**[Démonstration du jeu :]{.underline}**

1ère étape du jeu le choix du nombre de ligne et de colonne ( en général
on reste sur 6 lignes et 7 colonnes )

![](./image3.png){width="5.854166666666667in"
height="1.1979166666666667in"}

Ensuite les deux joueurs cochent la cache "Jouer en réseau" puis l'hôte
choisit d\'être le "serveur" et son ami choisie d'être le "client".

![](./image5.png){width="4.28125in" height="2.09375in"}

Les deux personnes mettent l'adresse IP réseau de l'hôte puis cliquez
sur ok pour lancer la partie.

![](./image4.png){width="5.0625in" height="3.7395833333333335in"}

Voici comment la grille de jeu est faite, le joueur 1 ( l\'hôte )
commence la partie puis ne peut pas jouer tant que le joueur 2 ( le
client ) n'a pas placé son jeton.

![](./image2.png){width="3.3125in" height="1.5208333333333333in"}

Lorsqu'un joueur essaye de jouer deux fois d\'affilée, un message
d'erreur apparaît.

![](./image1.png){width="2.75in" height="1.2291666666666667in"}

Quand un joueur gagne la partie, un message apparaît sur les écrans des
deux joueurs informant que le joueur ( 1 ou 2 ) a gagné la partie.

![](./image6.png){width="5.177083333333333in" height="1.5in"}

Enfin, le jeu redemande de faire une partie au deux joueurs puis recréer
une partie si un des deux joueurs a cliquer sur "oui" ou sinon affiche
la grille remplie des pions si on appuie sur "non".
