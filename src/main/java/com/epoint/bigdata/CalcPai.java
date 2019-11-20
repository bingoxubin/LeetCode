package com.epoint.bigdata;

import java.util.Scanner;

public class CalcPai {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入割圆次数：");
		int n = scan.nextInt();
		cut(n);

		System.out.println("请输入精度：");
		double z = scan.nextDouble();
		System.out.println("在精度为" + z + "的条件下，π约等于：\n" + jishuPI(z));
	}

	static void cut(int n) {
		double y = 1.0;
		for (int i = 0; i <= n; i++) {
			double π = 3 * Math.pow(2, i) * y;
			System.out.println("第" + i + "次切割,为正" + (6 + 6 * i) + "边形，圆周率π≈" + π);
			y = Math.sqrt(2 - Math.sqrt(4 - y * y));
		}
	}

	static double jishuPI(double z) {
		double sum = 2;
		int n = 1;
		int m = 3;
		double t = 2;
		while (t > z) {
			t = t * n / m;
			sum = sum + t;
			n++;
			m += 2;

		}
		return sum;
	}
}
