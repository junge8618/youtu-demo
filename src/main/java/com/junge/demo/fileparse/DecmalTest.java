package com.junge.demo.fileparse;

import java.math.BigDecimal;

public class DecmalTest {

	public static void main(String[] args) {
		double val = 4.9E-324;
		System.out.println(BigDecimal.valueOf(val).setScale(9, BigDecimal.ROUND_HALF_UP).stripTrailingZeros());
		
		System.out.println(BigDecimal.valueOf(113.827542000).setScale(9, BigDecimal.ROUND_HALF_UP).stripTrailingZeros());
	}
}
