# Project Automation Flutter Android

Hi! This is a project automation Android with study case [Flutter Android](https://github.com/flutter/gallery) using Maven, Cucumber, TestNG, Appium, and Selenium

### Prerequisites

What things you need to install:

- [Java Development Kit 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [Appium](https://github.com/appium/appium-desktop/releases/)

## How to Run the Project
* ### Running on local machine

    1. Run script `./download-apk.sh` to get the apk. If it's not working, you can download it manually and drop it into folder `src/test/resources/apk`
    2. Running Appium Server with command `appium -a 127.0.0.1 -p 4723`.
    3. Open your Android emulator.
    4. Open the project using any IDE (Eclipse, IDEA, etc).
    5. Download sources Maven and update the project.
    6. Running the project using command `mvn clean test`.
    7. Report will automatically generate after test is completely finish. Check on the `report` folder.
