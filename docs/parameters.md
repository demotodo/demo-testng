# Parameters

- Test methods don't have to be parameterless.  

- You can use an arbitrary number of parameters on each of your test method, 
    - and you instruct TestNG to pass you the correct parameters with the `@Parameters` annotation.

- There are two ways to set these parameters:  with testng.xml or programmatically.


## Parameters from testng.xml

- On any method that already has a `@Test`, `@Before`/`After` or `@Factory` annotation.

- On at most one constructor of your test class.  
    - In this case, TestNG will invoke this particular constructor with the parameters initialized to the values specified in testng.xml whenever it needs to instantiate your test class.  
    - This feature can be used to initialize fields inside your classes to values that will then be used by your test methods.

- The XML parameters are mapped to the Java parameters in the same order as they are found in the annotation, and TestNG will issue an error if the numbers don't match.

- Parameters are scoped. 
    - In testng.xml, you can declare them either under a `<suite>` tag or under `<test>`. 
    - If two parameters have the same name, it's the one defined in `<test>` that has precedence. 
    - This is convenient if you need to specify a parameter applicable to all your tests and override its value only for certain tests.


```
@Parameters({ "first-name" })
@Test
public void testSingleString(String firstName) {
  System.out.println("Invoked testString " + firstName);
  assert "Cedric".equals(firstName);
}


@Parameters({ "datasource", "jdbcDriver" })
@BeforeMethod
public void beforeTest(String ds, String driver) {
  m_dataSource = ...;                              // look up the value of datasource
  m_jdbcDriver = driver;
}


@Parameters("db")
@Test
public void testNonExistentParameter(@Optional("mysql") String db) { ... }

```

```
<suite name="My suite">
  <parameter name="first-name"  value="Cedric"/>
  <test name="Simple example">
  <-- ... -->
```

### @Optional

- Specifies that the current parameter is optional.  

- TestNG will pass in a specified default value, or null if none is specified.


## Parameters with DataProviders

- you can use a Data Provider to supply the values you need to test

- A Data Provider is a method on your class that returns an array of array of objects.

- By default, the data provider will be looked for in the current test class or one of its base classes. 
    - If you want to put your data provider in a different class, it needs to be a static method or a class with a non-arg constructor, 
    - and you specify the class where it can be found in the dataProviderClass attribute:


```
@DataProvider(name = "test1")
public Object[][] createData1() {
 return new Object[][] {
   { "Cedric", new Integer(36) },
   { "Anne", new Integer(37)},
 };
}
 

@Test(dataProvider = "test1")
public void verifyData1(String n1, Integer n2) {
 System.out.println(n1 + " " + n2);
}
```

```
public class StaticProvider {
  @DataProvider(name = "create")
  public static Object[][] createData() {
    return new Object[][] {
      new Object[] { new Integer(42) }
    };
  }
}
 
public class MyTest {
  @Test(dataProvider = "create", dataProviderClass = StaticProvider.class)
  public void test(Integer n) {
    // ...
  }
}
```


### support injection

- TestNG will use the test context for the injection.

- The Data Provider method can return one of the following two types:
    - An array of array of objects (`Object[][]`) where 
        - the first dimension's size is the number of times the test method will be invoked 
        - and the second dimension size contains an array of objects that must be compatible with the parameter types of the test method.
    - An `Iterator<Object[]>`.
        - The only difference with Object[][] is that an Iterator lets you create your test data lazily.
        - TestNG will invoke the iterator and then the test method with the parameters returned by this iterator one by one.

- If you declare your @DataProvider as taking a `java.lang.reflect.Method` as first parameter, 
    - TestNG will pass the current test method for this first parameter. 


```
@DataProvider(name = "test1")
public Iterator<Object[]> createData() {
  return new MyIterator(DATA);
}
```

```
@DataProvider(name = "dp")
public Object[][] createData(Method m) {
  System.out.println(m.getName());  // print test method name
  return new Object[][] { new Object[] { "Cedric" }};
}
 
@Test(dataProvider = "dp")
public void test1(String s) {
}
 
@Test(dataProvider = "dp")
public void test2(String s) {
}
```


### parallel

- Data providers can run in parallel with the attribute parallel: `@DataProvider(parallel = true)`

- Parallel data providers running from an XML file share the same pool of threads, which has a size of 10 by default.

```
<suite name="Suite1" data-provider-thread-count="20" >
```


## Parameters in reports

- Parameters used to invoke your test methods are shown in the HTML reports generated by TestNG. 
