FROM debian:latest

<<<<<<< HEAD
# Installer des services et des packages
RUN  apt-get update 
    

# Copier les fichiers de l'hôte vers l'image
COPY ./html /var/www/html

# Exposer le port 80
EXPOSE 80

# Lancer le service apache au démarrage du conteneur
CMD ["/usr/sbin/apache2ctl","-DFOREGROUND"]
=======
RUN  apt-get update && \
    apt-get -y install  \
    apache2
    
COPY ./html/ /usr/local/apache2/htdocs/

EXPOSE 80

CMD ["/usr/sbin/apache2ctl","-DFOREGROUND"]
>>>>>>> dfaebf554d8cfd1c06fe62bdf5943bf95fd00300
