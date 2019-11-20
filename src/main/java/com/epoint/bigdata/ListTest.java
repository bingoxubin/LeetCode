package com.epoint.bigdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List初始化
 *
 * @author xumaosheng
 * @date 2019/8/12 13:31
 */
public class ListTest {
	public static void main(String[] args) {
		//方式一
		List<String> lst1 = new ArrayList<String>();
		lst1.add("hello");
		lst1.add("man");
		lst1.add("oh");
		lst1.add("i");
		lst1.add("am");
		lst1.add("xms");
		System.out.println(lst1 + "------------------" + lst1.get(3));

		//方式二
		List<String> lst2 = new ArrayList<String>(Arrays.asList("hello", "man", "i", "am", "xms"));
		System.out.println(lst2);

	}
}
