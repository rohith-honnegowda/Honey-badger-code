package com.partnerdiscovery;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This is used to validate the URL before passing it on the Image Processor
public class ValidationUtility {

	private static final String URL_REGEX =
			"^((((http?|https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
			"(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
			"([).!';/?:,][[:blank:]])?$";
	
	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	
	public static boolean ValidateURL(String url) {
		if (url == null) {
			return false;
		}

		Matcher matcher = URL_PATTERN.matcher(url);
		return matcher.matches();
	}
	
	// The idea was to only use urls which has a .jpeg/.gif at the end but not all urls of images have that format.
	public static boolean ValidateImageURL(String url) {
		if (url == null) {
			return false;
		}
		
		String[] parts = url.split("\\.");
		
		if(parts.length > 0) {
			if(parts[parts.length - 1] == ("jpg")|| parts[parts.length - 1] == ("jpeg")) {
				return true;
			}
		}
		
		return false;
	}
	
}
