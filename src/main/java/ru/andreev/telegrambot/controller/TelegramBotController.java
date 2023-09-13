package ru.andreev.telegrambot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.andreev.telegrambot.service.TelegramBot;

@Controller
public class TelegramBotController {
    private final TelegramBot telegramBot;

    public TelegramBotController(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        telegramBot.sendToTelegram(message);
        return ResponseEntity.ok("Message has been sent");
    }
}
