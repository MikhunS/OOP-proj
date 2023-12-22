import main.java.org.example.Dialogue;
import main.java.org.example.Integration;
import main.java.org.example.TGBot;
import org.junit.Assert;
import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;

public class HelpTest  {
    @Test
    public void testHelp()
    {
        String expected = "1.4599198195963226";
        Integration i = new Integration();
        Assert.assertEquals(expected,i.calc_shell(1,10,20,50));

    };
}