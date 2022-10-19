package com.example.telegram4pdanewsbot.command;

import com.example.telegram4pdanewsbot.service.BotMessageSendService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}.
 */

public class StopCommand implements Command {

    private final BotMessageSendService botMessageSendService;

    public StopCommand(BotMessageSendService botMessageSendService) {
        this.botMessageSendService = botMessageSendService;
    }

    @Override
    public void execute(Update update) {
        String chatID = update.getMessage().getChatId().toString();
        String name = update.getMessage().getChat().getFirstName();
        String answer = "До свидания " + name;
        botMessageSendService.sendMessage(chatID, answer);
    }
}
