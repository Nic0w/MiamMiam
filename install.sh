#!/bin/sh

sudo apt-get -q -y install openjdk-7-jre apache2-mpm-prefork libapache2-mod-jk mysql-server

echo "JkWorkersFile /etc/apache2/workers.properties" | sudo tee -a /etc/apache2/mods-available/jk.load
echo "JkLogFile /var/log/apache2/mod_jk.log" | sudo tee -a /etc/apache2/mods-available/jk.load
echo "JkLogLevel debug" | sudo tee -a /etc/apache2/mods-available/jk.load
echo "JkLogStampFormat \"[%a %b %d %H:%M:%S %Y] \"" | sudo tee -a /etc/apache2/mods-available/jk.load

sudo sed -i '23 a\JkMount /MiamMiam/* worker1' /etc/apache2/sites-enabled/000-default

sudo touch /etc/apache2/workers.properties
echo "workers.tomcat_home=/srv/apache-tomcat-7.0.42" | sudo tee -a /etc/apache2/workers.properties
echo "workers.java_home=/usr/lib/jvm/java-7-opendjk-i386" | sudo tee -a /etc/apache2/workers.properties
echo "ps=/" | sudo tee -a /etc/apache2/workers.properties
echo "worker.list=worker1" | sudo tee -a /etc/apache2/workers.properties
echo "worker.worker1.port=8009" | sudo tee -a /etc/apache2/workers.properties
echo "worker.worker1.host=localhost" | sudo tee -a /etc/apache2/workers.properties
echo "worker.worker1.type=ajp13" | sudo tee -a /etc/apache2/workers.properties
echo "worker.worker1.lbfactor=1" | sudo tee -a /etc/apache2/workers.properties

cd /srv

sudo wget http://apache.mirrors.multidist.eu/tomcat/tomcat-7/v7.0.42/bin/apache-tomcat-7.0.42.tar.gz

sudo tar -xvf apache-tomcat-7.0.42.tar.gz


