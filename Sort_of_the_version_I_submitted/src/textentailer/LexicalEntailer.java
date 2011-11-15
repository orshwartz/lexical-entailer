/**
 * 
 */
package textentailer;

import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class LexicalEntailer {

	private static WordNetWrapper wordNetWrapper =
		new WordNetWrapper();
	
	public static boolean isEntailing(ArrayList<ProcessedTerm> hypothesis,
									  SetRecord candidatePhrase) {

		// For each term in given hypothesis
		for (ProcessedTerm processedHypoTerm : hypothesis) {
			
			ArrayList<ProcessedTerm> candidatePhraseTerms =
				candidatePhrase.getSentTermList();
			
			// For each term in candidate phrase
			for (ProcessedTerm processedCandPhraseTerm : candidatePhraseTerms) {
				
				// If the term from the hypothesis entails the term from
				// the candidate phrase
				if (wordNetWrapper.isEntailing(processedHypoTerm.getPosTag(),
											   processedHypoTerm.getLemma(),
											   processedCandPhraseTerm.getPosTag(),
											   processedCandPhraseTerm.getLemma())) {
					
					return true;
				}
			}
		}
		
		return false;
	}
}
