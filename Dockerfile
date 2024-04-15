FROM debian:latest

RUN  apt-get update && \
    apt-get -y install  \
    apache2
    
COPY ./html/ /usr/local/apache2/htdocs/

EXPOSE 80

CMD ["/usr/sbin/apache2ctl","-DFOREGROUND"]
