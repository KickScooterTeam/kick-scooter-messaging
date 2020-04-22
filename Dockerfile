FROM openjdk:9
ENV TZ=Europe/Kiev
ADD target/kick-scooter-messaging.jar kick-scooter-messaging.jar
COPY sumo_credentials.txt /home/sumo_credentials.txt
COPY sumo-sources.json /home/sumo-sources.json
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezon
RUN wget "https://collectors.sumologic.com/rest/download/linux/64" -O SumoCollector.sh && chmod +x SumoCollector.sh
ENTRYPOINT ["java", "-jar", "kick-scooter-messaging.jar"]
CMD ["sh", "-c", "./SumoCollector.sh -q -varfile /home/sumo_credentials.txt -Vcollector.name=messaging"]
