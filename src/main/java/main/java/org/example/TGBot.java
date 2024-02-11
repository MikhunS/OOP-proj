package main.java.org.example;

import org.jfree.chart.ChartUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;



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
        Form form = new Form();
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
            case "-show":
                var ex = new Graph((int) Form.up, (int) Form.down, Form.func_num);
                File file = new File("graph.png");
                try {
                    ChartUtils.saveChartAsPNG(file, ex.chart, 800, 600);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(String.valueOf(chatId));
                sendPhoto.setPhoto(new InputFile(file));

                try {
                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                break;
            default:
                d.enter(chatId, Form.fields);
                String result = ing.getResult(arg, form);
                if (Form.fields == 4) {
                    sendMessage.setChatId(chatId);
                    sendMessage.setText("Integral is: " + result);
                    try {
                        this.execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    sendMessage.setText("Для просмотра графика соответсвующего интеграла с переменным верхним пределом введите -show");
                    try {
                        this.execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    Form.fields = 0;
                }
        }
    }
}
