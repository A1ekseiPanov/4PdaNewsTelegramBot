package com.example.telegram4pdanewsbot.service;

/**
 * Сервис для отправки сообщений через telegram-бота
 */


public interface BotMessageSendService {
    /**
     * Отправка сообщений через telegram-бота.
     *
     * @param chatId предоставил идентификатор чата, в котором будут отправляться сообщения.
     * @param message предоставило сообщение для отправки.
     */
    void sendMessage(String chatId, String message);
}
