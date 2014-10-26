package org.egonet.model.v2;

import java.util.UUID;

import org.egonet.model.v2.util.UniqueWithName;

/**
 * An alter in an egocentric network, a person not presently being interviewed
 */
public class Alter extends UniqueWithName {
	public Alter(String name, String id) {
		super(name, id);
	}

	public Alter(String name, UUID id) {
		super(name, id);
	}

	public Alter(String name) {
		super(name);
	}


}
