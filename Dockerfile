FROM ubuntu:latest

MAINTAINER Femi Ojo "nifemiojo13@gmail.com"

RUN apt-get update && apt-get install -y software-properties-common

RUN add-apt-repository -y ppa:linuxuprising/java

RUN apt install -y oracle-java15-installer

WORKDIR /usr/local/bin/
ADD target/contentcollector-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "contentcollector-0.0.1-SNAPSHOT.jar"]