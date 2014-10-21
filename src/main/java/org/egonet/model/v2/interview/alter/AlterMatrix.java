package org.egonet.model.v2.interview.alter;

import java.util.*;

/**
 * Integer values for a pair of alters. This class can be used to map any pair of alters to an integer.
 * @author Martin
 *
 */
public class AlterMatrix extends HashMap<AlterPair,Integer> {
	public AlterMatrix() { 
		 this(10);
	}
	public AlterMatrix(int size) { 
		super(size);
	}
	
	public void set(Alter first, Alter second, Integer i) {
		put(new AlterPair(first, second), i);
	}
	
	public Integer get(Alter first, Alter second) {
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
