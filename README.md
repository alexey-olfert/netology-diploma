## Как запускать тесты
---
**Условия**

На тестируемой машине установлен Docker, Gradle, MySQL.

**Шаги**

1. Открыть терминал;
1. Скопировать репозиторий:
```
git clone https://github.com/alexey-olfert/netology-diploma.git
```
1. Перейти в директорию `netology-diploma/`
1. Остановить и удалить запущенные контейнеры, если есть:
```
docker stop $(docker ps -q)
docker rm $(docker ps -qa)
```
1. Остановить сервис MySQL, если он запущен:
```
sudo service mysql stop
```
1. Запустить контейнер Docker:
```
docker-compose up -d --force-recreate
```
1. Убедиться в том, что сервис MySQL запустился, выполнив вход:
```
docker-compose exec mysql mysql -u app -p app
```
1. Выйти из командной строки MySQL, выполнив запрос `exit;`
1. Перейти в директорию `gate-simulator/`, расположенную в корне проекта;
1. Запустить симулятор командой `npm start`
1. Перейти на новую вкладку терминала;
1. Вернуться в корень проекта;
1. Запустить SUT:
```
java -jar aqa-shop.jar
```
1. Перейти на новую вкладку терминала;
1. Запустить тесты командой `./gradlew test`
