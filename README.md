# -Cu-pper_-Te-lerium

## Members: Maryann Foley, Aaron Li, Jackie Li
### Heap Algorithms: Adding and Removing

#### Adding Algorithm:

1. Add the number to the end of the heap, represented by the array.
2. Set a position counter to the current size, where the new element is at.
3. Check the value of the new value with its parent. If it is greater, stay. Otherwise, move it to the parent's spot.
4. Repeat step 3 until the parent is larger or equal to the value. Vice versa if it is other priority.

```java

if ( size == length-1 ) doubleSize();

int position = size++;

for ( ; position > 1 && heap[position] < parentNode; pos = parentNode)
	heap[position] = heap[pos/2];

heap[position] = newValue;
```

#### Removing Algorithm:
1. The element of interest is the root of the tree.
2. Remove the root, and replace it with the last element.
3. Similar to inserting, we precolate downwards instead of upwards. This will maintain heap property.
