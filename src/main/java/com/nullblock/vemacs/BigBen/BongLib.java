package com.nullblock.vemacs.BigBen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.ChatColor;

public class BongLib {

	public static String getTimeString(){
		SimpleDateFormat timeUTC = new SimpleDateFormat("HH:mm:ss");
		timeUTC.setTimeZone(TimeZone.getTimeZone("GMT"));
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("HH:mm:ss");
		String time = null;
		try {
			time = dateFormatLocal.parse(timeUTC.format(new Date())).toString().substring(11, 19).trim();
			return time;
		} catch (ParseException e) {
		}
		return time;
		
	}
	
	public static int secondOfDay()  {
		String time = getTimeString();
		int second = Integer.parseInt(time.substring(0,2)) * 3600 + Integer.parseInt(time.substring(3,5)) * 60 + Integer.parseInt(time.substring(6,8));
		return second;
	}
	
	public static int nextHour() {
		int nexthour = (int)Math.ceil((double)secondOfDay() / 3600);
		return nexthour;
	}
	
	public static int secondsUntilNextHour() {
		int seconds = nextHour() * 3600 - secondOfDay();
		return seconds;
	}
	
	public static String bongText(int hours){
		String text = "";
		hours = hours % 12;
		if(hours == 0){
			hours = 12;
		}
		for(int i=1; i<=hours; i++){
			text = text + "BONG " ;
		}
		return text;
	}
	
	public static String textToColor(String text) {
	//copied from http://forums.bukkit.org/threads/simple-colors-parsing-method.32058/#post-1251988
        char[] chrarray = text.toCharArray();
 
        for (int index = 0; index < chrarray.length; index ++) {
            char chr = chrarray[index];
            if (chr != '&') {
                continue;
            }
 
            if ((index + 1) == chrarray.length) {
                break;
            }
             char forward = chrarray[index + 1];
            if ((forward >= '0' && forward <= '9') || (forward >= 'a' && forward <= 'f') || (forward >= 'k' && forward <= 'r')) {
                chrarray[index] = '\u00A7';
            }
        }
         return new String(chrarray);
    }
	
	public static String replaceAcutesHTML(String str) {

		str = StringEscapeUtils.unescapeHtml(str).replaceAll("[^\\x20-\\x7e]", "");

		return str;
	}

	
}
