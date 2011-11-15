package textentailer;

import java.util.ArrayList;
import java.util.HashMap;

public class TestSet {
	
	private HashMap<Integer, ArrayList<ProcessedTerm>> hypotheses =
		new HashMap<Integer, ArrayList<ProcessedTerm>>(300);
	private ArrayList<TestSetRecord> candidatePhrases =
		new ArrayList<TestSetRecord>(15500);
	
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
	 */
	public void addCandidatePhrase(String topicID,
								   Integer hypothesisID,
								   String docID,
								   int sentIdx,
								   ArrayList<ProcessedTerm> sentTermList) {
System.out.println("added: " + topicID + "\t" + hypothesisID + "\t" + docID + "\t" + sentIdx + "\t" + sentTermList);
		candidatePhrases.add(new TestSetRecord(topicID,
											   hypothesisID,
											   docID,
											   sentIdx,
											   sentTermList));
	}
}
