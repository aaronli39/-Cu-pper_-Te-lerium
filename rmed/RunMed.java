/*
Our algo is to have a heaps that have the minimum value on top for the big values and the max of the little values on top so that the middle 2 elements are always showing.  We also have counters for size so that we can see if there is an odd number of elements in the array, indicating that the median is not the mean of the middle 2 elements.
*/

public class RunMed{
	ALHeapMin bigVals;
	ALHeapMax lilVals;
	int bigSize;
	int lilSize;
	public RunMed (){
		bigVals = new ALHeapMin();
		lilVals = new ALHeapMax(); //our max method names were not modified, follow the naming of methods in AlHeapMin
		bigSize=0;
		lilSize=0;
	}
	public void add(int input){
		if (input<lilVals.peekMin()){
			lilVals.add(input);
			lilSize+=1;
		}
		else{
			bigVals.add(input);
			bigSize+=1;
		}
		if(bigSize<lilSize-1){
			bigVals.add(lilVals.removeMin());
		}
		else if (bigSize > lilSize+1){
			lilVals.add(bigVals.removeMin());
		}
	}
	public int getMedian(){
		//if (bigVals.isEmpty()&&lilVals.isEmpty()){
		//	throw new '''NoSuchElementException'''(); //not letting me do element
		//}
		try{
			lilVals.peekMin();
			bigVals.peekMin();
		}
		catch(Exception e){
			System.out.println("No such element");
		}
		
			if (bigSize>lilSize){
				return  bigVals.peekMin();
			}
			else if (bigSize<lilSize){
				return  lilVals.peekMin();
			}
			else{
				return (lilVals.peekMin()+bigVals.peekMin())/2;
			}

		
	}
}