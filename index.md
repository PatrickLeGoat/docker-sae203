<p style="color: red; font-weight: bold">>>>>>  gd2md-html alert:  ERRORs: 0; WARNINGs: 0; ALERTS: 6.</p>
<ul style="color: red; font-weight: bold"><li>See top comment block for details on ERRORs and WARNINGs. <li>In the converted Markdown or HTML, search for inline alerts that start with >>>>>  gd2md-html alert:  for specific instances that need correction.</ul>

<p style="color: red; font-weight: bold">Links to alert messages:</p><a href="#gdcalert1">alert1</a>
<a href="#gdcalert2">alert2</a>
<a href="#gdcalert3">alert3</a>
<a href="#gdcalert4">alert4</a>
<a href="#gdcalert5">alert5</a>
<a href="#gdcalert6">alert6</a>

<p style="color: red; font-weight: bold">>>>>> PLEASE check and correct alert issues and delete this message and the inline alerts.<hr></p>


**<span style="text-decoration:underline;">Projet SAE 2.03 Equipe 09 </span>**

**<span style="text-decoration:underline;">Titre du projet : </span>**

Installation d’un jeu en réseau en java avec docker.

**<span style="text-decoration:underline;">Membre de l’équipe : </span>**

B2 - Elliot Lebreton

B1 - Clément Lemaire

B2 - Ladji Dianissy

**<span style="text-decoration:underline;">But de la SAE:</span>**



* Proposer un service réseau ( ou autre ) à l’aide de docker.
* Pour notre part nous avons pour projet de créer un jeu de société (puissance 4) en ligne qui utilise l’adresse IP du réseau. 

**<span style="text-decoration:underline;">Étapes de conception:</span>**

<span style="text-decoration:underline;"> </span>



* Création de l'arborescence pour recevoir tous les fichiers rangés.
* Création des branches main et gh-pages.
* Écriture du code du jeu.
* Écriture du code sur la partie réseau ( serveur et client ).
* Écriture de la partie IHM qui permet d’afficher la grille de jeu et la page d'accueil.

**<span style="text-decoration:underline;">Description des fichiers créés:</span>**



* dans le main: 
    * DockerFile: Permet de faire le pont entre les 2 joueurs ( comme une antenne relais ) 
    * Dossier puissance 4 avec tous les codes.

         

* dans le gh-pages:
    * index.md: texte du compte-rendu
    * config.yml: code du site web et thème de la page

**<span style="text-decoration:underline;">Utilisation du jeu :</span>**

Pour pouvoir jouer à notre jeu en ligne il faut un hôte et un client présent sur le même serveur.

L’hôte met en route le jeu et sélectionne la case “hôte”, il copie l’adresse ip du réseau de son pc et le colle dans la partie prévue pour.

Le client lui coche la case “client” et colle l’adresse ip de l’hôte.

La particularité de notre puissance 4 est que l’hôte de la partie peut choisir la taille de la grille pour jouer sur petit ou grand espace.

Une fois cela fait, il suffit d’appuyer sur entrée et de commencer à jouer avec son ami. 

**<span style="text-decoration:underline;">Démonstration du jeu :</span>**

1ère étape du jeu le choix du nombre de ligne et de colonne ( en général on reste sur 6 lignes et 7 colonnes )



<p id="gdcalert1" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image1.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert2">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image1.png "image_tooltip")


	Ensuite les deux joueurs cochent la cache “Jouer en réseau” puis l’hôte choisit d'être le “serveur” et son ami choisie d’être le “client”.



<p id="gdcalert2" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image2.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert3">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image2.png "image_tooltip")


Les deux personnes mettent l’adresse IP réseau de l’hôte puis cliquez sur ok pour lancer la partie.



<p id="gdcalert3" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image3.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert4">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image3.png "image_tooltip")


	Voici comment la grille de jeu est faite, le joueur 1 ( l'hôte ) commence la partie puis ne peut pas jouer tant que le joueur 2 ( le client ) n’a pas placé son jeton.



<p id="gdcalert4" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image4.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert5">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image4.png "image_tooltip")


	Lorsqu’un joueur essaye de jouer deux fois d'affilée, un message d’erreur apparaît.



<p id="gdcalert5" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image5.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert6">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image5.png "image_tooltip")


Quand un joueur gagne la partie, un message apparaît sur les écrans des deux joueurs informant que le joueur ( 1 ou 2 ) a gagné la partie.



<p id="gdcalert6" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image6.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert7">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image6.png "image_tooltip")


	Enfin, le jeu redemande de faire une partie au deux joueurs puis recréer une partie si un des deux joueurs a cliquer sur “oui” ou sinon affiche la grille remplie des pions si on appuie sur “non”.
