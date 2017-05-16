# DataProvider

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


## work with factory

- Factories can also be used with data providers, 
    - and you can leverage this functionality by putting the @Factory annotation either on a regular method or on a constructor.


```
@Factory(dataProvider = "dp")
public FactoryDataProviderSampleTest(int n) {
  super(n);
}
 
@DataProvider
static public Object[][] dp() {
  return new Object[][] {
    new Object[] { 41 },
    new Object[] { 42 },
  };
}
```


## org.testng.annotations.TestInstance

If this annotation is used on a parameter of a data provider, 
that parameter is the instance of the test method which is going to be fed by this data provider.

