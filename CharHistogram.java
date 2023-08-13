package letterFrequences;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CharHistogram {

	private int [] letters;
	private double letterCount;
	private String textDescription;
	private final int ASCII_OFFSET;
	
	/**
	 * the constructor
	 * @param description - description of the string
	 */
	public CharHistogram (String description) {
		letters = new int [26];
		letterCount = 0;
		textDescription = description;
		ASCII_OFFSET = 97;
	}
	
	/**
	 * counts all the characters in the given string and saves them in the array
	 * @param s - the given string
	 */
	public void count (String s) {
		for (int i= 0; i < s.length(); i++) {
			if (s.charAt(i)>=65 && s.charAt(i)<=90 || s.charAt(i)>=97 && s.charAt(i)<=122) {
				char symbol = Character.toLowerCase(s.charAt(i));
				
				// character 'a' is 97th character
				letters [symbol - ASCII_OFFSET] = letters [symbol - ASCII_OFFSET] + 1;
				letterCount++;
			}
		}
	}
	
	public void countFile (File f) {
		try (Scanner sc = new Scanner(f)){
			while (sc.hasNext()) {
				String line = sc.nextLine();
				count(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double dissimilarity (CharHistogram other) {
		double sum = 0;
		for (int i = 0; i < letters.length; i++) {
			double frequency = getFrequency((char) (i + ASCII_OFFSET));
			double otherFrequency = other.getFrequency((char) (i + ASCII_OFFSET));
			sum += Math.abs(frequency - otherFrequency);
		}
		return sum;
	}
	
	public CharHistogram compareWith (ArrayList<CharHistogram> options) {
		if (options.size()<1) {
			return null;
		}
		double smallest = dissimilarity(options.get(0));
		int smallestIndex = 0;
		for (int i =1; i < options.size(); i++) {
			if (smallest > dissimilarity(options.get(i))) {
				smallest = dissimilarity(options.get(i));
				smallestIndex = i;
			}
		}
		return options.get(smallestIndex);
		
	}
	
	/**
	 * gets the frequency of the given letter
	 * @param c - the given letter
	 * @return - frequency
	 * @throws Exception - division by zero
	 */
	public double getFrequency(char c) {
		if (Character.isLetter(c) && letterCount>0) {
			c = Character.toLowerCase(c);
			return (letters[c - ASCII_OFFSET])/ letterCount;
		} else {
			return 0;
		}
	}
	
	public void printArray () {
		System.out.println(Arrays.toString(letters));
		System.out.println(letterCount);
	}
	
	/**
	 * gets the description given in the object constructor
	 * @return the description
	 */
	public String getDescription () {
		return textDescription;
	}
}
