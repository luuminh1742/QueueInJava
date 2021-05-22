package utilities;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class MyAbstractQueue {
	/**
	 * Phương thức <b>thêm</b> một số int n vào queue. <br>
	 * Phương thức này sẽ chèn số n vào cuối queue. <br>
	 * Phương thức này sẽ trả về true nếu thêm thành công ngược lại trả về false
	 * 
	 * @param AQ
	 * @param n
	 * @return
	 */
	public static boolean add(AbstractQueue<Integer> AQ, int n) {
		return AQ.add(n);
	}

	/**
	 * - Phương thức <b>thêm</b> một danh sách số vào hàng đợi.</br>
	 * - Phương thức này sẽ chèn một danh sách số vào cuối của hàng đợi.</br>
	 * - Phương thức này sẽ trả về true nếu thêm thành công và nó sẽ trả về false
	 * nếu thêm thất bại..
	 * 
	 * @param queue
	 * @param listInteger
	 * @return
	 */
	public static boolean addAll(AbstractQueue<Integer> queue, ArrayList<Integer> listInteger) {
		// Phương thức addAll() sẽ chèn tất cả các phần tử của danh sách
		// vào cuối của hàng đợi.
		return queue.addAll(listInteger);
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
	public static boolean addAll(AbstractQueue<Integer> queue, AbstractQueue<Integer> newQueue) {
		// Phương thức addAll() sẽ chèn tất cả các phần tử của newQueue vào
		// cuối của hàng đợi queue.
		return queue.addAll(newQueue);
	}

	/**
	 * - Phương thức xóa toàn bộ phần tử của AbstractQueue
	 * 
	 * @param AQ
	 */
	public static void clear(AbstractQueue<Integer> AQ) {
		// Phương thức clear() sẽ xóa tất cả các phần tử của AQ
		AQ.clear();
	}

	/**
	 * - Phương thức truy xuất phần tử đầu của AbstracQueue
	 * 
	 * @param AQ
	 * @return
	 */
	public static Integer element(AbstractQueue<Integer> AQ) {
		return AQ.element();
	}

	/**
	 * - Phương thức xóa 1 phần tử trong AbstractQueue
	 * 
	 * @param AQ
	 * @param n
	 * @return
	 */
	public static boolean remove(AbstractQueue<Integer> AQ, int n) {
		return AQ.remove(n);
	}

	public static void main(String[] argv) throws Exception {
		// Since AbstractQueue is an abstract class
		// create object using LinkedBlockingQueue
		AbstractQueue<Integer> AQ1 = new LinkedBlockingQueue<Integer>();

		// Populating AQ
		AQ1.add(10);
		AQ1.add(20);
		AQ1.add(30);
		AQ1.add(40);
		AQ1.add(50);

		System.out.println("AbstractQueue contains : " + AQ1);
		System.out.println("Remove status: " + remove(AQ1, 20));
		System.out.println("AbstractQueue contains : " + AQ1);
	}
}
