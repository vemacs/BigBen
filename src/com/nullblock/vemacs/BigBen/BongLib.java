package com.nullblock.vemacs.BigBen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
	
	public static String textToColor(String text)
	{
		text = text.replaceAll("&0", ChatColor.BLACK+"");
		text = text.replaceAll("&1", ChatColor.DARK_BLUE+"");
		text = text.replaceAll("&2", ChatColor.DARK_GREEN+"");
		text = text.replaceAll("&3", ChatColor.DARK_AQUA+"");
		text = text.replaceAll("&4", ChatColor.DARK_RED+"");
		text = text.replaceAll("&5", ChatColor.DARK_PURPLE+"");
		text = text.replaceAll("&6", ChatColor.GOLD+"");
		text = text.replaceAll("&7", ChatColor.GRAY+"");
		text = text.replaceAll("&8", ChatColor.DARK_GRAY+"");
		text = text.replaceAll("&9", ChatColor.BLUE+"");
		text = text.replaceAll("&A", ChatColor.GREEN+"");
		text = text.replaceAll("&B", ChatColor.AQUA+"");
		text = text.replaceAll("&C", ChatColor.RED+"");
		text = text.replaceAll("&D", ChatColor.LIGHT_PURPLE+"");
		text = text.replaceAll("&E", ChatColor.YELLOW+"");
		text = text.replaceAll("&F", ChatColor.WHITE+"");
		text = text.replaceAll("&a", ChatColor.GREEN+"");
		text = text.replaceAll("&b", ChatColor.AQUA+"");
		text = text.replaceAll("&c", ChatColor.RED+"");
		text = text.replaceAll("&d", ChatColor.LIGHT_PURPLE+"");
		text = text.replaceAll("&e", ChatColor.YELLOW+"");
		text = text.replaceAll("&u", ChatColor.UNDERLINE+"");
		text = text.replaceAll("&U", ChatColor.UNDERLINE+"");
		text = text.replaceAll("&n", ChatColor.BOLD+"");
		text = text.replaceAll("&N", ChatColor.BOLD+"");
		text = text.replaceAll("&o", ChatColor.ITALIC+"");
		text = text.replaceAll("&O", ChatColor.ITALIC+"");
		text = text.replaceAll("&i", ChatColor.ITALIC+"");
		text = text.replaceAll("&I", ChatColor.ITALIC+"");
		text = text.replaceAll("&k", ChatColor.MAGIC+"");
		text = text.replaceAll("&K", ChatColor.MAGIC+"");
		return text;
	}

	
}
