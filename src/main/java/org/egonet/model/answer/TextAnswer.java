package org.egonet.model.answer;

import java.util.List;

import org.egonet.model.alter.Alter;

public class TextAnswer extends Answer {

	public TextAnswer() {
		super();
	}

	public TextAnswer(Long qId) {
		super(qId);
	}
	
	public TextAnswer(Long qId, List<Alter> qAlters) {
		super(qId, qAlters);
	}

}
