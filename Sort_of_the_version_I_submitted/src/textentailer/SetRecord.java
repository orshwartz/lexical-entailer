/**
 * 
 */
package textentailer;

import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public abstract class SetRecord {

	protected String topicID;
	protected Integer hypothesisID;
	protected String docID;
	protected int sentIdx;
	protected ArrayList<ProcessedTerm> sentTermList;
	
	public String getTopicID() {

		return topicID;
	}

	public Integer getHypothesisID() {
		
		return hypothesisID;
	}

	public String getDocID() {
		
		return docID;
	}

	public int getSentIdx() {
		
		return sentIdx;
	}

	public ArrayList<ProcessedTerm> getSentTermList() {

		return sentTermList;
	}
}
