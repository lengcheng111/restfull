FROM java:8

MAINTAINER lengcheng111(truonglv)

USER root

# Install telnet
RUN apt-get update
RUN apt-get install -y telnet

WORKDIR .

ADD target/user-service-jetty.jar user-service-jetty.jar

EXPOSE 8081

# JAVA_OPTS is variable containing all java options that a microservice will need.
# Such as Memory allocation, new Relics configurations, etc.
#CMD /usr/lib/jvm/java-8-openjdk-amd64/bin/java $JAVA_OPTS -jar user-service-jetty.jar
CMD java -jar $JAVA_OPTS -jar user-service-jetty.jar