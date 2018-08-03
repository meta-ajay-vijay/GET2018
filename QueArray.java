package queArray;

public class QueArray implements Que {
	private int[] array;
	private int back = -1;
	private int front = -1;
	private int N;

	public QueArray(int N) {
		array = new int[N];
		this.N = N;
	}

	@Override
	public boolean add(int element) {
		if (back == -1 && front == -1) {
			array[++back] = element;
			front++;
			return true;
		} else {
			int temproryBack = (back + 1) % N;
			if (temproryBack != front) {
				array[temproryBack] = element;
				back = temproryBack;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean delete() {
		if (back < 0 && front < 0) {
			System.out.println("The Que is Empty");
			return false;
		} else {
			int temproryFront = (front + 1) % N;
			if (temproryFront != back || temproryFront == 0 ) {
				front = temproryFront;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean isEmpty() {
		if (front < 0 && back < 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if ((back + 1) % N == front) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		QueArray obj = new QueArray(3);
		System.out.println(obj.add(1));
		System.out.println(obj.add(5));
		System.out.println(obj.add(1000));
		System.out.println(obj.front);
		System.out.println(obj.back);
		System.out.println(obj.delete());
		System.out.println(obj.add(1));
		System.out.println(obj.delete());
		System.out.println(obj.delete());
		System.out.println(obj.add(5));
		System.out.println(obj.front);
		System.out.println(obj.back);
		System.out.println(obj.delete());
		System.out.println(obj.add(1));
		System.out.println(obj.add(5));
		System.out.println(obj.front);
		System.out.println(obj.back);
		System.out.println(obj.isEmpty());
	}
}