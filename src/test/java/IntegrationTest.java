package test.java;

import main.java.org.example.Form;
import main.java.org.example.Integration;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {
    @Test
    public void testIntegrate()
    {
        String expected = "1.4599198195963226";
        IntegrationTestPrep res = new IntegrationTestPrep();
        String result = res.resultTest();
        Assert.assertEquals(expected,result);
    }
}
