# Calculator
A calculator application built in Java allowing use of both infix and reverse-Polish notation. Uses toolchains such as Javadoc, Maven, and Junit.

#### Building the application
In order to build the application, you must first be in the root calculator folder. This is the folder in which this README file is contained.
With the command-line open, run the command `mvn package`, this will perform a series of operations which will result in an executable `jar` file.
Running this command will generate a target folder, this is where the executable `jar` file will be contained.

#### Running the application
In order to run this with a GUI interface, simply double click the file and the program should run.

To run the executable from the command-line with an ASCII interface, you must change directory in the command-line from the root calculator folder using `cd target`. Then, when the directory has been changed, you can run the program with the command `java -jar calculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar`

#### Generating a Javadoc summary
In order to generate a Javadoc summary of the program, you can use the command `mvn javadoc:javadoc -e` from the command-line within the root calculator folder. The generated Javadoc file will be located in the target folder, with the path `site\apidocs\index.html`
