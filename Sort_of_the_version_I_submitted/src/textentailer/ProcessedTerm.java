/**
 * 
 */
package textentailer;

import net.sf.extjwnl.data.POS;

/**
 * This class represents a term from a tagged corpus which includes:<BR>
 * - Part-of-speech tag of the word<BR>
 * - The word, as it appears in the corpus<BR>
 * - The lemma of the word
 * @author Or Shwartz
 */
public class ProcessedTerm {

	private POS posTag;
	private String word;
	private String lemma;
	
	/**
	 * Create a processed term object
	 * @param posTag Part-of-speech tag of term.
	 * @param word Term word as it appears in the original sentence. 
	 * @param lemma Lemma form of term.
	 */
	public ProcessedTerm(POS posTag, String word, String lemma) {

		this.posTag = posTag;
		this.word = word;
		this.lemma = lemma;
	}
	
	/**
	 * Return the part of speech tag
	 * @return the posTag
	 */
	public final POS getPosTag() {
		
		// Return the part-of-speech tag
		return posTag;
	}

	/**
	 * Return the word, as it appears in the corpus.
	 * @return the word, as it appears in the corpus
	 */
	public final String getWord() {
		
		// Return the word as it originally appears in the corpus
		return word;
	}

	/**
	 * Return the lemma form of the word.
	 * @return the lemma
	 */
	public final String getLemma() {

		// Return the lemma form of the word
		return lemma;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "posTag=" + posTag + ", word=" + word + ", lemma=" + lemma;
	}
}
