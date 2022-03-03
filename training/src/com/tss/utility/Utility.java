package com.tss.utility;

import java.io.File;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tss.pojo.Branch;
import com.tss.pojo.Student;

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
			return (((String) obj).trim().isEmpty());
		return false;
	}

	/**
	 * This is a main method to check is file is blank
	 * 
	 * @author vinay kumar
	 * @since 2022/01/07 description:This is a main method
	 */
//	public static void main(String[] args) {
//
//		File value = new File("F:\\Upload\\");
//		System.out.println(Utility.isBlank(value));
//	}

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

	/**
	 * This method generate alphanumeric otp
	 * 
	 * @author vinay
	 * @param int
	 * @since 2022/02/03
	 * @return String
	 */
	public static String generateAlphanumeric(int length) {
		if (Utility.isBlank(length) || length < 4 || length > 12) {
			return null;
		}
		int i = 0;
		String alphabet = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder str = new StringBuilder();
		SecureRandom random = new SecureRandom();
		while (i < length) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			str.append(randomChar);
			i++;

		}
		return str.toString();
	}

	/**
	 * This method generate alphanumeric otp
	 * 
	 * @author vinay
	 * @param int
	 * @since 2022/02/03
	 * @return String
	 */
	public static ArrayList<String> generateAlphanumeric(int length, int count) {
		ArrayList<String> value = new ArrayList<String>();
		if (Utility.isBlank(count)) {
			return null;
		}
		for (int j = 0; j < count; j++) {
			value.add(generateAlphanumeric(length));
		}
		return value;
	}

	/**
	 * This method returns date format to given date format
	 * 
	 * @author vinay
	 * @param String
	 * @param String
	 * @since 2022/02/09
	 * @return String
	 */
	public static String dateOne(String format) {
		DateTimeFormatter form = DateTimeFormatter.ofPattern(format);
		LocalDateTime now = LocalDateTime.now();
		return form.format(now);
	}

	/**
	 * This method returns given date format to java date format
	 * 
	 * @author vinay
	 * @param String
	 * @param String
	 * @since 2022/02/09
	 * @return date
	 * @throws ParseException
	 */
	public static String dateTwo(String dateGiven, String formatGiven, String strFormat) throws ParseException {
		if (Utility.isBlank(strFormat)) {
			return null;
		}
		Date date = new SimpleDateFormat(formatGiven).parse(dateGiven);
		return new SimpleDateFormat(strFormat).format(date);
	}

	/**
	 * This method returns No of days, months ,years as per the given data and date
	 * 
	 * @author vinay
	 * @param String
	 * @param String
	 * @since 2022/02/09
	 * @return int
	 */
	public static int age(String data, String date) {
		if (isBlank(data) || isBlank(date)) {
			return 0;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Period age = Period.between(LocalDate.parse(date, formatter), LocalDate.now());
		switch (data) {
		case "years":
			return (age.getYears());
		case "months": {
			return ((age.getMonths()) + (age.getYears() * 12));
		}
		case "days": {
			return ((age.getYears() * 365) + (age.getMonths() * 30) + (age.getDays()));
		}
		}
		return 0;
	}

	/**
	 * This method returns no of days in the month
	 * 
	 * @author vinay
	 * @param int
	 * @since 2022/02/09
	 * @return int
	 */
	public static int noOfDays(int month) {
		if (isBlank(month)) {
			return 0;
		}
		LocalDate localDate = LocalDate.of(2022, month, 01);
		return localDate.lengthOfMonth();
	}

	/**
	 * This method returns time taken to execute the program in milliseconds
	 * 
	 * @author vinay
	 * @since 2022/02/09
	 * @return long
	 */
	public static long RunTimeCalculation() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
		}
		return System.currentTimeMillis() - startTime;
	}

	/**
	 * This method checks if the year is leap year and returns the day of 29th feb
	 * 
	 * @author vinay
	 * @param int
	 * @since 2022/02/13
	 * @return String
	 */
	public static String dayInLeapYear(int year) throws ParseException {
		final int DATE = 29;
		final int MONTH = 02;
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date myDate = dateFormat.parse(DATE + "/" + MONTH + "/" + year);
			dateFormat.applyPattern("EEEE");
			return dateFormat.format(myDate);
		} else {
			return "given year is not a leap year";
		}
	}

	/**
	 * This method removes extra spaces in a given string
	 * 
	 * @author vinay
	 * @param String
	 * @since 2022/02/21
	 * @return String
	 */
	public static String removeExtraSpaces(String data) {
		if (isBlank(data)) {
			return null;
		}
		return data.replaceAll("\\s+", " ").trim();
	}

	/**
	 * This method generates given number of zeros
	 * 
	 * @author vinay
	 * @param int
	 * @since 2022/02/21
	 * @return String
	 */
	public static String generateZeros(int count) {
		if (isBlank(count)) {
			return null;
		}
		return String.format("%0" + count + "d", 0);
	}

	/**
	 * This method removes special characters and extra from a given string
	 * 
	 * @author vinay
	 * @param String
	 * @since 2022/02/21
	 * @return String
	 */
	public static String replaceSpecialCharacters(String data) {
		if (isBlank(data)) {
			return null;
		}
		return data.replaceAll("[^a-zA-Z0-9]+\\s+", " ");
	}

	public static String extractIdFromUrl(String url) {

		String regex = "\\/d\\/(.*?)(\\/|$)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);
		while (matcher.find()) {
		}
		return matcher.group();
	}

	/**
	 * This method removes special characters and extra from a given string
	 * 
	 * @author vinay
	 * @param String
	 * @since 2022/02/21
	 * @return String
	 */
	public static String extractYoutubeUrlId(String url) {
		if (isBlank(url)) {
			return null;
		}
		String regex = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);
		while (matcher.find()) {
			return "https://www.youtube.com/embed/" + matcher.group();
		}
		return "";
	}

	/**
	 * This method validates given ip address
	 * 
	 * @author vinay
	 * @param String
	 * @since 2022/02/22
	 * @return boolean
	 */
	public static boolean isValidIpAddress(String ipAddress) {
		if (isBlank(ipAddress)) {
			return false;
		}
		String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
		String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
		Pattern ipv4 = Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
		Pattern ipv6 = Pattern.compile(ipv6Pattern, Pattern.CASE_INSENSITIVE);
		Matcher ipv4Matcher = ipv4.matcher(ipAddress);
		if (ipv4Matcher.matches()) {
			return true;
		}
		Matcher ipv6Matcher = ipv6.matcher(ipAddress);
		if (ipv6Matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * @author vinay
	 * @param args
	 * @param List
	 * @return
	 */
	public static List<Student> sortByAge(List<Student> students) {
//		List<Student> newList = new ArrayList<Student>();
//		for (Student student : students) {
//			if (student.getAge()>student.age) {
//				newList.add(student);
//			}
		Collections.sort(students);
		return students;
	}

	public static List<Branch> sortingStudentsByBranch(List<Branch> branches) {
		for (Branch branch : branches) {
			Collections.sort(branch.getStudents());
		}
		return branches;
	}

	public static List<Student> getStudentsByHobby(List<Branch> branches, String hobby) {
		List<Student> students = new ArrayList<Student>();
		for (Branch branch : branches) {
			for (Student student : branch.getStudents()) {
				if (student.getHobbies().contains(hobby)) {
					students.add(student);
				}
			}
		}
		return students;
	}

//	public static List<Branch> sortingStudentsByBranch(List<Branch> branches,List<Student> students){
//	List<Branch> branche=new ArrayList<Branch>();
//	Collections.sort(students);
//	int i=0;
//	while(i<branches.size()) {
//		return branches.get(0);
//	}
//		return null;
//	
//	}
	public static void main(String[] args) {
//		System.out.println(extractYoutubeUrlId("http://www.youtube.com/watch?v=0zM4nApSvMg#t=0m10s"));
//		System.out.println(SampleIp.isIpAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
//		System.out.println(SampleIp.isIpAddress("103.5.134.75"));
	}
}