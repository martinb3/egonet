package org.egonet.model.v2;

import java.util.UUID;

import org.egonet.model.v2.util.UniqueWithName;

public class Alter2 extends UniqueWithName {

	public Alter2(String name, String id) {
		super(name, id);
	}

	public Alter2(String name, UUID id) {
		super(name, id);
	}

	public Alter2(String name) {
		super(name);
	}


}
