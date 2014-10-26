package org.egonet.model.v2;

import java.util.List;
import java.util.UUID;

import org.egonet.model.v2.util.UniqueWithName;

/**
 * An ordered list of questions and a collection of additional properties 
 * @see org.egonet.model.v2.AbstractQuestion
 * @see org.egonet.model.v2.Interview 
 */
public class Study extends UniqueWithName {
	List<AbstractQuestion> questions;
	
	public Study(String name, String id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	public Study(String name, UUID id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	public Study(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
