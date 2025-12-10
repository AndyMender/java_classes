FROM ubuntu:24.04

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get -y install openjdk-21-jdk openjdk-21-jre gradle
