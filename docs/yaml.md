# YAML

TestNG supports [YAML](http://www.yaml.org/) as an alternate way of specifying your suite file. 

```xml
<suite name="SingleSuite" verbose="2" thread-count="4">
 
  <parameter name="n" value="42" />
 
  <test name="Regression2">
    <groups>
      <run>
        <exclude name="broken" />
      </run>
    </groups>
 
    <classes>
      <class name="test.listeners.ResultEndMillisTest" />
    </classes>
  </test>
</suite>
```

==>

```
name: SingleSuite
threadCount: 4
parameters: { n: 42 }
 
tests:
  - name: Regression2
    parameters: { count: 10 }
    excludedGroups: [ broken ]
    classes:
      - test.listeners.ResultEndMillisTest
```
