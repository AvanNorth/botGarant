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
        super("price", "sosis");
        mCommandRegistry = commandRegistry;
    }
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
    if (chat.getId() == 615213408){
        Menu menu = new Menu();
        char[] helloArray1 = strings[0].toCharArray();
        char[] idArray = new char[9];
        char[] priceArray = new char[3];
        String naeb1 = "Аккаунт проверен!Статус - аккаунт рабочий.\nПереведите ";
        String naeb2 = " рублей на +79670701429(киви), после чего вам будут высланы данные от аккаунта.";
        System.arraycopy(helloArray1, 0, idArray, 0, 9);
        System.arraycopy(helloArray1, 9, priceArray, 0, 3);
        String helloString = new String(idArray);
        String helloString2 = new String(priceArray);
        SendMessage message = new SendMessage();
        message.setChatId(Long.parseLong(helloString, 10));
        message.setText(naeb1+helloString2+naeb2);
        message.setReplyMarkup(menu.getMainMenuReplyKeyboard());
        execute(absSender, message, user);
    }else{
        SendMessage message = new SendMessage();
        message.setText("Извини, но я тебя не понимаю, \nпопробуй нажать /start");
        message.setChatId(chat.getId());
        execute(absSender,message,user);
    }
    }
}