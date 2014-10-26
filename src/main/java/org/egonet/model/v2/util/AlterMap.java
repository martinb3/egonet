package org.egonet.model.v2.util;

import java.util.HashMap;
import java.util.Map;

import org.egonet.model.v2.Alter;

/**
 * A map of alters to an arbitrary type
 * @see org.egonet.model.v2.Alter
 */
public class AlterMap<T> extends HashMap<Alter,T> {

	public AlterMap() {
		super();
	}

	public AlterMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public AlterMap(int initialCapacity) {
		super(initialCapacity);
	}

	public AlterMap(Map<? extends Alter, ? extends T> m) {
		super(m);
	}

}
