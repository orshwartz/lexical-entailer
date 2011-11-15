package textentailer;

import java.util.ArrayList;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) {

		// Parse the sets
		DevSet devSet =
			ProcessedSetParser.parseDev("res/DevSet/Processed_DevSet.txt");
//		TestSet testSet =
//			ProcessedSetParser.parseTest("res/TestSet/Processed_TestSet.txt");
		ArrayList<DevSetRecord> devCandidatePhrases =
			devSet.getCandidatePhrases();
		HashMap<Integer, ArrayList<ProcessedTerm>> devHypotheses =
			devSet.getHypotheses();

		// For each candidate phrase
		for (DevSetRecord devSetRecord : devCandidatePhrases) {
			
			// Get terms of hypothesis
			ArrayList<ProcessedTerm> hypothesisTermList =
				devHypotheses.get(devSetRecord.getHypothesisID());
			
			// Check if there's an entailment
			boolean myResult =
				LexicalEntailer.isEntailing(hypothesisTermList,
											devSetRecord);
			boolean goldStd =
				devSetRecord.isEntailing();
			System.out.println("Mine: " + myResult + " Gold: " + goldStd);
		}
	}
}
