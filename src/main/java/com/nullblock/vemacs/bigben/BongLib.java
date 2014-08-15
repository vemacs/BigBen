package com.nullblock.vemacs.bigben;

import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.ChatColor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class BongLib {
    private BongLib() {
    }

    public static String getTimeString() {
        SimpleDateFormat timeUTC = new SimpleDateFormat("HH:mm:ss");
        timeUTC.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat dateFormatLocal = new SimpleDateFormat("HH:mm:ss");
        String time;
        try {
            time = dateFormatLocal.parse(timeUTC.format(new Date())).toString().substring(11, 19).trim();
            return time;
        } catch (ParseException ignored) {
        }
        return null;
    }

    public static int secondOfDay() {
        String time = getTimeString();
        return Integer.parseInt(time.substring(0, 2)) * 3600 + Integer.parseInt(time.substring(3, 5)) * 60 + Integer.parseInt(time.substring(6, 8));
    }

    public static int nextHour() {
        return (int) Math.ceil((double) secondOfDay() / 3600);
    }

    public static int secondsUntilNextHour() {
        return nextHour() * 3600 - secondOfDay();
    }

    public static String bongText(int hours) {
        String text = "";
        hours %= 12;
        hours = hours == 0 ? 12 : hours;
        for (int i = 1; i <= hours; i++)
            text += "BONG ";
        return text;
    }

    public static String replaceAcutesHTML(String str) {
        return StringEscapeUtils.unescapeHtml(str).replaceAll("[^\\x20-\\x7e]", "");
    }

    public static String cleanUp(String str) {
        str = str.replace("<em>", ChatColor.ITALIC.toString());
        str = str.replace("<b>", ChatColor.BOLD.toString());
        str = str.replace("<u>", ChatColor.UNDERLINE.toString());
        str = str.replace("</em>", ChatColor.RESET.toString());
        str = str.replace("</b>", ChatColor.RESET.toString());
        str = str.replace("</u>", ChatColor.RESET.toString());
        str = str.replace("</center>", "");
        str = str.replace("<center>", "");
        str = str.replace("<br>", "\n");
        String pattern = "\\<.*?\\>.*?\\<\\/.*?\\>";
        str = str.replaceAll(pattern, "");
        str = str.replaceAll("\\s+", " ").trim();
        return str;
    }
}
