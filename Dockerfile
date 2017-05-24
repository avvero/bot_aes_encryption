FROM ubuntu:14.04

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update -y && \
    apt-get install git -y && \
    apt-get install software-properties-common -y && \
    apt-get install python-software-properties -y && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update -y
RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN apt-get install oracle-java8-installer -y

WORKDIR /tmp

RUN git clone https://github.com/avvero/bot_aes_encryption.git

WORKDIR bot_aes_encryption

RUN chmod +x ./gradlew

RUN ./gradlew build

ENTRYPOINT ["./gradlew"]

EXPOSE 8088