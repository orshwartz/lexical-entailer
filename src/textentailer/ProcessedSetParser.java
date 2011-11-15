/**
 * 
 */
package textentailer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.extjwnl.data.POS;

/**
 * 
 */
public class ProcessedSetParser {

	private static String curTopicID;
	private static Integer curHypothesisID;
	private static String curDocID;
	private static int curSentenceID;
	private static ArrayList<ProcessedTerm> curTermList =
			new ArrayList<ProcessedTerm>();
	private static boolean curEntailFlag;
	
	private static final String DELIMS_TERM_LIST =
		new String("`");
	private static final String DELIMS_TERM_INFO =
		new String(":");
	
	// Set up pattern the gets line data type and string of data
	private static Pattern ptrnSentType =
		Pattern.compile("^(\\w+):\\t(.*)$");
	
	// Set up pattern that gets the topic ID
	private static Pattern ptrnTopicID =
		Pattern.compile("^\\s*(\\w+).*$");
	
	// Set up pattern that gets hypothesis ID and term list
	private static Pattern ptrnHypoIDAndTermList =
		Pattern.compile("^\\s*(\\d+).+\\[([^\\]]*)]\\s*$");
	
	// Set up pattern for DevSet that gets document ID, sentence ID, term list
	// and entailment flag (1 if entails hypothesis, 0 otherwise)
	private static Pattern ptrnDevSentenceData =
		Pattern.compile("^\\s*([\\d\\w\\.]+)\\s+(\\d+)\\s+\\[([^\\]]*)]\\s+([01])\\s*$");
	
	// Set up pattern for TestSet that gets document ID, sentence ID and term list
	private static Pattern ptrnTestSentenceData =
		Pattern.compile("^\\s*([\\d\\w\\.]+)\\s+(\\d+)\\s+\\[([^\\]]*)]\\s*$");

	public static DevSet parseDev(String pathProcessedDevSet)
	{
		DevSet returnedDevSet = new DevSet();
		
		try {
			BufferedReader devSetFileReader =
				new BufferedReader(new FileReader(pathProcessedDevSet));
			String curLine;
			
			// Read next line in file
			while ((curLine = devSetFileReader.readLine()) != null) {
				
				// Check type of data in current line
				Matcher matcher =
					ptrnSentType.matcher(curLine);
				matcher.matches();
				String lineType = matcher.group(1).trim();
				String lineData = matcher.group(2).trim();
				
				// If line contains topic data
				if (lineType.equals("Topic")) {
					
					handleTopicData(lineData);
				}
				
				// Else, if line contains hypothesis data
				else if (lineType.equals("Hypo")) {
					
					handleHypothesisData(lineData);
					
					// Add hypothesis to DevSet DB
					returnedDevSet.addHypothesis(curHypothesisID, curTermList);
				}

				// Else, if line contains candidate phrase data
				else if (lineType.equals("Sent")) {
					
					handleDevSentenceData(lineData);
					
					// Add candidate phrase to DevSet DB
					returnedDevSet.addCandidatePhrase(curTopicID,
													  curHypothesisID,
													  curDocID,
													  curSentenceID,
													  curTermList,
													  curEntailFlag);
				}
			}
			
			// Close file stream
			devSetFileReader.close();
		} catch (FileNotFoundException e) {

			System.out.println("Processed Dev Set not found in " + pathProcessedDevSet);
			e.printStackTrace();
		} catch (IOException e) {
			
			System.out.println("Error occured while reading " + pathProcessedDevSet);
			e.printStackTrace();
		}
		
		return returnedDevSet;
	}
	
	public static TestSet parseTest(String pathProcessedTestSet)
	{
		TestSet returnedTestSet = new TestSet();
		
		try {
			BufferedReader testSetFileReader =
				new BufferedReader(new FileReader(pathProcessedTestSet));
			String curLine;
			
			// Read next line in file
			while ((curLine = testSetFileReader.readLine()) != null) {
				
				// Check type of data in current line
				Matcher matcher =
					ptrnSentType.matcher(curLine);
				matcher.matches();
				String lineType = matcher.group(1).trim();
				String lineData = matcher.group(2).trim();
				
				// If line contains topic data
				if (lineType.equals("Topic")) {
					
					handleTopicData(lineData);
				}
				
				// Else, if line contains hypothesis data
				else if (lineType.equals("Hypo")) {
					
					handleHypothesisData(lineData);
					
					// Add hypothesis to TestSet DB
					returnedTestSet.addHypothesis(curHypothesisID, curTermList);
				}

				// Else, if line contains candidate phrase data
				else if (lineType.equals("Sent")) {
					
					handleTestSentenceData(lineData);
					
					// Add candidate phrase to TestSet DB
					returnedTestSet.addCandidatePhrase(curTopicID,
													   curHypothesisID,
													   curDocID,
													   curSentenceID,
													   curTermList);
				}
			}
			
			// Close file stream
			testSetFileReader.close();
		} catch (FileNotFoundException e) {

			System.out.println("Processed Dev Set not found in " + pathProcessedTestSet);
			e.printStackTrace();
		} catch (IOException e) {
			
			System.out.println("Error occured while reading " + pathProcessedTestSet);
			e.printStackTrace();
		}
		
		return returnedTestSet;
	}
	
	/**
	 * Get's the topic ID out the data part of topic line
	 * @param data Data part of topic line
	 */
	private static void handleTopicData(String data) {
		
		Matcher matcher = ptrnTopicID.matcher(data);
		matcher.matches();
		
		// Get the topic ID
		curTopicID = new String(matcher.group(1).trim());
	}
	
	/**
	 * Get's hypothesis ID and term list of hypothesis line
	 * @param data Data part of hypothesis line
	 */
	private static void handleHypothesisData(String data) {
		
		Matcher matcher = ptrnHypoIDAndTermList.matcher(data);
		matcher.matches();
		curHypothesisID = new Integer(Integer.parseInt(matcher.group(1).trim()));

		// Get the term list
		String termList = matcher.group(2).trim().replace(", ", "`");
		
		handleTermList(termList);
	}
	
	/**
	 * Gets DevSet sentence document ID, sentence ID, term list and
	 * entailment flag (1 if entails hypothesis and 0 otherwise)
	 * @param data Data part of sentence line
	 */
	private static void handleDevSentenceData(String data) {
		
		Matcher matcher = ptrnDevSentenceData.matcher(data);
		matcher.matches();
		curDocID = new String(matcher.group(1).trim());
		curSentenceID = new Integer(Integer.parseInt(matcher.group(2).trim()));

		// Get the term list
		String termList = matcher.group(3).trim().replace(", ", "`");
		
		curEntailFlag = matcher.group(4).trim().equals("1");
		
		handleTermList(termList);
	}
	
	/**
	 * Gets TestSet sentence document ID, sentence ID and term list
	 * @param data Data part of sentence line
	 */
	private static void handleTestSentenceData(String data) {
		
		Matcher matcher = ptrnTestSentenceData.matcher(data);
		matcher.matches();
		curDocID = new String(matcher.group(1).trim());
		curSentenceID = new Integer(Integer.parseInt(matcher.group(2).trim()));

		// Get the term list
		String termList = matcher.group(3).trim().replace(", ", "`");
		
		handleTermList(termList);
	}
	
	private static void handleTermList(String termList) {
		
		StringTokenizer termListTokenizer =
			new StringTokenizer(termList, DELIMS_TERM_LIST);

		// Remove previous terms from previous phrase (we need a new ArrayList because we saved
		// the reference to the older one in our DB)
		curTermList = new ArrayList<ProcessedTerm>();
		
		// Get terms in list
		while (termListTokenizer.hasMoreTokens()) {

			// Get term (Term, POS Tag and Lemma)
			String term = termListTokenizer.nextToken();
			
			// Get term metadata
			StringTokenizer termInfoTokenizer =
				new StringTokenizer(term, DELIMS_TERM_INFO);
			POS curPOSTag = POS.getPOSForKey(termInfoTokenizer.nextToken());
			String curOriginalTerm = termInfoTokenizer.nextToken();
			String curTermLemma = termInfoTokenizer.nextToken();
			
			// Add term to candidate phrase's term list
			curTermList.add(new ProcessedTerm(curPOSTag,
											  curOriginalTerm,
											  curTermLemma));
		}
	}
}
