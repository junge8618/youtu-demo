/**
 * 
 */
package com.junge.demo.youtu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * @author liuxj
 *
 */
public class SignUtils {

	public static String sign(List<String> values, String ticket) {
		if (values == null) {
			throw new NullPointerException("values is null");
		}

		values.removeAll(Collections.singleton(null));// remove null
		values.add(ticket);
		java.util.Collections.sort(values);

		StringBuilder sb = new StringBuilder();
		for (String s : values) {
			sb.append(s);
		}

		return Hashing.sha1().hashString(sb, Charsets.UTF_8).toString().toUpperCase();
	}
	
	public static void main(String[] args) {
		List<String> values = new ArrayList<String>();
		values.add("TIDA0001");
		values.add("userID19959248596551");
		values.add("kHoSxvLZGxSoFsjxlbzEoUzh5PAnTU7T");
		values.add("1.0.0");
		//values.add("XO99Qfxlti9iTVgHAjwvJdAZKN3nMuUhrsPdPlPVKlcyS50N6tlLnfuFBPIucaMS");
		
		System.out.println(sign(values, "XO99Qfxlti9iTVgHAjwvJdAZKN3nMuUhrsPdPlPVKlcyS50N6tlLnfuFBPIucaMS"));
	}
}
