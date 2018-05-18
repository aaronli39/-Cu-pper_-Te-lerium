import java.util.ArrayList;
public class ALHeapMax {
    //instance vars
    private ArrayList<Integer> _heap;
    
    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeapMax()
    {
	_heap = new ArrayList<Integer>();
    }
    
    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     *****************************************************/
    public String toString()
    {
	String ret = "";
	for (Integer i : _heap) ret += i + ", ";
	return ret;
    } // O(n)
    
    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    {
	return _heap.size() == 0;
    }//O(1)
    
    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin()
    {
	if (_heap.size() < 1) {
	    return null;
	}
	else {
	    return _heap.get(_heap.size()-1);
	}
    }//O(1)
    
    /* Algo for adding:
       1) Add element to end of the heap
       2) If the element is greater than the parent, swap it. If not, STOP.
       3) Repeat step 2 until element is in correct orientation
    */
    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *****************************************************/
    public void add( Integer addVal )
    {
	_heap.add(addVal); // add to the end
	
        int newIndex = _heap.size() - 1; //starting index
        int parentPos;
	
	//while index is bigger then 0, keep sifting
        while(newIndex > 0 ) {
	    parentPos = (newIndex-1) / 2; //parent index
	    if ( addVal > _heap.get(parentPos) ) { //if child is greater, swap
	        swap( newIndex, parentPos );
	        newIndex = parentPos;
	    }
	    else 
	        break;//break because element is in correct position
	}
    }//O(logn)

    /* Algo for removing:
       1) Swap the bottom (last element) with the root, Remove the former root.
       2) Of the new root is less than least child, swap. Else, STOP.
       3) Reoeat step 2 until element is in correct position
    */
    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin()
    {
	if( isEmpty() ){
	    return null;
	}
	int min = this.peekMin();
	int newRoot = _heap.get( _heap.size() - 1 ); //furthest node in heap
	
	swap( 0, _heap.size() - 1 );
	_heap.remove( _heap.size() - 1 );
	
	int pos = 0;
	int child;
	
	while ( pos < _heap.size() ) {
	    child = minChildPos( pos ); // choose smallest child
	    
	    if ( child == -1 ) { //if no children, stop
		break;
	    }
	    else if ( newRoot <=  _heap.get(child) ){ //less than the least child
		swap( pos, child );
		pos = child;
	    }
	    else { //greater then least child
		break;
	    }
	}
	return min;
    } // O(logn)
    
    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) {
	int left = 2 * pos + 1; //index of left
	int right = 2 * pos + 2; //index of right
	
	if ( pos < 0 || pos >= _heap.size() || left >= _heap.size() ) { //element is leaf || not in heap
	    return -1;
	}
	else if ( right >= _heap.size() ) { // right child not present
	    return left;
	}
	else if ( _heap.get(left) < _heap.get(right) ) { // 2 children, left is smaller
	    return left;
	}
	else {
	    return right;
	}
    } // O(1)
    
    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }
    
    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
        _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
      }
    //********************************************
    
    //main method for testing
    public static void main( String[] args )
    {
	ALHeapMax pile = new ALHeapMax();
	
	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()
    
}//end class ALHeapMin
