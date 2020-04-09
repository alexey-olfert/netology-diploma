## Как запускать тесты

**Условия**

На тестируемой машине установлен Docker, Gradle, MySQL.

**Шаги**

1. Открыть терминал;
2. Скопировать репозиторий:
```
git clone https://github.com/alexey-olfert/netology-diploma.git
```
3. Перейти в директорию `netology-diploma/`
4. Остановить и удалить запущенные контейнеры, если есть:
```
docker stop $(docker ps -q)
docker rm $(docker ps -qa)
```
5. Остановить сервис MySQL, если он запущен:
```
sudo service mysql stop
```
6. Запустить контейнер Docker:
```
docker-compose up -d --force-recreate
```
7. Убедиться в том, что сервис MySQL запустился, выполнив вход:
```
docker-compose exec mysql mysql -u app -p app
```
8. Выйти из командной строки MySQL, выполнив запрос `exit;`
9. Перейти в директорию `gate-simulator/`, расположенную в корне проекта;
10. Запустить симулятор командой `npm start`
11. Перейти на новую вкладку терминала;
12. Вернуться в корень проекта;
13. Запустить SUT:
```
java -jar aqa-shop.jar
```
14. Перейти на новую вкладку терминала;
15. Запустить тесты командой `./gradlew test`

## Отчётность

+ [План автоматизации](docs/Plan.md)
+ [Отчёт о пройденных тестах](docs/Report.md)
+ [Итоги](docs/Summary.md)
