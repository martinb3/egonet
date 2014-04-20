package org.egonet.io;

import java.io.File;

import org.egonet.statistics.StatRecord;
import org.egonet.statistics.StatRecord.AlterAnswer;
import org.egonet.statistics.StatRecord.EgoAnswer;
import org.egonet.util.Name;

import electric.xml.Document;
import electric.xml.Element;
import electric.xml.Elements;
import electric.xml.ParseException;

public class StatisticsFileReader {

	private File statisticsFile;
	public StatisticsFileReader(File statisticsFile) {
		super();
		this.statisticsFile = statisticsFile;
	}

	public StatRecord readStatRecord() throws ParseException
	{
		Document document = new Document(statisticsFile);
		Element e = document.getRoot();

		
		StatRecord sr = new StatRecord();

		String egoName = "unknown";
 		Element nameElem = e.getElement("EgoName");
		if (nameElem != null) {
			String test1 = new Name(nameElem.getString("First"), nameElem.getString("Last")).toString();
			String test2 = nameElem.getString();
			if(test1 != null && !test1.trim().equals("")) {
				egoName = test1;
			}
			else if(test2 != null && !test2.trim().equals("")) {
				egoName = test2;
			}
			
		}
		sr.setName(egoName);

		if(sr.getName() == null || sr.getName().trim().equals(""))
			throw new RuntimeException("Found null named stat record in " + statisticsFile.getName());
 
		sr.degreeName     = e.getString("DegreeName");
		sr.degreeValue    = new Integer(e.getInt("DegreeValue"));
		sr.degreeMean     = new Float(e.getFloat("DegreeMean"));
		sr.degreeNC       = new Float(e.getFloat("DegreeNC"));

		sr.closenessName  = e.getString("ClosenessName");
		sr.closenessValue = new Float(e.getFloat("ClosenessValue"));
		sr.closenessMean  = new Float(e.getFloat("ClosenessMean"));
		sr.closenessNC    = new Float(e.getFloat("ClosenessNC"));

		sr.betweenName    = e.getString("BetweenName");
		sr.betweenValue   = new Float(e.getFloat("BetweenValue"));
		sr.betweenMean    = new Float(e.getFloat("BetweenMean"));
		sr.betweenNC      = new Float(e.getFloat("BetweenNC"));

		sr.numCliques     = new Integer(e.getInt("NumCliques"));
		sr.numComponents  = new Integer(e.getInt("NumComponents"));
		sr.numIsolates    = new Integer(e.getInt("NumIsolates"));
		sr.numDyads       = new Integer(e.getInt("NumDyads"));

		Elements egoList = e.getElement("EgoAnswers").getElements("EgoAnswer");
		while (egoList.hasMoreElements())
		{
			sr.egoAnswers.add(readEgoAnswer(egoList.next()));
		}

		Elements alterList = e.getElement("AlterQuestionSummaries").getElements("AlterQuestionSummary");
		while (alterList.hasMoreElements())
		{
			sr.alterAnswers.add(readAlterAnswer(alterList.next()));
		}

		return sr;
	}

	protected EgoAnswer readEgoAnswer(Element e)
	{
		EgoAnswer ea = new EgoAnswer(e.getString("Title"), e.getString("Answer"), e.getInt("AnswerIndex"));
		return ea;
	}

	protected AlterAnswer readAlterAnswer(Element e)
	{
		int index=0;

		Elements answerList = e.getElement("Answers").getElements("Answer");
		
		AlterAnswer aa = new AlterAnswer(
				e.getString("Title"),
				e.getInt("Count"),
				new String[answerList.size()],
				new int[answerList.size()],
				new int[answerList.size()]
				);
		
		
		while (answerList.hasMoreElements())
		{
			Element a          = answerList.next();

			index              = a.getInt("AnswerIndex");
			aa.selections[index]  = a.getString("Text");
			aa.totals[index]      = a.getInt("Total");
			//added by sonam 08/24/07
			aa.AnswerIndex[index] = a.getInt("AnswerIndex");
			//end
		}
		
		return aa;
	}
}
