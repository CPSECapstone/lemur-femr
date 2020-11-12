# Setting up the project with IntelliJ

### Required downloads
1. [MySQL 5.7](http://www.mysql.com/)
2. [Scala Build Tool](http://www.scala-sbt.org/)
3. [Java JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
4. [IntelliJ IDEA Ultimate](http://www.jetbrains.com/idea/)
5. [Git](http://git-scm.com/)


### 1. Configure Java JDK 1.8
Download JDK 1.8 using [this link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
or use the following command: 
```bash
sudo apt-get update
sudo apt-get install openjdk-8-jdk
java -version
```
You should see the following version:
```bash
openjdk version "1.8.0_265"
OpenJDK Runtime Environment (build 1.8.0_265-8u265-b01-0ubuntu2~20.04-b01)
OpenJDK 64-Bit Server VM (build 25.265-b01, mixed mode)
```
If the correct version of Java isn't shown, run the following command to switch to JDK 8:
```bash
sudo update-alternatives --config java
```
When prompted, select the JDK 8 alternative.

### 2. Setup and install SBT
Download Scala Build Tool using [this link](http://www.scala-sbt.org/) or with the following command:
```bash
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
sudo apt-get update
sudo apt-get install sbt
```
SBT runs within the JVM so whichever Java version is set to your ```JAVA_HOME``` path will be used.

### 3. MySQL database setup
Install and configure MySQL using [this link](http://www.mysql.com/) or with the following command:
```bash
sudo apt update
sudo apt install mysql-server
sudo mysql_secure_installation
```
Start mysql:
```bash
sudo mysql
```
Create a database with the name femr:
```bash
mysql> CREATE DATABASE femr;
```
Create a user for the database (you will use this later to login to the fEMR app):
```bash
mysql> CREATE USER 'user_name'@'localhost' IDENTIFIED BY 'user_password';
```
Grant access to the mysql database to that user:
```bash
mysql> GRANT ALL PRIVILEGES ON femr.* TO 'user_name'@'localhost';
```

### 4. Clone the fEMR project
Simply cd into the directory where you want the project to be then clone the fEMR repo:
```bash
git clone https://github.com/FEMR/femr.git
```

### 5. IntelliJ setup
Install the Scala plugin for IntelliJ.

With IntelliJ open on the welcome screen, press control+shift+a or cmd+shift+a to bring up the quick search bar.
Type `new project from existing sources` and click: `import project from existing sources`

Select the folder where your fEMR project is located.s

In the project settings, select auto-import and choose your JDK. It should be Java version 1.8. Click finish.

Create a file named `application.dev.conf` inside `/femr/conf` and copy and paste the information from `application.example.conf`
into it. 

Change two lines in `application.dev.conf` to match up with your MySQL database user you created:
```java
db.default.username="user_name"
db.default.password="user_password"
```

In `application.conf` change four lines to match up with your MySQL database user you created:
```java
default.admin.username="user_name"
default.admin.password="user_password"

db.default.username="user_name"
db.default.password="user_password
```

If you have IntelliJ Ultimate, you're done! You can run the project. If not we need to do a bit more configuration.

Edit your project configuration. Add two new environment variables:
```bash
Name        |    Value
--------------------------
user.dir    |    .../femr
config.file |    .../femr/conf/application.dev.conf
```

Once those variables are setup, you should be able to run the project.
