package ua.konstantynov.hw15_collections.task1;

class MyList<E> {

    private MyNode<E> tail;
    private MyNode<E> head;
    private MyNode<E> myNode = new MyNode<>();
    private int length = 0;

    public void add(E value) {
        if (value != null) {
            if (length == 0) {
                myNode.next = new MyNode<>();
                myNode.value = value;
                head = myNode;
            }
            myNode.value = value;
            myNode.prev = tail;
            tail = myNode;
            myNode = myNode.next;
            myNode.next = new MyNode<>();
            length++;
        }
    }

    public E getFromLast(E value) {
        MyNode<E> myNode = tail;
        for (int i = 0; i < length; i++) {
            if (myNode.value.equals(value)) {
                return myNode.value;
            }
            myNode = myNode.prev;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if (length == 0) {
            string.append(" ");
        } else {
            MyNode<E> myNode = head;
            for (int i = 0; i < length; i++) {
                string.append(i == length - 1 ? myNode.value + " " : myNode.value + ", ");
                myNode = myNode.next;
            }
        }
        return "MyList{value=" + string + '}';
    }
}