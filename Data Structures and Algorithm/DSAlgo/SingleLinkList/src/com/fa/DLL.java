package com.fa;

public class DLL {
    NodeDLL head;

    public DLL() {
        head = null;
    }

    public void append(int new_data) {
        NodeDLL new_node = new NodeDLL(new_data);

        NodeDLL last = head;

        // This new node is going to be the last node, so make next of it as NULL
        new_node.next_link = null;

        // If the Linked List is empty, then make the new node as head
        if (head == null) {
            new_node.prev_link = null;
            head = new_node;
            return;
        }

        // Else traverse till the last node
        while (last.next_link != null)
            last = last.next_link;

        // Change the next of last node
        last.next_link = new_node;

        // Make last node as previous of new node
        new_node.prev_link = last;
    }

    public void show() {
        // traverse in SLL until SLL not over
        for (NodeDLL tr = head; tr != null; tr = tr.next_link)
            System.out.println(tr.data);
    }
}
