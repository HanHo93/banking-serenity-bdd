package Utils;

import org.testng.Assert;

public class Assertions {

    public static void verifyEquals(Object actual, Object expected, String item) {
        try {
            Assert.assertEquals(actual, expected);
            Log.info("The actual " + item + " is " + actual + ". The expected "+ item + " is " + expected);
        } catch (AssertionError e) {
            Log.error("[Assert Fail] - The actual " + item + " is " + actual + ". While the expected "+ item + " is " + expected);
            Assert.fail();
        }
    }

    public static void verifyTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition);
            Log.info(message + " : true");
        } catch (AssertionError e) {
            Log.info(message + " : false");
            Assert.fail();
        }
    }
}
