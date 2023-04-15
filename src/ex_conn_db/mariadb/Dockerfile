FROM debian:buster

RUN apt update -y && apt install mariadb-server -y
RUN sed -i 's/bind-address/bind-address = 0.0.0.0 #/i' /etc/mysql/mariadb.conf.d/50-server.cnf

COPY script.sql /tmp/

EXPOSE 3306

RUN /etc/init.d/mysql start && mysql -u root --password="root" -e "source /tmp/script.sql"
CMD mysqld_safe