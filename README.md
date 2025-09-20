- # design-patterns-assignment1
+ # Assignment 1 — Design Patterns (Abstract Factory + Factory Method)
+ 
+ This project implements an Abstract Factory for smart devices (Bulb, Lock) across two brands,
+ and uses a Factory Method inside products to load usage values from files after creation.
+ 
+ ## Repository Structure
+ .
+ ├── data/
+ │   ├── brandA_bulb.txt
+ │   └── brandB_lock.txt
+ ├── src/
+ │   └── main/java/com/assignment/dp/...
+ └── src/
+     └── test/java/com/assignment/dp/SmartDevicesTest.java
+ 
+ ## How to Run (no build tool)
+ javac -d out $(find src/main/java -name "*.java")
+ java -cp out com.assignment.dp.Demo
+ 
+ ## How to Run (Maven)
+ mvn -q -DskipTests package
+ java -cp target/classes com.assignment.dp.Demo
+ 
+ ## Test (JUnit 5 with Maven)
+ mvn -q -DskipTests=false test
+ 
+ ## Tests Included
+ - Brand A Bulb loads integer watts from file
+ - Brand B Lock loads `battery=NNN` from file
+ - Graceful fallbacks on missing/invalid files
+ 
+ ## Execution Proof
+ - Screenshot of demo output
+ - Screenshot of `mvn test` summary
+ 
+ _Assignment reference included._ 