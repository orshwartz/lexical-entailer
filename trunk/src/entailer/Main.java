package entailer;

import java.io.FileInputStream;
import java.util.ArrayList;

import net.sf.extjwnl.data.POS;
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
		
		Dictionary dictionary =
			Dictionary.getInstance(new FileInputStream(PATH_FILE_PROPERTIES));
	}
}
