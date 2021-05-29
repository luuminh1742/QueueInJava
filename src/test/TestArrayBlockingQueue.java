package test;

import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Spliterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import utilities.MyArrayBlockingQueue;

/**
 * Lớp test phương thức
 * 
 * @author vanha
 *
 */
public class TestArrayBlockingQueue {

	public static ArrayBlockingQueue<Integer> fn_arrayBlocking() {
		ArrayBlockingQueue<Integer> queue = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(456);

		MyArrayBlockingQueue.addAllElement(queue, list);

		return queue;
	}

	/**
	 * Khởi tạo đối tượng
	 */
	public static void fn_constructor() {
		// Hàm khởi tạo đối tượng có kích thước = 5
		ArrayBlockingQueue<String> abq = MyArrayBlockingQueue.createArrayBlockingQueue(5);
		abq.add("A");
		abq.add("B");
		// Hàm khởi tạo đối tượng có kích thước = 5, true
		ArrayBlockingQueue<String> abq1 = MyArrayBlockingQueue.createArrayBlockingQueue(5, true);
		abq1.add("A");
		abq1.add("B");
		// Hàm khởi tạo đối tượng có kích thước = 5, true, clo
		Collection<String> clo = new ArrayList<String>();
		clo.add("A");
		clo.add("B");
		clo.add("C");
		ArrayBlockingQueue<String> abq2 = MyArrayBlockingQueue.createArrayBlockingQueue(5, true, clo);
		
		// Hiển thị hàng đợi
		System.out.println("Hàng đợi 1: " + abq);
		System.out.println("Hàng đợi 2: " + abq1);
		System.out.println("Hàng đợi 3: " + abq2);
	}

	/**
	 * Thêm mới đối tượng
	 */
	public static void fn_add() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> abq = MyArrayBlockingQueue.createArrayBlockingQueue(5);

		// Thêm phần tử mới vào hàng đợi
		MyArrayBlockingQueue.addElement(abq, 4);

		// Hiển thị hàng đợi
		System.out.println("Add: " + abq);

		// Khởi tạo và thêm giá trị vào danh sách
		Collection<Integer> clo = new ArrayList<Integer>();
		clo.add(1);
		clo.add(3);
		clo.add(2);

		// Thêm danh sách vào hàng đợi
		MyArrayBlockingQueue.addAllElement(abq, clo);

		// Hiển thị hàng đợi
		System.out.println("Add all: " + abq);

	}

	public static void fn_addOffer() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		// Thêm phần tử vào hàng đợi
		System.out.println("Thêm 423: " + MyArrayBlockingQueue.addElementByOffer(queue, 423));
		System.out.println("Thêm 243: " + MyArrayBlockingQueue.addElementByOffer(queue, 243));

		// Kiểm tra đầy hàng đợi
		if (MyArrayBlockingQueue.getCapacityEmpty(queue) == 0) {
			System.out.println("Hàng đợi đầy");
			System.out.println("Hàng đợi tồn tại  " + queue);
		} else {
			System.out.println("Hàng đợi chưa đầy");
			System.out.println("Hàng đợi tồn tại" + queue);
		}

		// Cố gắng thêm phần tử vào
		System.out.println("Thêm 123: " + MyArrayBlockingQueue.addElementByOffer(queue, 123));
		System.out.println("Thêm 321: " + MyArrayBlockingQueue.addElementByOffer(queue, 321));
	}

	public static void fn_addOfferV2() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		System.out.println("Thêm 423: " + MyArrayBlockingQueue.addElementByOffer(queue, 433, 10, TimeUnit.SECONDS));
		System.out.println("Thêm 456: " + MyArrayBlockingQueue.addElementByOffer(queue, 456, 10, TimeUnit.SECONDS));

		// Kiểm tra đầy hàng đợi
		if (MyArrayBlockingQueue.getCapacityEmpty(queue) == 0) {
			System.out.println("Hàng đợi đầy");
			System.out.println("Hàng đợi tồn tại  " + queue);
		} else {
			System.out.println("Hàng đợi chưa đầy");
			System.out.println("Hàng đợi tồn tại" + queue);
		}

		// Tiếp tục thêm nhân viên
		System.out.println("Thêm 123: " + MyArrayBlockingQueue.addElementByOffer(queue, 123, 5, TimeUnit.SECONDS));
	}

	public static void fn_addPut() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		// Thêm mới phần tử
		MyArrayBlockingQueue.addElementByPut(queue, 223);
		MyArrayBlockingQueue.addElementByPut(queue, 456);

		// Hiển thị phần tử
		System.out.println("Hàng đợi: " + queue);
	}

	public static void fn_addAll() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = MyArrayBlockingQueue.createArrayBlockingQueue(2);
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(456);

		// Thêm danh sách phần tử vào hàng đợi
		MyArrayBlockingQueue.addAllElement(queue, list);
	}

	public static void fn_removeV2() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		// Hiển thị hàng đợi
		System.out.println("Hàng đợi 1: " + queue);
		System.out.println("Loại bỏ giá trị hàng đợi 1: " + MyArrayBlockingQueue.removeElementFirst(queue));
		System.out.println("Hàng đợi 1: " + queue + "\n");

		// Hiển thị mảng rỗng
		System.out.println("Hàng đợi 2: " + queue2);
		System.out.println("Loại bỏ giá trị hàng đợi 2: " + MyArrayBlockingQueue.removeElementFirst(queue2));
	}

	public static void fn_removeAll() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);
		queue2.add(123);
		// Hiển thị hàng đợi
		System.out.println("Hàng đợi 1: " + queue);
		System.out.println("Loại bỏ giá trị hàng đợi 1: " + MyArrayBlockingQueue.removeAllElement(queue, queue2));
		System.out.println("Hàng đợi 1: " + queue + "\n");

		// Hiển thị mảng rỗng
		System.out.println("Hàng đợi 2: " + queue2);
		System.out.println("Loại bỏ giá trị hàng đợi 2: " + MyArrayBlockingQueue.removeAllElement(queue2, queue));
	}

	public static void fn_clear() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);
		queue2.add(123);
		// Hiển thị hàng đợi
		System.out.println("Hàng đợi 1: " + queue);
		MyArrayBlockingQueue.clear(queue);
		System.out.println("Hàng đợi 1: " + queue + "\n");

		// Hiển thị mảng rỗng
		System.out.println("Hàng đợi 2: " + queue2);
		MyArrayBlockingQueue.clear(queue2);
		System.out.println("Hàng đợi 2: " + queue2);
	}

	public static void fn_contains() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);
		// Hiển thị hàng đợi
		System.out.println("Hàng đợi 1 tồn tại 123: " + MyArrayBlockingQueue.containElement(queue, 123));

		// Hiển thị mảng rỗng
		System.out.println("Hàng đợi 2 tồn tại 123: " + MyArrayBlockingQueue.containElement(queue2, 123));
	}

	public static void fn_containsAll() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		// Khởi tạo danh sách và thêm phần tử
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(456);
		// Hiển thị hàng đợi
		System.out.println("Hàng đợi 1 tồn tại 123: " + MyArrayBlockingQueue.containAllElement(queue, list));

		// Hiển thị mảng rỗng
		System.out.println("Hàng đợi 2 tồn tại 123: " + MyArrayBlockingQueue.containAllElement(queue2, list));
	}

	public static void fn_draintTo() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		System.out.println("Trước khi drainTo:\n" + queue);
		MyArrayBlockingQueue.drainToCollection(queue, queue2);
		System.out.println("Sau khi drainTo: " + queue);
		System.out.println("queue2: " + queue2);
	}

	public static void fn_drainToV2() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		System.out.println("Trước khi drainTo\n" + queue);
		try {
			MyArrayBlockingQueue.drainToCollection(queue, queue2, 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Sau khi drainTo\n" + queue);
		System.out.println("queue2: " + queue2);
	}

	public static void fn_ToArray() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		Object[] array = MyArrayBlockingQueue.toArray(queue);
		Object[] array2 = MyArrayBlockingQueue.toArray(queue2);

		System.out.println("Mảng 1:");
		MyArrayBlockingQueue.printArray(array);
		System.out.println("\nMảng 2:");
		MyArrayBlockingQueue.printArray(array2);
	}

	public static void fn_ToArrayV2() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();

		// Tạo mảng
		Integer[] array = new Integer[2];

		// gọi hàm toArray(T[] a)
		Object[] ReturnArray = MyArrayBlockingQueue.toArray(queue, array);

		System.out.println("Hàng đợi: " + queue);
		System.out.println("\nMảng chuyển từ toArray():");
		MyArrayBlockingQueue.printArray(array);

		System.out.println("\nMảng trả về từ toArray():");
		MyArrayBlockingQueue.printArray(ReturnArray);
	}

	public static void fn_remainingCapacity() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		System.out.println("Hàng đợi 1: " + queue);
		System.out.println("Kích thước có thể lưu trữ hàng đợi 1: " + MyArrayBlockingQueue.getCapacityEmpty(queue));
		System.out.println("Hàng đợi 2: " + queue2);
		System.out.println("Kích thước có thể lưu trữ hàng đợi 2: " + MyArrayBlockingQueue.getCapacityEmpty(queue2));
	}

	public static void fn_spliterator() {
		// khởi tạo đối tượng
		ArrayBlockingQueue<Integer> queue = TestArrayBlockingQueue.fn_arrayBlocking();
		ArrayBlockingQueue<Integer> queue2 = MyArrayBlockingQueue.createArrayBlockingQueue(2);

		Spliterator<Integer> number1 = MyArrayBlockingQueue.getSpliteratorList(queue);
		Spliterator<Integer> number2 = MyArrayBlockingQueue.getSpliteratorList(queue2);

		System.out.println("Kích thước của number1 : " + number1.estimateSize());

		System.out.println("Danh sách number1:");
		//Dùng hàm forEachRemaining
		number1.forEachRemaining((n) -> System.out.println(n));
		
		System.out.println("Kích thước của number2 : " + number1.estimateSize());

		System.out.println("Danh sách number2:");
		//Dùng hàm forEachRemaining
		number2.forEachRemaining((n) -> System.out.println(n));
	}

	public static void main(String[] args) {
		// Exception: java.util.NoSuchElementException
		TestArrayBlockingQueue.fn_remainingCapacity();
	}

}
