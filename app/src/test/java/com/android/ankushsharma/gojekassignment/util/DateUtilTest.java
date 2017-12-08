package com.android.ankushsharma.gojekassignment.util;

import android.text.format.DateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by ankushsharma on 09/12/17.
 */
public class DateUtilTest {

    @Test
    public void testIfDayFromDateIsCorrect() throws Exception {
        String date_string = "2017-12-09"; //7th Nov 2015
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(date_string);
            String dayOfWeek = String.valueOf(DateFormat.format("EEEE", date));
            assertEquals("Day is wrong", "SATURDAY", dayOfWeek);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}