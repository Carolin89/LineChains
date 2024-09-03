# LineChain Project

## Overview

The **LineChain** project is a Java application that models and processes chains of connected line segments in 2D space. The project includes functionality for:

- Creating and managing individual line segments.
- Building and sorting chains of connected lines.
- Displaying the line chains graphically in a user interface.

## Features

- **Line Representation:** The `Line` class models a line segment with a start and end point, and provides methods to calculate its length and determine connections to other lines.
- **Chain Building:** The `LineChainBuilder` class constructs chains of connected lines, ensuring that only valid connections are formed.
- **Graphical Display:** The application includes a GUI to visualize the line chains using the `LinePanel` class.
- **Testing:** Unit tests are provided to ensure the correctness of the core functionality.


## Clone the repository
git clone https://github.com/yourusername/line-chain-project.git

## Build the project using Maven
mvn clean install

## Dependencies
The project uses the following dependencies:

- JUnit 5: For unit testing.
- Maven Compiler Plugin: Configured to use Java 17.
These dependencies are managed via the pom.xml file.
##Usage
The application starts by creating a set of line segments and then attempts to build and display chains of connected lines. The lengths of these chains are calculated and printed in the console. The chains are also displayed in a graphical user interface.