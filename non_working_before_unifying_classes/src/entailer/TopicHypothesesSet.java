/**
 * 
 */
package entailer;

import java.util.ArrayList;

/**
 * This class represents a single topic which includes:<BR>
 * - The ID of the topic<BR>
 * - A list of hypotheses regarding this topic along with candidate
 * phrases for entailing these hypotheses
 * @author Or Shwartz
 */
public class TopicHypothesesSet<PhraseType extends ProcessedCandidatePhrase> {

	private String topicID;
	private ArrayList<ProcessedHypothesis<PhraseType>> hypotheses;
	
	/**
	 * Creates and empty topic that has:<BR>
	 * - Given topic ID <BR>
	 * - Empty list of hypotheses regarding that topic
	 * @param topicID The ID of the new topic
	 */
	public TopicHypothesesSet(String topicID) {
		
		// Set the topic ID
		this.topicID = topicID;
	}
	
	/**
	 * Return the ID of this topic.
	 * @return the topicID
	 */
	public String getTopicID() {
		
		// Get the topic ID
		return topicID;
	}
	
	/**
	 * Returns the list of hypotheses regarding this topic.
	 * @return list of hypotheses regarding the topic.
	 */
	public ArrayList<ProcessedHypothesis<PhraseType>> getHypotheses() {
		
		// Return the hypotheses regarding the topic
		return hypotheses;
	}

	/**
	 * Add a hypothesis to this topic.
	 * @param hypo The hypothesis to add to the topic.
	 */
	public void addHypothesis(ProcessedHypothesis<PhraseType> hypo) {
		
		// Add the hypothesis
		hypotheses.add(hypo);
	}
}
