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
            default:
                switch (Form.fields) {
                    case 0:
                        form.setFunc_num(Integer.parseInt(update.getMessage().getText()));
                        d.enter(chatId, Form.fields);
                        form.setFields();
                        break;
                    case 1:
                        form.setDown(Double.parseDouble(update.getMessage().getText()));
                        d.enter(chatId, Form.fields);
                        form.setFields();
                        break;
                    case 2:
                        form.setUpp(Double.parseDouble(update.getMessage().getText()));
                        d.enter(chatId, Form.fields);
                        form.setFields();
                        break;
                    case 3:
                        form.setAccuracy(Integer.parseInt(update.getMessage().getText()));
                        form.setFields();
                        break;
                }
        }
        if (Form.fields == 4) {
            i.calc(chatId,Form.func_num, Form.down, Form.up, Form.accuracy);
            Form.fields=0;
        }
    }
}
