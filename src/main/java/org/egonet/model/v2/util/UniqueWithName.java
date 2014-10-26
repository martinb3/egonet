package org.egonet.model.v2.util;

import java.util.Comparator;
import java.util.UUID;

/**
 * An object with a UUID that also may have a string/textual name
 * 
 *  Using UUIDs instead of basing everything by String allows a nice way to rename
 *  objects and check equality and compare values without worrying about comparing 
 *  Strings. The downside is a counter-intuitive sort order, but we expect implementations
 *  to provide a comparator for this.
 *  @see java.util.UUID
 *  @see java.util.Comparator
 */
public abstract class UniqueWithName implements Comparable<UniqueWithName> {
	/**
	 * Using UUID instead of a String allows us to rename alters without losing
	 * alter data. It also gives us a nice way to check equality and compare
	 * values without worry about comparing Strings. This leads to a
	 * counter-intuitive sort order, but we'll provide a comparator for that.
	 */
	private String name;
	private final UUID _id;

	public UniqueWithName(String name) {
		super();
		this.name = name;
		_id = UUID.randomUUID();
	}
	
	public UniqueWithName(String name, UUID id) {
		super();
		this.name = name;
		_id = id;
	}
	
	public UniqueWithName(String name, String id) {
		super();
		this.name = name;
		_id = UUID.fromString(id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
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
		UniqueWithName other = (UniqueWithName) obj;
		
		return _id.equals(other._id);
	}

	@Override
	public String toString() {
		return "[name=" + name + ",class="+getClass()+"]";
	}

	@Override
	public int compareTo(UniqueWithName arg0) {
		UUID first = this._id;
		UUID second = arg0._id;
		
		return first.compareTo(second);
	}
	
	public class UniqueWithNameComparator implements Comparator<UniqueWithName> {

		@Override
		public int compare(UniqueWithName arg0, UniqueWithName arg1) {
			String first = arg0.name;
			String second = arg1.name;
			
			return first.compareTo(second);
		}
		
	}

	public String getName() {
		return name;
	}
	
	public UUID getId() {
		return _id;
	}

}
