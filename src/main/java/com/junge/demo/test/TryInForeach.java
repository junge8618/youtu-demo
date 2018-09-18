/**
 * 
 */
package com.junge.demo.test;

/**
 * @author "liuxj"
 *
 */
public class TryInForeach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			try {
				
				if (i==5) {
					System.out.println("continue");
					continue;
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("i=" + i);
			}
		}

	}

}
