import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PriceCommand extends BotsCommand {

    private final ICommandRegistry mCommandRegistry;

    public PriceCommand(ICommandRegistry commandRegistry) {
        super("price", "sosi");
        mCommandRegistry = commandRegistry;
    }
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

            final String regex = "\\D+";
            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(strings[0]);
            if (matcher.find()) {
                char[] helloArray1 = strings[0].toCharArray();
                char[] idArray = new char[9];
                char[] priceArray = new char[4];
                System.arraycopy(helloArray1, 0, idArray, 0, 9);
                System.arraycopy(helloArray1, 10, priceArray, 0, 4);
                String helloString = new String(idArray);
                String priceString = new String(priceArray);
                System.out.println("Full match: " + matcher.group(0));
                SendMessage message = new SendMessage();
                message.setChatId(Long.parseLong(helloString,10));
                message.setText(priceString);
                System.out.println(priceString);
                execute(absSender, message, user);
            }
        

    }
}