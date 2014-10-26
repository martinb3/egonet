package org.egonet.model.v2;

import java.util.List;
import java.util.UUID;

import org.egonet.model.v2.util.UniqueWithName;

/**
 * An ordered list of questions, a collection of additional properties, and a study they were created from 
 * @see org.egonet.model.v2.AbstractQuestion
 * @see org.egonet.model.v2.Study 
 */
public class Interview extends UniqueWithName {

	Study study; // read only except first interview
	List<AbstractQuestion> questions;

	public Interview(String name, String id) {
		super(name, id);
	}

	public Interview(String name, UUID id) {
		super(name, id);
	}

	public Interview(String name) {
		super(name);
	}

}
