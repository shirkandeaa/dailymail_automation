
Run Pre Requisite:
1. Chrome should be installed on your machine.

You need to add chromedriver as per youe machine at src/test/java/com/cucumber/Assignment/base_files/resources/chrome_mac/chromedriver
For ex. If You are using Mac OS with intel processor and installed Chrome 105.*** locally then you need to download chrome driver from https://chromedriver.storage.googleapis.com/105.0.5195.52/chromedriver_mac64.zip and add it to src/test/java/com/cucumber/Assignment/base_files/resources/chrome_mac/chromedriver
This is very important to update chromedriver. I ahve added Chromedriver for MAC + Chorme 105. If you are using other platform then please update the chromedriver. 

Steps to execute:
1. Clone the project.
2. Open in editor.
3. Run test runner class at src/test/java/com/cucumber/Assignment/base_files/runners/TestRunner.java

Reports:
You will get execution report in
You will see the final report link in the run console like this - https://reports.cucumber.io/reports/444201e1-b278-4799-b6f2-718cae17dfbe 


The project has two parts i.e. UI automation and api automation. 

UI automation is complete and running. Swagger api automation is having some issue with user authentication. Which needs to be fixed. I have not added @runSmoke tag to api test.
