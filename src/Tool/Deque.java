public class Deque {

    private int[] arr;
    private int left;
    private int right;
    private int size;
    private int maxsize;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public Deque(int k) {
        arr = new int[k];
        left = 0;
        right = 0;
        size = 0;
        maxsize = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())
        {
            return false;
        }
        else
        {
            if(isEmpty())
            {
                left = right = 0;
                arr[left] = value;
            }else
            {
                left = (maxsize+ left-1) % maxsize;
                arr[left] = value;
            }
            size++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())
            return false;
        else
        {
            if(isEmpty())
            {
                left = right = 0;
                arr[right] = value;
            }
            else
            {
                right = (right+1) % maxsize;
                arr[right] = value;
            }
            size++;
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())
            return false;
        else
        {
            left = (left+1)%maxsize;
            size--;
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())
            return false;
        else
        {
            right = (maxsize+right-1) % maxsize;
            size--;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty()?-1:arr[left];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty()?-1:arr[right];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == maxsize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */