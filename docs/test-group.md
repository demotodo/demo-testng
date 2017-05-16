# Test Groups

- TestNG allows you to perform sophisticated groupings of test methods. 

- Not only can you declare that methods belong to groups, but you can also specify groups that contain other groups.

- Then TestNG can be invoked and asked to include a certain set of groups (or regular expressions) while excluding another set.

- Groups are specified in your testng.xml file and can be found either under the <test> or <suite> tag.
    - Groups specified in the <suite> tag apply to all the <test> tags underneath.
    - Note that groups are accumulative in these tags: if you specify group "a" in <suite> and "b" in <test>, then both "a" and "b" will be included.


## For example, it is quite common to have at least two categories of tests
   
- Check-in tests.  
    - These tests should be run before you submit new code.  
    - They should typically be fast and just make sure no basic functionality was broken.
    
- Functional tests.  
    - These tests should cover all the functionalities of your software and be run at least once a day, although ideally you would want to run them continuously.

- Typically, check-in tests are a subset of functional tests.

```
@Test
public class Test1 {
  @Test(groups = { "windows.checkintest" })
  public void testWindowsOnly() {
  }
 
  @Test(groups = {"linux.checkintest"} )
  public void testLinuxOnly() {
  }
 
  @Test(groups = { "windows.functest" )
  public void testWindowsToo() {
  }
}
```

```xml
<test name="Test1">
  <groups>
    <run>
      <include name="windows.*"/>
    </run>
  </groups>
 
  <classes>
    <class name="example1.Test1"/>
  </classes>
</test>
```

- Note: TestNG uses regular expressions, and not wildmats.


## method groups

```xml
<test name="Test1">
  <classes>
    <class name="example1.Test1">
      <methods>
        <include name=".*enabledTestMethod.*"/>
        <exclude name=".*brokenTestMethod.*"/>
      </methods>
     </class>
  </classes>
</test>
```


## groups of groups

called `MetaGroups`

```xml
<test name="Regression1">
  <groups>
    <define name="functest">
      <include name="windows"/>
      <include name="linux"/>
    </define>
  
    <define name="all">
      <include name="functest"/>
      <include name="checkintest"/>
    </define>
  
    <run>
      <include name="all"/>
    </run>
  </groups>
  
  <classes>
    <class name="test.sample.Test1"/>
  </classes>
</test>
```


## exclude broken tests

```
@Test(groups = {"checkintest", "broken"} )
public void testMethod2() {
}
```

```xml
<test name="Simple example">
  <groups>
    <run>
      <include name="checkintest"/>
      <exclude name="broken"/>
    </run>
  </groups>
  
  <classes>
    <class name="example1.Test1"/>
  </classes>
</test>
```

- Note:  you can also disable tests on an individual basis by using the "enabled" property available on both @Test and @Before/After annotations.


## partial groups

You can define groups at the class level and then add groups at the method level:

```
@Test(groups = { "checkin-test" })
public class All {
 
  @Test(groups = { "func-test" )
  public void method1() { ... }
 
  public void method2() { ... }
}
```

- method1() belongs to both "checkin-test" and "func-test"

