package textentailer;

import java.util.ArrayList;

/**
 * This class represents a candidate phrase record.
 */
public class DevSetRecord extends SetRecord {

	private boolean isEntailing;
	
	/** Construct a candidate phrase record.
	 * @param topicID
	 * @param hypothesisID
	 * @param docID
	 * @param sentIdx
	 * @param sentTermList
	 * @param isEntailing
	 */
	public DevSetRecord(String topicID,
						Integer hypothesisID,
						String docID,
						int sentIdx, 
						ArrayList<ProcessedTerm> sentTermList,
						boolean isEntailing) {
		this.topicID = topicID;
		this.hypothesisID = hypothesisID;
		this.docID = docID;
		this.sentIdx = sentIdx;
		this.sentTermList = sentTermList;
		this.isEntailing = isEntailing;
	}

	/**
	 * @return the isEntailing
	 */
	public boolean isEntailing() {
		
		return isEntailing;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[topic=" + topicID + ", hypothesis=" + hypothesisID + ", doc=" + docID + ", sent=" + sentIdx + ", terms=" + sentTermList + ", isEntailing=" + isEntailing + "]";
	}
}
