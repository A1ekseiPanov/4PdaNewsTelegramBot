package com.example.telegram4pdanewsbot.command;

import com.example.telegram4pdanewsbot.service.BotMessageSendService;
import com.google.common.collect.ImmutableMap;

import static com.example.telegram4pdanewsbot.command.CommandName.*;

/**
 * Контейнер {@link Command}, которые используются для обработки telegram команд.
 */
public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(BotMessageSendService botMessageSendService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(botMessageSendService))
                .put(STOP.getCommandName(), new StopCommand(botMessageSendService))
                .put(HELP.getCommandName(), new HelpCommand(botMessageSendService))
                .put(NO.getCommandName(), new NoCommand(botMessageSendService))
                .build();

        unknownCommand = new UnknownCommand(botMessageSendService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
