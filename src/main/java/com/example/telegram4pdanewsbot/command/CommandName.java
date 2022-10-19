package com.example.telegram4pdanewsbot.command;

public enum CommandName {
    /**
     * Enumeration для {@link Command}.
     */

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("nocommand");

    private final String commandName;

    CommandName(String commandName) {
      this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
