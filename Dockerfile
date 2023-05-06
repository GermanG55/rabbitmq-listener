FROM centos:centos7.9.2009

RUN yum install httpd -y

WORKDIR /var/www/html

COPY rabbitmq .

CMD apachectl -D FOREGROUND