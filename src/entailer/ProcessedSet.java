package entailer;

import java.util.HashMap;

/**
 * This class represents a set of topics, each having hypotheses and
 * candidate phrases for entailing these hypotheses.
 * @author Or Shwartz
 */
public class ProcessedSet <PhraseType extends ProcessedCandidatePhrase> {

	private HashMap<String, TopicHypothesesSet<PhraseType>> topics =
		new HashMap<String, TopicHypothesesSet<PhraseType>>();

	/**
	 * Add the topic data to the processed set.
	 * @param topicData The topic data (ID, hypotheses...).
	 */
	public void addTopic(TopicHypothesesSet<PhraseType> topicData) {
		
		topics.put(topicData.getTopicID(), topicData);
	}
	
	public void addPhrase(String topicID, ProcessedCandidatePhrase phrase) {
		
	}
	
	/**
	 * Returns the topic data (ID, hypotheses,...) for given ID.
	 * @param topicID ID of topic for which the data should be returned.
	 * @return Topic data (ID, hypotheses,...) for given topic ID.
	 */
	public TopicHypothesesSet<PhraseType> getTopicData(String topicID) {
		
		return topics.get(topicID);
	}
}
