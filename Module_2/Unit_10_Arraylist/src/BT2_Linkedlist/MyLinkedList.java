package BT2_Linkedlist;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        numNodes++;
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(Object data) {
        add(data);
    }

    public void remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node previousNode = getNode(index - 1);
            Node currentNode = previousNode.next;
            previousNode.next = currentNode.next;
            currentNode.next = null;
        }
        numNodes--;
    }

    public void remove(Object data) {
        Node currentNode = head; // nút hiện tại
        Node previousNode = null;// nút trước đó
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                if (previousNode == null) {
                    head = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                currentNode.next = null;
                numNodes--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public Object get(int index) {
        Node node = getNode(index);
        return node.data;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public int size() {
        return numNodes;
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public MyLinkedList clone() {
        MyLinkedList newList = new MyLinkedList();
        Node currentNode = head;
        while (currentNode != null) {
            newList.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return newList;
    }

    public boolean contains(Object data) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public int indexOf(Object data) {
        Node currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }
}

