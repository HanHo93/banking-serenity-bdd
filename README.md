# Guru99 Bank Introduction
This is my project for doing web automation testing using Serenity test automation framework,cucumber + java + testNG on maven. 
This project tests some of the functionalities of the demo banking website. (http://demo.guru99.com/v4)

# Running these tests

♫ Prerequisites:
- Java JDK 1.8
- Apache Maven 3.5+ (Follow this guide to install maven: https://mkyong.com/maven/how-to-install-maven-in-windows/)
- IntelliJ IDE (Community)
- Chrome, Firefox, IE latest version.

♫ Select browser/ test classes to run:

The test is run on Chrome by default.
If you want to run on another browser( Firefox, Internet Explorer). Please select test/java/resources/senerity.conf and edit driver parameter from "chrome" to "firefox" or "ie".
And of course you can change the class test you want to run by adding the specific feature file path to this line:
features = "src/test/resources/feature" from test/java/runner.

♫ Run tests:

Right click on the Runner, select "Run Runner"
After finishing running, expand "log" folder to get the log file. Refer this instruction: https://ttprivatenew.s3.amazonaws.com/pulse/myhanspkt2-gmail/attachments/12314552/TinyTake17-01-2020-08-59-16.mp4
