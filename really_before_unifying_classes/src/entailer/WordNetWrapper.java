package entailer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.PointerUtils;
import net.sf.extjwnl.data.Synset;
import net.sf.extjwnl.data.Word;
import net.sf.extjwnl.data.list.PointerTargetTreeNode;
import net.sf.extjwnl.data.list.PointerTargetTreeNodeList.Operation;
import net.sf.extjwnl.dictionary.Dictionary;

public class WordNetWrapper {

	private final static String PATH_FILE_PROPERTIES =
		"res/extjwnl/file_properties.xml";
	
	private final static int HYPERNYM_DEPTH = 2;
	
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
	public HashMap<String,Word> getSimilarWords(POS pos, String lemma) {
		
		HashMap<String,Word> returnedWords = new HashMap<String,Word>();
		
		try {
			IndexWord indexWordForGivenLemma =
				dictionary.lookupIndexWord(pos, lemma);
			
			// If the word was found
			if (indexWordForGivenLemma != null) {
				
				// Add word synonyms and hypernyms to returned results
				List<Synset> senses = indexWordForGivenLemma.getSenses();
				for (Synset synset : senses) {
					
					// Add synonyms to returned results
					List<Word> synsetWords = synset.getWords();
					for (Word curWord : synsetWords) {
						returnedWords.put(curWord.getLemma(), curWord);
					}
					
//					// Add hypernyms to returned results
//					List<Pointer> synsetHypernyms =
//						synset.getPointers(PointerType.HYPERNYM);
//					for (Pointer curHyponym : synsetHypernyms) {
//						
//						curHyponym.getTargetSynset().getWords();
//						
//						synsetWords = synset.getWords();
//						for (Word curWord : synsetWords) {
//							returnedWords.put(curWord.getLemma(), curWord);
//						}
//					}
					
					// Add all hypernyms on tree paths for specified depth
					Operation opr = new Operation() {
						@Override
						public PointerTargetTreeNode execute(PointerTargetTreeNode node) {
							return node;
						}
					};
					List<PointerTargetTreeNode> hypernyms =
						PointerUtils.getHypernymTree(synset, HYPERNYM_DEPTH).getAllMatches(opr);
					for (PointerTargetTreeNode curHypernym : hypernyms) {
						List<Word> hypernymSynset =
							curHypernym.getSynset().getWords();
						for (Word curHypernymWord : hypernymSynset) {
							returnedWords.put(curHypernymWord.getLemma(), curHypernymWord);
						}
					}
				}
			}
		} catch (JWNLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnedWords;
	}
}
