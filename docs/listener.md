# TestNG Listener

There are several interfaces that allow you to modify TestNG's behavior. 
These interfaces are broadly called "`TestNG Listeners`". (`org.testng.ITestNGListener`) 

![](images\testng-listeners.png)


When you implement one of these interfaces, you can let TestNG know about it with either of the following ways:
- Using `-listener` on the command line.
- Using `<listeners>` with ant.
- Using `<listeners>` in your testng.xml file.
- Using the `@Listeners` annotation on any of your test classes.
- Using `ServiceLoader`.


## \<listeners> tag

```
<suite>
 
  <listeners>
    <listener class-name="com.example.MyListener" />
    <listener class-name="com.example.MyMethodInterceptor" />
  </listeners>

```


## @Listners annotation

The `@Listeners` annotation can contain any class that extends `org.testng.ITestNGListener` except `IAnnotationTransformer` and `IAnnotationTransformer2`. 
The reason is that these listeners need to be known very early in the process so that TestNG can use them to rewrite your annotations, 
therefore you need to specify these listeners in your testng.xml file.

```
@Listeners({ com.example.MyListener.class, com.example.MyMethodInterceptor.class })
public class MyTest {
  // ...
}
```


Note that the `@Listeners` annotation will apply to your entire suite file, just as if you had specified it in a testng.xml file. 
If you want to restrict its scope (for example, only running on the current class), 
the code in your listener could first check the test method that's about to run and decide what to do then.

```
@Retention(RetentionPolicy.RUNTIME)
@Target ({ElementType.TYPE})
public @interface DisableListener {}


public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
  ConstructorOrMethod consOrMethod =iInvokedMethod.getTestMethod().getConstructorOrMethod();
  DisableListener disable = consOrMethod.getMethod().getDeclaringClass().getAnnotation(DisableListener.class);
  if (disable != null) {
    return;
  }
  // else resume your normal operations
}


@DisableListener
@Listeners({ com.example.MyListener.class, com.example.MyMethodInterceptor.class })
public class MyTest {
  // ...
}
```


## ServiceLoader

Finally, the JDK offers a very elegant mechanism to specify implementations of interfaces on the class path via the `ServiceLoader` class.

With ServiceLoader, all you need to do is 
- create a jar file that contains your listener(s) and a few configuration files, 
    - create a file at the location `META-INF/services/org.testng.ITestNGListener`, which will name the implementation(s) you want for this interface
- put that jar file on the classpath 
- when you run TestNG and TestNG will automatically find them.

This mechanism allows you to 
- apply the same set of listeners to an entire organization just by adding a jar file to the classpath, 
- instead of asking every single developer to remember to specify these listeners in their testng.xml file.

```
$ jar cvf ../sl.jar .
added manifest
ignoring entry META-INF/
adding: META-INF/services/(in = 0) (out= 0)(stored 0%)
adding: META-INF/services/org.testng.ITestNGListener(in = 26) (out= 28)(deflated -7%)
adding: test/(in = 0) (out= 0)(stored 0%)
adding: test/tmp/(in = 0) (out= 0)(stored 0%)
adding: test/tmp/TmpSuiteListener.class(in = 849) (out= 470)(deflated 44%)


$ java -classpath sl.jar:testng.jar org.testng.TestNG testng-single.yaml
```


## Listening to method invocations

The listener `IInvokedMethodListener` allows you to be notified 
- whenever TestNG is about to invoke a test (annotated with `@Test`) 
- or configuration (annotated with any of the `@Before` or `@After` annotation) method. 


## Overriding test methods

TestNG allows you to override and possibly skip the invocation of test methods. 

One example of where this is useful is if you need to your test methods with a specific security manager. 
You achieve this by providing a listener that implements `IHookable`.

```
public class MyHook implements IHookable {
  public void run(final IHookCallBack icb, ITestResult testResult) {
    // Preferably initialized in a @Configuration method
    mySubject = authenticateWithJAAs();
    
    Subject.doAs(mySubject, new PrivilegedExceptionAction() {
      public Object run() {
        icb.callback(testResult);
      }
    };
  }
}
```


## Altering suites (or) tests

Sometimes you may need to just want to alter a suite (or) a test tag in a suite xml in runtime 
without having to change the contents of a suite file.

A classic example for this would be to try and leverage your existing suite file 
and try using it for simulating a load test on your "Application under test". 
At the minimum you would end up duplicating the contents of your <test> tag multiple times and create a new suite xml file and work with. 
But this doesn't seem to scale a lot.

```
public class AlterSuiteNameListener implements IAlterSuiteListener {
 
    @Override
    public void alter(List<XmlSuite> suites) {
        XmlSuite suite = suites.get(0);
        suite.setName(getClass().getSimpleName());
    }

}
```


## org.testng.ITestContext

- This class defines a test context which contains all the information for a given test run.

- An instance of this context is passed to the test listeners so they can query information about their environment.


### org.testng.TestRunner

This class takes care of running one Test.

**TODO** study deeply


### org.testng.SuiteRunner

- It is responsible for running all the tests included in one suite. 

- The test start is triggered by `run()` method.

**TODO** study deeply

