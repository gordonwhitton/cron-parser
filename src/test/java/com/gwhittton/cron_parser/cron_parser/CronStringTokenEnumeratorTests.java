package com.gwhittton.cron_parser.cron_parser;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class CronStringTokenEnumeratorTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEnumerateTokenNull() {
		int min = 0;
		int max = 100;
		CronStringTokenEnumerator.enumerateToken(null, min, max);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEnumerateTokenIsEmpty() {
		
		int min = 0;
		int max = 100;
		CronStringTokenEnumerator.enumerateToken("", min, max);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEnumerateTokenNegative1() {
		
		int min = -1;
		int max = 100;
		CronStringTokenEnumerator.enumerateToken("value", min, max);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEnumerateTokenNegative2() {
		
		int min = 1;
		int max = -100;
		CronStringTokenEnumerator.enumerateToken("value", min, max);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEnumerateTokenMinGTMax() {
		
		int min = 2;
		int max = 1;
		CronStringTokenEnumerator.enumerateToken(null, min, max);
	}

	@Test
	public void testEnumerateTokenWildcard() {
		int min = 0;
		int max = 10;
		String result = CronStringTokenEnumerator.enumerateToken("*", min, max);
		assertTrue(result.equals("0 1 2 3 4 5 6 7 8 9 10"));
	}
	
	@Test
	public void testEnumerateTokenInterval1() {
		int min = 0;
		int max = 59;
		String result = CronStringTokenEnumerator.enumerateToken("*/15", min, max);
		assertTrue(result.equals("0 15 30 45"));
	}
	
	@Test
	public void testEnumerateTokenInterval2() {
		int min = 0;
		int max = 59;
		String result = CronStringTokenEnumerator.enumerateToken("*/45", min, max);
		assertTrue(result.equals("0 45"));
	}
	
	@Test
	public void testEnumerateTokenInterval3() {
		int min = 0;
		int max = 10;
		String result = CronStringTokenEnumerator.enumerateToken("*/5", min, max);
		assertTrue(result.equals("0 5 10"));
	}
	
	@Test(expected=CronParserException.class)
	public void testEnumerateTokenIntervalOutOfRange() {
		int min = 0;
		int max = 10;
		CronStringTokenEnumerator.enumerateToken("*/11", min, max);
	}
	
	@Test
	public void testEnumerateTokenSingle() {
		int min = 0;
		int max = 10;
		String result1 = CronStringTokenEnumerator.enumerateToken("5", min, max);
		assertTrue(result1.equals("5"));
		String result2 = CronStringTokenEnumerator.enumerateToken("10", min, max);
		assertTrue(result2.equals("10"));
	}
	
	@Test(expected=CronParserException.class)
	public void testEnumerateTokenSingleOutOfRange() {
		int min = 0;
		int max = 10;
		CronStringTokenEnumerator.enumerateToken("11", min, max);
	}
	
	@Test
	public void testEnumerateTokenList() {
		int min = 0;
		int max = 10;
		String result1 = CronStringTokenEnumerator.enumerateToken("1,3,5,7,9", min, max);
		assertTrue(result1.equals("1 3 5 7 9"));
		String result2 = CronStringTokenEnumerator.enumerateToken("3,5", min, max);
		assertTrue(result2.equals("3 5"));
	}
	
	@Test(expected=CronParserException.class)
	public void testEnumerateTokenListOutOfRange() {
		int min = 0;
		int max = 10;
		CronStringTokenEnumerator.enumerateToken("1,3,5,7,9,11", min, max);
	}

	@Test
	public void testEnumerateTokenRange() {
		int min = 0;
		int max = 10;
		String result = CronStringTokenEnumerator.enumerateToken("1-5", min, max);
		assertTrue(result.equals("1 2 3 4 5"));
	}
	
	@Test(expected=CronParserException.class)
	public void testEnumerateTokenRangeOutOfRange() {
		int min = 0;
		int max = 10;
		CronStringTokenEnumerator.enumerateToken("1-11", min, max);
	}
	
	private static String[] invalid = {"*/", "*8", ",2", "3,4,", "2-", "-5", "some text", "£$%^&£", "-1", String.valueOf(Integer.MIN_VALUE)};
	
	
	@Test
	public void testEnumerateTokenInvalid() {
		int min = 0;
		int max = 10;
		
		for(int i = 0; i < invalid.length; i++){
			try{
				CronStringTokenEnumerator.enumerateToken(invalid[i], min, max);
			} catch(CronParserException e){
				continue;
			}
			fail(String.format("test failed on %s", invalid[i]));
		}
	}
}
