/*
 *Maryann Foley
 *APSC2 pd08
 *HW #46: Arrr, There Be Priorities Here Matey
 *2018-5-9
 */

public class ArrayPriorityQueue implements PriorityQueue{
	ArrayList data;
	int size;
	public ArrayPriorityQueue(){
		data = new ArrayList;
		size = 0;
	}
	public boolean isEmpty(){ //O(1)
		return (size==0);
	}
	public void add(String input){ //O(n)
		int index=size-1;
		while (index > 1 && input.compareTo(data.get(index)) <0 && input.compareTo(data.get(index-1)) >0){
			index--;
		}
		data.add(index,input);
		size++;
	}
	public String peekMin(){ //O(1)
		return data.get(size-1);
	}
	public String removeMin(){ //O(1)
		if (isEmpty()){
			return null;
		}
		String temp = data.get(size-1);
		data.set(size-1,0);
		size--;
		return temp;
	}
	public static void main(String[] args) {
		ArrayPriorityQueue charles = new ArrayPriorityQueue();
		charles.add("Mcduff");
		charles.add("AAAA");
		charles.add("ZZZZZ");
		System.out.println( charles.peekMin());
		charles.add("A");
		System.out.println(  charles.removeMin());
		System.out.println(  charles.removeMin());
		System.out.println(  charles.removeMin());
		System.out.println(  charles.removeMin());
		System.out.println(  charles.removeMin());


	}

}
