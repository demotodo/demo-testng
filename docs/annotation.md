# annotation

- @BeforeSuite: The annotated method will be run before all tests in this suite have run. 
- @AfterSuite: The annotated method will be run after all tests in this suite have run. 
- @BeforeTest: The annotated method will be run `before any test method belonging to the classes inside the <test> tag` is run. 
- @AfterTest: The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run. 

- @BeforeGroups: The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked. 
- @AfterGroups: The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked. 

- @BeforeClass: The annotated method will be run `before the first test method in the current class` is invoked. 
- @AfterClass: The annotated method will be run after all the test methods in the current class have been run. 
- @BeforeMethod: The annotated method will be run `before each test method`. 
- @AfterMethod: The annotated method will be run after each test method.


- @DataProvider: Marks a method as supplying data for a test method. 
    - The annotated method must return an Object[][] where each Object[] can be assigned the parameter list of the test method. 
    - The @Test method that wants to receive data from this DataProvider needs to use a dataProvider name equals to the name of this annotation.


- @Factory: Marks a method as a factory that returns objects that will be used by TestNG as Test classes. 
    -The method must return Object[].


- @Listeners: Defines listeners (`org.testng.ITestNGListener`) on a test class.


- @Parameters: Describes how to pass parameters to a @Test method.


- @Test: Marks a class or a method as part of the test.


## notes

- The annotations above will also be honored (inherited) when placed on a superclass of a TestNG class. 

- In that case, TestNG guarantees that 
    - the "@Before" methods are executed in inheritance order (highest superclass first, then going down the inheritance chain), 
    - and the "@After" methods in reverse order (going up the inheritance chain).


## annotation transforms

TestNG allows you to modify the content of all the annotations at runtime. 
This is especially useful if the annotations in the source code are right most of the time, 
but there are a few situations where you'd like to override their value.

An Annotation Transformer is a class that implements the following interface: `org.testng.IAnnotationTransformer`

When the method `transform()` is invoked, 
you can call any of the setters on the ITest test parameter to alter its value before TestNG proceeds further.

`IAnnotationTransformer` only lets you modify a `@Test` annotation. 
If you need to modify another TestNG annotation (a configuration annotation, `@Factory` or `@DataProvider`), use an `IAnnotationTransformer2`.


```
public interface IAnnotationTransformer extends ITestNGListener {

  public void transform(ITestAnnotation annotation, Class testClass,
      Constructor testConstructor, Method testMethod);

}
```

```
public class MyTransformer implements IAnnotationTransformer {
  public void transform(ITest annotation, Class testClass,
      Constructor testConstructor, Method testMethod)
  {
    if ("invoke".equals(testMethod.getName())) {
      annotation.setInvocationCount(5);
    }
  }
}
```

```
java org.testng.TestNG -listener MyTransformer testng.xml
```

```
TestNG tng = new TestNG();
tng.setAnnotationTransformer(new MyTransformer());
```

