package Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegex {
    public static boolean checkNameStudent(String str) {
        String regex = "^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean checkAgeStudent(String str) {
        String regex = "^(0?[1-9]|[1-9][0-9]|[1][0-9][0-9]|200)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean checkAddressStudent(String str) {
        String regex = "\\d+\\s+([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean checkSroceStudent(String str) {
        String regex = "^\\d\\.\\d|[10\\.0]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static boolean checkId(String str) {
        String regex = "^\\d{1}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static String convertInt(String str) {
        if (str.equals("1")||str.equals("2")||str.equals("3")||str.equals("4")|| str.equals("5")||
                str.equals("6")||str.equals("7")||str.equals("8")|| str.equals("9")||str.equals("10")) {
            str = str + ".0";
        }
        return str;
    }
}
