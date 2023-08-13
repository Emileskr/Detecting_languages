package letterFrequences;

import java.io.File;
import java.util.ArrayList;

public class TestCharHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "C:\\Users\\Emile\\Desktop\\eclipse\\second_course\\src\\letterFrequences\\";
		File englishFile = new File(path + "English.txt");
		CharHistogram english = new CharHistogram("English");
		english.countFile(englishFile);
		
		File dutchFile = new File(path + "Dutch.txt");
		CharHistogram dutch = new CharHistogram("Dutch");
		dutch.countFile(dutchFile);
		
		File germanFile = new File(path + "German.txt");
		CharHistogram german = new CharHistogram("German");
		german.countFile(germanFile);
		
		// the text I chose was about Obama
		ArrayList<CharHistogram> obama = new ArrayList<CharHistogram>();
		obama.add(english);
		obama.add(dutch);
		obama.add(german);
		
		CharHistogram test = new CharHistogram("Test");

		test.count("Hello, my name is Potato");
		
		CharHistogram result = test.compareWith(obama);
		System.out.println(result.getDescription());
		
		
		
		
		
		
		
	}

}
