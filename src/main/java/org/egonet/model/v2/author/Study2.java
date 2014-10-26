package org.egonet.model.v2.author;

import java.util.List;
import java.util.UUID;

import org.egonet.model.v2.util.UniqueWithName;

public class Study2 extends UniqueWithName {
	
	public Study2(String name, String id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	public Study2(String name, UUID id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	public Study2(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	List<StudyQuestion2> questions;

}
