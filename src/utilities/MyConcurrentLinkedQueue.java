package utilities;

import java.util.*;
import java.util.concurrent.*;

public class MyConcurrentLinkedQueue {

	/**
	 * Phương thức khởi tạo môt <b>hàng đợi</b> chuỗi ký tự
	 * 
	 * @return
	 */
	public static ConcurrentLinkedQueue<String> createConcurrentLinkedQueue() {
		// Khởi tạo 3 phần tử cho hàng đợi
		ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>(List.of("One", "Two", "Three"));
		return clq;
	}

	/**
	 * Phương thức khởi tạo môt <b>hàng đợi</b> chuỗi ký tự với đối số truyền vào là
	 * queue
	 * 
	 * @return
	 */
	public static ConcurrentLinkedQueue<String> createConcurrentLinkedQueue(ConcurrentLinkedQueue<String> queue) {
		ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>(queue);
		return clq;
	}

	/**
	 * - Phương thức <b>thêm</b> một chuỗi str vào hàng đợi queue.</br>
	 * - Phương thức này sẽ chèn một chuỗi str vào cuối của hàng đợi.</br>
	 * - Phương thức này sẽ trả về true nếu thêm thành công và nó sẽ trả về false
	 * nếu thêm thất bại.
	 * 
	 * @param queue
	 * @param str
	 * @return
	 */
	public static boolean add(ConcurrentLinkedQueue<String> queue, String str) {
		// Phương thức add() sẽ chèn phần tử được chỉ định vào cuối của hàng đợi
		return queue.add(str);
	}

	/**
	 * - Phương thức <b>thêm</b> một chuỗi str vào hàng đợi queue.</br>
	 * - Phương thức này sẽ chèn một chuỗi str vào cuối của hàng đợi.</br>
	 * - Phương thức này sẽ trả về true nếu thêm thành công và nó sẽ trả về false
	 * nếu thêm thất bại.
	 * 
	 * @param queue
	 * @param str
	 * @return
	 */
	public static boolean addByOffer(ConcurrentLinkedQueue<String> queue, String str) {
		// Phương thức offer() sẽ chèn phần tử được chỉ định vào cuối của hàng đợi
		return queue.offer(str);
	}

	/**
	 * - Phương thức <b>thêm</b> một danh sách chuỗi vào hàng đợi.</br>
	 * - Phương thức này sẽ chèn một danh sách String vào cuối của hàng đợi.</br>
	 * - Phương thức này sẽ trả về true nếu thêm thành công và nó sẽ trả về false
	 * nếu thêm thất bại..
	 * 
	 * @param queue
	 * @param listString
	 * @return
	 */
	public static boolean addAll(ConcurrentLinkedQueue<String> queue, ArrayList<String> listString) {
		// Phương thức addAll() sẽ chèn tất cả các phần tử của danh sách vào cuối của
		// hàng đợi.
		return queue.addAll(listString);
	}

	/**
	 * - Phương thức <b>thêm</b> một hàng đợi newQueue vào một hàng đợi khác
	 * queue.</br>
	 * - Phương thức này sẽ chèn một hàng đợi newQueue vào cuối của hàng đợi
	 * queue.</br>
	 * - Phương thức này sẽ trả về true nếu thêm thành công và nó sẽ trả về false
	 * nếu thêm thất bại.
	 * 
	 * @param queue
	 * @param newQueue
	 * @return
	 */
	public static boolean addAll(ConcurrentLinkedQueue<String> queue, ConcurrentLinkedQueue<String> newQueue) {
		// Phương thức addAll() sẽ chèn tất cả các phần tử của newQueue vào cuối của
		// hàng đợi queue.
		return queue.addAll(newQueue);
	}

	/**
	 * Phương thức tìm kiếm phần tử trong hàng đợi sử dụng phương thức queue.
	 * 
	 * @param queue
	 * @param str
	 * @return
	 */
	public static boolean search(ConcurrentLinkedQueue<String> queue, String str) {
		// Phương thức contains() sẽ trả về true nếu hàng đợi chứa phần tử được chỉ
		// định.
		return queue.contains(str);
	}

	/**
	 * Phương thức lấy phần tử đầu tiên trong hàng đợi sử dụng phương thức peek().
	 * 
	 * @param queue
	 * @return
	 */
	public static String getValueHeadByPeek(ConcurrentLinkedQueue<String> queue) {
		// Phương thức peek() dùng để lấy phần tử đầu tiên trong hàng đợi.
		// Không xóa phần tử đó ra khỏi hàng đợi.
		return queue.peek();
	}

	/**
	 * Phương thức lấy phần tử đầu tiên trong hàng đợi sử dụng phương thức
	 * element().
	 * 
	 * @param queue
	 * @return
	 */
	public static String getValueHeadByElement(ConcurrentLinkedQueue<String> queue) {
		// Phương thức element() dùng để lấy phần tử đầu tiên trong hàng đợi.
		// Không xóa phần tử đó ra khỏi hàng đợi.
		return queue.element();
	}

	/**
	 * Phương thức lấy phần tử đầu tiên trong hàng đợi và xóa giá trị đó ra khỏi
	 * hàng đợi sử dụng phương thức poll().
	 * 
	 * @param queue
	 * @return
	 */
	public static String getValueHeadByPoll(ConcurrentLinkedQueue<String> queue) {
		// Phương thức poll() dùng để lấy phần tử đầu tiên trong hàng đợi.
		// Và xóa phần tử đó ra khỏi hàng đợi.
		return queue.poll();
	}

	/**
	 * Phương thức in từng phần tử trong queue ra màn hình sử dụng iterator().
	 * 
	 * @param queue
	 */
	public static void printQueueByIterator(ConcurrentLinkedQueue<String> queue) {
		// Call iterator() method
		Iterator<String> iterator = queue.iterator();
		// Print elements of iterator
		System.out.println("\nThe String Values of iterator are:");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	/**
	 * Phương thức in từng phần tử trong queue ra màn hình sử dụng spliterator().
	 * 
	 * @param queue
	 */
	public static void printQueueBySpliterator(ConcurrentLinkedQueue<String> queue) {
		// create Spliterator of ConcurrentLinkedQueue
		// using spliterator() method
		Spliterator<String> spt = queue.spliterator();

		// print result from Spliterator
		System.out.println("List of ConcurrentLinkedQueue:");

		// forEachRemaining method of Spliterator
		spt.forEachRemaining((n) -> System.out.println(n + ", "));
	}

	/**
	 * Phương thức in hàng đợi ra màn hình sử dụng forEach().
	 * 
	 * @param queue
	 */
	public static void printQueueByForEach(ConcurrentLinkedQueue<String> queue) {
		queue.forEach(element -> {
			// In từng phần tử trong hàng đợi ra màn hình
			System.out.println(element);
		});
	}

	/**
	 * Phương thức xóa phần tử có giá trị value trong hàng đợi queue.
	 * 
	 * @param queue
	 * @param value
	 * @return
	 */
	public static boolean removeElement(ConcurrentLinkedQueue<String> queue, String value) {
		return queue.remove(value);
	}

	/**
	 * Phương thức xóa tất cả các phần tử của hàng đợi queue có trong danh sách
	 * listRemove.
	 * 
	 * @param queue
	 * @param listRemove
	 * @return
	 */
	public static boolean removeAllByList(ConcurrentLinkedQueue<String> queue, ArrayList<String> listRemove) {
		return queue.removeAll(listRemove);
	}

	/**
	 * Phương thức xóa tất các các phần tử của ngăn xếp queue có trong ngăn xếp
	 * queueRemove.
	 * 
	 * @param queue
	 * @param queueRemove
	 * @return
	 */
	public static boolean removeAllByQueue(ConcurrentLinkedQueue<String> queue,
			ConcurrentLinkedQueue<String> queueRemove) {
		return queue.removeAll(queueRemove);
	}

	/**
	 * Phương thức xóa tất các các phần tử trong hàng đợi queue.
	 * 
	 * @param queue
	 */
	public static void removeAll(ConcurrentLinkedQueue<String> queue) {
		queue.clear();
	}

	/**
	 * Phương thức xóa giá trị trong hàng đợi với điều kiện xác định.
	 * 
	 * @param queue
	 * @param valueRemove
	 * @return
	 */
	public static boolean removeIf(ConcurrentLinkedQueue<String> queue, String valueRemove) {
		// Phương thức xóa các phần tử trong hàng đợi với điều kiện.
		return queue.removeIf(value -> value.equals(valueRemove));
	}

	/**
	 * Phương thức chuyển hàng đợi thành mảng một chiều sử dụng phương thức
	 * toArray();
	 * 
	 * @param queue
	 * @return
	 */
	public static Object[] toArray(ConcurrentLinkedQueue<String> queue) {
		// Phương thức toArray() dùng để chuyển một hàng đợi thành mảng đối tượng.
		Object[] obj = queue.toArray();
		return  obj;
	}

	/**
	 * Phương thức kiểm tra xem hàng đợi có rỗng không</br>
	 * -> Trả về true nếu hàng đợi không chứa phần tử.
	 * 
	 * @param queue
	 * @return
	 */
	public static boolean isEmpty(ConcurrentLinkedQueue<String> queue) {
		return queue.isEmpty();
	}
}
