This project automates the testing of ebay search functionality.

Environment setup:
------------------

The machine to execute tests is expected to have the version 47.0.1 Firefox installed and frozen
(no autoupdates should be installed neither for the browser itself nor for the plugins).
This would otherwise result in failing test executions.
The machine should also have Java 1.8 installed and setup together with maven.

Once that is established, the project can be built and the tests would be executed as part of the `mvn clean verify`
goal.
