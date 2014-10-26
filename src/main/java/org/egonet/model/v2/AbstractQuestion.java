package org.egonet.model.v2;

import java.util.List;

public class AbstractQuestion {
	/**
	 * The list of potential answers associated with this question
	 */
	List<AbstractAnswer> answers;
	
	/**
	 * The default choice (study) or user-selected choice (interview)
	 */
	AbstractAnswer selectedAnswer;
}
