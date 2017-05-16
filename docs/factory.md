# Factory

- Factories allow you to create tests dynamically. 

- The factory method can receive parameters just like @Test and @Before/After and it must return Object[].
    - The objects returned can be of any class (not necessarily the same class as the factory class) 
    - and they don't even need to contain TestNG annotations (in which case they will be ignored by TestNG).


```
public class WebTestFactory {
  @Factory
  public Object[] createInstances() {
   Object[] result = new Object[10]; 
   for (int i = 0; i < 10; i++) {
      result[i] = new WebTest(i * 10);
    }
    return result;
  }
}


public class WebTest {
  private int m_numberOfTimes;
  public WebTest(int numberOfTimes) {
    m_numberOfTimes = numberOfTimes;
  }
 
  @Test
  public void testServer() {
   for (int i = 0; i < m_numberOfTimes; i++) {
     // access the web page
    }
  }
}
```

```
<class name="WebTestFactory" />
```

```
TestNG testNG = new TestNG();
testNG.setTestClasses(WebTestFactory.class);
testNG.run();
```


## work with data provider

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


---

# ObjectFactory

## org.testng.annotations.ObjectFactory

Marks a method as the object factory to use for creating all test instances.

The test classes can only contain one method marked with this annotation, 
and the method must return an instance of `org.testng.ITestObjectFactory`.

```
public interface ITestObjectFactory extends Serializable {
}


public interface IObjectFactory extends ITestObjectFactory {
  Object newInstance(Constructor constructor, Object... params);
}


public interface IObjectFactory2 extends ITestObjectFactory {
  Object newInstance(Class<?> cls);
}
```
