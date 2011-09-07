/**
 * 
 */
package entailer;

/**
 * @author Or Shwartz
 *
 */
public class ProcessedDevCandidatePhrase extends ProcessedCandidatePhrase {

	private boolean isEntailing;
	
	public ProcessedDevCandidatePhrase(String docID, int sentenceID) {
		super(docID, sentenceID);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns true if this candidate phrase entails the hypothesis
	 * and false otherwise.
	 * @return Entailment flag.
	 */
	public boolean isEntailing() {
		
		return isEntailing;
	}

	/**
	 * Set entailment flag to true if the sentence entails the
	 * hypothesis and false otherwise. 
	 * @param isEntailing The flag value.
	 */
	public void setEntailing(boolean isEntailing) {
		this.isEntailing = isEntailing;
	}
}
