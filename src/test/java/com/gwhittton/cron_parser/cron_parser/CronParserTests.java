package com.gwhittton.cron_parser.cron_parser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CronParserTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCronParser1() {
		String cronString = "*/15 0 1,15 * 1-5 /usr/bin/find";
		CronParser parser = new CronParser(cronString);
		assertTrue(parser.getMinute().equals("0 15 30 45"));
		assertTrue(parser.getHour().equals("0"));
		assertTrue(parser.getDayOfMonth().equals("1 15"));
		assertTrue(parser.getMonth().equals("1 2 3 4 5 6 7 8 9 10 11 12"));
		assertTrue(parser.getDayOfWeek().equals("1 2 3 4 5"));
		assertTrue(parser.getCommand().equals("/usr/bin/find"));
	}
	
	@Test
	public void testCronParser2() {
		String cronString = "1-5 */15 1 1,12 * /usr/bin/find";
		CronParser parser = new CronParser(cronString);
		assertTrue(parser.getMinute().equals("1 2 3 4 5"));
		assertTrue(parser.getHour().equals("0 15"));
		assertTrue(parser.getDayOfMonth().equals("1"));
		assertTrue(parser.getMonth().equals("1 12"));
		assertTrue(parser.getDayOfWeek().equals("1 2 3 4 5 6 7"));
		assertTrue(parser.getCommand().equals("/usr/bin/find"));
	}
	
	@Test(expected=CronParserException.class)
	public void testCronParserEmpty() {
		String cronString = "";
		new CronParser(cronString);
	}
	
	@Test(expected=CronParserException.class)
	public void testCronParserMissingArg() {
		String cronString = "*/15 0 1,15 1-5 /usr/bin/find";
		new CronParser(cronString);
	}
	
	@Test(expected=CronParserException.class)
	public void testCronParserMissingCommand() {
		String cronString = "*/15 0 1,15 1-5 3";
		new CronParser(cronString);
	}
}
