import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

class HelpTest{
    public void testHelp()
    {
        Scanner scan = new Scanner (System.in);
        String expected = "--help";
        String actual = scan.next();
        Assert.assertEquals(expected,actual);

    };
}