FROM debian:latest

# Installer des services et des packages
RUN  apt-get update 
    

# Copier les fichiers de l'hôte vers l'image
COPY ./puissance4 /app

# Exposer le port 80
EXPOSE 80

# Lancer le service apache au démarrage du conteneur
CMD ["tail", "-f", "/dev/null"]