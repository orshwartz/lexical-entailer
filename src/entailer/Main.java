package entailer;

import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;

import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.Word;
import net.sf.extjwnl.dictionary.Dictionary;

public class Main {

	private final static String PATH_FILE_PROPERTIES =
		"res/extjwnl/file_properties.xml";
	
	/**
	 * @param args
	 * @throws Exception 
	 * @throws  
	 */
	public static void main(String[] args) throws Exception {

		ProcessedDevSetParser devSetParser =
			new ProcessedDevSetParser("res/DevSet/Processed_DevSet.txt");
Date date = new Date(); long start = date.getTime();		
		Dictionary dictionary =
			Dictionary.getInstance(new FileInputStream(PATH_FILE_PROPERTIES));

		WordNetWrapper wordNetWrapper = new WordNetWrapper();
		HashMap<String,Word> similarWords =
			wordNetWrapper.getSimilarWords(POS.NOUN, "golden retriever");
		for (String word : similarWords.keySet()) {
			System.out.println(word);
		}
Date date2 = new Date(); long end = date2.getTime();
System.out.println(end-start);
	}
}
