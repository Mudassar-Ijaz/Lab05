## Lab Task 05 – Designing Specifications: Preconditions and Postconditions



# Objective

The purpose of this lab is to understand method specifications, behavioral equivalence, preconditions, postconditions, and fail-fast validation using Java and JUnit testing.

#What Was Implemented

### Lab Task 1  SearchStrategies.java

The findFirst and findLast methods search for a value in an integer array from different directions.

Both methods give the same result when a value appears only once. When duplicate values exist, they can return different positions. They can also use different values to represent a missing value.

This shows that two methods can only be considered equivalent when they follow the same specification.

### Lab Task 2  MathUtils.java

The calculateGravitationalPotentialEnergy method calculates gravitational potential energy.

Its precondition is that the altitude must be greater than or equal to 0.

If a negative altitude is provided, the method immediately throws an IllegalArgumentException. This is called fail-fast validation and prevents an incorrect result from being produced.

### Lab Task 3  ListFormatter.java

The sortInPlace method changes the original list by sorting it.

The toLowerCase method does not change the original list. Instead, it creates and returns a new list containing the lowercase values.

This demonstrates that a method should not modify its input unless the specification clearly allows it.

### Lab Task 4  Authenticator.java

The getMitId method returns a direct reference to an internal char array. If the client changes the returned array, the internal data of the Authenticator object can also be changed.

The getMitIdSecure method returns the ID as a String. Since String is immutable, the client cannot directly change the original value.

This shows why immutable objects are safer when sharing data with other parts of a program.

### Lab Task 5  JoinStrings.java

This task contains two JavaDoc specifications for the same method.

The first JavaDoc is operational because it explains how the method works internally, such as the loop and StringBuilder.

The second JavaDoc is declarative because it explains only what the method produces.

The declarative style is better because it describes the expected result without depending on the internal implementation.

## JUnit Tests

Each task has a JUnit 5 test class in:

src/test/java/com/university/lab/lab5/

The test classes are:

SearchStrategiesTest
MathUtilsTest
ListFormatterTest
AuthenticatorTest
JoinStringsTest

## How to Run

This is a Maven project.

### Option 1 – NetBeans

1. Open the project in NetBeans.
2. Open Source Packages and then open com.university.lab.lab5.
3. Right-click a class such as MathUtils.java and select Run File.
4. To run the tests, open Test Packages and right-click a test class.
5. Select Test File.
6. You can also right-click the project and select Test to run all tests.

### Option 2 – Command Line

Compile the project:

mvn compile

Run a specific class:

mvn exec:java -Dexec.mainClass="com.university.lab.lab5.MathUtils"

You can replace MathUtils with SearchStrategies, ListFormatter, Authenticator, or JoinStrings.

Run all JUnit tests:

mvn test

## Reflection

This lab helped me understand the idea of a contract between a method and its caller. The findFirst and findLast methods showed that two methods can give different results when duplicate values exist, so their behavior depends on the specification.

The MathUtils task showed why invalid input should be checked early. Throwing an exception for a negative altitude is better than allowing an incorrect result.

The ListFormatter task helped me understand that a method should not change its input unless the specification allows it.

The Authenticator task showed the importance of immutability. Returning a mutable char array can allow the client to change internal data, while returning a String protects the original value.

Finally, the JoinStrings task showed that declarative JavaDoc is easier to understand because it explains what the method does instead of explaining every step of its implementation.

If I extend this lab, I would add more tests for edge cases, such as invalid array indexes in SearchStrategies and very large lists in JoinStrings.

