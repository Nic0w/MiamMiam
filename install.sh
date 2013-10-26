#!/bin/sh

MYSQL_ROOT_PASSWORD="zkB4TfA3u3A9263"
TOMCAT_ADMIN_PASSWORD="86Y1U2g31M5XvH8"

INSTALL_DIR=`pwd`

echo "mysql-server-5.5 mysql-server/root_password $MYSQL_ROOT_PASSWORD" | sudo debconf-set-selections
echo "mysql-server-5.5 mysql-server/root_password_again $MYSQL_ROOT_PASSWORD" | sudo debconf-set-selections 

sudo apt-get -qq -y install openjdk-7-jre apache2-mpm-prefork libapache2-mod-jk mysql-server

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

sudo rm -f apache-tomcat-7.0.42/conf/tomcat-users.xml

sudo touch apache-tomcat-7.0.42/conf/tomcat-users.xml

echo "<?xml version='1.0' encoding='utf-8'?>" | sudo tee -a apache-tomcat-7.0.42/conf/tomcat-users.xml
echo "<tomcat-users>" | sudo tee -a apache-tomcat-7.0.42/conf/tomcat-users.xml
echo "  <role rolename=\"manager\"/>" | sudo tee -a apache-tomcat-7.0.42/conf/tomcat-users.xml
echo "  <role rolename=\"admin\"/>" | sudo tee -a apache-tomcat-7.0.42/conf/tomcat-users.xml
echo "  <user username=\"admin\" password=\"$TOMCAT_ADMIN_PASSWORD\" roles=\"admin,manager\"/>" | sudo tee -a apache-tomcat-7.0.42/conf/tomcat-users.xml
echo "</tomcat-users>" | sudo tee -a apache-tomcat-7.0.42/conf/tomcat-users.xml

cd /opt

sudo wget http://mir2.ovh.net/ftp.apache.org/dist/maven/maven-3/3.1.1/binaries/apache-maven-3.1.1-bin.tar.gz

sudo tar -xvf apache-maven-3.1.1-bin.tar.gz

sudo cp $INSTALL_DIR/conf/maven_conf.xml apache-maven-3.1.1/conf/settings.xml

export JAVA_HOME=/usr/lib/jvm/java-7-opendjk-i386
export PATH=/opt/apache-maven-3.1.1/bin:$PATH

cd $INSTALL_DIR

mysql --user=root --password=$MYSQL_ROOT_PASSWORD < miam_structure.sql
mysql --user=root --password=$MYSQL_ROOT_PASSWORD < miam_user.sql





