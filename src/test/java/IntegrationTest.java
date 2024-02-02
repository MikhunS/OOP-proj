package test.java;

import main.java.org.example.Form;
import main.java.org.example.IntegrationTestPrep;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {
    @Test
    public void testIntegrate()
    {
        String expected = "1.4599198195963226";
        String[] actual ={"1","10","20","50"};
        Form form = new Form();
        IntegrationTestPrep res = new IntegrationTestPrep();
        for (int k=0;k<4;k++) {
            String result = res.getResult(actual[k], form);
            if(k==3) {
                Assert.assertEquals(expected, result);
            }
        }
    }
}

