package com.gwhittton.cron_parser.cron_parser;

import junit.framework.TestCase;

public class CronStringParserTests extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testParseMinute() {
		String result1 = CronStringParser.parseMinute("*");
		assertTrue(result1.equals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59"));
	
		String result2 = CronStringParser.parseMinute("*/15");
		assertTrue(result2.equals("0 15 30 45"));
		
		String result3 = CronStringParser.parseMinute("30");
		assertTrue(result3.equals("30"));
		
		String result4 = CronStringParser.parseMinute("5,20,50");
		assertTrue(result4.equals("5 20 50"));
		
		String result5 = CronStringParser.parseMinute("15-20");
		assertTrue(result5.equals("15 16 17 18 19 20"));
	}

	public void testParseHour() {
		String result1 = CronStringParser.parseHour("*");
		assertTrue(result1.equals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23"));
	
		String result2 = CronStringParser.parseHour("*/3");
		assertTrue(result2.equals("0 3 6 9 12 15 18 21"));
		
		String result3 = CronStringParser.parseHour("12");
		assertTrue(result3.equals("12"));
		
		String result4 = CronStringParser.parseHour("6,12,18");
		assertTrue(result4.equals("6 12 18"));
		
		String result5 = CronStringParser.parseHour("15-20");
		assertTrue(result5.equals("15 16 17 18 19 20"));
	}

	public void testParseDayOfMonth() {
		String result1 = CronStringParser.parseDayOfMonth("*");
		assertTrue(result1.equals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31"));
	
		String result2 = CronStringParser.parseDayOfMonth("*/3");
		assertTrue(result2.equals("1 4 7 10 13 16 19 22 25 28 31"));
		
		String result3 = CronStringParser.parseDayOfMonth("12");
		assertTrue(result3.equals("12"));
		
		String result4 = CronStringParser.parseDayOfMonth("6,12,18");
		assertTrue(result4.equals("6 12 18"));
		
		String result5 = CronStringParser.parseDayOfMonth("15-20");
		assertTrue(result5.equals("15 16 17 18 19 20"));
	}

	public void testParseMonth() {
		String result1 = CronStringParser.parseMonth("*");
		assertTrue(result1.equals("1 2 3 4 5 6 7 8 9 10 11 12"));
	
		String result2 = CronStringParser.parseMonth("*/3");
		assertTrue(result2.equals("1 4 7 10"));
		
		String result3 = CronStringParser.parseMonth("12");
		assertTrue(result3.equals("12"));
		
		String result4 = CronStringParser.parseMonth("2,5,7");
		assertTrue(result4.equals("2 5 7"));
		
		String result5 = CronStringParser.parseMonth("3-6");
		assertTrue(result5.equals("3 4 5 6"));
	}

	public void testParseDayOfWeek() {
		String result1 = CronStringParser.parseDayOfWeek("*");
		assertTrue(result1.equals("1 2 3 4 5 6 7"));
	
		String result2 = CronStringParser.parseDayOfWeek("*/3");
		assertTrue(result2.equals("1 4 7"));
		
		String result3 = CronStringParser.parseDayOfWeek("2");
		assertTrue(result3.equals("2"));
		
		String result4 = CronStringParser.parseDayOfWeek("2,5,7");
		assertTrue(result4.equals("2 5 7"));
		
		String result5 = CronStringParser.parseDayOfWeek("3-6");
		assertTrue(result5.equals("3 4 5 6"));
	}
}
