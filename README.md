zUxdSvnjPh7AnkfHdzjG
## [AppCli](https://mikhail1488.github.io/AppCLI/)
Учебный проект, созданный с целью изучения backend-разработки в рамках курса "Программная инженерия".
Приложение представляет собой консольную утилиту, выполняющую аутентификацию, авторизацию и аккаунтинг.
На вход программа принимает следующие параметры: 

| Аргумент | Описание |  Примечание |
|----------|----------|-------------|  
| -log | логин пользователя | должен соответствовать формату [a -z],{1-9} |  
| -pass | пароль пользователя  | - |  
| -res | абсолютный путь к ресурсу | В качестве разделителя используется `.` |   
| -role | уровень доступа к ресурсу | допустимые роли WRITE, READ, EXCUTE |  
| -ds | Дата начала сессии с ресурсом  | В формате  YYYY-MM-DD |   
| -de | Дата окончания сессии с ресурсом | В формате  YYYY-MM-DD |  
| -vol | Объем | целое число |  


## Требования

К проекту предъявляются следующие [требования](https://github.com/Mikhail1488/AppCLI/blob/master/Requirements.md).    
Для реализации которых  разработаный планы:  
1) [Roadmap-1](https://github.com/Mikhail1488/AppCLI/blob/master/Roadmap-1.md)    
2) [Roadmap-2](https://github.com/Mikhail1488/AppCLI/blob/master/Roadmap-2.md)  

## Сборка и запуск приложения
Для сборки приложения нужно:  
1) Склонировать репозиторий  
2) Запустить скрипт:  
```
bash build.sh
```

Для запуска приложения запустите скрипт:
```
bash run.sh <args>
```

## Тестирование
Для запуска тестов выполните скрипт
```
bash test.sh
```
