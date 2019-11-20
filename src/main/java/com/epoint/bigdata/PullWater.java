package com.epoint.bigdata;

import java.util.ArrayList;

import java.util.List;

public class PullWater {
	private List<List<Integer>> histories = new ArrayList<List<Integer>>();
	private List<Glass> glasses = new ArrayList<Glass>();

	public static void main(String[] args) {
		new PullWater().test();
	}

	public void test() {
		Glass a = new Glass(12);
		a.size = 8;
		Glass b = new Glass(7);
		Glass c = new Glass(5);
		glasses.add(a);
		glasses.add(b);
		glasses.add(c);
		addHistory();

		// 最终结果 4 4 0
		while (true) {
			Glass max = glasses.get(0);
			Glass min = glasses.get(0);
			for (int i = 1; i < glasses.size(); i++) {
				Glass glass = glasses.get(i);
				if (max.size < glass.size) {
					max = glass;
				}
				if (min.size > glass.size) {
					min = glass;
				}
			}

			Glass mid = null;
			for (Glass glass : glasses) {
				if (glass != max && glass != min) {
					mid = glass;
				}
			}
			if (!pour(max, mid)) {
				if (!pour(max, min)) {
					if (!pour(mid, min)) {
						if (!pour(mid, max)) {
							if (!pour(min, max)) {
								if (!pour(min, mid)) {
									System.out.println("error");
								}
							}
						}
					}
				}
			}
			addHistory();
			System.out.println(a.size + ", " + b.size + ", " + c.size);
			System.out.println("----------------");
			if (a.size == 3 && b.size == 5 && c.size == 0) {
				System.out.println("success");
				return;
			}
		}
	}

	/**
	 * 描述：增加历史记录
	 */
	private void addHistory() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(glasses.get(0).size);
		list.add(glasses.get(1).size);
		list.add(glasses.get(2).size);
		histories.add(list);
	}

	/**
	 * 描述：是否是历史状态
	 *
	 * @return
	 */
	private boolean isHistory() {
		for (List<Integer> history : histories) {
			if (history.get(0) == glasses.get(0).size && history.get(1) == glasses.get(1).size
					&& history.get(2) == glasses.get(2).size) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 描述：倒水
	 *
	 * @param from
	 * @param to
	 * @return
	 */
	public boolean pour(Glass from, Glass to) {
		// 保留初始值
		int temp1 = from.size;
		int temp2 = to.size;
		// form 中没水或 to 中已满
		if (from.size == 0 || to.capacity == to.size) {
			return false;
		}
		int toResidual = to.capacity - to.size;
		if (from.size >= toResidual) { // 对方倒满
			to.size = to.capacity;
			from.size -= toResidual;
		} else { // 自己倒完
			to.size += from.size;
			from.size = 0;
		}
		if (isHistory()) {
			// 还原
			from.size = temp1;
			to.size = temp2;
			return false;
		}
		return true;
	}

	class Glass {
		int capacity; // 容量
		int size; // 拥有水量

		public Glass(int capacity) {
			this.capacity = capacity;
		}

		@Override
		public String toString() {
			return "Glass [capacity=" + capacity + ", size=" + size + "]";
		}

	}

}
