package com.gwhittton.cron_parser.cron_parser;

public class CronParser 
{
	private static final int MIN_CRON_STRING_LENGTH = 6;
	private String minute;
	private String hour;
	private String dayOfMonth;
	private String month;
	private String dayOfWeek;
	private String command;
	
	public String getMinute() {
		return minute;
	}

	public String getHour() {
		return hour;
	}

	public String getDayOfMonth() {
		return dayOfMonth;
	}

	public String getMonth() {
		return month;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public String getCommand() {
		return command;
	}

	public CronParser(String cronString){
		//validate
		
		/*
		 * array should contain at least 6 entries - 
		 * 
		 * minute
		 * hour
		 * dayOfMonth
		 * month
		 * dayOfWeek
		 */
		String[] cronStringSplit = cronString.split(" ");
		
		if(cronStringSplit.length < MIN_CRON_STRING_LENGTH){
			throw new CronParserException(String.format("invalid string, only %d present, %d required", cronStringSplit.length, MIN_CRON_STRING_LENGTH));
		}
		
		minute = CronStringParser.parseMinute(cronStringSplit[0]);
		hour = CronStringParser.parseHour(cronStringSplit[1]);
		dayOfMonth = CronStringParser.parseDayOfMonth(cronStringSplit[2]);
		month = CronStringParser.parseMonth(cronStringSplit[3]);
		dayOfWeek = CronStringParser.parseDayOfWeek(cronStringSplit[4]);
		
		//lets assume the remainder of the string consists of the command
		StringBuilder commandSb = new StringBuilder();
		
		for(int i = 5; i < cronStringSplit.length; i++){
			commandSb.append(cronStringSplit[i]);
		}
		
		command = commandSb.toString();
	}

    public static void main( String[] args )
    {
    	if(args.length != 1){
    		throw new CronParserException("there must be one command line argument");
    	}
    	
    	CronParser cronParser = new CronParser(args[0]);
    	CronStringPrinter printer = new CronStringPrinter();
    	printer.setMinute(cronParser.getMinute());
    	printer.setHour(cronParser.getHour());
    	printer.setDayOfMonth(cronParser.getDayOfMonth());
    	printer.setMonth(cronParser.getMonth());
    	printer.setDayOfWeek(cronParser.getDayOfWeek());
    	printer.setCommand(cronParser.getCommand());
    	printer.printEnumeratedString();
    }
}
