# Run TestNG

## org.testng.TestNG

```bash
java org.testng.TestNG testng1.xml [testng2.xml testng3.xml ...]
```

- You need to specify at least one XML file describing the TestNG suite you are trying to run.

- command line parameters: http://testng.org/doc/documentation-main.html#running-testng
    - This documentation can be obtained by invoking TestNG without any arguments.

- Important: The command line flags that specify what tests should be run will be ignored if you also specify a testng.xml file, 
    - with the exception of -includedgroups and -excludedgroups, which will override all the group inclusions/exclusions found in testng.xml.


```
C:> more c:\command.txt
-d test-output testng.xml
C:> java org.testng.TestNG @c:\command.txt
```

```
java org.testng.TestNG -groups windows,linux -testclass org.test.MyTest

java -Dtestng.test.classpath="c:/build;c:/java/classes;" org.testng.TestNG testng.xml
```

### org.testng.TestNG#run

```
  public void run() {
    initializeSuitesAndJarFile();
    initializeConfiguration();
    initializeDefaultListeners();
    initializeCommandLineSuites();
    initializeCommandLineSuitesParams();
    initializeCommandLineSuitesGroups();

    sanityCheck();

    runExecutionListeners(true /* start */);

    runSuiteAlterationListeners();

    m_start = System.currentTimeMillis();
    List<ISuite> suiteRunners = runSuites();

    m_end = System.currentTimeMillis();

    if(null != suiteRunners) {
      generateReports(suiteRunners);
    }

    runExecutionListeners(false /* finish */);

    if(!m_hasTests) {
      setStatus(HAS_NO_TEST);
      if (TestRunner.getVerbose() > 1) {
        System.err.println("[TestNG] No tests found. Nothing was run");
        usage();
      }
    }
  }
```


## rerun failed tests

Every time tests fail in a suite, TestNG creates a file called `testng-failed.xml` in the output directory. 

This XML file contains the necessary information to rerun only these methods that failed, allowing you to quickly reproduce the failures without having to run the entirety of your tests.

```
java -classpath testng.jar;%CLASSPATH% org.testng.TestNG -d test-outputs testng.xml

java -classpath testng.jar;%CLASSPATH% org.testng.TestNG -d test-outputs test-outputs\testng-failed.xml

```


## run JUnit tests

TestNG can run JUnit 3 and JUnit 4 tests.  

- All you need to do is put the JUnit `jar` file on the classpath, 
- specify your JUnit test classes in the `testng.classNames` property 
- and set the `testng.junit` property to true:

- TestNG will use the org.junit.runner.JUnitCore runner to run your tests


```
<test name="Test1" junit="true">
  <classes>
    <!-- ... -->
```

## running programmatically

You can invoke TestNG from your own programs very easily:

```
TestListenerAdapter tla = new TestListenerAdapter();
TestNG testng = new TestNG();
testng.setTestClasses(new Class[] { Run2.class });
testng.addListener(tla);
testng.run();
```

### virtual testng.xml file

Similary, you can invoke TestNG on a testng.xml file or you can create a virtual testng.xml file yourself.

Supposed you want to create the following virtual file:

```
<suite name="TmpSuite" >
  <test name="TmpTest" >
    <classes>
      <class name="test.failures.Child"  />
    <classes>
    </test>
</suite>
```

```
XmlSuite suite = new XmlSuite();
suite.setName("TmpSuite");
 
XmlTest test = new XmlTest(suite);
test.setName("TmpTest");

List<XmlClass> classes = new ArrayList<XmlClass>();
classes.add(new XmlClass("test.failures.Child"));
test.setXmlClasses(classes) ;

List<XmlSuite> suites = new ArrayList<XmlSuite>();
suites.add(suite);
TestNG tng = new TestNG();
tng.setXmlSuites(suites);
tng.run();
```
