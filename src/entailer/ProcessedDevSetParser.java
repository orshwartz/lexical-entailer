/**
 * 
 */
package entailer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Administrator
 */
public class ProcessedDevSetParser {

	private String curTopicID;
	private String curHypothesisID;
	private String curDocID;
	private int curSentenceID;
	private String termList;
	private Boolean curEntailFlag;
	
	private ProcessedSet<ProcessedDevCandidatePhrase> returnedSet =
		new ProcessedSet<ProcessedDevCandidatePhrase>();
	
	private static final String DELIMS_TERM_LIST =
		new String(" ,");
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
	
	// Set up pattern that gets document ID, sentence ID, term list
	// and entailment flag (1 if entails hypothesis, 0 otherwise)
	private static Pattern ptrnSentenceData =
		Pattern.compile("^\\s*([\\d\\w\\.]+)\\s+(\\d+)\\s+\\[([^\\]]*)]\\s+([01])\\s*$");	

	public ProcessedDevSetParser(String pathProcessedDevSet)
	{
		try {
			BufferedReader devSetFileReader =
				new BufferedReader(new FileReader(pathProcessedDevSet));
			String curLine;
			
			// Read next line in file
			while ((curLine = devSetFileReader.readLine()) != null) {
				
				// Check type of data in current line
				Matcher matcher =
					ptrnSentType.matcher(curLine);
				String lineType = matcher.group(1);
				String lineData = matcher.group(2);
				
				// If line contains topic data
				if (lineType.equals("Topic")) {
					
					handleTopicData(lineData);
				}
				
				// Else, if line contains hypothesis data
				else if (lineType.equals("Hypo")) {
					
					handleHypothesisData(lineData);
				}
				
				// Else, if line contains candidate phrase data
				else if (lineType.equals("Sent")) {
					
					handleSentenceData(lineData);
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
	}
	
	/**
	 * Get's the topic ID out the data part of topic line
	 * @param data Data part of topic line
	 */
	private void handleTopicData(String data) {
		
		Matcher matcher = ptrnTopicID.matcher(data);
		
		// Get the topic ID
		curTopicID = matcher.group(1);
	}
	
	/**
	 * Get's hypothesis ID and term list of hypothesis line
	 * @param data Data part of hypothesis line
	 */
	private void handleHypothesisData(String data) {
		
		Matcher matcher = ptrnHypoIDAndTermList.matcher(data);
		curHypothesisID = matcher.group(1);

		// Get the term list
		String termList = matcher.group(2);
		
		StringTokenizer termListTokenizer =
			new StringTokenizer(termList, DELIMS_TERM_LIST);

		// Get terms in list
		while (termListTokenizer.hasMoreTokens()) {

			// Get term
			String term = termListTokenizer.nextToken();
			
			StringTokenizer termInfoTokenizer =
				new StringTokenizer(term, DELIMS_TERM_INFO);
			
			String curPOSTag = termInfoTokenizer.nextToken(term);
			String curOriginalTerm = termInfoTokenizer.nextToken(term);
			String curTermLemma = termInfoTokenizer.nextToken(term);
		}
	}
	
	/**
	 * Get's sentence document ID, sentence ID, term list and
	 * entailment flag (1 if entails hypothesis and 0 otherwise)
	 * @param data Data part of sentence line
	 */
	private void handleSentenceData(String data) {
		
		Matcher matcher = ptrnSentenceData.matcher(data);
		curDocID = matcher.group(1);
		curSentenceID = Integer.parseInt(matcher.group(2));
		String termList = matcher.group(3);
		Boolean isEntailing = matcher.group(4).equals("1");
		
		StringTokenizer termListTokenizer =
			new StringTokenizer(termList, DELIMS_TERM_LIST);

		// Get terms in list
		while (termListTokenizer.hasMoreTokens()) {

			// Get term
			String term = termListTokenizer.nextToken();
			
			StringTokenizer termInfoTokenizer =
				new StringTokenizer(term, DELIMS_TERM_LIST);
			
			String curPOSTag = termInfoTokenizer.nextToken(term);
			String curOriginalTerm = termInfoTokenizer.nextToken(term);
			String curTermLemma = termInfoTokenizer.nextToken(term);
		}
	}
}
