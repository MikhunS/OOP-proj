package test.java;

import main.java.org.example.Form;
import main.java.org.example.Integration;

public class IntegrationTestPrep {
    public String resultTest() {
        String[] input = {"1", "10", "20", "50"};
        String result="";
        Form form = new Form();
        Integration i = new Integration();
        for (int k = 0; k < 4; k++) {
            switch (Form.fields) {
                case 0:
                    form.setFunc_num(Integer.parseInt(input[k]));
                    form.setFields();
                    break;
                case 1:
                    form.setDown(Double.parseDouble(input[k]));
                    form.setFields();
                    break;
                case 2:
                    form.setUpp(Double.parseDouble(input[k]));
                    form.setFields();
                    break;
                case 3:
                    form.setAccuracy(Integer.parseInt(input[k]));
                    form.setFields();
                    break;
            }
            if (Form.fields == 4) {
                result = i.calc_shell(form.func_num, form.down, form.up, form.accuracy);
            }
        }
        return result;
    }
}
