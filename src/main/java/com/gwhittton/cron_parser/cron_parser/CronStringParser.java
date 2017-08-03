package com.gwhittton.cron_parser.cron_parser;

public class CronStringParser {
	
	private static final int MAX_DAY = 7;
	private static final int MIN_DAY = 1;
	private static final int MAX_MONTH = 12;
	private static final int MIN_MONTH = 1;
	private static final int MAX_DAY_OF_MONTH = 31;
	private static final int MIN_DAY_OF_MONTH = 1;
	private static final int MAX_HOUR = 23;
	private static final int MIN_HOUR = 0;
	private static final int MAX_MINUTE = 59;
	private static final int MIN_MINUTE = 0;

	/**
	 * Parses a minutes value
	 * 
	 * @param value
	 * @return
	 */
	public static String parseMinute(String value){
		return CronStringTokenEnumerator.enumerateToken(value, MIN_MINUTE, MAX_MINUTE);
	}
	
	/**
	 * Parses an hours value
	 * 
	 * @param value
	 * @return
	 */
	public static String parseHour(String value){
		return CronStringTokenEnumerator.enumerateToken(value, MIN_HOUR, MAX_HOUR);
	}
	
	/**
	 * Parses a days of month value
	 * 
	 * @param value
	 * @return
	 */
	public static String parseDayOfMonth(String value){
		return CronStringTokenEnumerator.enumerateToken(value, MIN_DAY_OF_MONTH, MAX_DAY_OF_MONTH);
	}
	
	/**
	 * Parses a month
	 * 
	 * @param value
	 * @return
	 */
	public static String parseMonth(String value){
		return CronStringTokenEnumerator.enumerateToken(value, MIN_MONTH, MAX_MONTH);
	}
	
	/**
	 * parses a day of week
	 * 
	 * @param value
	 * @return
	 */
	public static String parseDayOfWeek(String value){
		return CronStringTokenEnumerator.enumerateToken(value, MIN_DAY, MAX_DAY);
	}
}
