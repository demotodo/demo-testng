import com.demotodo.example.testng.FirstTry;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bribin.zheng on 2017-05-19.
 */
public class RunTestNGXML {

    public static void main(String[] args) {
        XmlSuite suite = new XmlSuite();
        suite.setName("my suite");

        XmlTest test = new XmlTest(suite);
        test.setName("my test");

        List<XmlClass> xmlClasses = new ArrayList<>();
        xmlClasses.add(new XmlClass(FirstTry.class.getName()));
        test.setXmlClasses(xmlClasses);

        TestNG testNG = new TestNG();
        testNG.setXmlSuites(Arrays.asList(suite));

        testNG.run();
    }

}
