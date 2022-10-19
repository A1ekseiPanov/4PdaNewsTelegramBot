package com.example.telegram4pdanewsbot.command;

import com.example.telegram4pdanewsbot.service.BotMessageSendService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Unknown {@link Command}.
 */
public class UnknownCommand implements Command {

    private final BotMessageSendService botMessageSendService;

    public UnknownCommand(BotMessageSendService botMessageSendService) {
        this.botMessageSendService = botMessageSendService;
    }

    @Override
    public void execute(Update update) {
        String unknownMassage = "Не понимаю вас, напишите /help чтобы узнать что я понимаю.";
        botMessageSendService.sendMessage(update.getMessage().getChatId().toString(), unknownMassage);

    }
}
