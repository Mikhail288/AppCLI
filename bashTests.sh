##!/bin/bash
kotlinc -d out/AppCli.jar -include-runtime src -cp lib/kotlinx-cli-0.2.1.jar

QUANTITY_RUN=0
QUANTITY_SUCCESSED=0
QUANTITY_FAILED=0
run_test () {
PARAMS=$1
EXPECTED_CODE=$2
MESSAGE=$3
java -classpath out\AppCli.jar;lib\kotlinx-cli-0.2.1.jar MainKt ${PARAMS}
RESULT=$?
(("QUANTITY_RUN+=1"))
if [[ $RESULT = $EXPECTED_CODE ]]
then 
  echo "$MESSAGE OK"
  (("QUANTITY_SUCCESSED+=1"))
else 
  echo "$MESSAGE NOT OK! expected $EXPECTED_CODE, but given $RESULT"
  (("QUANTITY_FAILED+=1"))
fi

#Справка
run_test "" 1 "1.1"
run_test "-h" 1 "1.2"

run_test "-q" 1 "1.3"


# # Аутентификация

run_test "-log vasya -pass 123" 0 "2.1"

run_test "-pass 123 -log vasya" 0 "2.2"

run_test "-log VASYA -pass 123" 2 "2.3"

run_test "-log asd -pass 123" 3 "2.4"

run_test "-log admin -pass 1234" 4 "2.5"

run_test "-log admin -pass admin" 0 "2.6"


# #Авторизация

run_test "-log vasya -pass 123 -role READ -res A" 0 "3.1"

run_test "-log vasya -pass 123 -role DELETE -res A" 5 "3.2"

run_test "-log vasya -pass 123 -role WRITE -res A" 6 "3.3"

run_test "-log vasya -pass 123 -role READ -res A.B" 0 "3.4"

run_test "-log admin -pass admin -role WRITE -res A.B.C" 0 "3.5"

run_test "-log vasya -pass 1234 -role DELETE -res A" 4 "3.6"

run_test "-log vasya -pass 123 -role WRITE -res a.b.c" 6 "3.7"

run_test "-log admin -pass admin -role READ -res" 0 "3.8"

run_test "-log admin -pass admin -role EXECUTE -res A" 6 "3.9"

run_test "-log admin -pass admin -res A.A -role WRITE " 6 "3.10"


# # Аккаунтинг

run_test "-log vasya -pass 123 -role READ -res A -ds 2017.01.07 -de 2017.02.12 -vol 100" 0 "4.1"

run_test "-log vasya -pass 1234 -role READ -res A -ds 2017.01.07 -de 2017.02.12 -vol 100" 4 "4.2"

run_test "-log admin -pass admin -role WRITE -res A -ds 2017.01.07 -de 2017.02.12 -vol qewqeq" 7 "4.3"

run_test "-log admin -pass admin -role EXECUTE -res A -ds 2017.01.07 -de 2017.01.02 -vol 234" 7 "4.4"

run_test "-log admin -pass admin -role READ -res A -ds 432134 -de 2017.02.12 -vol 100" 7 "4.5"

run_test "-log vasya -pass 123 -role READ -res A" 0 "4.6"

run_test "-log q -pass 123 -role WRITE -res A -ds 2017.01.07 -de 2017.02.12 -vol 100" 4 "4.7"

run_test "-log qwqe -pass 123 -role WRITE -res A -ds 2017.01.07 -de 2017.01.07 -vol 100" 3 "4.8"

run_test "-log USER -pass 123 -role WRITE -res A -ds 2017.01.07 -de 2017.02.12 -vol 100" 2 "4.9"

run_test "-log admin -pass admin -role DELETE -res A -ds 2017.01.07 -de 2017.02.12 -vol wqeq" 5 "4.10"

run_test "-log vasya -pass 123 -role WRITE -res A -ds 2017.01.07 -de 2017.02.12 -vol 100" 6 "4.11"

run_test "-log admin -pass admin -role EXECUTE -res A -ds 2017.01.02 -de 12162 -vol 234" 7 "4.12"

run_test "-log admin -pass admin -role EXECUTE -res A -ds 2017.01.02 -vol 234" 7 "4.13"

run_test "-log admin -pass admin -role EXECUTE -res A -ds 2017.01.02 -vol" 7 "4.14"

echo "Total tests run: $QUANTITY_RUN, Successed: $QUANTITY_SUCCESSED, Failed: $QUANTITY_FAILED"