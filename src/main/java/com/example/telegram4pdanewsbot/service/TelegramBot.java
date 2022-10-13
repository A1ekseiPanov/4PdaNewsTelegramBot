package com.example.telegram4pdanewsbot.service;

import com.example.telegram4pdanewsbot.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalTime;

@Component
public class TelegramBot extends TelegramLongPollingBot {



    private final BotConfig botConfig;

    @Autowired
    public TelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }


    @Override
    public String getBotUsername() {
        return botConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            String firstName = update.getMessage().getChat().getFirstName();
            long chatId = update.getMessage().getChatId();
            if (messageText.equals("/start")) {
                startCommand(chatId,firstName);

            } else {
                sendMessage(chatId,"Такой команды не существует");

            }
        }
    }

    private void startCommand(long chatId,String name) {
        final LocalTime time = LocalTime.now();
        String answer;

        if (time.getHour() >= 0 && time.getHour() < 6) {
            answer = "Доброй ночи, " + name;
        }else if (time.getHour() >= 6 && time.getHour() < 12){
            answer = "Доброе утро, " + name;
        }else if(time.getHour() >= 12 && time.getHour() < 18){
            answer = "Доброй день, " + name;
        }else{
            answer = "Доброй вечер, " + name;
        }
        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId,String textToSend){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
