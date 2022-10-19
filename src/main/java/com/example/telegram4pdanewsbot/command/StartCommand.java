package com.example.telegram4pdanewsbot.command;

import com.example.telegram4pdanewsbot.service.BotMessageSendService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalTime;

/**
 * Start {@link Command}.
 */

public class StartCommand implements Command {

    private final BotMessageSendService botMessageSendService;

    public StartCommand(BotMessageSendService botMessageSendService) {
        this.botMessageSendService = botMessageSendService;
    }

    @Override
    public void execute(Update update) {
        final LocalTime time = LocalTime.now();

        String answer;

        String chatID = update.getMessage().getChatId().toString();

        String name = update.getMessage().getChat().getFirstName();

        String additionalAnswer = ". Я 4pda Telegram Bot. Я помогу тебе быть в курсе выхода новых статей. Чтобы посмотреть список команд введите /help";

        if (time.getHour() >= 0 && time.getHour() < 6) {
            answer = "Доброй ночи, " + name + additionalAnswer;
        } else if (time.getHour() >= 6 && time.getHour() < 12) {
            answer = "Доброе утро, " + name + additionalAnswer;
        } else if (time.getHour() >= 12 && time.getHour() < 18) {
            answer = "Доброй день, " + name + additionalAnswer;
        } else {
            answer = "Доброй вечер, " + name + additionalAnswer;
        }
        botMessageSendService.sendMessage(chatID, answer);


    }
}
