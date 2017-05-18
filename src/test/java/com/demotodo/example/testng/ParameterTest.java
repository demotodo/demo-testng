package com.demotodo.example.testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by bribin.zheng on 2017-05-18.
 */
public class ParameterTest {

    @Parameters({"first-name"})
    @Test
    public void testSingleString(String firstName) {
        System.out.println("Invoked testString " + firstName);
        assert "Cedric".equals(firstName);
    }

    @Parameters({"first-name", "last-name"})
    @Test
    public void testTwoStrings(String firstName, String lastName) {
        System.out.println("Invoked testString " + firstName + ", " + lastName);
        assert "Cedric".equals(firstName);
        assert "Last".equals(lastName);
    }

    @Parameters("db")
    @Test
    public void testNonExistentParameter(@Optional("mysql") String db) {
        System.out.println("ParameterTest.testNonExistentParameter: " + db);
    }

}
