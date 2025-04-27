import java.util.EmptyStackException;

public class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode;
    private Node lastNode;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);

        if(isEmpty()) 
            firstNode = newNode;
        else 
            lastNode.setNextNode(newNode);

        lastNode = newNode;
    }

    public T dequeue() {
        T front = getFront();

        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null)
            lastNode = null;

        return front;
    }

    public T getFront() {
        if (isEmpty())
            throw new EmptyStackException();
        else  
            return firstNode.getData();
    }

    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
    }


    private class Node {
        private T data;
        private Node next;

        private Node(T data){
            this(data, null);
        }

        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }
    } 
}
