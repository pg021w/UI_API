This framework contains both UI and API automation scenarios.
UI automation Website - https://www.amazon.com/
API Automation -  https://reqres.in/

Framework is build with BDD cucumber, selenium and rest assured using core java.

Below is the explaination and steps to run UI automation
1. To run go to TestRunner under cucumberOptions and put tag as "@searchProduct"
2. I have used BDD with POM model for Ui automation

Below is the explaination and steps to run API automation
1. API scenarios are divided in 2 features
a. API_E2E - It consists on POST, PUT and GET calls (Tag- "@API_E2E")
b. API_Delete - It consists of GET (LIST users) and DELETE (Tag- "@API-Delete")
2. To run got to TestRunner under cucumberOptions and put tag as mentioned above

For reporting open cucumber.html under taget in any of the browser



