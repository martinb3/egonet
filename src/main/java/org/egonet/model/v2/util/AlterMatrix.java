package org.egonet.model.v2.util;

import java.util.*;

import org.egonet.model.v2.Alter;

/**
 * A map of alter pairs to an arbitrary type
 * @see org.egonet.model.v2.Alter
 */
public class AlterMatrix<T> extends HashMap<AlterPair,T> {
	public AlterMatrix() { 
		 this(10);
	}
	public AlterMatrix(int size) { 
		super(size);
	}
	
	public void set(Alter first, Alter second, T i) {
		put(new AlterPair(first, second), i);
	}
	
	public T get(Alter first, Alter second) {
		return get(new AlterPair(first,second));
	}
	
	public List<AlterPair> getAllAlterPairs() {
		return new ArrayList<AlterPair>(keySet());
	}
	
	public Set<Alter> getAllAlters() {
		Set<AlterPair> keys = keySet();
		HashSet<Alter> s = new HashSet<Alter>(keys.size()*2);
		
		for(AlterPair p : keys) {
			s.addAll(p.getAlters());
		}
		
		
		return s;
	}
	
	@Deprecated
	public boolean contains(Alter first, Alter second) {
		return containsKey(new AlterPair(first, second));
	}

}
