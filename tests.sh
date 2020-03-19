##!/bin/bash

kotlinc ./src -include-runtime -d AppCli.jar

java -jar AppCli.jar
