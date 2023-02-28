FROM ubuntu:22.04

RUN apt update
RUN apt install default-jdk -y

COPY . .

RUN javac main.java

CMD ["java","main"]

