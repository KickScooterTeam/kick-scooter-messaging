#!bin/bash

nohup java -jar *.jar </dev/null &>/dev/null &

sleep 5

./SumoCollector.sh -q -varfile /home/sumo_credentials.txt -Vcollector.name=messaging
