package test;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import utilities.MyAbstractQueue;

public class TestAbstractQueue {
	public static void f1Constructor() {
		// Since AbstractQueue is an abstract class
        // create object using LinkedBlockingQueue
        AbstractQueue<Integer> AQ1 = new LinkedBlockingQueue<Integer>();
  
        // Populating AQ
        AQ1.add(10);
        AQ1.add(20);
        AQ1.add(30);
        AQ1.add(40);
        AQ1.add(50);
  
        // print AQ
        System.out.println("AbstractQueue contains : "
                           + AQ1);
        AbstractQueue<Integer> AQ2 = new LinkedBlockingQueue<Integer>(AQ1);
        System.out.println("AbstractQueue contains : "
                + AQ2);
	}

	public static void f2Add() {
		// Tạo một AbstractQueue
		AbstractQueue<Integer> AQ = new LinkedBlockingQueue<Integer>();
		// Sử dụng phương thức addAll() theo ArrayList();
		// Tạo một ArrayList
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		temp.add(2);
		temp.add(3);
		// Phương thức addAll từ một ArrayList
		MyAbstractQueue.addAll(AQ, temp);
		// Hiển thị AbstractQueue hiện có
		System.out.println("AbstractQueue: " + AQ);
		// Tạo một AbstractQueue
		AbstractQueue<Integer> AQ2 = new LinkedBlockingQueue<Integer>();
		// Phương thức addAll từ một AbstractQueue
		MyAbstractQueue.addAll(AQ2, AQ);
		System.out.println("AbstractQueue2: " + AQ2);
	}
	
	public static void f3Element() {
		// Since AbstractQueue is an abstract class
        // create object using LinkedBlockingQueue
        AbstractQueue<Integer> AQ1 = new LinkedBlockingQueue<Integer>();
  
        // Populating AQ
        AQ1.add(10);
        AQ1.add(20);
        AQ1.add(30);
        AQ1.add(40);
        AQ1.add(50);
  
        // print AQ
        System.out.println("Head: "
                           + MyAbstractQueue.element(AQ1));
	}

	public static void f4Remove() {
		// Tạo một AbstractQueue
		// Since AbstractQueue is an abstract class
        // create object using LinkedBlockingQueue
        AbstractQueue<Integer> AQ1 = new LinkedBlockingQueue<Integer>();
  
        // Populating AQ
        AQ1.add(10);
        AQ1.add(20);
        AQ1.add(30);
        AQ1.add(40);
        AQ1.add(50);
		// Hiển thị hàng đợi hiện có
		System.out.println(AQ1);
		// Xóa phần tử khỏi hàng đợi
		MyAbstractQueue.remove(AQ1, 20);
		// Hiển thị hàng đợi sau khi đã xóa một phần tử
		System.out.println("Removed : " + AQ1);
	}

	public static void main(String[] args) {

	}
}
