package com.android.ankushsharma.gojekassignment.util;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ankushsharma on 09/12/17.
 */

public class DateUtil {

    public static String getDayFromDateString(String date_string) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(date_string);
            return String.valueOf(DateFormat.format("EEEE", date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
