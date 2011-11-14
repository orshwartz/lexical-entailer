/**
 * 
 */
package entailer;

import java.util.ArrayList;

/**
 * This class represents a hypothesis which includes:<BR>
 * - Hypothesis ID (a number)<BR>
 * - Hypothesis term list<BR>
 * - Candidate phrases for hypothesis
 * 
 * @author Or Shwartz
 */
public class ProcessedHypothesis <PhraseType extends ProcessedCandidatePhrase> {

	private int hypoID;
	private ArrayList<ProcessedTerm> termList =
		new ArrayList<ProcessedTerm>();
	private ArrayList<PhraseType> candidatePhrases =
		new ArrayList<PhraseType>();
	
	/**
	 * Create a hypothesis with given ID and no term list or
	 * candidate phrases.
	 * @param hypothesisID ID of hypothesis.
	 */
	public ProcessedHypothesis(int hypothesisID) {
		
		// Set the hypothesis ID
		hypoID = hypothesisID;
	}
	
	/**
	 * Add a term that appears in the original hypothesis sentence.
	 * @param term Term appearing in hypothesis.
	 */
	public void addTerm(ProcessedTerm term) {
		
		// Add the term
		termList.add(term);
	}
	
	/**
	 * Add a phrase which is a possible entailing phrase of the hypothesis.
	 * @param candidatePhrase The candidate phrase.
	 */
	public void addCandidatePhrase(PhraseType candidatePhrase) {
		
		// Add candidate phrase to list of candidates
		candidatePhrases.add(candidatePhrase);
	}
	
	/**
	 * Get the hypothesis ID.
	 * @return the hypoID
	 */
	public int getHypoID() {
	
		// Return the hypothesis ID
		return hypoID;
	}

	/**
	 * Get the list of candidate phrases.
	 * @return the termList
	 */
	public ArrayList<ProcessedTerm> getTermList() {
	
		// Return the list of terms from the hypothesis
		return termList;
	}	
	
	/**
	 * Get the list of candidate phrases.
	 * @return the candidatePhrases
	 */
	public ArrayList<PhraseType> getCandidatePhrases() {
	
		// Return the list of candidate phrases
		return candidatePhrases;
	}
}
