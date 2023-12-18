import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

class HelpTest{
    public void testHelp(String actual)
    {
        String expected = "--help";
        Assert.assertEquals(expected,actual);
    };
}
