package entailer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.IndexWordSet;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.dictionary.Dictionary;

public class WordNetWrapper {

	private final static String PATH_FILE_PROPERTIES =
		"res/extjwnl/file_properties.xml";
	
	private Dictionary dictionary;
	
	public WordNetWrapper() {
		
		try {
			// Initialize dictionary object
			dictionary =
				Dictionary.getInstance(new FileInputStream(PATH_FILE_PROPERTIES));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JWNLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method receives a word and a part-of-speech matching that word
	 * and returns a set of words that can be an expansion for that word.
	 * @param pos
	 * @param word
	 * @return
	 */
	public ArrayList<IndexWord> getSimilarWords(POS pos, String word) {
		
		ArrayList<IndexWord> returnedWords = new ArrayList<IndexWord>();
		
		return returnedWords;
	}
}
