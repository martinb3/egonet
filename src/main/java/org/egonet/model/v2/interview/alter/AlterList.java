package org.egonet.model.v2.interview.alter;

import java.util.ArrayList;
import java.util.Collection;

public class AlterList extends ArrayList<Alter> {

	public AlterList() {
		super();
	}

	public AlterList(Collection<? extends Alter> c) {
		super(c);
	}

	public AlterList(int initialCapacity) {
		super(initialCapacity);
	}

}
