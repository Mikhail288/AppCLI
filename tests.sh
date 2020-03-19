##!/bin/bash

kotlinc ./src -include-runtime -d AppCli.jar

java -jar AppCli.jar

#Справка

java -jar AppCli.jar

java -jar AppCli.jar -h

java -jar AppCli.jar -q


# Аутентификация

java -jar AppCli.jar -log: vasya -pass:123

java -jar AppCli.jar -pass:123 -log: vasya

java -jar AppCli.jar -log: VASYA -pass:123

java -jar AppCli.jar -log: asd -pass:123

java -jar AppCli.jar -log: admin -pass:1234

java -jar AppCli.jar -log: admin -pass:admin


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


# Аккаунтинг

java -jar AppCli.jar -log: vasya -pass:123 -role READ -res A -ds 2017.01.07 -de 2017.02.12 -vol 100

java -jar AppCli.jar -log: vasya -pass:1234 -role READ -res A -ds 2017.01.07 -de 2017.02.12 -vol 100

java -jar AppCli.jar -log: admin -pass:admin -role WRITE -res A -ds 2017.01.07 -de 2017.02.12 -vol qewqeq

java -jar AppCli.jar -log: admin -pass:admin -role EXECUTE -res A -ds 2017.01.07 -de 2017.01.02 -vol 234

java -jar AppCli.jar -log: admin -pass:admin -role READ -res A -ds 432134 -de 2017.02.12 -vol 100

java -jar AppCli.jar -log: vasya -pass:123 -role READ -res A

java -jar AppCli.jar -log: q -pass:123 -role WRITE -res A -ds 2017.01.07 -de 2017.02.12 -vol 100

java -jar AppCli.jar -log: qwqe -pass:123 -role WRITE -res A -ds 2017.01.07 -de 2017.01.07 -vol 100

java -jar AppCli.jar -log: USER -pass:123 -role WRITE -res A -ds 2017.01.07 -de 2017.02.12 -vol 100

java -jar AppCli.jar -log: admin -pass:admin -role DELETE -res A -ds 2017.01.07 -de 2017.02.12 -vol wqeq

java -jar AppCli.jar -log: vasya -pass:123 -role WRITE -res A -ds 2017.01.07 -de 2017.02.12 -vol 100

java -jar AppCli.jar -log: admin -pass:admin -role EXECUTE -res A -ds 2017.01.02 -de 12162 -vol 234

java -jar AppCli.jar -log: admin -pass:admin -role EXECUTE -res A -ds 2017.01.02 -vol 234

java -jar AppCli.jar -log: admin -pass:admin -role EXECUTE -res A -ds 2017.01.02 -vol
