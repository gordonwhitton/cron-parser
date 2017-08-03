package com.gwhittton.cron_parser.cron_parser;

import java.util.regex.Pattern;

public class CronStringTokenEnumerator {

	private static final String WILDCARD_CHARACTER = "*";

	/**
	 * enumerates a cron token
	 * 
	 * @param value
	 * @param min
	 * @param max
	 * @return
	 */
	public static String enumerateToken(String value, int min, int max){
		
		validateParameters(value, min, max);
		
		if(WILDCARD_CHARACTER.equals(value)){
			return parseWildcard(min, max);
		}
			
		if(Pattern.matches("^\\*/[0-9]+$", value)){
			return parseInterval(value, min, max);
		}

		if(Pattern.matches("^[0-9]+$", value)){
			return parseSingle(value, min, max);
		}
		
		if(Pattern.matches("^[0-9]+(,[0-9]+)+$", value)){
			return parseList(value, min, max);
		}
		
		if(Pattern.matches("^[0-9]+-[0-9]+$", value)){
			return parseRange(value, min, max);
		}
		
		throw new CronParserException(String.format("value %s does not correspond to valid pattern", value));
	}

	private static void validateParameters(String value, int min, int max) {
		if(value == null){
			throw new IllegalArgumentException("value is null");
		}
		
		if(value.isEmpty()){
			throw new IllegalArgumentException("value is empty");
		}
		
		if(min < 0 || max < 0){
			throw new IllegalArgumentException("min and max must not be negative");
		}
		
		if(min > max){
			throw new IllegalArgumentException("min is greater than max");
		}
	}

	private static String parseWildcard(int min, int max){
		
		StringBuilder result = new StringBuilder();
		
		for(int i = min; i <= max; i++){
			result.append(i);
			result.append(" ");
		}
		
		result.deleteCharAt(result.length() - 1);
		
		return result.toString();
	}
	
	private static String parseInterval(String value, int min, int max){
		
		String[] valueSplit = value.split("/");
		parseSingle(valueSplit[1], min, max); //use to validate single value
		int interval = Integer.parseInt(valueSplit[1]);
		StringBuilder result = new StringBuilder();
		
		for(int i = min; i <= max; i += interval){
			result.append(i);
			result.append(" ");
		}
		
		result.deleteCharAt(result.length() - 1);
		
		return result.toString();
	}
	
	private static String parseSingle(String value, int min, int max) {
		int valueInt = Integer.parseInt(value);
		
		if(valueInt >= min && valueInt <= max){
			return value;
		}
		
		throw new CronParserException(String.format("value %d is outwith limits of %d to %d", valueInt, min, max));
	}
	
	private static String parseList(String value, int min, int max) {
		String[] valueSplit = value.split(",");
		
		for(int i = 0; i < valueSplit.length; i++){
			parseSingle(valueSplit[i], min, max); //use to validate single value
		}
		
		return value.replace(",", " ");
	}

	private static String parseRange(String value, int min, int max) {
		String[] valueSplit = value.split("-");
		
		int start = Integer.parseInt(valueSplit[0]);
		int end = Integer.parseInt(valueSplit[1]);
		
		if(start < min){
			throw new CronParserException(String.format("start %d is less than %d min", start, min));
		}
		
		if(end > max){
			throw new CronParserException(String.format("end %d is greater than %d max", end, max));

		}
		
		StringBuilder result = new StringBuilder();
		
		for(int i = start; i <= end; i++){
			result.append(i);
			result.append(" ");
		}
		
		result.deleteCharAt(result.length() - 1);
		
		return result.toString();
	}
}
