package utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static Date str2Date(String str) {
        try {
            return format.parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String date2Str(Date date) {
        return format.format(date);
    }

    public static boolean checkField(String ngay, String thang, String nam) {
        return Integer.parseInt(ngay) < checkMonth(Integer.parseInt(thang), Integer.parseInt(nam));
    }

    public static Date createDate(int ngay, int thang, int nam) {
        try {
            return format.parse(String.format("%d/%d/%d", ngay, thang, nam));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static String createStrDate(String ngay, String thang, String nam) {
        return ngay + "/" + thang + "/" + nam;
    }

    public static int checkMonth(int thang, int nam) {
        switch (thang) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
            case 2 -> {
                return isLeapYear(nam) ? 29 : 28;
            }
            default -> {
                return 0;
            }
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
