package com.gwhittton.cron_parser.cron_parser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CronStringPrinterTests {

	private static CronStringPrinter printer;

	@Before
	public void setUp() throws Exception {
		printer = new CronStringPrinter();
		printer.setMinute("0 15 30 45");
		printer.setHour("0");
		printer.setDayOfMonth("1 15");
		printer.setMonth("1 2 3 4 5 6 7 8 9 10 11 12");
		printer.setDayOfWeek("1 2 3 4 5");
		printer.setCommand("/usr/bin/find");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMinute() {
		assertTrue(printer.getMinute().equals("minute        0 15 30 45"));
	}

	@Test
	public void testGetHour() {
		assertTrue(printer.getHour().equals("hour          0"));
	}

	@Test
	public void testGetDayOfMonth() {
		assertTrue(printer.getDayOfMonth().equals("day of month  1 15"));
	}

	@Test
	public void testGetMonth() {
		assertTrue(printer.getMonth().equals("month         1 2 3 4 5 6 7 8 9 10 11 12"));
	}

	@Test
	public void testGetDayOfWeek() {
		assertTrue(printer.getDayOfWeek().equals("day of week   1 2 3 4 5"));
	}

	@Test
	public void testGetCommand() {
		assertTrue(printer.getCommand().equals("command       /usr/bin/find"));
	}
	
	@Test
	public void testPrintEnumeratedString() {
		//largely for manual testing by viewing the cmd line
		printer.printEnumeratedString();
	}

}
