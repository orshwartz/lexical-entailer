/**
 * 
 */
package entailer;

import java.util.ArrayList;

/**
 * @author Or Shwartz
 */
public class ProcessedCandidatePhrase {

	private String docID;
	private int sentenceID;
	private ArrayList<ProcessedTerm> termList =
		new ArrayList<ProcessedTerm>();
	
	/**
	 * Create a new candidate phrase with no terms.
	 * @param docID ID of the document the phrase was taken from.
	 * @param sentenceID ID of the sentence in the document.
	 */
	public ProcessedCandidatePhrase(String docID, int sentenceID) {

		this.docID = docID;
		this.sentenceID = sentenceID;
	}
	
	/**
	 * @return the docID
	 */
	public String getDocID() {
	
		return docID;
	}
	/**
	 * @return the sentenceID
	 */
	public int getSentenceID() {
		
		return sentenceID;
	}
	/**
	 * @return the termList
	 */
	public ArrayList<ProcessedTerm> getTermList() {
		
		return termList;
	}
}
