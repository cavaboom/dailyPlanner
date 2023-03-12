package Util;

import Exception.IncorrectArgumentException;
public class Util {
    public static String checkString(String string) throws IncorrectArgumentException {
        if (string == null || string.isEmpty()) {
            throw new IncorrectArgumentException("Некорректный ввод");
        } else {
            return string;
        }
    }
}
