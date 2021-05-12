package test;

import java.util.*;
import java.util.concurrent.*;

import utilities.MyConcurrentLinkedQueue;

public class TestConcurrentLinkedQueue {

	public static void f1Constructor() {
		// Create a ConcurrentLinkedQueue
		// using ConcurrentLinkedQueue() contructor
		ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
		clq.add("A");
		clq.add("B");
		clq.add("C");
		clq.add("D");
		// Displaying the existing LinkedQueue
		System.out.println("ConcurrentLinkedQueue: " + clq);
		// Create a ConcurrentLinkedQueue
		// using ConcurrentLinkedQueue(Collection c)
		// constructor
		ConcurrentLinkedQueue<String> clq1 = new ConcurrentLinkedQueue<String>(clq);
		// Displaying the existing LinkedQueue
		System.out.println("ConcurrentLinkedQueue1: " + clq1);
	}

	public static void f2Add() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
		// Sử dụng phương thức addAll() theo ArrayList();
		// Tạo một ArrayList
		ArrayList<String> temp = new ArrayList<String>(List.of("A", "B", "C"));
		// Phương thức addAll từ một ArrayList
		MyConcurrentLinkedQueue.addAll(clq, temp);
		// Hiển thị ConcurrentLinkedQueue hiện có
		System.out.println("ConcurrentLinkedQueue: " + clq);
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq2 = new ConcurrentLinkedQueue<String>();
		// Phương thức addAll từ một ConcurrentLinkedQueue
		MyConcurrentLinkedQueue.addAll(clq2, clq);
		System.out.println("ConcurrentLinkedQueue2: " + clq2);
	}

	public static void f3Contains() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = MyConcurrentLinkedQueue.createConcurrentLinkedQueue();
		// Hiển thị ConcurrentLinkedQueue hiện có
		System.out.println(clq);
		// Dùng phương thức contains() để tìm kiếm phần tử trong hàng đợi
		if (MyConcurrentLinkedQueue.search(clq, "One")) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	public static void f4ForEach() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = MyConcurrentLinkedQueue.createConcurrentLinkedQueue();
		// Phương thức in thông tin của các phần tử trong clq ra màn hình
		// sử dụng forEach
		MyConcurrentLinkedQueue.printQueueByForEach(clq);
	}

	public static void f5IsEmpty() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
		// Kiểm tra xem hàng đợi trên có rỗng hay không sử dụng phương thức isEmpty()
		// Nếu rỗng thì trả về true
		if (MyConcurrentLinkedQueue.isEmpty(clq)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	public static void f6Interator() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = MyConcurrentLinkedQueue.createConcurrentLinkedQueue();
		// In clq sử dụng interator()
		MyConcurrentLinkedQueue.printQueueByIterator(clq);
	}

	public static void f7Offer() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
		// Sử dụng offer() để thêm phần tử vào clq
		MyConcurrentLinkedQueue.addByOffer(clq, "Lưu Bá Minh");
		// Hiển thị hàng đợi hiện có
		System.out.println(clq);
	}

	public static void f8Remove() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = MyConcurrentLinkedQueue.createConcurrentLinkedQueue();
		// Hiển thị hàng đợi hiện có
		System.out.println(clq);
		// Xóa phần tử khỏi hàng đợi
		MyConcurrentLinkedQueue.removeElement(clq, "Two");
		// Hiển thị hàng đợi sau khi đã xóa một phần tử
		System.out.println("Removed : " + clq);
	}

	public static void f9RemoveAll() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = MyConcurrentLinkedQueue.createConcurrentLinkedQueue();
		// Hiển thị hàng đợi hiện có
		System.out.println(clq);
		// Tạo một danh sách cần xóa
		ArrayList<String> listRemove = new ArrayList<String>(List.of("One", "Three"));
		// Dùng removeAll() để xóa danh sách listRemove ra khỏi hàng đợi clq
		MyConcurrentLinkedQueue.removeAllByList(clq, listRemove);
		// Hiển thị hàng đợi sau khi xóa
		System.out.println("Removed : " + clq);
	}

	public static void f10RemoveIf() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = MyConcurrentLinkedQueue.createConcurrentLinkedQueue();
		// Hiển thị hàng đợi hiện có
		System.out.println(clq);
		// Tạo một danh sách cần xóa
		// Dùng removeIf() để xóa danh sách giá ra khỏi hàng đợi clq
		MyConcurrentLinkedQueue.removeIf(clq, "Two");
		// Hiển thị hàng đợi sau khi xóa
		System.out.println("Removed : " + clq);
	}

	public static void f11Spliterator() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = MyConcurrentLinkedQueue.createConcurrentLinkedQueue();
		// Sử dụng Spliterator để in hàng đợi ra màn hình
		MyConcurrentLinkedQueue.printQueueBySpliterator(clq);
	}

	public static void f12ToArray() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = MyConcurrentLinkedQueue.createConcurrentLinkedQueue();
		// Hiển thị hàng đợi hiện có
		System.out.println("ConcurrentLinkedQueue: " + clq);
		// Chuyển hàng đợi thành mảng một chiều
		Object[] strArray = MyConcurrentLinkedQueue.toArray(clq);
		// Hiển thị mảng một chiều
		System.out.println("Array: ");
		for (Object str : strArray) {
			System.out.println(str);
		}
	}

	public static void f13GetElement() {
		// Tạo một ConcurrentLinkedQueue
		ConcurrentLinkedQueue<String> clq = MyConcurrentLinkedQueue.createConcurrentLinkedQueue();
		// Hiển thị hàng đợi hiện có
		System.out.println("ConcurrentLinkedQueue: " + clq);
		String value = "";
		// Sử dung peek()
		value = MyConcurrentLinkedQueue.getValueHeadByPeek(clq);
		System.out.println("peek() = " + value);
		System.out.println("ConcurrentLinkedQueue after use peek() : " + clq);
		// Sử dung element()
		value = MyConcurrentLinkedQueue.getValueHeadByElement(clq);
		System.out.println("element() = " + value);
		System.out.println("ConcurrentLinkedQueue after use element() : " + clq);
		// Sử dung peek()
		value = MyConcurrentLinkedQueue.getValueHeadByPoll(clq);
		System.out.println("poll() = " + value);
		System.out.println("ConcurrentLinkedQueue after use poll() : " + clq);
	}

	public static void main(String[] args) {

	}
}
