package org.egonet.model.v2.util;

import java.util.ArrayList;
import java.util.Collection;

import org.egonet.model.v2.Alter;

/**
 * A list of alters
 * @see org.egonet.model.v2.Alter
 */
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
