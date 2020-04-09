## Как запускать тесты

**Условия**

На тестируемой машине установлен Docker, Gradle, MySQL, PostgreSQL.

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
5. Запустить контейнер Docker:
```
docker-compose up -d --force-recreate
```
7. Убедиться в том, что сервис БД запустился, выполнив вход;

    * Для MySQL:
    ```
    docker-compose exec mysql mysql -u app -p app
    ```
    * Для PostgreSQL:
    ```
    docker-compose exec postgres psql -U app -W postgres
    ```


7. Выйти из БД, выполнив запрос `exit;` (для MySQL) либо `exit` (для PostgreSQL)
8. Запустить SUT.

    * Для MySQL:
    ```
    java -jar -Dspring.datasource.url=jdbc:mysql://localhost:3306/app aqa-shop.jar
    ```
    * Для PostgreSQL:

    ```
    java -jar -Dspring.datasource.url=jdbc:postgresql://localhost:5432/postgres aqa-shop.jar

    ```    

14. Перейти на новую вкладку терминала
15. Запустить тесты

    * Для MySQL:
    ```
    ./gradlew test -Dsut.url=http://localhost:8080 -Ddb.url=jdbc:mysql://localhost:3306/app -Ddb.user=app -Ddb.password=pass
    ```

    * Для PostgreSQL:
    ```
    ./gradlew test -Dsut.url=http://localhost:8080 -Ddb.url=jdbc:postgresql://localhost:5432/postgres -Ddb.user=app -Ddb.password=pass
    ```

## Отчётность

+ [План автоматизации](docs/Plan.md)
+ [Отчёт о пройденных тестах](docs/Report.md)
+ [Итоги](docs/Summary.md)
