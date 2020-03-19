##!/bin/bash

kotlinc ./src -include-runtime -d AppCli.jar

java -jar AppCli.jar

#Справка

java -jar AppCli.jar

java -jar AppCli.jar -h

java -jar AppCli.jar -q


#Авторизация

java -jar AppCli.jar -log: vasya -pass:123 -role READ -res A

java -jar AppCli.jar -log: vasya -pass:123 -role DELETE -res A

java -jar AppCli.jar -log: vasya -pass:123 -role WRITE -res A

java -jar AppCli.jar -log: vasya -pass:123 -role READ -res A.B

java -jar AppCli.jar -log: admin -pass:admin -role WRITE -res A.B.C

java -jar AppCli.jar -log: vasya -pass:1234 -role DELETE -res A

java -jar AppCli.jar -log: vasya -pass:123 -role WRITE -res a.b.c

java -jar AppCli.jar -log: admin -pass:admin -role READ -res

java -jar AppCli.jar -log: admin -pass:admin -role EXECUTE -res A

java -jar AppCli.jar -log: admin -pass:admin -role WRITE -res A.A
