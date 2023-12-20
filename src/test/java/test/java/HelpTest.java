package test.java;

import main.java.org.example.Dialogue;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HelpTest{
    @Test
    public void testHelp()
    {
        String expected = "Для вычисления неопределенного интеграла введите -u";
        ArrayList<String> actual = new ArrayList<>();
        actual.add("--help");
        Dialogue d = new Dialogue();
        Assert.assertEquals(expected,d.help(actual));

    };
}