##!/bin/bash

kotlinc ./src -include-runtime -d AppCli.jar

java -jar AppCli.jar

#Справка

java -jar AppCli.jar

java -jar AppCli.jar -h

java -jar AppCli.jar -q


