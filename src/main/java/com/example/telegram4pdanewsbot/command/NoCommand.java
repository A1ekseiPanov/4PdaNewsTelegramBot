package com.example.telegram4pdanewsbot.command;

import com.example.telegram4pdanewsbot.service.BotMessageSendService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * NO {@link Command}.
 */
public class NoCommand implements Command {

    private final BotMessageSendService botMessageSendService;

    public NoCommand(BotMessageSendService botMessageSendService) {
        this.botMessageSendService = botMessageSendService;
    }

    @Override
    public void execute(Update update) {
        String noMessage = "Я поддерживаю команды, начинающиеся со слеша(/).\n"
                + "Чтобы посмотреть список команд введите /help";
        botMessageSendService.sendMessage(update.getMessage().getChatId().toString(), noMessage);
    }
}
