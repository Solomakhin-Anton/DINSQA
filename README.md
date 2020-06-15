## CI
[![Build status](https://ci.appveyor.com/api/projects/status/pa0bl7f8bq0rqmke?svg=true)](https://ci.appveyor.com/project/Solomakhin-Anton/dinsqa)


## Repository Description:

1. The plan of auto tests - https://github.com/Solomakhin-Anton/DINSQA/blob/master/Plan.md .
2. The program code - https://github.com/Solomakhin-Anton/DINSQA/tree/master/src/test/java .
3. The bug-reports - https://github.com/Solomakhin-Anton/DINSQA/issues .

### To run the program and conduct auto tests:

1. Clone and download this repository.
2. Start java app: `java -jar ./artifacts/phonebook.jar` .
3. Open UserDataTest and ContactDataTest.
4. Tests are run sequentially, because the shouldGet test should be the last (in the future it can be moved to a separate class, but for simplicity of understanding, all tests are still together).
5.In the application was added the ability to generate an Allure report, results can be obtained by entering the command in the terminal ./gradlew clean test allureReport and then ./gradlew allureServe.
The report will be stored in the folder: build/test-results.

#### OS environment:

MacOS 10.13.6.

Java SE 11.

Openjdk Version "11.0.5".
