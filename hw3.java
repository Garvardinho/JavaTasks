package geekbrains.java_alg.hw3;

import java.util.*;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) { this.name = name; this.age = age; }
    public void print() { System.out.println("Name: " + name + ", age: " + age); }
}

class Link<T> {
    private T data;
    private Link<T> next;

    public Link(T data) { this.data = data; }
    public Link<T> getNext() { return next; }
    public void setNext(Link<T> next) { this.next = next; }
    public T getData() { return data; }
}

class myStringList<T> {
    private Link<T> head;

    public myStringList() { head = null; }
    public boolean isEmpty() { return head == null; }

    public void insert(T elem) {
        Link<T> link = new Link<>(elem);
        link.setNext(head);
        head = link;
    }

    public T delete() {
        T data = head.getData();
        head = head.getNext();
        return data;
    }

    public void display() {
        Link<T>tmp = head;

        while (tmp != null) {
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }

    public int find(T data) { // If the element is found, it returns its index
        int index = 0;
        Link<T>tmp = head;

        while (tmp != null) {
            if (tmp.getData() == data)
                return index;

            tmp = tmp.getNext();
            ++index;
        }

        return -1; // If element is not found
    }
}

public class hw3 {

    public static void main(String[] args) {
        int []array;
        ArrayList<Integer> myIntList = new ArrayList<>();
        long start_time;
        long end_time;
        double time;

        array = new int[10];
        Random rand = new Random();

        for (int i = 0; i < array.length; ++i)
            array[i] = rand.nextInt(15);

        // Task 3.1
        System.out.println("Task 3.1");

        start_time = System.nanoTime();

        // Due to the primitiveness of the initial array type, elements should be added by 'for' loop
        for (int el : array)
            myIntList.add(el);

        end_time = System.nanoTime();
        time = (double)(end_time - start_time) * 0.000001f;
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Array list: " + myIntList);
        System.out.println("Time: " + time + " ms\n");

        // Task 3.2
        System.out.println("Task 3.2");

        start_time = System.nanoTime();

        myIntList.add(12321);
        myIntList.add(2, 12345);
        myIntList.remove(1);
        Integer element = myIntList.get(1);

        System.out.println("Array list: " + myIntList);
        System.out.println("Element " + element + " is at index 1");

        myIntList.removeAll(myIntList);
        System.out.println("Array list: " + myIntList);

        end_time = System.nanoTime();
        time = (double)(end_time - start_time) * 0.000001f;
        System.out.println("Time: " + time + " ms\n");

        // Task 3.3
        System.out.println("Task 3.3");

        start_time = System.nanoTime();

        myStringList<String> myStringList = new myStringList<>();
        if (myStringList.isEmpty())
            System.out.println("The list is empty");

        myStringList.insert("Kate");
        myStringList.insert("Ann");
        myStringList.insert("John");
        myStringList.insert("Mark");

        myStringList.display();

        System.out.println(myStringList.delete() + " was deleted");
        myStringList.display();

        int index = myStringList.find("Ann");
        if (index != -1)
            System.out.println("Ann is at the " + index + " index in the list");
        else
            System.out.println("Ann is not found");

        end_time = System.nanoTime();
        time = (double)(end_time - start_time) * 0.000001f;
        System.out.println("Time: " + time + " ms\n");

        // Task 3.4
        System.out.println("Task 3.4");
        Integer item = 777;

        LinkedList<Integer> myLinkedList = new LinkedList<>(myIntList);
        myLinkedList.add(123);
        myLinkedList.add(1,item);
        myLinkedList.addFirst(456);
        myLinkedList.addLast(item * 2);

        System.out.println("Linked list: " + myLinkedList.toString());

        if (myLinkedList.contains(item))
            System.out.println("Linked list contains " + item + " at the " + myLinkedList.indexOf(item) + " index\n");
        else
            System.out.println("Linked list does not contain " + item + "\n");

        // Task 3.5
        System.out.println("Task 3.5");

        LinkedList<Student> myStudentList = new LinkedList<>();
        myStudentList.add(new Student("Sarah", 19));
        myStudentList.add(new Student("Vic", 20));
        myStudentList.add(new Student("Mark", 21));
        myStudentList.add(new Student("Anna", 18));

        start_time = System.nanoTime();

        ListIterator<Student> it = myStudentList.listIterator();

        it.next();
        it.set(new Student("Paul", 22));
        it.previous();

        Student student;
        while (it.hasNext()) {
            student = it.next();
            student.print();
        }

        end_time = System.nanoTime();
        time = (double)(end_time - start_time) * 0.000001f;
        System.out.println("Time: " + time + " ms");
    }
}
