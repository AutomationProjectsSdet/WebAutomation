# ParaBank Automation Framework

# :test_tube: WebAutomation – Test Automation Framework for ParaBank
A robust TestNG-based automation framework built to simulate end-to-end user journeys on the [ParaBank](https://parabank.parasoft.com/parabank/index.htm) demo banking application. Designed to reflect senior-level automation engineering skills with a strong focus on scalability, maintainability, and business value.
---
## :mag: Overview
This project automates key banking functionalities such as:
- Login & Logout
- Open New Account
- Transfer Funds
- Account Overview
- Contact Us (Form Submission)
It follows the **Page Object Model (POM)** design pattern and integrates advanced TestNG features like retry logic, test grouping, and data-driven testing.
---
## :briefcase: Business Value
This framework enables:
- **Faster Release Cycles**: Automated regression tests reduce manual testing efforts by up to 70%, accelerating delivery.
- **Early Bug Detection**: Catch high-severity issues in critical workflows before production.
- **CI-Ready Execution**: Easily integrated into CI pipelines (GitHub Actions, Jenkins) for automated testing on every pull request.
- **Scalability**: Modular architecture supports easy addition of new features and tests.
---
## :rocket: Tech Stack
- **Language**: Java 11 
- **Test Framework**: TestNG 
- **Build Tool**: Maven 
- **Design Pattern**: Page Object Model (POM) 
- **WebDriver Manager**: For automatic browser driver handling 
- **Reporting**: (Planned – Allure or ExtentReports) 
- **Logging**: (Recommended – Log4j2 or SLF4J)
---
### :wrench: Prerequisites
- Java 11+
- Maven installed
- Chrome browser
### :arrow_forward: Run All Tests
mvn clean test
