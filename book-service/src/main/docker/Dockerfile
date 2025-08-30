FROM adoptopenjdk:8-jre
RUN  apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install -y netcat
VOLUME /tmp
ADD book-service-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh

