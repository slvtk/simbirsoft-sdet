# Simbirsoft test task
- All configurations are in the 'Configurations' class. 
- Helpers use 'Page Object' methods for its purposes. 
- 'ApplicationManager' keeps all important instances.
- 'Base' classes has some general methods.
## Selenium Grid
### Hub:
```
java -jar selenium-server-standalone-3.141.59.jar -role hub -port 4444 
```
### Node:
```
java -Dwebdriver.chrome.driver="C:/chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register/
```
### Result:
![Grid result](https://i.imgur.com/YmppwpJ.png)

## Allure
```
mvn clean install site
```
### Result:
![Allure result](https://i.imgur.com/2izr9t1.png)
