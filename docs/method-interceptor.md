# Method Interceptors

Once TestNG has calculated in what order the test methods will be invoked, these methods are split in two groups:

- Methods `run sequentially`. 
    - These are all the test methods that have `dependencies` or `dependents`. 
    - These methods will be run in a specific order.

- Methods `run in no particular order`. 
    - These are all the methods that don't belong in the first category. 
    - The order in which these test methods are run is random and can vary from one run to the next (although by default, TestNG will try to group test methods by class).

In order to give you more control on the methods that belong to the second category, TestNG defines the following interface:

```
public interface org.testng.IMethodInterceptor extends ITestNGListener {

  List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context);

}
```

The list of methods passed in parameters are all the methods that can be run in any order. 
Your intercept method is expected to return a similar list of `IMethodInstance`, which can be either of the following:
- The same list you received in parameter but in a different order.
- A smaller list of IMethodInstance objects.
- A bigger list of IMethodInstance objects.

```
public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
  List<IMethodInstance> result = new ArrayList<IMethodInstance>();
  for (IMethodInstance m : methods) {
    Test test = m.getMethod().getConstructorOrMethod().getAnnotation(Test.class);
    Set<String> groups = new HashSet<String>();
    for (String group : test.groups()) {
      groups.add(group);
    }
    if (groups.contains("fast")) {
      result.add(0, m);
    }
    else {
      result.add(m);
    }
  }
  return result;
}
```

```
java -classpath "testng-jdk15.jar:test/build" org.testng.TestNG 
    -listener test.methodinterceptors.NullMethodInterceptor
    -testclass test.methodinterceptors.FooTest
```

