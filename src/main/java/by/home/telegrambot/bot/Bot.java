package by.home.telegrambot.bot;

import by.home.telegrambot.config.BotProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramLongPollingBot {

    private final BotProperties botProperties;

    public Bot(final BotProperties botProperties) {
        this.botProperties = botProperties;
    }

    @Override
    public void onUpdateReceived(final Update update) {

    }

    @Override
    public String getBotUsername() {
        return botProperties.getName();
    }

    @Override
    public String getBotToken() {
        return botProperties.getToken();
    }
}
