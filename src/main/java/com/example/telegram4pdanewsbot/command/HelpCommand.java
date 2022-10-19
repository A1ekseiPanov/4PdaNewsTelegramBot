package com.example.telegram4pdanewsbot.command;

import com.example.telegram4pdanewsbot.service.BotMessageSendService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.telegram4pdanewsbot.command.CommandName.*;

/**
 * Help {@link Command}.
 */

public class HelpCommand implements Command {

    private final BotMessageSendService botMessageSendService;

    public HelpCommand(BotMessageSendService botMessageSendService) {
        this.botMessageSendService = botMessageSendService;
    }

    private final String helpMessage = String.format(
            "Доступные команды:\n\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n"
                    + "%s - информация о командах при работе со мной\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    @Override
    public void execute(Update update) {
        String chatID = update.getMessage().getChatId().toString();

        botMessageSendService.sendMessage(chatID, helpMessage);
    }
}
