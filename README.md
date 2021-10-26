## Setup

1. Create automationproperties directory in AutomationFramework directory
2. Copy automation_template.properties to the automationproperties directory from project folder /properties in repo
3. Rename properties file to automation.properties and update properties for your paths and credentials - Save
4. Update sauce credentials using the encryption tool - /src/main/java/com.dsg.framework/credentials/GenerteEncyrptedCredentials - Right click/run Main
5. The application name can be anything.  PW is the access key from user settings of saucelabs.
6. Add encrypted sauce credentials from the new file that was generated automatically to  the automation.properties file
7. Run SampleTest and verify in sauceLabs - /framework/sampletest/SampleTest - Right click/run SampleTest


# FAQ   
Run specific tag

    mvn clean test -Dcucumber.filter.tags='@SB_042'

Specific tag with specific browser (default is chrome-latest)

    mvn clean test -Dcucumber.filter.tags='@SB_042' -DsauceBrowser='ANDROID_PIXEL3_11_CHROME'

Run using sauceTunnel

    mvn clean test -Dcucumber.filter.tags='@SB_042' -DsauceBrowser='ANDROID_PIXEL3_11_CHROME' -DsauceTunnel='true'


Run cucumber report

    mvn clean test -Dcucumber.filter.tags='@SB_042' -DsauceBrowser='ANDROID_PIXEL3_11_CHROME' -Dcucumber


#### you can specify any tags that are available in your project

### To run smoke test use:

    clean test -P Smoke

### To start regression execute:

    clean test -P Regression

### To run feature files in parallel without limiting number of threads:

    <parallel>methods</parallel>
    <useUnlimitedThreads>true</useUnlimitedThreads>
    <includes>
      <include>**/RegressionRunner.java</include>
    </includes>
   
   
### To specify browser type, use parameter -Dbrowser=browserType:

    clean test -Dbrowser=chrome

### To specify environment, use parameter -Denv=envType

    mvn test -Denv=dsg

### To run regression on dsg and chrome browser:

    clean test -Dbrowser=chrome -Denv=dsg -P Regression

### To run smoke test on dsg and chrome:

    clean test -Dbrowser=chrome -Denv=dsg -P Smoke

## NOTE: add mvn before every command if you are not running it on Jenkins:

    mvn test -Dbrowser=chrome -Denv=dsg -P Regression

#### To read in Java something -Dparam use --> System.getProperty("param")

### To run regression on Sauce Lab

    clean test -Dbrowser=sauce -P Regression
   
### List of parameters
  -Dbrowser

  -Denv 
  
