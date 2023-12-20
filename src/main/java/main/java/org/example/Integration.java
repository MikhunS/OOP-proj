package main.java.org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Integration extends TGBot {

    public void calc_prep(String chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        Function function;
        Dialogue di;
        di = new Dialogue();
        function = new Function();
        sendMessage.setText("Введите через пробел следующие 4 параметра :");
        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        sendMessage.setText("выберите функцию : 1) cos , 2) sin , 3) tg");
        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        di.enter(chatId);
    }
    public void calc(String chatId,int d,double a,double b,int n){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        Function function;
        function = new Function();
        double result = function.IntSimpson(a, b, n, d);

        sendMessage.setText("Integral is: " + result);
        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
