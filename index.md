<u> <b> Projet SAE 2.03 Equipe 09 </b> </u>

<u> <b> Titre du projet : </b> </u>

Installation d'un jeu en réseau en java avec docker.

<u> <b> Membre de l'équipe : </b> </u>

B2 - Elliot Lebreton

B1 - Clément Lemaire

B2 - Ladji Dianissy

<u> <b> But de la SAE: </b> </u>

-   Proposer un service réseau ( ou autre ) à l'aide de docker.

-   Pour notre part nous avons pour projet de créer un jeu de société
    > (puissance 4) en ligne qui utilise l'adresse IP du réseau.

<u> <b> Étapes de conception: </b> </u>

-   Création de l\'arborescence pour recevoir tous les fichiers rangés.

-   Création des branches main et gh-pages.

-   Écriture du code du jeu.

-   Écriture du code sur la partie réseau ( serveur et client ).

-   Écriture de la partie IHM qui permet d'afficher la grille de jeu et
    > la page d\'accueil.

<u> <b> Description des fichiers créés: </b> </u>

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

<u> <b> Utilisation du jeu : </b> </u>
Pour pouvoir jouer à notre jeu en ligne il faut un hôte et un client
présent sur le même serveur.

L'hôte met en route le jeu et sélectionne la case "hôte", il copie
l'adresse ip du réseau de son pc et le colle dans la partie prévue pour.

Le client lui coche la case "client" et colle l'adresse ip de l'hôte.

La particularité de notre puissance 4 est que l'hôte de la partie peut
choisir la taille de la grille pour jouer sur petit ou grand espace.

Une fois cela fait, il suffit d'appuyer sur entrée et de commencer à
jouer avec son ami.

<u> <b> Démonstration du jeu : </b> </u>

1ère étape du jeu le choix du nombre de ligne et de colonne ( en général
on reste sur 6 lignes et 7 colonnes )

![image3](https://github.com/PatrickLeGoat/docker-sae203/assets/159245876/a4819460-aa00-4498-a152-b3dbc1e1072c)


Ensuite les deux joueurs cochent la cache "Jouer en réseau" puis l'hôte
choisit d\'être le "serveur" et son ami choisie d'être le "client".

![image5](https://github.com/PatrickLeGoat/docker-sae203/assets/159245876/bda01a1d-e122-441e-ae23-e749b4cd6118)


Les deux personnes mettent l'adresse IP réseau de l'hôte puis cliquez
sur ok pour lancer la partie.

![image4](https://github.com/PatrickLeGoat/docker-sae203/assets/159245876/d2d3a79c-cb8a-4ec8-b992-3a28695cf200)


Voici comment la grille de jeu est faite, le joueur 1 ( l\'hôte )
commence la partie puis ne peut pas jouer tant que le joueur 2 ( le
client ) n'a pas placé son jeton.

![image2](https://github.com/PatrickLeGoat/docker-sae203/assets/159245876/db8a8d52-95de-45bc-bc83-0cf1b13d5af4)


Lorsqu'un joueur essaye de jouer deux fois d\'affilée, un message
d'erreur apparaît.

![image1](https://github.com/PatrickLeGoat/docker-sae203/assets/159245876/31a4d072-1b50-4797-afda-1fbab9b169eb)


Quand un joueur gagne la partie, un message apparaît sur les écrans des
deux joueurs informant que le joueur ( 1 ou 2 ) a gagné la partie.

![image6](https://github.com/PatrickLeGoat/docker-sae203/assets/159245876/b08b9403-104e-43db-a877-64bcb619e249)


Enfin, le jeu redemande de faire une partie au deux joueurs puis recréer
une partie si un des deux joueurs a cliquer sur "oui" ou sinon affiche
la grille remplie des pions si on appuie sur "non".
