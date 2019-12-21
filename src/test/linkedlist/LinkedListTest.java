package linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList<Integer> integerLinkedList = new LinkedList<>();

    private void initialLinkedList(){
        for (int i = 0; i < 10; i++) {
            integerLinkedList.addFirst(i);
        }
    }
    @Test
    public void get_size_test() {
        initialLinkedList();
        System.out.println(integerLinkedList);
    }

    @Test
    public void is_empty_test() {
        LinkedList<Integer> newLinkList = new LinkedList<>();
        System.out.println(newLinkList.isEmpty());
    }

    @Test
    public void add_test() {
        initialLinkedList();
        integerLinkedList.add(5,10);
        System.out.println(integerLinkedList);
    }


    @Test
    public void add_last_test() {
        initialLinkedList();
        integerLinkedList.addLast(-1);
        System.out.println(integerLinkedList);
    }

    @Test
    public void get_test() {
        initialLinkedList();
        System.out.println(integerLinkedList.get(4));
    }


    @Test
    public void set_test() {
        initialLinkedList();
        integerLinkedList.set(3,-6);
        System.out.println(integerLinkedList);
    }

    @Test
    public void contains_test() {
        initialLinkedList();
        System.out.println(integerLinkedList.contains(9));
    }

    @Test
    public void remove_test() {
        initialLinkedList();
        integerLinkedList.remove(6);
        System.out.println(integerLinkedList);
    }

    @Test
    public void remove_element_test() {
        initialLinkedList();
        integerLinkedList.removeElement(7);
        System.out.println(integerLinkedList);
    }
}