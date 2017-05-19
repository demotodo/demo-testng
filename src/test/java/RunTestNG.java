import com.demotodo.example.testng.FirstTry;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/**
 * Created by bribin.zheng on 2017-05-19.
 */
public class RunTestNG {

    public static void main(String[] args) {
        TestListenerAdapter testListenerAdapter = new TestListenerAdapter() {
            @Override
            public void onTestSuccess(ITestResult tr) {
                System.out.println("RunTestNG.onTestSuccess: " + tr.getName() + ", " + tr.getMethod());
                super.onTestSuccess(tr);
            }
        };

        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{FirstTry.class});
        testNG.addListener(testListenerAdapter);

        testNG.run();
    }

}
