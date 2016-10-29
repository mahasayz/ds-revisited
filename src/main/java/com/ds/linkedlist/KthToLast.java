package com.ds.linkedlist;

/**
 * Created by Mahbub on 10/29/2016.
 */

class Node<K> {
    K value;
    Node next = null;

    public Node(K value) {
        this.value = value;
    }
}

class LinkedList<K> {
    Node head = null;
    Node tail = null;

    public void add(K n) {
        Node<K> node = new Node(n);
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void print() {
        Node current = head;
        while (current != null){
            if (current.next == null)
                System.out.printf("%d", current.value);
            else
                System.out.printf("%d -> ", current.value);
            current = current.next;
        }
        System.out.println();
    }
}

public class KthToLast {

    public static void kthToLast(LinkedList list, int k) {
        Node current = list.head, runner = list.head;
        int counter = 0;

        while (current != null) {
            if (counter >= k)
                runner = runner.next;

            current = current.next;
            counter++;
        }

        System.out.println(runner.value);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);

        list.print();

        kthToLast(list, 3);
    }

}
