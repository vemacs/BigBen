package com.nullblock.vemacs.BigBenTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.nullblock.vemacs.BigBen.BongLib;

public class BigBenTest {
	public static void main(String[] args) {
		SimpleDateFormat timeUTC = new SimpleDateFormat("HH:mm:ss");
		timeUTC.setTimeZone(TimeZone.getTimeZone("GMT"));

		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("HH:mm:ss");

		try {
			String time = dateFormatLocal.parse(timeUTC.format(new Date())).toString().substring(11, 19).trim();
			int second = Integer.parseInt(time.substring(0,2)) * 3600 + Integer.parseInt(time.substring(3,5)) * 60 + Integer.parseInt(time.substring(6,8));
			int nexthour = (int)Math.ceil((double)second / 3600);
			int secondsUntilNextHour = nexthour * 3600 - second;
			System.out.println(second);
			System.out.println(secondsUntilNextHour);
	        int hour = 1;
	        for(;;){
	            try {
	                Thread.sleep(1000);
	            } catch(InterruptedException ex) {
	                Thread.currentThread().interrupt();
	            }
	            hour++;
	            hour = hour % 12;
	            System.out.println(BongLib.bongText(hour));
	        }
		
		} catch (ParseException e) {
		}

	}

}
