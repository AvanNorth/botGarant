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
                char[] helloArray1 = strings[0].toCharArray();
                char[] helloArray = new char[9];
                for (int i=0;i<9;i++){
                    helloArray[i] = helloArray1[i];
                    helloArray1[i] = 0;
                }
                String helloString = new String(helloArray);
                String helloString2 = new String(helloArray1);
                SendMessage message = new SendMessage();
                message.setChatId(Long.parseLong(helloString,10));
                message.setText(helloString2);
                execute(absSender, message, user);
        }
        else{
            SendMessage message = new SendMessage();
            message.setText("Извини, но я тебя не понимаю, \nпопробуй нажать /start");
            message.setChatId(chat.getId());
            execute(absSender,message,user);
        }


    }
}