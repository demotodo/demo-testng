# Command Line Options

The `ant task` (also the maven/gradle plugin now) and `testng.xml` allow you to launch TestNG with more parameters (methods to include, specifying parameters, etc...),

so you should consider using the command line only when you are trying to learn about TestNG and you want to get up and running quickly.


## TestNG options

```
D:\GitRepo\demo-testng\script>java -ea org.testng.TestNG
You need to specify at least one testng.xml, one class or one method
Usage: <main class> [options] The XML suite files to run
  Options:
    -configfailurepolicy
      Configuration failure policy (skip or continue)
    -d
      Output directory
    -dataproviderthreadcount
      Number of threads to use when running data providers
    -excludegroups
      Comma-separated list of group names to  exclude
    -groups
      Comma-separated list of group names to be run
    -junit
      JUnit mode
      Default: false
    -listener
      List of .class files or list of class names implementing ITestListener
      or ISuiteListener
    -methods
      Comma separated of test methods
      Default: []
    -methodselectors
      List of .class files or list of class names implementing IMethodSelector
    -mixed
      Mixed mode - autodetect the type of current test and run it with
      appropriate runner
      Default: false
    -objectfactory
      List of .class files or list of class names implementing
      ITestRunnerFactory
    -parallel
      Parallel mode (methods, tests or classes)
      Possible Values: [tests, methods, classes, instances, none, true, false]
    -port
      The port
    -reporter
      Extended configuration for custom report listener
    -suitename
      Default name of test suite, if not specified in suite definition file or
      source code
    -suitethreadpoolsize
      Size of the thread pool to use to run suites
      Default: 1
    -testclass
      The list of test classes
    -testjar
      A jar file containing the tests
    -testname
      Default name of test, if not specified in suitedefinition file or source
      code
    -testnames
      The list of test names to run
    -testrunfactory, -testRunFactory
      The factory used to create tests
    -threadcount
      Number of threads to use when running tests in parallel
    -usedefaultlisteners
      Whether to use the default listeners
      Default: true
    -log, -verbose
      Level of verbosity
    -xmlpathinjar
      The full path to the xml file inside the jar file (only valid if
      -testjar was specified)
      Default: testng.xml
```


## JVM properties

Additionally, TestNG can be passed properties on the command line of the Java Virtual Machine, for example

```
java -Dtestng.test.classpath="c:/build;c:/java/classes;" org.testng.TestNG testng.xml
```

`testng.test.classpath` is the only system property that TestNG understands.


## default name

```
  /** The default name for a suite launched from the command line */
  public static final String DEFAULT_COMMAND_LINE_SUITE_NAME = "Command line suite";

  /** The default name for a test launched from the command line */
  public static final String DEFAULT_COMMAND_LINE_TEST_NAME = "Command line test";


    //no two tests in the same suite should have the same name.
    //so, make the default test name unique
    m_name = TestNG.DEFAULT_COMMAND_LINE_TEST_NAME + " " + UUID.randomUUID().toString();
```
