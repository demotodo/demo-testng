# TestNG

http://testng.org/doc/index.html

http://testng.org/doc/misc.html


- TestNG is designed to cover all categories of tests:  unit, functional, end-to-end, integration, etc...

- Run your tests in arbitrarily big thread pools with various policies available (all methods in their own thread, one thread per test class, etc...).

- Test that your code is multithread safe.

- Support for data-driven testing (with @DataProvider).

- Support for parameters.

- A suite is represented by one XML file. It can contain one or more tests and is defined by the <suite> tag.

- A test is represented by <test> and can contain one or more TestNG classes.

- A TestNG class is a Java class that contains at least one TestNG annotation. It is represented by the <class> tag and can contain one or more test methods.

- A test method is a Java method annotated by @Test in your source.

- The @Test annotation can be put on a class instead of a test method:
    - The effect of a class level @Test annotation is to make all the public methods of this class to become test methods even if they are not annotated. 
    - You can still repeat the @Test annotation on a method if you want to add certain attributes.


## testng.xml structure

- A `suite` is made of `tests` and `parameters`.
    - `parameters`, which are used to link Java metho parameters to their actual values

- A `test` is made of three parts:
    - `parameters`, which override the suite parameters
    - `groups`, made of two parts
    - `classes`, defining which classes are going to be part of this test run

- In turn, `groups` are made of two parts:
    - `definitions`, which allow you to group groups into bigger groups (groups of groups)
    - `runs`, which defines the groups that the methods must belong to in order to run during this test
