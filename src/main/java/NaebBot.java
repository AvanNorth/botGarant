import org.apache.commons.logging.Log;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class NaebBot extends TelegramLongPollingCommandBot {

        public NaebBot() {
            StartCommand startCommand = new StartCommand(this);
            register(startCommand);
        }

        public String getBotUsername() {
            return "GarantService";
        }

        @Override
        public String getBotToken() {
            return "1147671928:AAEM_iYtAMkIChYhOKDS9NlG3ke5eH-cpKc";
        }

        @Override
        public void processNonCommandUpdate(Update update) {
            Message msg = update.getMessage();
            long chatId = msg.getChatId();
            Menu menu = new Menu();
            switch (msg.getText()) {
                case "Проверить аккаунт":{
                    sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Отправьте 99999руб на номер 88005553535 и получите по ебалу");
                    System.out.println(msg.getChatId());
                    sendMessageToUser(615213408,msg.getChatId().toString());
                    break;
                }

                default: {
                    if(chatId == 615213408){
                        
                    }
                    if (!msg.getText().equals("/start")) {
                        sendMessageToUser(chatId, "Извини, но я тебя не понимаю, \nпопробуй нажать /start");
                    }
                    break;
                }
            }
        }


    private void sendMessageToUser(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(chatId);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.err.println(e);
        }
    }

    private void sendKeyboardMarkupToUser(long chatId, ReplyKeyboardMarkup replyKeyboardMarkup, String reply) {
        SendMessage message = new SendMessage();
        message.setReplyMarkup(replyKeyboardMarkup);
        message.setText(reply);
        message.setChatId(chatId);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.err.println(e);
        }
    }
    }
