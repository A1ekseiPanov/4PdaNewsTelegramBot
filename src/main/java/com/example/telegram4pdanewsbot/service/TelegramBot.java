package com.example.telegram4pdanewsbot.service;

import com.example.telegram4pdanewsbot.command.CommandContainer;
import com.example.telegram4pdanewsbot.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.telegram4pdanewsbot.command.CommandName.NO;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    public final String prefix = "/";
    private final BotConfig botConfig;
    private final CommandContainer commandContainer;

    @Autowired
    public TelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
        this.commandContainer = new CommandContainer(new BotMessageSendServiceImpl(this));
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
            String messageText = update.getMessage().getText().trim();
            if (messageText.startsWith(prefix)) {
                String commandIdentifier = messageText.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }





}
