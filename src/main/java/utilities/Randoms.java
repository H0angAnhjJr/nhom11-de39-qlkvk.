package utilities;

import java.text.ParseException;
import java.util.Date;

public class Randoms {
    public static int randInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    static String z = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    public static String randString(int len) {
        String res = "";
        for (int i = 0; i < len; ++i)
            res += z.charAt(randInt(0, z.length() - 1));
        return res;
    }

    public static Date randDate() throws ParseException {
        int nam = randInt(1900, 2024);
        int month = randInt(1, 12);
        int ngay = randInt(1, DateUtils.checkMonth(month, nam));
        return DateUtils.createDate(ngay, month, nam);
    }
}
