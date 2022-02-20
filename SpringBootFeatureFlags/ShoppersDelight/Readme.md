# Feature Toggles for Spring Boot applications with IBM Cloud App Configuration

> **DISCLAIMER**: This is a guideline sample application and is used for demonstrative and illustrative purposes only. This is not a production-ready code.

## Contents
- [Feature Toggles for Spring Boot applications with IBM Cloud App Configuration](#feature-toggles-for-spring-boot-applications-with-ibm-cloud-app-configuration)
  - [Contents](#contents)
  - [Create an instance of App Configuration service](#create-an-instance-of-app-configuration-service)
  - [Setup the App Configuration service instance](#setup-the-app-configuration-service-instance)
  - [Run the sample app](#run-the-sample-app)


## Create an instance of App Configuration service
- Log in to your IBM Cloud account.
- In the [IBM Cloud catalog](https://cloud.ibm.com/catalog#services), search **App Configuration** and select [App Configuration](https://cloud.ibm.com/catalog/services/apprapp). The service configuration screen opens.
- **Select a region** - Currently, Dallas (us-south) and London (eu-gb) region is supported.
- Select a pricing plan, resource group and configure your resource with a service name, or use the preset name.
- Click **Create**. A new service instance is created and the App Configuration console displayed.

## Setup the App Configuration service instance
- Install `jq` - command-line JSON processor.
    - You can install it from [here](https://stedolan.github.io/jq/download/)
- Go to dashboard of your App Configuration instance in IBM Cloud UI.
- Navigate to Service Credentials section and generate a new set of credentials. Note down the `region`, `guid` and `apikey`. These credentials are required in the next steps.
- From your terminal, inside the source code execute the `demo.sh` script by running below command
    ```bash
    $ ./appconfigurationdemo.sh
    ```
- Script execution takes time. Script is executed successfully only when you see the log `---Demo script complete---` at the end in your terminal.
- This script will create the collections, feature flags & segments in the instance which are required for the web app


## Run the sample app
Load this application to your Visual Studio Code to run the application. In the terminal, execute the below command to run the application - 
<code>
mvn spring-boot:run
</code>

In the browser navigate to http://localhost:8080 to view the application.