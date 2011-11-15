package textentailer;

import java.util.ArrayList;

/**
 * This class represents a candidate phrase record.
 */
public class TestSetRecord extends SetRecord {

	/** Construct a candidate phrase record.
	 * @param topicID
	 * @param hypothesisID
	 * @param docID
	 * @param sentIdx
	 * @param sentTermList
	 */
	public TestSetRecord(String topicID,
						Integer hypothesisID,
						String docID,
						int sentIdx, 
						ArrayList<ProcessedTerm> sentTermList) {
		this.topicID = topicID;
		this.hypothesisID = hypothesisID;
		this.docID = docID;
		this.sentIdx = sentIdx;
		this.sentTermList = sentTermList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[topic=" + topicID + ", hypothesis=" + hypothesisID + ", doc=" + docID + ", sent=" + sentIdx + ", terms=" + sentTermList + "]";
	}
}
