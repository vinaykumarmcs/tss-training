package com.tss.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

public class Utility {
	/**
	 * 
	 * @author vinay kumar
	 * @since 2022/01/07
	 * @param String email validateEmail
	 * @return boolean
	 * 
	 *         description: This method is used to validate given email address
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
	 * @author vinay kumar
	 * @param String number - isValidMobileNo
	 * @since 2022/01/07
	 * @return boolean
	 * 
	 *         description:This method is used to validate the given mobile number
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
	 * @author vinay
	 * @paramObject obj - isBlank @since2022/01/07
	 * @return boolean
	 * 
	 *         description:This method is used to check the given value is blank
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
	 * @author vinay kumar
	 * @since 2022/01/07 description:This is a main method
	 */
	public static void main(String[] args) {

		File f =new File("F:\\Upload\\" );
		System.out.println(Utility.isBlank(f));
	}

	/**
	 * @author vinay
	 * @paramint length - otpGenerator(generates random otp of 4 digit)
	 * @since 2022/01/10
	 * @return int
	 * 
	 *         description:This method is used to generate random otp
	 */
	public static int otpGenerator(int length) {
		Random random = new Random();
		int otp = random.nextInt(length);
		return otp;
	}
	/**
	 * @author vinay
	 * @param filePart
	 * @since 2022/01/11
	 * @return int
	 * 
	 *         description:This method is used to upload file
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
}