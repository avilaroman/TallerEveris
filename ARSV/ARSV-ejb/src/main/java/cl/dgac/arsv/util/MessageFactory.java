package cl.dgac.arsv.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessageFactory {

	private static final String DEFAULT_BUNDLE = "ValidationMessages";

	
	public static String getMessage(String key, Locale locale, Object... params) {

		ResourceBundle bundle = ResourceBundle
				.getBundle(DEFAULT_BUNDLE, locale);
		String summary = "???" + key + "???";

		try {
			key = key.substring(1,key.length()-1);
			summary = MessageFormat.format(bundle.getString(key), params);
		} catch (MissingResourceException e) {

		}

		return summary;
	}

	public static String getMessage(String key, Object... params) {
		return getMessage(key, Locale.getDefault(), params);
	}

	public static String getMessage(String key) {
		return getMessage(key, Locale.getDefault(), new Object[] {});
	}

	public static String getMessage(String key, Locale lc) {
		return getMessage(key, lc, new Object[] {});
	}

}
