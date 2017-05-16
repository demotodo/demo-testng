# Test results

## Success, failure and assert

A test is considered `successful` 
- if it completed without throwing any exception 
- or if it threw an exception that was expected.

Your test methods will typically be made of calls that can throw an exception, or of various `assertions` (using the Java "assert" keyword).  
An "assert" failing will trigger an `AssertionErrorException`, which in turn will mark the method as `failed` (remember to use `-ea` on the JVM if you are not seeing the assertion errors).

```
@Test
public void verifyLastName() {
  assert "Beust".equals(m_lastName) : "Expected name Beust, for" + m_lastName;
}
```

TestNG also include JUnit's Assert class, which lets you perform assertions on complex objects:

```
import static org.testng.AssertJUnit.*;

@Test
public void verify() {
  assertEquals("Beust", m_lastName);
}
```


## Logging and results

The results of the test run are created in a file called `index.html` in the directory specified when launching `SuiteRunner`.
This file points to various other HTML and text files that contain the result of the entire test run.

It's very easy to generate your own reports with TestNG with Listeners and Reporters:

- Listeners implement the interface `org.testng.ITestListener` and are notified in real time of when a test starts, passes, fails, etc...

- Reporters implement the interface `org.testng.IReporter` and are notified when all the suites have been run by TestNG. 
    - The IReporter instance receives a list of objects that describe the entire test run.

### Logging Listeners

```
public class DotTestListener extends TestListenerAdapter {
  private int m_count = 0;
 
  @Override
  public void onTestFailure(ITestResult tr) {
    log("F");
  }
 
  @Override
  public void onTestSkipped(ITestResult tr) {
    log("S");
  }
 
  @Override
  public void onTestSuccess(ITestResult tr) {
    log(".");
  }
 
  private void log(String string) {
    System.out.print(string);
    if (++m_count % 40 == 0) {
      System.out.println("");
    }
  }
}
```

```
java -classpath testng.jar;%CLASSPATH% org.testng.TestNG -listener org.testng.reporters.DotTestListener test\testng.xml
```

### Logging Reporters

```
public interface IReporter extends ITestNGListener {
  void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory);
}
```

### JUnitReports

TestNG contains a listener that takes the TestNG results and outputs an XML file that can then be fed to JUnitReport.

```xml
<target name="reports">
  <junitreport todir="test-report">
    <fileset dir="test-output">
      <include name="*/*.xml"/>
    </fileset>
  
    <report format="noframes"  todir="test-report"/>
  </junitreport>
</target>
```

### Reporter API

If you need to log messages that should appear in the generated HTML reports, you can use the class `org.testng.Reporter`:

```
Reporter.log("M3 WAS CALLED");
```

### XML Reports

TestNG offers an XML reporter capturing TestNG specific information that is not available in JUnit reports. 

In order to configure this reporter you can use the `-reporter` option in the command line 
or the Ant task with the nested `<reporter>` element. 
For each of these you must specify the class `org.testng.reporters.XMLReporter`. 

Please note that you cannot configure the built-in reporter because this one will only use default settings. 
If you need just the XML report with custom settings you will have to add it manually with one of the two methods and disable the default listeners.

```xml
<testng-results>
  <suite name="Suite1">
    <groups>
      <group name="group1">
        <method signature="com.test.TestOne.test2()" name="test2" class="com.test.TestOne"/>
        <method signature="com.test.TestOne.test1()" name="test1" class="com.test.TestOne"/>
      </group>
      <group name="group2">
        <method signature="com.test.TestOne.test2()" name="test2" class="com.test.TestOne"/>
      </group>
    </groups>
    <test name="test1">
      <class name="com.test.TestOne">
        <test-method status="FAIL" signature="test1()" name="test1" duration-ms="0"
              started-at="2007-05-28T12:14:37Z" description="someDescription2"
              finished-at="2007-05-28T12:14:37Z">
          <exception class="java.lang.AssertionError">
            <short-stacktrace>
              <![CDATA[
                java.lang.AssertionError
                ... Removed 22 stack frames
              ]]>
            </short-stacktrace>
          </exception>
        </test-method>
        <test-method status="PASS" signature="test2()" name="test2" duration-ms="0"
              started-at="2007-05-28T12:14:37Z" description="someDescription1"
              finished-at="2007-05-28T12:14:37Z">
        </test-method>
        <test-method status="PASS" signature="setUp()" name="setUp" is-config="true" duration-ms="15"
              started-at="2007-05-28T12:14:37Z" finished-at="2007-05-28T12:14:37Z">
        </test-method>
      </class>
    </test>
  </suite>
</testng-results>
```
