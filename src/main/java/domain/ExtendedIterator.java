package domain;

import java.util.Iterator;
import java.util.Vector;

public interface ExtendedIterator<Object> extends Iterator<Object> {

	
	public boolean hasNext();
	//It is placed in the first element
	public Object next();
	//return the actual element and go to the next
	public Object previous();
	//true if ther is a previous element
	public boolean hasPrevious();
	//It is placed in the first element
	public void goFirst();
	// It is placed in the last element
	public void goLast();
	}