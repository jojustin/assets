# Sample Base Application of Spring Boot using  @ConfigurationProperties

> **DISCLAIMER**: This is a guideline sample application and is used for demonstrative and illustrative purposes only. This is not a production-ready code.

## Contents
- [Sample Base Application of Spring Boot using  @ConfigurationProperties](#sample-base-application-of-spring-boot-using--configurationproperties)
  - [Contents](#contents)
  - [Application Details](#application-details)
  - [Run the sample app](#run-the-sample-app)


## Application Details
This Spring Boot app uses configuration properties loaded from the appliction.yml file. This application uses three configuration properties declared in application.yml.  

PropertiesBackedFeatureFlagService is a class that implements the FeatureFlagService interface. PropertiesBackedFeatureFlagService uses three feature flags to control the release of the application. 

## Run the sample app

Load this application to your Visual Studio Code to run the application. In the terminal, execute the below command to run the application - 
<code>
mvn spring-boot:run
</code>

In the browser navigate to http://localhost:8080 to view the application.