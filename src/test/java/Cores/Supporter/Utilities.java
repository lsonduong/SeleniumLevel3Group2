package Cores.Supporter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.UUID;

import TestData.Constant;

public class Utilities {
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	// return integer random
	public static int randomInt(int min, int max) {
		// Code in here
		return 0; 
	}
	
	// return character random
    public static char randomCharacter() {
    	// Code in here
        return 'a';
    }
    
    public static LocalDate convertStringtoDate(String sdate, String pattern) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date;
		try {
			date = LocalDate.parse(sdate, formatter);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public static String convertDateToString(LocalDate localDate, String pattern) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    	
    	try {
    		return localDate.format(formatter);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static String convertStringDateToAnotherPattern(String date, String oldPattern, String newPattern) {
    	LocalDate d = convertStringtoDate(date, oldPattern);
    	return convertDateToString(d, newPattern);
    }
    
    public static LocalDate calcNextFriday(LocalDate d) {
    	return d.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
    }

    public static String generateString() {
        String uuid = UUID.randomUUID().toString().replaceAll("-","").substring(15);
        return uuid;
    }
    
    public static String getNextFriday() {
    	LocalDate d = LocalDate.now();
    	LocalDate dFri = calcNextFriday(d);
    	return convertDateToString(dFri, Constant.AgodaDatePattern);
    }
    
    public static String getNextFridayPlusThree() {
    	LocalDate d = LocalDate.now();
    	LocalDate dFri = calcNextFriday(d);
    	LocalDate dFriPlus3 = dFri.plusDays(3);
    	return convertDateToString(dFriPlus3, Constant.AgodaDatePattern);
    }
    
    public static String getNextDay() {
    	LocalDate d = LocalDate.now();
    	LocalDate dPlus = d.plusDays(1);
    	return convertDateToString(dPlus, Constant.VietjetDatePattern);
    }
    
    public static String getNextDay(String pattern) {
    	LocalDate d = LocalDate.now();
    	LocalDate dPlus = d.plusDays(1);
    	return convertDateToString(dPlus, pattern);
    }
    
    public static String getNextDayPlusTree() {
    	LocalDate d = LocalDate.now();
    	LocalDate dPlus3 = d.plusDays(4);
    	return convertDateToString(dPlus3, Constant.VietjetDatePattern);
    }
    
    public static String getNextDayPlusTree(String pattern) {
    	LocalDate d = LocalDate.now();
    	LocalDate dPlus = d.plusDays(4);
    	return convertDateToString(dPlus, pattern);
    }
    
    public static String getTodayPlusTree(String pattern) {
    	LocalDate d = LocalDate.now();
    	LocalDate dPlus = d.plusDays(3);
    	return convertDateToString(dPlus, pattern);
    }
    
    public static String getStringDatePlusTree(String localDate, String pattern) {
    	LocalDate d = convertStringtoDate(localDate, pattern);
    	LocalDate dPlus = d.plusDays(3);
    	return convertDateToString(dPlus, pattern);
    }
    
    public static String removeNonDigits(String str) {
    	return str.replaceAll("[^0-9]", "");
    }
    
    public static String[] splitDayMonthYear(String date) {
    	return date.split(" ");
    }
    
    public static void wait(int seconds) {
    	try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
        
    public static boolean compareTwoStrings(String a, String b, boolean isIgnoreCase)
    {
    	System.out.println(a + "compare:" + b);
        if (isIgnoreCase)
        {
            return a.equalsIgnoreCase(b);
        }

        return a.equals(b);
    }
    
    public static boolean isBlankOrNull(String str) {
        return (str == null || "".equals(str.trim()));
    }
}
