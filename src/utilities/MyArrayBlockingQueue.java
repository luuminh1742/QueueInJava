package utilities;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Lớp chứa các phương thức để xử lý, làm việc với Hàng đợi <br>
 * Create by: BVHA (12/05/2021)
 * 
 * @author vanha
 */
public class MyArrayBlockingQueue {

	/**
	 * Tạo một thực thể hàng đợi với tham số là kích thước <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param capacity
	 * @return
	 * 
	 */
	public static <E> ArrayBlockingQueue<E> createArrayBlockingQueue(int capacity) {
		ArrayBlockingQueue<E> abq = new ArrayBlockingQueue<E>(capacity);
		return abq;
	}

	/**
	 * Tạo một thực thể hàng đợi với tham số là kích thước, boolean <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param capacity
	 * @param fair
	 * @return
	 */
	public static <E> ArrayBlockingQueue<E> createArrayBlockingQueue(int capacity, boolean fair) {
		ArrayBlockingQueue<E> abq = new ArrayBlockingQueue<E>(capacity, fair);
		return abq;
	}

	/**
	 * Tạo một thực thể hàng đợi với tham số là kích thước, boolean, tập hợp
	 * (Collection) <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param capacity
	 * @param fair
	 * @param c
	 * @return
	 */
	public static <E> ArrayBlockingQueue<E> createArrayBlockingQueue(int capacity, boolean fair, Collection<E> c) {
		ArrayBlockingQueue<E> abq = new ArrayBlockingQueue<E>(capacity, fair, c);
		return abq;
	}

	/**
	 * Phương thức sẽ thêm phần tử mới vào hàng đợi với vị trí là cuối cùng Trả về
	 * True nếu thêm thành công, ngược lại sẽ trả về thông báo lỗi <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq
	 * @param e   - Phần tử để thêm vào hàng đợi
	 * @return
	 */
	public static <E> boolean addElement(ArrayBlockingQueue<E> abq, E e) {
		return abq.add(e);
	}

	/**
	 * Phương thức được dùng để thêm mới phần tử <b>e</b> vào hàng đợi với vị trí là
	 * cuối cùng Trả về <i>True</i> nếu thêm thành công, ngược lại sẽ trả về
	 * <i>False</i> <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq
	 * @param e   - Phần tử để thêm vào hàng đợi
	 * @return
	 */
	public static <E> boolean addElementByOffer(ArrayBlockingQueue<E> abq, E e) {
		return abq.offer(e);
	}

	/**
	 * Phương thức được dùng để thêm mới phần tử <b>e</b> vào hàng đợi. Nếu hàng đợi
	 * đầy, thì hàm sẽ thực hiện đợi một khoảng thời gian <i>time</i>, với cách tính
	 * thời gian dựa vào <i>unit</i> Trả về <i>True</i> nếu thêm thành công, ngược
	 * lại trả về <i>False</i> <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq  - Hàng đợi
	 * @param e    - Phần tử để thêm vào hàng đợi
	 * @param time - Thời gian chờ
	 * @param unit - Đơn vị tính thời gian chờ
	 * @return
	 */
	public static <E> boolean addElementByOffer(ArrayBlockingQueue<E> abq, E e, long time, TimeUnit unit) {
		try {
			return abq.offer(e, time, unit);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * Phương thức dùng để thêm phần tử mới vào hàng đợi. Nếu hàng đợi chưa đầy, thì
	 * thực hiện thêm mới phần tử vào cuối hàng đợi. Ngược lại, sẽ đợi cho đến khi
	 * có vị trí thêm mới. <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq
	 * @param e
	 * @throws InterruptedException
	 */
	public static <E> void addElementByPut(ArrayBlockingQueue<E> abq, E e) {
		try {
			abq.put(e);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Phương thức thực dùng để thêm mới một danh sách phần tử vào hàng đợi. <br>
	 * Trả về <i>True</i> nếu thêm tất cả phần tử từ danh sách vào hàng đợi thành
	 * công. Ngược lại, trả về thông báo lỗi. <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq    - Hàng đợi
	 * @param collec - Danh sách thêm vào hàng đợi
	 * @return
	 */
	public static <E> boolean addAllElement(ArrayBlockingQueue<E> abq, Collection<E> collec) {
		return abq.addAll(collec);
	}

	/**
	 * Trả về giá trị đầu tiên của hàng đợi nếu hàng đợi không rỗng. Ngược lại trả
	 * về thông báo lỗi <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq - Hàng đợi
	 * @return
	 */
	public static <E> E getElementFirstByElement(ArrayBlockingQueue<E> abq) {
		return abq.element();
	}

	/**
	 * Trả về giá trị đầu tiên của hàng đợi nếu hàng đợi không rỗng. Ngược lại trả
	 * về <i>Null</i><br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq - Hàng đợi
	 * @return
	 */
	public static <E> E getElementFirstByPeek(ArrayBlockingQueue<E> abq) {
		return abq.peek();
	}

	/**
	 * Phương trả về giá trị đầu tiên của hàng đợi, đồng thời loại bỏ giá trị đó
	 * khỏi hàng đợi <br>
	 * Trả về <i>null</i> khi hàng đợi rỗng Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq - Hàng đợi
	 * @return
	 */
	public static <E> E getAndRemoveFirstElement(ArrayBlockingQueue<E> abq) {
		return abq.poll();
	}

	/**
	 * Phương thức trả về giá trị đầu tiên của hàng đợi. Thực hiện đợi khi hàng đợi
	 * rỗng <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq  - Hàng đợi
	 * @param time - Thời gian chờ
	 * @param unit - Đơn vị tính thời gian chờ
	 * @return
	 * @throws InterruptedException
	 */
	public static <E> E getAndRemoveFirstElement(ArrayBlockingQueue<E> abq, long time, TimeUnit unit)
			throws InterruptedException {
		return abq.poll(time, unit);
	}

	/**
	 * Phương thức loại bỏ một phần tử theo giá trị <b>e</b> tồn tại trong hàng đợi,
	 * thứ tự từ FIFO. Trả về <i>True</i>nếu loại bỏ thành công, ngược lại trả về
	 * <i>False</i> <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq - Hàng đợ
	 * @param e   - Phần tử loại bỏ khỏi hàng đợi
	 * @return
	 */
	public static <E> boolean removeElementByValue(ArrayBlockingQueue<E> abq, E e) {
		return abq.remove(e);
	}

	/**
	 * Phương thức trả về phần tử đầu tiên, đồng thời loại bỏ phần tử đó khỏi hàng
	 * đợi. Trả về thông báo lỗi nếu hàng đợi rỗng. <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq - Hàng đợi
	 * @return
	 */
	public static <E> E removeElementFirst(ArrayBlockingQueue<E> abq) {
		return abq.remove();
	}

	/**
	 * Phương thức loại bỏ các phần tử dựa vào danh sách phần tử được truyền vào.
	 * Trả về <i>true</i> nếu hàm được thực thi, ngược lại trả về thông báo lỗi nếu
	 * danh sách được truyền vào là <i>null</i><br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq
	 * @param c
	 * @return
	 */
	public static <E> boolean removeAllElement(ArrayBlockingQueue<E> abq, Collection<E> c) {
		return abq.removeAll(c);
	}

	/**
	 * Phương thức loại bỏ tất cả các phần tử của hàng đợi. Hàng đợi sẽ rỗng sau khi
	 * gọi hàm này <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq - Hàng đợi
	 */
	public static <E> void clear(ArrayBlockingQueue<E> abq) {
		abq.clear();
	}

	/**
	 * Phương thức kiểm tra tồn tại của phần tử <b>e</b> có trong hàng đợi. Trả về
	 * True nếu tồn tại, ngược lại trả về False <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq - Hàng đợi
	 * @param e   - Phần tử để kiểm tra tồn tại
	 * @return
	 */
	public static <E> boolean containElement(ArrayBlockingQueue<E> abq, E e) {
		return abq.contains(e);
	}

	/**
	 * Phương thức kiểm tra tồn tại của tất cả phần tử trong <b>abq2</b> tồn tại
	 * trong <b>abq</b> Trả về <i>True</i> nếu tồn tại, ngược lại trả về
	 * <i>False</i> <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq  - Hàng đợi
	 * @param abq2 - Danh sách giá trị để kiểm tra tồn tại trong hàng đợi
	 * @return boolean
	 */
	public static <E> boolean containAllElement(ArrayBlockingQueue<E> abq, Collection<E> abq2) {
		return abq.containsAll(abq2);
	}

	/**
	 * Phương thức chuyển đổi phần tử của hàng đợi thành tập các phần tử
	 * (Collection). Trả về số lượng phần tử đã chuyển đổi. <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq    - Hàng đợi
	 * @param collec - Danh sách để chứa giá trị chuyển đổi
	 * @return
	 */
	public static <E> int drainToCollection(ArrayBlockingQueue<E> abq, Collection<E> collec) {
		return abq.drainTo(collec);
	}

	/**
	 * Phương thức chuyển đổi phần tử của hàng đợi thành tập các phần tử
	 * (Collection). Trả về số lượng phần tử đã chuyển đổi. Được giới hạn phần tử
	 * chuyển đổi bởi <b>maxElements.</b> Giá trị lấy tuân theo FIFO, nếu
	 * maxElements nhở hơn kích thước sẽ lấy đúng số lượng giới hạn, ngượi lại nếu
	 * lớn hơn thì sẽ lấy toàn bộ <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq         - Hàng đợi
	 * @param collec      - Danh sách để chứa giá trị chuyển đổi
	 * @param maxElements - Số lượng tối đa được chuyển đổi
	 * @return
	 * @throws IOException
	 */
	public static <E> int drainToCollection(ArrayBlockingQueue<E> abq, Collection<E> collec, int maxElements)
			throws IOException {
		return abq.drainTo(collec, maxElements);
	}

	/**
	 * Phương thức kiểm tra hàng đợi có tồn tại giá trị. Trả về <i>True</i> nếu tồn
	 * tại, ngược lại trả về <i>False</i> <br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq - Hàng đợi
	 * @return
	 */
	public static <E> boolean isEmpty(ArrayBlockingQueue<E> abq) {
		return abq.isEmpty();
	}

	/**
	 * Phương thức trả về một mảng chứa tất cả các giá trị của hàng đợi<br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq - Hàng đợi
	 * @return
	 */
	public static <E> Object[] toArray(ArrayBlockingQueue<E> abq) {

		// Tạo một mảng đối tượng, với giá trị lấy từ hàng đợi
		Object[] array = abq.toArray();
		return array;
	}

	/**
	 * Phương thức trả về một mảng chứ tất cả các giá trị của hàng đợi. The
	 * <i>arr</i> sẽ chứa tất cả các phần tử của hàng đợi, nếu mảng có kích thước
	 * lớn hơn hoặc bằng kích thước hàng đợi<br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq - Hàng đợi
	 * @param arr - Mảng kiểu dữ liệu
	 * @return
	 */
	public static <E> Object[] toArray(ArrayBlockingQueue<E> abq, E[] arr) {

		// Tạo một mảng đối tượng, với giá trị lấy từ hàng đợi
		Object[] array = abq.toArray(arr);
		return array;
	}

	/**
	 * Phương thức trả về số lượng phần tử có thể lưu trữ<br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq
	 * @return
	 */
	public static <E> int getCapacityEmpty(ArrayBlockingQueue<E> abq) {
		return abq.remainingCapacity();
	}

	/**
	 * Phương thức trả về Spliterator dựa vào các phần tử trong hàng đợi<br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq
	 * @return
	 */
	public static <E> Spliterator getSpliteratorList(ArrayBlockingQueue<E> abq) {
		Spliterator<E> spliterators = abq.spliterator();
		return spliterators;
	}

	/**
	 * Hiển thị lần lượt các phần tử trong hàng đợi<br>
	 * Create by: BVHA (12/05/2021)
	 * 
	 * @param <E>
	 * @param abq
	 */
	public static <E> void printArrayBlockingQueue(ArrayBlockingQueue<E> abq) {
		abq.forEach(e -> System.out.println(e));
	}
	
	public static <E> void printArray(Object[] arr) {
		for (Object i : arr) {
            System.out.println(i);
        }
	}
}
