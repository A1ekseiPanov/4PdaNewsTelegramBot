package com.example.telegram4pdanewsbot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
/**
 * Command интерфейс для обработки команд telegram-бота.
 */

public interface Command {

    /**
     * Основной метод, который выполняет логику команд.
     *
     *  @param update предоставляет объекту {@link Update} все необходимые данные для команды.
     */

    void execute(Update update);
}
