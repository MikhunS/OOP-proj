package main.java.org.example;


public class IntegrationTestPrep {
    public String getResult(String input,Form form) {
        String result="";
        Integration i = new Integration();
        switch (form.fields) {
            case 0:
                form.setFunc_num(Integer.parseInt(input));
                form.setFields();
                break;
            case 1:
                form.setDown(Double.parseDouble(input));
                form.setFields();
                break;
            case 2:
                form.setUpp(Double.parseDouble(input));
                form.setFields();
                break;
            case 3:
                form.setAccuracy(Integer.parseInt(input));
                form.setFields();
                break;
        }
        if (Form.fields == 4) {
            result = i.calc_shell(form.func_num, form.down, form.up, form.accuracy);
        }
        return result;
    }
}
