import org.example.Dialogue;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

class TestHelp{
    public void helpTest()
    {
        String expected = "Для вычисления неопределенного интеграла введите -u";
        ArrayList<String> actual = new ArrayList<>();
        actual.add("--help");
        Dialogue d = new Dialogue();
        Assert.assertEquals(expected,d.help(actual));

    };
}
