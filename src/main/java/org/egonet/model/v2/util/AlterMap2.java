package org.egonet.model.v2.util;

import java.util.HashMap;
import java.util.Map;

import org.egonet.model.v2.Alter2;

public class AlterMap2<T> extends HashMap<Alter2,T> {

	public AlterMap2() {
		super();
	}

	public AlterMap2(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public AlterMap2(int initialCapacity) {
		super(initialCapacity);
	}

	public AlterMap2(Map<? extends Alter2, ? extends T> m) {
		super(m);
	}

}
