# Verbose

```
  /** The suite verbose flag. (0 to 10)*/
  public static final Integer DEFAULT_VERBOSE = 1;
```

## 0

- no summary report

```
D:\GitRepo\demo-testng\script>java -ea org.testng.TestNG -verbose 0 ../src/test/resources/testng.xml 
FirstTry.beforeSuite
FirstTry.beforeTest
FirstTry.beforeClass
FirstTry.beforeGroups-group1
FirstTry.beforeMethod
FirstTry.test1-group1
FirstTry.afterMethod
FirstTry.beforeMethod
FirstTry.test2-group2
FirstTry.afterMethod
FirstTry.beforeMethod
FirstTry.test3-group1
FirstTry.afterMethod
FirstTry.afterGroups-group1
FirstTry.afterClass
FirstTry.afterTest
FirstTry.afterSuite
```


## 1 (default)

- has summary report

```
D:\GitRepo\demo-testng\script>java -ea org.testng.TestNG -verbose 1 ../src/test/resources/testng.xml 
FirstTry.beforeSuite
FirstTry.beforeTest
FirstTry.beforeClass
FirstTry.beforeGroups-group1
FirstTry.beforeMethod
FirstTry.test1-group1
FirstTry.afterMethod
FirstTry.beforeMethod
FirstTry.test2-group2
FirstTry.afterMethod
FirstTry.beforeMethod
FirstTry.test3-group1
FirstTry.afterMethod
FirstTry.afterGroups-group1
FirstTry.afterClass
FirstTry.afterTest
FirstTry.afterSuite

===============================================
TestNG
Total tests run: 3, Failures: 0, Skips: 0
===============================================
```


## 2

- add `PASSED`, `FAILED` info etc.
- summary after `test`

```
D:\GitRepo\demo-testng\script>java -ea org.testng.TestNG -verbose 2 ../src/test/resources/testng.xml 
FirstTry.beforeSuite
FirstTry.beforeTest
FirstTry.beforeClass
FirstTry.beforeGroups-group1
FirstTry.beforeMethod
FirstTry.test1-group1
FirstTry.afterMethod
FirstTry.beforeMethod
FirstTry.test2-group2
FirstTry.afterMethod
FirstTry.beforeMethod
FirstTry.test3-group1
FirstTry.afterMethod
FirstTry.afterGroups-group1
FirstTry.afterClass
FirstTry.afterTest
PASSED: test1
PASSED: test2
PASSED: test3

===============================================
    FirstTry
    Tests run: 3, Failures: 0, Skips: 0
===============================================

FirstTry.afterSuite

===============================================
TestNG
Total tests run: 3, Failures: 0, Skips: 0
===============================================
```


## 3

- add invoked methods info

```
D:\GitRepo\demo-testng\script>java -ea org.testng.TestNG -verbose 3 ../src/test/resources/testng.xml 
FirstTry.beforeSuite
FirstTry.beforeTest
FirstTry.beforeClass
FirstTry.beforeGroups-group1
FirstTry.beforeMethod
FirstTry.test1-group1
FirstTry.afterMethod
FirstTry.beforeMethod
FirstTry.test2-group2
FirstTry.afterMethod
FirstTry.beforeMethod
FirstTry.test3-group1
FirstTry.afterMethod
FirstTry.afterGroups-group1
FirstTry.afterClass
FirstTry.afterTest
===== Invoked methods
  FirstTry.beforeSuite()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
  FirstTry.beforeTest()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
  FirstTry.beforeClass()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
  FirstTry.beforeMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
    FirstTry.test1()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
  FirstTry.afterMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
  FirstTry.beforeMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
    FirstTry.test2()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
  FirstTry.afterMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
  FirstTry.beforeMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
    FirstTry.test3()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
  FirstTry.afterMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
  FirstTry.afterClass()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
  FirstTry.afterTest()[pri:0, instance:com.demotodo.example.testng.FirstTry@5d3411d] 97730845
=====
PASSED: test1
PASSED: test2
PASSED: test3

===============================================
    FirstTry
    Tests run: 3, Failures: 0, Skips: 0
===============================================

FirstTry.afterSuite

===============================================
TestNG
Total tests run: 3, Failures: 0, Skips: 0
===============================================
```


## 4

**TODO**


## 5

- add more trace info, starting with `[TestNG]` prefix


```
D:\GitRepo\demo-testng\script>java -ea org.testng.TestNG -verbose 5 ../src/test/resources/testng.xml 
[TestNG] INVOKING CONFIGURATION: "UNKNOWN" - @BeforeSuite com.demotodo.example.testng.FirstTry.beforeSuite()
FirstTry.beforeSuite
[TestNG] PASSED CONFIGURATION: "UNKNOWN" - @BeforeSuite com.demotodo.example.testng.FirstTry.beforeSuite() finished in 7 ms
[TestNG] RUNNING: Suite: "FirstTry" containing "3" Tests (config: D:\GitRepo\demo-testng\src\test\resources\testng.xml)
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @BeforeTest com.demotodo.example.testng.FirstTry.beforeTest()
FirstTry.beforeTest
[TestNG] PASSED CONFIGURATION: "FirstTry" - @BeforeTest com.demotodo.example.testng.FirstTry.beforeTest() finished in 0 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @BeforeClass com.demotodo.example.testng.FirstTry.beforeClass()
FirstTry.beforeClass
[TestNG] PASSED CONFIGURATION: "FirstTry" - @BeforeClass com.demotodo.example.testng.FirstTry.beforeClass() finished in 1 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @BeforeGroups com.demotodo.example.testng.FirstTry.beforeGroups()
FirstTry.beforeGroups-group1
[TestNG] PASSED CONFIGURATION: "FirstTry" - @BeforeGroups com.demotodo.example.testng.FirstTry.beforeGroups() finished in 0 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @BeforeMethod com.demotodo.example.testng.FirstTry.beforeMethod()
FirstTry.beforeMethod
[TestNG] PASSED CONFIGURATION: "FirstTry" - @BeforeMethod com.demotodo.example.testng.FirstTry.beforeMethod() finished in 0 ms
[TestNG] INVOKING: "FirstTry" - com.demotodo.example.testng.FirstTry.test1()
FirstTry.test1-group1
[TestNG] PASSED: "FirstTry" - com.demotodo.example.testng.FirstTry.test1() finished in 0 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @AfterMethod com.demotodo.example.testng.FirstTry.afterMethod()
FirstTry.afterMethod
[TestNG] PASSED CONFIGURATION: "FirstTry" - @AfterMethod com.demotodo.example.testng.FirstTry.afterMethod() finished in 1 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @BeforeMethod com.demotodo.example.testng.FirstTry.beforeMethod()
FirstTry.beforeMethod
[TestNG] PASSED CONFIGURATION: "FirstTry" - @BeforeMethod com.demotodo.example.testng.FirstTry.beforeMethod() finished in 0 ms
[TestNG] INVOKING: "FirstTry" - com.demotodo.example.testng.FirstTry.test2()
FirstTry.test2-group2
[TestNG] PASSED: "FirstTry" - com.demotodo.example.testng.FirstTry.test2() finished in 0 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @AfterMethod com.demotodo.example.testng.FirstTry.afterMethod()
FirstTry.afterMethod
[TestNG] PASSED CONFIGURATION: "FirstTry" - @AfterMethod com.demotodo.example.testng.FirstTry.afterMethod() finished in 0 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @BeforeMethod com.demotodo.example.testng.FirstTry.beforeMethod()
FirstTry.beforeMethod
[TestNG] PASSED CONFIGURATION: "FirstTry" - @BeforeMethod com.demotodo.example.testng.FirstTry.beforeMethod() finished in 0 ms
[TestNG] INVOKING: "FirstTry" - com.demotodo.example.testng.FirstTry.test3()
FirstTry.test3-group1
[TestNG] PASSED: "FirstTry" - com.demotodo.example.testng.FirstTry.test3() finished in 0 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @AfterMethod com.demotodo.example.testng.FirstTry.afterMethod()
FirstTry.afterMethod
[TestNG] PASSED CONFIGURATION: "FirstTry" - @AfterMethod com.demotodo.example.testng.FirstTry.afterMethod() finished in 0 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @AfterGroups com.demotodo.example.testng.FirstTry.afterGroups()
FirstTry.afterGroups-group1
[TestNG] PASSED CONFIGURATION: "FirstTry" - @AfterGroups com.demotodo.example.testng.FirstTry.afterGroups() finished in 0 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @AfterClass com.demotodo.example.testng.FirstTry.afterClass()
FirstTry.afterClass
[TestNG] PASSED CONFIGURATION: "FirstTry" - @AfterClass com.demotodo.example.testng.FirstTry.afterClass() finished in 0 ms
[TestNG] INVOKING CONFIGURATION: "FirstTry" - @AfterTest com.demotodo.example.testng.FirstTry.afterTest()
FirstTry.afterTest
[TestNG] PASSED CONFIGURATION: "FirstTry" - @AfterTest com.demotodo.example.testng.FirstTry.afterTest() finished in 0 ms
===== Invoked methods
  FirstTry.beforeSuite()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
  FirstTry.beforeTest()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
  FirstTry.beforeClass()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
  FirstTry.beforeMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
    FirstTry.test1()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
  FirstTry.afterMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
  FirstTry.beforeMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
    FirstTry.test2()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
  FirstTry.afterMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
  FirstTry.beforeMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
    FirstTry.test3()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
  FirstTry.afterMethod()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
  FirstTry.afterClass()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
  FirstTry.afterTest()[pri:0, instance:com.demotodo.example.testng.FirstTry@d70c109] 225493257
=====
PASSED: test1
PASSED: test2
PASSED: test3

===============================================
    FirstTry
    Tests run: 3, Failures: 0, Skips: 0
===============================================

[TestNG] 
[TestNG] ===============================================
[TestNG]     FirstTry
[TestNG]     Tests run: 3, Failures: 0, Skips: 0
[TestNG] ===============================================
[TestNG] INVOKING CONFIGURATION: "UNKNOWN" - @AfterSuite com.demotodo.example.testng.FirstTry.afterSuite()
FirstTry.afterSuite
[TestNG] PASSED CONFIGURATION: "UNKNOWN" - @AfterSuite com.demotodo.example.testng.FirstTry.afterSuite() finished in 0 ms

===============================================
TestNG
Total tests run: 3, Failures: 0, Skips: 0
===============================================

```

