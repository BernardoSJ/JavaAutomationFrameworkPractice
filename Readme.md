# Java Selenium Test Automation Framework

A scalable UI test automation framework built with **Java 23**, **Selenium WebDriver**, and **TestNG**.  
This project was created applying common industry patterns.


## 🚀 About Me
Hi My name is Bernardo Salinas and I have 2+ years of experience in Automation Testing using technologies like Selenium Webdriver, Playwright and Appvance.
## Authors
- Bernardo Salinas Jaquez
- EmailAddress: salinasbernardo56@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/BernardoSJ)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/bernardo-salinas-jaquez-822551122/)


## Prerequisites

Before running this framework, make sure the following tools are installed:

- **Java 23**
- **Maven 3.8+ or newer**

## Features

- **Selenium WebDriver + TestNG**: Used for browser automation and test execution engine.
- **Data-Driven Testing**: Supplied through: CSV, Excel and JSON
- **Fake Test Data Generation**: Generates dynamic and realistic data
- **Cloud Execution with LambdaTest**: To enable scalable execution in the cloud.
- **Headless Execution**: For faster execution especially in CI/CD environments.
- **Command-Line Execution with Maven**: To configure runtime parameters.
- **Reporting**: Execution results are generated using Extent Reports.
- **Logging**: Using Log4j for logging execution details.
## Tech Stack

- **Java 23**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Maven Surefire Plugin**
- **OpenCSV**
- **Gson**
- **Apache POI**
- **Java Faker**
- **Extent Reports**
- **Log4j**
- **LambdaTest**

## Setup Instructions

Install my-project with npm

**Clone the repository**

```bash
  git clone https://github.com/BernardoSJ/JavaAutomationFrameworkPractice.git

  cd JavaAutomationFrameworkPractice
```


**Running Tests**

This command runs the tests in Chrome browser, indicating to not execute in LambdaTest and with headless mode

```bash
  mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true
```


## Reports
After test execution, the framework generates an HTML report: reports.html. The report includes: test execution summary, passed and failed tests and timestamps.

## Logs
Are created uring the test execution in the logs directory.

## Integrated the project with GitHub Actions
The project is integrated with GitHub actions. Can be secheduled or trigger manually. The reports witll be archieved in gh-pages branch. You can view the reports at https://bernardosj.github.io/JavaAutomationFrameworkPractice/report.html
