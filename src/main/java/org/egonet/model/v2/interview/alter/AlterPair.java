package org.egonet.model.v2.interview.alter;

import java.util.HashSet;
import java.util.Set;

public class AlterPair extends AlterList implements Comparable<AlterPair> {
	public AlterPair(Alter first, Alter second) {
		super(2);
		// ensure these come sorted correctly
		if(first.compareTo(second) < 0) {
			set(0, first);
			set(1, second);
		}
		else {
			set(1, first);
			set(0, second);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((get(0) == null) ? 0 : get(0).hashCode());
		result = prime * result + ((get(1) == null) ? 0 : get(1).hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlterPair other = (AlterPair) obj;
		if (get(0) == null) {
			if (other.get(0) != null)
				return false;
		} else if (!get(0).equals(other.get(0)))
			return false;
		if (get(1) == null) {
			if (other.get(1) != null)
				return false;
		} else if (!get(1).equals(other.get(1)))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlterPair [first=" + get(0) + ", second=" + get(1) + "]";
	}
	
	
	public Set<Alter> getAlters() {
		// separate unordered list (force that with set)
		HashSet<Alter> r = new HashSet<Alter>();
		r.addAll(this);
		
		return r;
	}

	@Override
	public int compareTo(AlterPair o) {
		if(o.equals(this))
			return 0;
		
		int r = hashCode()- (o.hashCode());
		if(r == 0)
			throw new RuntimeException("very unlikely UUID collusion");
		
		return  r;
	}
}
