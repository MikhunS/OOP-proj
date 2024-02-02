package main.java.org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class TGBot extends TelegramLongPollingBot {



    @Override
    public String getBotUsername() {
        return "integral_taker_chat_bot";
    }

    @Override
     public String getBotToken() {
        String token = Token.token;
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Form form =new Form();
        String chatId = update.getMessage().getChatId().toString();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        Integration i = new Integration();
        Dialogue d = new Dialogue();
        IntegrationTestPrep ing = new IntegrationTestPrep();
        String arg = update.getMessage().getText();
        switch (arg) {
            case "--help":
                d.help(chatId);
                break;
            case "-integrate":
                sendMessage.setText("выберите функцию : 1) cos , 2) sin , 3) tg");
                try {
                    this.execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                d.enter(chatId, Form.fields);
                String result = ing.getResult(arg,form);
                if (Form.fields == 4) {
                    sendMessage.setChatId(chatId);
                    sendMessage.setText("Integral is: " + result);
                    try {
                        this.execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    Form.fields=0;
                }
        }
    }
}

