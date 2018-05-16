// Aaron Li
// APCS2 pd8
// HW46 -- Arr, There Be Priorities Here Matey
// 2018-05-09

// import ArrayList
import java.util.ArrayList;

public class ArrayPriorityQueue { // class ArrayPriorityQueue

     // instance variables
     ArrayList<String> _data;

     // default constructor
     public ArrayPriorityQueue() {
          _data = new ArrayList();
     }

     // checks if _data is empty
     // returns: true if empty, false otherwise
     // O(1)
     public boolean isEmpty() {
          return _data.size() == 0;
     }

     // add a String input to _data
     // O(1)
     public void add(String inp) {
          if (this.isEmpty() || inp.compareTo(_data.get(_data.size() - 1)) > 0) _data.add(inp);
          else if (inp.compareTo(_data.get(0)) < 0) _data.add(0, inp);
          else {
               this.add(inp, 0, _data.size() / 2, _data.size());
          }
     }

     public void add(String inp, int min, int mid, int max) {
          System.out.println("" + min + ", " + mid + ", " + max);
          if (((max - min)) == 1) {
               _data.add(max, inp);
               return;
          } if (inp.equals(_data.get(mid))) {
               _data.add(mid, inp);
               return;
          } else if (_data.get(mid).compareTo(inp) > 0) add(inp, min, ((mid-min) / 2)-1, mid);
          else add(inp, mid, ((max + mid) -1) / 2, max-1);
     }

     // checks for the String element of smallest value in _data
     // returns: String element of the smallest value
     // O(n)
     public String peekMin() {
          return _data.get(0);
     }

     // removes and returns the smallest String element
     // returns: value removed
     // O(n)
     public String removeMin() {
          String ret = this.peekMin();
          _data.remove(0);
          return ret;
     }

     // toString to print _data
     // O(n)
     public String toString() {
          String ret = "";
          for (String i : _data) {
               ret += i + ", ";
          } ret = ret.substring(0, ret.length() - 2);
          ret += "\n";
          return ret;
     }

     // main method
     public static void main(String[] args) {
          ArrayPriorityQueue test = new ArrayPriorityQueue();
          System.out.println("\nAdding elements to the queue...");
          test.add("baboons");
          System.out.println(test.toString());
          test.add("monkeys");
          System.out.println(test.toString());
          test.add("orangutans");
          System.out.println(test.toString());
          test.add("chimpanzee");
          System.out.println(test.toString());
          test.add("gorilla");
          System.out.println(test.toString());
          test.add("ape");

          System.out.println("\nPrinting current queue...");
          System.out.println(test.toString());

          System.out.println("The smallest String element to be removed: " + test.peekMin());
          System.out.println("\nRemoving the smallest element...");
          System.out.println("Element removed: " + test.removeMin());
          System.out.println("\nPrinting current state of ArrayList...");
          System.out.println(test.toString());
          System.out.println("Removing next smallest String element: " + test.peekMin());
          test.removeMin();
          System.out.println(test.toString());
     } // end main method

} // end class
