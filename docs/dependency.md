# Dependency

- Sometimes, you need your test methods to be invoked in a certain order.


## Dependencies with annotations

- You can use the attributes `dependsOnMethods` or `dependsOnGroups`, found on the `@Test` annotation.

- There are two kinds of dependencies:
    - Hard dependencies. 
        - All the methods you depend on must have run and succeeded for you to run. 
        - If at least one failure occurred in your dependencies, you will not be invoked and marked as a SKIP in the report.
    - Soft dependencies.
        - You will always be run after the methods you depend on, even if some of them have failed.
        - A soft dependency is obtained by adding "`alwaysRun`=true" in your @Test annotation.
        
- Note:  as stated before, the order of invocation for methods that belong in the same group is not guaranteed to be the same across test runs.

- Both dependsOnGroups and dependsOnMethods accept regular expressions as parameters.  

- For dependsOnMethods, if you are depending on a method which happens to have several overloaded versions, 
    - all the overloaded methods will be invoked.  
    - If you only want to invoke one of the overloaded methods, you should use dependsOnGroups.


```
@Test
public void serverStartedOk() {}
 
@Test(dependsOnMethods = { "serverStartedOk" })
public void method1() {}


@Test(groups = { "init" })
public void serverStartedOk() {}
 
@Test(groups = { "init" })
public void initEnvironment() {}
 
@Test(dependsOnGroups = { "init.*" })
public void method1() {}

```

### group

- By default, dependent methods are grouped by class.

- For example, if method b() depends on method a() and you have several instances of the class that contains these methods (because of a factory of a data provider), 
    - then the invocation order will be as follows:
    ```
        a(1)
        a(2)
        b(2)
        b(2)
    ```    
    - TestNG will not run b() until all the instances have invoked their a() method.

- This behavior might not be desirable in certain scenarios, 
    - such as for example testing a sign in and sign out of a web browser for various countries. 
    - In such a case, you would like the following ordering:
    ```
    signIn("us")
    signOut("us")
    signIn("uk")
    signOut("uk")
    ```
    - For this ordering, you can use the XML attribute group-by-instances. This attribute is valid either on <suite> or <test>:
    ```
      <suite name="Factory" group-by-instances="true">
    or
      <test name="Factory" group-by-instances="true">
    ```


## Dependencies in XML

- The <depends-on> attribute contains a space-separated list of groups.

```xml
<test name="My suite">
  <groups>
    <dependencies>
      <group name="c" depends-on="a  b" />
      <group name="z" depends-on="c" />
    </dependencies>
  </groups>
</test>
```


## Dependent test methods

The @Test annotation is now on the class, which means it applies to all the public methods inside that class (so there is no need to repeat it on each individual method).

- Two classes that have responsibilities that are very clearly delineated.

- Very easy maintenance and evolution, 
    - since adding test methods (whether they are init or "real" test methods) boils down to just adding these methods to the right class (no need to annotate them).  
    - A newcomer doesn’t even need to know about that annotations that are needed to get all this to work.

- A report that will accurately reflect the result of the test runs 
    - and will correctly identify the real failures from those that are caused by a cascade effect, 
    - and whose resolution should therefore be postponed until all the FAILs have been resolved.


```
@Test(groups = "init")
public class BaseTest {
  public correctVM() {}
  public serverStartedOk() {}
}


@Test(dependsOnGroups = { "init.*" })
public class TestServer extends BaseTest {
  public method1() { ... }
  public method2() { ... }
  ...
}
```
