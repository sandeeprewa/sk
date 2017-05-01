package com.academics.school.pl.controller.registration.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	
	public static boolean isEmpty(String input){
		return input=="";
	}
	
	public static boolean isNull(String input){
		return input==null;
	}
	
	public static boolean isEmptyOrNull(String input){
		return isEmpty(input) || isNull(input);
	}
	
	public static boolean containOnlyNumbers(String input){
		return (input.matches("[0-9]+"));
	}
	
	public static boolean containOnlyAlphnumericWords(String input){
		return (input.matches("[a-zA-Z_]+")) ;
	}

	public static boolean isVaildEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
	}

}
