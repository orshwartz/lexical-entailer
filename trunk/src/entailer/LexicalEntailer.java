/**
 * 
 */
package entailer;



/**
 * @author Or Shwartz
 *
 */
public class LexicalEntailer {

//	private final static String PATH_PROCESSED_DEV_SET =
//		"res/DevSet/Processed_DevSet.txt";
//	
//	private final static String PATH_FILE_PROPERTIES =
//		"res/extjwnl/file_properties.xml";
	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//
//		try {
//			// Initialize JWNL with the file containing the WordNet
//			// dictionary and get an instance of it
//			JWNL.initialize(new FileInputStream(PATH_FILE_PROPERTIES));
//			Dictionary dictionary = Dictionary.getInstance();
//		
//			for (POS curPOS : POS.getAllPOS()) {
//				System.out.println(curPOS);
//				IndexWord indexWord = dictionary.getIndexWord(curPOS, "eating");
//				
//				// If the word is found
//				if (indexWord != null) {
//					List<Synset> senses = indexWord.getSenses();
//					for (Synset synset : senses) {
//						//System.out.println(synset.getGloss().toString());
//						List<Word> synsetWords = synset.getWords();
//						for (Word word : synsetWords) {
//							System.out.println("\t" + word.getLemma().toString());
//						}
//					}
//				}
//			}
//		} catch (FileNotFoundException e) {
//
//			System.out.println("Can't find file properties at " + PATH_FILE_PROPERTIES);
//			e.printStackTrace();
//		} catch (JWNLException e) {
//			
//			System.out.println("JWNL Exception.");
//			e.printStackTrace();
//		}
//	}
}
