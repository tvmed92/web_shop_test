# web_shop_test

Запуск тестов из консоли:

1. Перейти в корневую директорию проекта (Пример: "C:\Users\your_name\IdeaProjects\shop_test")
2. Ввести команду 
```
mvn clean test
```
или
```
mvn clean test -DsuiteXMLFile=src/test/resources/testng.xml
```
После выполнения тестов для формирования отчета следует выполнить следующую команду:
```
allure serve build/allure-results
```
*Внимание*: Перед запуском тестов убедитесь, что на вашей АРМ установлен Google Chrome
