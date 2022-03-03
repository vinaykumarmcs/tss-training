package com.tss.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtility {
	/**
	 * This method reads the data in the file and stores it in array
	 * 
	 * @author vinay
	 * @param File
	 * @since 2022/02/15
	 * @return String[]
	 */
	public static String[] readData(File path) throws FileNotFoundException, IOException {
		BufferedReader bufReader = new BufferedReader(new FileReader(path));
		List<String> list = new ArrayList<>();
		String line = bufReader.readLine();
		while (line != null) {
			list.add(line);
			line = bufReader.readLine();
		}
		bufReader.close();
		String[] arr = new String[list.size()];
		for (int i = 0; i < list.size(); i++)
			arr[i] = list.get(i);
		return arr;
	}

	/**
	 * This method Writes the given String data into given file
	 * 
	 * @author vinay
	 * @param String
	 * @param file
	 * @since 2022/01/29
	 * @return boolean
	 * @throws IOException
	 */
	public static boolean appendData(File file, String text) throws IOException {
		if (Utility.isBlank(text) || file == null) {
			return false;
		}
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(text);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
		return true;
	}

	/**
	 * This method checks if the given path is directory or file and creates file if
	 * does not exist.
	 * 
	 * @author vinay
	 * @param String
	 * @param file
	 * @since 2022/01/29
	 * @return boolean
	 * @throws IOException
	 */
	public static File getFile(String path) throws FileNotFoundException, IOException {
		File file = new File(path);
		if (Utility.isBlank(path)) {
			return null;
		}
		try {
			if (file.isDirectory()) {
				throw new Exception("given path is a directory");
			} else {
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * This method checks if the given path is directory or file and creates file if
	 * does not exist.
	 * 
	 * @author vinay
	 * @param String
	 * @param file
	 * @since 2022/01/29
	 * @return boolean
	 * @throws IOException
	 */
	public static boolean modifyData(File originalFile, int lineNumber, String line) throws Exception {
		File tempFile = FileUtility.getFile(".\\file\\temp.csv");
		boolean status = false;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(originalFile));
			writer = new BufferedWriter(new FileWriter(tempFile));
			int count = 0;
			String lineFromFile = "";
			while ((lineFromFile = reader.readLine()) != null) {
				count++;
				if (count == lineNumber) {
					writer.write(line + "\n");
					status = true;
				} else {
					writer.write(lineFromFile + "\n");
				}
				writer.flush();
			}

		} finally {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
			tempFile.deleteOnExit();
		}
		if (status) {
			if (!originalFile.delete()) {
				throw new Exception("Problem occured while deleting original file");
			}
			if (!tempFile.renameTo(originalFile)) {
				throw new Exception("Problem occured while renaming a file");
			}
//			Files.move(tempFile.toPath(), originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
		return true;
	}

	public static List<List<Object>> readFileData(String filePath) throws IOException {
		File file = getFile(filePath);
		List<List<Object>> records = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		while ((line = reader.readLine()) != null) {
			Object[] fields = line.split(",");
			records.add(Arrays.asList(fields));
		}
		reader.close();
		return records;
	}

	public static void main(String[] args) throws IOException {
//		String[] value = ReadData(new File(("C:\\Users\\Dell\\Desktop\\New Text Document.txt")));
//		System.out.println(Arrays.toString(value));
//		System.out.println(appendData(new File("C:\\Users\\Dell\\Desktop\\New Text Document.txt"), "hello World"));
		System.out.println(getFile("C:\\Users\\Dell\\Desktop\\New Text Document.txt"));
	}
}