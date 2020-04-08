import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public final class StartCommand extends BotsCommand {

    private final ICommandRegistry mCommandRegistry;

    public StartCommand(ICommandRegistry commandRegistry) {
        super("start", "старт");
        mCommandRegistry = commandRegistry;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage message = new SendMessage();
        message.setChatId(chat.getId().toString());
        message.setText("\uD83D\uDDB1Здравствуйте! Вы используете нашего гарант бота! Мы проверяем аккаунт на наличие верных данных, гарантируем честность проведения сделки.\n\uD83D\uDCCCПОЖАЛУЙСТА НЕ НАЖИМАЙТЕ 2 РАЗА НА КНОПКУ БОТ АВТОМАТИЧЕСКИ ОПРЕДЕЛИТ ПРОДАВЦА\uD83D\uDCCC\n");
        Menu menu = new Menu();
        message.setReplyMarkup(menu.getMainMenuReplyKeyboard());

        execute(absSender, message, user);
    }
}