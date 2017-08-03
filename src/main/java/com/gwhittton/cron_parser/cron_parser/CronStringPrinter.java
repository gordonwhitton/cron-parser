package com.gwhittton.cron_parser.cron_parser;

public class CronStringPrinter {

	private static final String LINE_FORMAT_STRING = "%-14s%s";
	
	//package level getters provided for testing only
	String getMinute() {
		return minute;
	}

	String getHour() {
		return hour;
	}

	String getDayOfMonth() {
		return dayOfMonth;
	}

	String getMonth() {
		return month;
	}

	String getDayOfWeek() {
		return dayOfWeek;
	}

	String getCommand() {
		return command;
	}

	private String minute;
	private String hour;
	private String dayOfMonth;
	private String month;
	private String dayOfWeek;
	private String command;
	
	public void setMinute(String minute) {
		this.minute = String.format(LINE_FORMAT_STRING, "minute", minute);
	}

	public void setHour(String hour) {
		this.hour = String.format(LINE_FORMAT_STRING, "hour", hour);
	}

	public void setDayOfMonth(String dayOfMonth) {
		this.dayOfMonth = String.format(LINE_FORMAT_STRING, "day of month", dayOfMonth);
	}

	public void setMonth(String month) {
		this.month = String.format(LINE_FORMAT_STRING, "month", month);
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = String.format(LINE_FORMAT_STRING, "day of week", dayOfWeek);
	}

	public void setCommand(String command) {
		this.command = String.format(LINE_FORMAT_STRING, "command", command);
	}

	public void printEnumeratedString(){
		System.out.println(minute);
		System.out.println(hour);
		System.out.println(dayOfMonth);
		System.out.println(month);
		System.out.println(dayOfWeek);
		System.out.println(command);
	}
}
