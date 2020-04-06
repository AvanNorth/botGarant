import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NaebCommand extends BotsCommand {

    private final ICommandRegistry mCommandRegistry;

    public NaebCommand(ICommandRegistry commandRegistry) {
        super("naeb", "sosi");
        mCommandRegistry = commandRegistry;
    }
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        if (chat.getId() == 615213408){

            final String regex = "\\D+";
            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(strings[0]);
            if (matcher.find()) {
                System.out.println("Full match: " + matcher.group(0));
                SendMessage message = new SendMessage();
                message.setChatId((long)615213408);
                message.setText(matcher.group(0));
                execute(absSender, message, user);
            }
        }

    }
}