#!bin/bash

java -jar *.jar &>/dev/null &

./SumoCollector.sh -q -varfile /home/sumo_credentials.txt -Vcollector.name=messaging
