package ArrayList;


import java.util.Arrays;

public  class MyArrayList<E>  implements ListInerface <E>  {

	private int capacityMax = 16;
	
    
	public Object[] elements;
	public int size;


    public int size() {
    	return size;
    }

    public MyArrayList() {
    	this.elements = new Object[capacityMax];
    	this.size = 0;
    }

    public void checkCapacity(int chekNum) {
    	if(chekNum+4 >= capacityMax) {
    		int newCapacity = capacityMax*2+chekNum;
    		elements = Arrays.copyOf(elements, newCapacity) ;
    	}
    }

    public int capacity() {
        return elements.length;
    }

    public boolean isEmpty() {
    	return size == 0;
	}

	public boolean add(E element) {
		checkCapacity(size+1);
		elements[size++] = element;
		return true;
    }

	public void add(int index, E element) {
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        checkCapacity(size+1);
        size++;

        for(int i = 1; i<= index;i++) {
        	elements[size] = elements[size-i]; 
        }
        elements[index] = element;

	}

	public E get(int index) {
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
		return (E) elements[index];
	}

	public E set(int index, E element) {
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
		E previousElem = (E) elements[index];
		elements[index] = element;
		return previousElem;
	}

	public boolean remove(E element) {
		int index = indexOf(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;

	}

	public E remove(int index) {
		E removeElem = get(index);
		elements[index] = null;
        return removeElem;
	}



	public int indexOf(E element) {
			for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
	}

    public boolean contains(Object element) {
        return indexOf(E element) != -1;
    }
	public int lastIndexOf(E element) {

		for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
	}

	public void clear() {
		Arrays.fill(elements, null);
        size = 0;
	}

	public E[] toArray() {
		  return (E[]) Arrays.copyOf(elements, size);
	}

	public <T> T[] toArray(T[] array) {

		 if (array.length < size) {
            return (T[]) Arrays.copyOf(elements, size, array.getClass());
        }
        
        if (array.length > size) {
            array[size] = null;
        }
        return array;

	}

	public ListInerface<E> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || fromIndex > toIndex || toIndex > size) {
            throw new IndexOutOfBoundsException("From Index: " + fromIndex + ", To Index: " + toIndex + ", Size: " + size);
        }

        ListInerface<E> sublist = new ListInerface<>();
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.add(get(i));
        }
        return sublist;
	}



    public boolean removeAll(ListInerface<?> otherList) {

		boolean removeOrNo = false;
        for (int i = 0; i < size; i++) {
            if (otherList.contains(elements[i])) {
                remove(i);
                removeOrNo = true;
                i--;
            }
        }
        return removeOrNo;
	}

	public boolean retainAll(ListInerface<?> otherList) {

		boolean removeOrNo = false;
        for (int i = 0; i < size; i++) {
            if (!otherList.contains(elements[i])) {
                remove(i);
                removeOrNo = true;
                i--;
            }
        }
        return removeOrNo;

	}

	public boolean containsAll(ListInerface<?> otherList) {

		boolean containsAllOrNo = true;
        for (int i = 0; i < size; i++) {
            if (!otherList.contains(elements[i])) {
                containsAllOrNo = false;
            }
        }
        return containsAllOrNo;

	}

	public boolean addAll(ListInerface<? extends E> otherList) {
		int addSize = size + otherList.size();
        checkCapacity(addSize);
        for (E element : otherList) {
            elements[size++] = element;
        }
        return addSize != size;
	}


	/*public boolean addAll(int index, ListInerface<? extends E> otherList) {
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        int newSize = size + otherList.size();
        checkCapacity(newSize);
        
        for (int i = index, j = 0; j < otherList.size(); i++, j++) {
            elements[i] = otherList.get(j);
            size++;
        }
        return newSize != size;
	}*/

	public boolean equals(Object obj) {
		 if (this == obj) {
            return true;
        } else {
        	return false;
        }
	}

	public int hashCode() {
		return size;
	}

	public String toString() {
		StringBuilder listInString = new StringBuilder();
        listInString.append('[');
        for (int i = 0; i < size; i++) {
            listInString.append(elements[i]);
            if (i < size - 1) {
                listInString.append(", ");
            }
        }
        listInString.append(']');
        return listInString.toString();
	}
}

