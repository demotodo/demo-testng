# testng.xml

## DTD

[testng-1.0.dtd](testng-1.0.dtd)


```dtd
<!ELEMENT suite (groups?,(listeners|packages|test|parameter|method-selectors|suite-files)*) >

<!ELEMENT groups (define*,run?,dependencies?) >
<!ELEMENT run (include?,exclude?)* >


<!ELEMENT listeners (listener*) >


<!ELEMENT packages (package*) >


<!ELEMENT test (method-selectors?,parameter*,groups?,packages?,classes?) >


<!ELEMENT method-selectors (method-selector*) >
<!ELEMENT method-selector ((selector-class)*|script) >


<!ELEMENT classes (class*,parameter*) >

<!ELEMENT class (methods|parameter)* >

<!ELEMENT methods (include?,exclude?,parameter?)* >
```


## Example

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suite1" verbose="1" >
  <test name="Nopackage" >
    <classes>
       <class name="NoPackageTest" />
    </classes>
  </test>
 
  <test name="Regression1">
    <classes>
      <class name="test.sample.ParameterSample"/>
      <class name="test.sample.ParameterTest"/>
    </classes>
  </test>
  
  <test name="Regression2">
    <packages>
      <package name="test.sample" />
   </packages>
 </test>

 <test name="Regression3">
   <groups>
     <run>
       <exclude name="brokenTests"  />
       <include name="checkinTests"  />
     </run>
   </groups>
   
   <classes>
     <class name="test.IndividualMethodsTest">
       <methods>
         <include name="testMethod" />
       </methods>
     </class>
   </classes>
 </test>

</suite>
```


## `parameter` support variable substitution

- substitue system properties or environment variables

```
  private static String expandValue(String value)
  {
    StringBuffer result = null;
    int startIndex = 0;
    int endIndex = 0;
    int startPosition = 0;
    String property = null;
    while ((startIndex = value.indexOf("${", startPosition)) > -1 && (endIndex = value.indexOf("}", startIndex + 3)) > -1) {
      property = value.substring(startIndex + 2, endIndex);
      if (result == null) {
        result = new StringBuffer(value.substring(startPosition, startIndex));
      } else {
        result.append(value.substring(startPosition, startIndex));
      }
      String propertyValue = System.getProperty(property);
      if (propertyValue == null) {
        propertyValue = System.getenv(property);
      }
      if (propertyValue != null) {
        result.append(propertyValue);
      } else {
        result.append("${");
        result.append(property);
        result.append("}");
      }
      startPosition = startIndex + 3 + property.length();
    }
    if (result != null) {
      result.append(value.substring(startPosition));
      return result.toString();
    } else {
      return value;
    }
  }
```
