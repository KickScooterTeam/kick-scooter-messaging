FROM openjdk:9
ADD target/kick-scooter-messaging.jar kick-scooter-messaging.jar
COPY sumo_credentials.txt /home/sumo_credentials.txt
COPY sumo-sources.json /home/sumo-sources.json
RUN wget "https://collectors.sumologic.com/rest/download/linux/64" -O SumoCollector.sh && chmod +x SumoCollector.sh
ENTRYPOINT ["java", "-jar", "kick-scooter-messaging.jar"]
CMD ["./SumoCollector.sh", "-q", "-varfile /home/sumo_credentials.txt", "-Vcollector.name=payment"]
