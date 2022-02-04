package com.tss.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

public class Utility {
	/**
	 * This method is used to validate given email address
	 * 
	 * @author vinay kumar
	 * @since 2022/01/07
	 * @param String email
	 * @return boolean
	 */
	public static boolean validateEmail(String email) {
		if (isBlank(email)) {
			return false;
		}
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-xA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}

	/**
	 * This method is used to validate the given mobile number
	 * 
	 * @author vinay kumar
	 * @param String number
	 * @since 2022/01/07
	 * @return boolean
	 */
	public static boolean isValidMobileNo(String number) {
		if (isBlank(number)) {
			return false;
		}
		Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		java.util.regex.Matcher match = pattern.matcher(number);
		return (match.find() && match.group().equals(number));
	}

	/**
	 * This method is used to check the given value is blank
	 * 
	 * @author vinay
	 * @since 2022/01/07
	 * @param Object obj
	 * @return boolean
	 */
	public static boolean isBlank(Object obj) {
		if (obj == null)
			return true;
		else if (obj instanceof String)
			return (((String) obj).trim().isEmpty());
		else if (obj instanceof Collection)
			return ((Collection<?>) obj).isEmpty();
		else if (obj instanceof Map)
			return ((Map<?, ?>) obj).isEmpty();
		else if (obj.getClass().isArray())
			return (Array.getLength(obj) <= 0);
		else if (obj instanceof Integer)
			return ((Integer) (obj) <= 0);
		else if (obj instanceof Float)
			return ((Float) (obj) <= 0);
		else if (obj instanceof Double)
			return ((Double) (obj) <= 0);
		else if (obj instanceof Long)
			return ((Long) (obj) <= 0);
		else if (obj instanceof Short)
			return ((Short) (obj) <= 0);
		else if (obj instanceof Byte)
			return ((Byte) (obj) <= 0);
		else if (obj instanceof File)
			return ((File) (obj) == null);
		return false;
	}

	/**
	 * This is a main method to check is file is blank
	 * 
	 * @author vinay kumar
	 * @since 2022/01/07 description:This is a main method
	 */
	public static void main(String[] args) {

		File value = new File("F:\\Upload\\");
		System.out.println(Utility.isBlank(value));
	}

	/**
	 * This method is used to generate random otp
	 * 
	 * @author vinay
	 * @param int length
	 * @since 2022/01/10
	 * @return int
	 */
	public static int otpGenerator(int length) {
		Random random = new Random();
		int otp = random.nextInt(length);
		return otp;
	}

	/**
	 * This method is used to upload file
	 * 
	 * @author vinay
	 * @param filePart
	 * @since 2022/01/11
	 * @return boolean
	 */

	public static boolean fileUpload(Part filePart) throws IOException {
		if (isBlank(filePart)) {
			return false;
		}
		String fileName = filePart.getSubmittedFileName();
		File file = new File("F:\\Upload\\" + File.separator + fileName);
		Files.copy(filePart.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		return true;
	}

	/**
	 * This method extracts data in between the given start and end in the string
	 * 
	 * @author vinay
	 * @param data
	 * @param start
	 * @param end
	 * @since 2022/01/29
	 * @return String
	 */

	public static String getData(String data, String start, String end) {
		if (isBlank(data) || isBlank(start) || isBlank(end)) {
			return "";
		}
		int startStr = data.indexOf(start);
		if (startStr != -1) {
			int endStr = data.indexOf(end, startStr + start.length());
			if (endStr != -1) {
				return data.substring(startStr + start.length(), endStr);
			}
		}
		return "";
	}

	/**
	 * This method extracts data by given position and label
	 * 
	 * @author vinay
	 * @param data
	 * @param label
	 * @param start
	 * @param end
	 * @since 2022/01/29
	 * @return String
	 */
	public static String typeB(String data, String label, String position) {
		if (isBlank(data) || isBlank(label)) {
			return "";
		}
		if (isBlank(position)) {
			position = "any";
		}
		String lines[] = data.split("\r\n");
		for (String line : lines) {
			if (position.equalsIgnoreCase("start") && line.startsWith(label)) {
				return line.substring(line.indexOf(label) + label.length()).trim();
			}
			if (position.equalsIgnoreCase("any") && line.contains(label)) {
				return line.substring(line.indexOf(label) + label.length()).trim();
			}
		}
		return "";
	}

	/**
	 * This method extracts data by given position, label, start and end
	 * 
	 * @author vinay
	 * @param data
	 * @param label
	 * @param start
	 * @param end
	 * @since 2022/01/29
	 * @return String
	 */

	public static String typeC(String data, String label, String position, String start, String end) {
		if (isBlank(data) || isBlank(label) || isBlank(start) || isBlank(end)) {
			return "";
		} else if (isBlank(position)) {
			position = "any";
		}
		String lines[] = data.split("\r\n");
		for (String line : lines) {
			if (position.equalsIgnoreCase("any") && line.indexOf(label) > line.indexOf(start)
					&& line.indexOf(label) < line.indexOf(end)) {
				return line.substring(line.indexOf(label) + label.length(), line.indexOf(end)).trim();
			}
			if (position.equalsIgnoreCase("start") && line.contains(label) && line.contains(start) && line.contains(end)
					&& line.startsWith(start) && line.endsWith(end)) {
				return line.substring(line.indexOf(label) + label.length(), line.indexOf(end)).trim();
			}
		}
		return "";
	}

	/**
	 * This method converts text to camel case
	 * 
	 * @author vinay
	 * @param text
	 * @since 2022/02/03
	 * @return String
	 */

	public static String toCamelCase(String text) {
		if (isBlank(text)) {
			return "";
		}
		StringBuilder str = new StringBuilder();
		boolean nextCapital = false;
		for (int i = 0; i < text.length(); i++) {
			if (Character.isLetter(text.charAt(i))) {
				char tmp = text.charAt(i);
				if (nextCapital) {
					tmp = Character.toUpperCase(tmp);
				}
				str.append(tmp);
				nextCapital = false;
			} else {
				nextCapital = true;
			}
		}
		return str.toString();
	}

	/**
	 * This method converts text to pascal case
	 * 
	 * @author vinay
	 * @param text
	 * @since 2022/02/03
	 * @return String
	 */

	public static String toPascalCase(String text) {
		if (isBlank(text)) {
			return "";
		}
		text = text.substring(0, 1).toUpperCase() + text.substring(1);
		StringBuilder builder = new StringBuilder(text);
		for (int i = 0; i < builder.length(); i++) {
			if (builder.charAt(i) == ' ') {
				builder.deleteCharAt(i);
				builder.replace(i, i + 1, String.valueOf(Character.toUpperCase(builder.charAt(i))));
			}
		}
		return builder.toString();
	}

	/**
	 * This method converts text to pascal case
	 * 
	 * @author vinay
	 * @param text
	 * @since 2022/02/03
	 * @return String
	 */
	public static String toTitleCase(String text) {
		if (isBlank(text)) {
			return "";
		}
		StringBuilder convert = new StringBuilder();
		boolean convertNext = true;
		for (char ch : text.toCharArray()) {
			if (Character.isSpaceChar(ch)) {
				convertNext = true;
			} else if (convertNext) {
				ch = Character.toTitleCase(ch);
				convertNext = false;
			} else {
				ch = Character.toLowerCase(ch);
			}
			convert.append(ch);
		}
		return convert.toString();
	}
	}