# BeanShell

If the <include> and <exclude> tags in testng.xml are not enough for your needs, 
you can use a BeanShell expression to decide whether a certain test method should be included in a test run or not. 

When a \<script> tag is found in testng.xml, 
TestNG will ignore subsequent <include> and <exclude> of groups and methods in the current <test> tag,
your BeanShell expression will be the only way to decide whether a test method is included or not.


```
<test name="BeanShell test">
   <method-selectors>
     <method-selector>
       <script language="beanshell"><![CDATA[
         groups.containsKey("test1")
       ]]></script>
     </method-selector>
   </method-selectors>
  <!-- ... -->
```

- It must return a `boolean` value.

- TestNG defines the following variables for your convenience:
    - `java.lang.reflect.Method` `method`:  the current test method.
    - `org.testng.ITestNGMethod` `testngMethod`:  the description of the current test method.
    - `java.util.Map<String, String>` `groups`:  a map of the groups the current test method belongs to.

- You might want to surround your expression with a `CDATA` declaration (as shown above) to avoid tedious quoting of reserved XML characters).

