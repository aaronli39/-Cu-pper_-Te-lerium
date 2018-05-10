/*
 * Team Chili Dogs -- Jackie Li and Jessica Wu
 * APCS2 pd08
 * HW46 -- Arrr, There Be Priorities Here Matey
 * 2018-5-9
*/

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {

    private ArrayList<String> _data = new ArrayList<String>();

    public void add( String x ) {
	_data.add( x );
    }

    public boolean isEmpty() {
	return ( _data.size() == 0 );
    }

    public String peekMin() {
	String minVal = _data.get(0);
	for ( String word : _data ) {
	    if ( word.compareTo( minVal ) < 0 ) {
		minVal = word;
	    }
	}
	return minVal;
    }

    public String removeMin() {
	String minVal = peekMin();
	for ( int i = 0; i < _data.size(); i++) {
	    if ( minVal.compareTo( _data.get(i) ) == 0 ) {
		_data.remove(i);
		break;
	    }
	}
	return minVal;
    }
    public String toString() {
	return _data.toString();
    }

    public static void main(String[] args) {
	ArrayPriorityQueue theodore = new ArrayPriorityQueue();
	theodore.add("Samuel");
	theodore.add("Bobby");
	theodore.add("Charles");
	theodore.add("Echo");
	theodore.add("Tango");

	System.out.println(theodore);

	while(theodore.isEmpty() == false){
	    System.out.println("Smallest value is: " + theodore.peekMin());
	    System.out.println("Removing smallest value: " + theodore.removeMin());
	    System.out.println(theodore);
	}
    }

}

