# Dependency injection

TestNG supports two different kinds of dependency injection: 
- `native` (performed by `TestNG` itself) 
- and `external` (performed by a `dependency injection framework` such as `Guice`).


## Native dependency injection

Dependency injection can be used in the following places:

- Any `@Before` method or `@Test` method can declare a parameter of type `ITestContext`.

- Any `@AfterMethod` method can declare a parameter of type `ITestResult`, 
    - which will reflect the result of the test method that was just run.

- Any `@Before` and `@After` methods can declare a parameter of type `XmlTest`, 
    - which contain the current `<test>` tag.

- Any `@BeforeMethod` (and `@AfterMethod`) can declare a parameter of type `java.lang.reflect.Method`. 
    - This parameter will receive the test method that will be called once this `@BeforeMethod` finishes (or after the method as run for `@AfterMethod`).

- Any `@BeforeMethod` can declare a parameter of type `Object[]`. 
    - This parameter will receive the list of parameters that are about to be fed to the upcoming test method, 
    - which could be either injected by TestNG, such as `java.lang.reflect.Method` or come from a `@DataProvider`.

- Any `@DataProvider` can declare a parameter of type `ITestContext` or `java.lang.reflect.Method`. 
    - The latter parameter will receive the test method that is about to be invoked.

You can turn off injection with the `@NoInjection` annotation:

```
public class NoInjectionTest {
 
  @DataProvider(name = "provider")
  public Object[][] provide() throws Exception {
      return new Object[][] { { CC.class.getMethod("f") } };
  }
 
  @Test(dataProvider = "provider")
  public void withoutInjection(@NoInjection Method m) {
      Assert.assertEquals(m.getName(), "f");
  }
 
  @Test(dataProvider = "provider")
  public void withInjection(Method m) {
      Assert.assertEquals(m.getName(), "withInjection");
  }
}
```


## Guice dependency injection

If you use Guice, TestNG gives you an easy way to inject your test objects with a Guice module:

```
public class GuiceExampleModule implements Module {
 
  @Override
  public void configure(Binder binder) {
    binder.bind(ISingleton.class).to(ExampleSingleton.class).in(Singleton.class);
  }
 
}



@Guice(modules = GuiceExampleModule.class)
public class GuiceTest extends SimpleBaseTest {
 
  @Inject
  ISingleton m_singleton;
 
  @Test
  public void singletonShouldWork() {
    m_singleton.doSomething();
  }
 
}
```
