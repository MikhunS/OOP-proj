package main.java.org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;



public class TGBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "integral_taker_chat_bot";
    }

    @Override
    public String getBotToken() {
        return "6855102557:AAEzXWk0l_zcy1tq-wvYsM8x4QdDyOO88lM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        Integration i = new Integration();
        Dialogue d = new Dialogue();
        String[] arg = (update.getMessage().getText().split(" "));
        //setButtons(sendMessage);
        if (arg.length==1) {
            switch (arg[0]) {
                case "--help":
                    d.help(chatId);
                    break;
                case "-d":
                    i.calc_prep(chatId);
                    break;
                default:
                    d.start(chatId);
                    break;

            }
        }
        else {
            i.calc(chatId,Integer.parseInt(arg[0]),Integer.parseInt(arg[1]),Integer.parseInt(arg[2]),Integer.parseInt(arg[3]));
        }
    }
}
