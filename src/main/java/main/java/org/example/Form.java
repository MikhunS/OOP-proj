package main.java.org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Form{
    public static int fields;
    public static int func_num;
    public static double down;
    public static double up;
    public static int accuracy;



    public void setFunc_num(int num){
        func_num=num;
    }
    public void setDown(double down){
        Form.down =down;
    }
    public void setUpp(double up){
        Form.up =up;
    }
    public void setAccuracy(int accuracy){
        Form.accuracy =accuracy;
    }
    public void setFields(){
        fields = fields +1;
    }
}
