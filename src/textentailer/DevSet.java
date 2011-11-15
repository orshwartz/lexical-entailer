package textentailer;

import java.util.ArrayList;
import java.util.HashMap;

public class DevSet {
	
	private HashMap<Integer, ArrayList<ProcessedTerm>> hypotheses =
		new HashMap<Integer, ArrayList<ProcessedTerm>>(300);
	private ArrayList<DevSetRecord> candidatePhrases =
		new ArrayList<DevSetRecord>(15500);
	
	/**
	 * This method adds the given hypothesis to the hypotheses DB.
	 * @param hypothesisID
	 * @param termList
	 */
	public void addHypothesis(Integer hypothesisID, ArrayList<ProcessedTerm> termList) {
System.out.println("added: " + hypothesisID + "\t" + termList);
		hypotheses.put(hypothesisID, termList);
	}
	
	/**
	 * This method adds the given candidate to the candidate phrases DB.
	 * @param topicID
	 * @param hypothesisID
	 * @param docID
	 * @param sentIdx
	 * @param sentTermList
	 * @param isEntailing
	 */
	public void addCandidatePhrase(String topicID,
								   Integer hypothesisID,
								   String docID,
								   int sentIdx,
								   ArrayList<ProcessedTerm> sentTermList,
								   boolean isEntailing) {
System.out.println("added: " + topicID + "\t" + hypothesisID + "\t" + docID + "\t" + sentIdx + "\t" + sentTermList + "\t" + isEntailing);
		candidatePhrases.add(new DevSetRecord(topicID,
											  hypothesisID,
											  docID,
											  sentIdx,
											  sentTermList,
											  isEntailing));
	}

	/**
	 * @return the hypotheses
	 */
	public HashMap<Integer, ArrayList<ProcessedTerm>> getHypotheses() {
		return hypotheses;
	}

	/**
	 * @return the candidate phrases
	 */
	public ArrayList<DevSetRecord> getCandidatePhrases() {
		return candidatePhrases;
	}
}
