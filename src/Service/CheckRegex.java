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
        String regex = "^(0?[1-9]|[1-9][0-9]|[1][1-9][1-9]|200)$";
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
}
