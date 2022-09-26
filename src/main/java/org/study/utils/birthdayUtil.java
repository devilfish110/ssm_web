package org.study.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class birthdayUtil {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static int age = 0;
    public static Date nowDate = new Date();

    public static String timeFormat(Date birthday) {
        return dateFormat.format(birthday);
    }

    public static int getAge(Date birthday) {
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(birthdayUtil.nowDate);

        //当前时间
        int nowYear = nowCalendar.get(Calendar.YEAR);
        int nowMonth = nowCalendar.get(Calendar.MONTH) + 1;
        int nowDate = nowCalendar.get(Calendar.DATE);

        //出生的时间
        Calendar birCalendar = Calendar.getInstance();
        birCalendar.setTime(birthday);
        int birYear = birCalendar.get(Calendar.YEAR);
        int birMonth = birCalendar.get(Calendar.MONTH) + 1;
        int birDate = birCalendar.get(Calendar.DATE);
        if (nowCalendar.after(birCalendar)) {
            age = nowYear - birYear;
            if (nowMonth <= birMonth) {
                if (nowMonth == birMonth) {
                    if (nowDate < birDate) {
                        --age;
                    }
                } else {
                    --age;
                }
            }
        } else {
            age = 0;
        }

        return age;
    }
}
