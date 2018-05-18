/*****************************************************
* class ALHeapMin
* SKELETON
* Implements a min heap using an ArrayList as underlying container
*****************************************************/

import java.util.ArrayList;

public class ALHeapMin
{

     //instance vars
     private ArrayList<Integer> _heap;

     /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
     public ALHeapMin()
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
          if ( _heap.size() < 1 ) {
               return null;
          }
          return _heap.get(0);
     } // O(1)


     /*****************************************************
     * add(Integer)
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *****************************************************/
     public void add( Integer addVal )
     {
          _heap.add(addVal); // first add the value to the end
          int index = _heap.size() - 1; // starting index

          // while index is bigger than 0, keep sifting
          while (index > 0) {
               int parent = (index - 1) / 2; // index of parent
               // if the child(curent index) is smaller than parent, swap
               if(_heap.get(index).compareTo(_heap.get(parent)) < 0) {
                    swap(index, parent);
                    index = parent;
               } else {
                    break; // break otherwise
               }
          }
     } // O(logn)


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
                    break;
               }
               else { //greater than least child (out of place)
                    swap( pos, child );
                    pos = child;
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
     } // O(1)

     //swap for an ArrayList
     private void swap( int pos1, int pos2 )
     {
          _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
     }
     //********************************************



     //main method for testing
     public static void main( String[] args )
     {
          ALHeapMin pile = new ALHeapMin();

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
     }//end main()

}//end class ALHeapMin
