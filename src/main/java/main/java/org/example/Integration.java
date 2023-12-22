package main.java.org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Integration extends TGBot {

    public Integration() {
        super();
    }
    public void calc(String chatId,int d,double a,double b,int n){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        Function function;
        function = new Function();
        double result = function.intSimpson(a, b, n, d);

        sendMessage.setText("Integral is: " + result);
        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    public String calc_shell(int d,double a,double b,int n){
        Function function;
        function = new Function();
        double result = function.intSimpson(a, b, n, d);
        return String.valueOf(result);
    }
}
