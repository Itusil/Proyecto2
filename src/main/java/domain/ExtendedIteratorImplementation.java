package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class ExtendedIteratorImplementation implements ExtendedIterator<Event> {
	private ArrayList<Event> ev = new ArrayList<Event>();
	private int position = 0;
	private int finalN=0;

	public ExtendedIteratorImplementation(Vector<Event> e) {
		Iterator<Event> i = e.iterator();
		while (i.hasNext()){
			ev.add(i.next());
		}
		finalN = ev.size()-1;
	}


	@Override
	public boolean hasNext() {
		if(position<=finalN) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Event next() {
		Event s = ev.get(position);
		position = position +1;
		return s;
	}
	@Override
	public Event previous() {
		Event s= ev.get(position);
		position = position -1;
		return s;

	}

	@Override
	public boolean hasPrevious() {
		if (position>=0) {
			return true;
		}else {
			return false;
		}
	}


	@Override
	public void goFirst() {
		position = 0;
	}
	@Override
	public void goLast() {
		position = ev.size()-1;
	}

}
