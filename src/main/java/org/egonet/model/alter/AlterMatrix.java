package org.egonet.model.alter;

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

		// just in case put uses object equality for keys
		// instead of value equality

		AlterPair pair;
		if(!contains(first, second))
			pair = new AlterPair(first, second);
		else
			pair = getKey(first,second);
		
		put(pair, i);
	}
	
	public Integer get(Alter first, Alter second) {
		return get(new AlterPair(first,second));
	}
	
	public AlterPair getKey(Alter first, Alter second) {
		
		for(AlterPair p : getAllAlterPairs()) {
			if(p.equals(new AlterPair(first,second)))
				return p;
		}
		
		return null;
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
	
	public void buildIdentity(List<Alter> alterList) {
		List<Alter> x = new ArrayList<Alter>(alterList);
		List<Alter> y = new ArrayList<Alter>(alterList);
		
		for(Alter i : x) {
			for(Alter j : y) {
				set(i, j, i.equals(j) ? 1 : 0);
			}
		}
	}
	
	@Deprecated
	public boolean contains(Alter first, Alter second) {
		return containsKey(new AlterPair(first, second));
	}
	
	@Deprecated 
	public int[][] asMatrix() {
		int [][] matrix = new int[size()][size()];
		
		List<Alter> x = new ArrayList<Alter>(getAllAlters());
		List<Alter> y = new ArrayList<Alter>(getAllAlters());
		
		for(int i = 0; i < x.size(); i++) {
			for(int j = 0; j < y.size() ; j++) {
				matrix[i][j] = contains(x.get(i), y.get(j)) ? 1 : 0;
			}
		}
		
		return matrix;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		List<Alter> x = new ArrayList<Alter>(getAllAlters());
		List<Alter> y = new ArrayList<Alter>(getAllAlters());
		
		for(int i = 0; i < x.size(); i++) {
			for(int j = 0; j < y.size() ; j++) {
				sb.append(contains(x.get(i), y.get(j)) ? 1 : 0);
				sb.append(",");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
