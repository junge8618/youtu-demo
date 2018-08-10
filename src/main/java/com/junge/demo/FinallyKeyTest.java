package com.junge.demo;

public class FinallyKeyTest {

	public static void main(String[] args) {

		int j = 0;
		for (int i = 0; i < 100; i++) {
			try {
				if (i % 5 == 0) {
					continue;
				}
				j = j + i * 100;
			} finally {
				System.out.println("测试continue时，finally会不会执行,i=" + i);
			}
		}

	}

}
