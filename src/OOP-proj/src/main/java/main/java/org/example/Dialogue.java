package main.java.org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



public class Dialogue extends TGBot {
    public Dialogue() {
        super();
    }

    public void start(String chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText( "Я приложение вычисляющее интегралы введенной функции, для просмотра функционала введите --help");
        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void enter(String chatId,int opt) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        /*if(opt==0){
            sendMessage.setText("выберите функцию : 1) cos , 2) sin , 3) tg");
            try {
                this.execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }*/
        if(opt==0) {
            sendMessage.setText("Введите нижний предел интегрирования");
            try {
                this.execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        if (opt==1) {
            sendMessage.setText("Введите верхний предел интегрирования");
            try {
                this.execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        if(opt==2) {
            sendMessage.setText("Введите точность вычисления интеграла");
            try {
                this.execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void help (String chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Для вычисления определенного интеграла введите -d ");
        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
