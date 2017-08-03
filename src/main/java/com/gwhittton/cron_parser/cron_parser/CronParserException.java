package com.gwhittton.cron_parser.cron_parser;

public class CronParserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1320663640347163908L;
	
	public CronParserException(String format) {
		super(format);
	}
}
