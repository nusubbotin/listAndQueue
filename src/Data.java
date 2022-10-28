import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {

    private static boolean checkFormat(String str){
        Matcher m = Pattern.compile("^[a-zA-Z0-9_]{1,20}$").matcher(str);
        return m.find();
    }

    public static void checkAuthorization (Authorization auth) throws WrongLoginException, WrongPasswordException  {
        if (!checkFormat(auth.getLogin())) {
            throw new WrongLoginException("Не корректный формат Логина", auth.getLogin());
        }

        if (!checkFormat(auth.getPassword()) || !checkFormat(auth.getConfirmPassword()) || !auth.getPassword().equals(auth.getConfirmPassword())) {
            throw new WrongPasswordException("Пароль не соответствует требованиям безопасности или Повторный ввод был с ошибкой ", auth.getPassword(), auth.getConfirmPassword());
        }
    }
}
