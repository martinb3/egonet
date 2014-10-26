package org.egonet.model.v2.util;

import java.util.*;

/**
 * Integer values for a pair of alters. This class can be used to map any pair of alters to an integer.
 * @author Martin
 *
 */
public class AlterMatrix2 extends HashMap<AlterPair2,Integer> {
	public AlterMatrix2() { 
		 this(10);
	}
	public AlterMatrix2(int size) { 
		super(size);
	}
	
	public void set(Alter2 first, Alter2 second, Integer i) {
		put(new AlterPair2(first, second), i);
	}
	
	public Integer get(Alter2 first, Alter2 second) {
		return get(new AlterPair2(first,second));
	}
	
	public List<AlterPair2> getAllAlterPairs() {
		return new ArrayList<AlterPair2>(keySet());
	}
	
	public Set<Alter2> getAllAlters() {
		Set<AlterPair2> keys = keySet();
		HashSet<Alter2> s = new HashSet<Alter2>(keys.size()*2);
		
		for(AlterPair2 p : keys) {
			s.addAll(p.getAlters());
		}
		
		
		return s;
	}
	
	@Deprecated
	public boolean contains(Alter2 first, Alter2 second) {
		return containsKey(new AlterPair2(first, second));
	}

}
