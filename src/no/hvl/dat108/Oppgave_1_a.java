package no.hvl.dat108;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Oppgave_1_a {

	public static void main(String[] args) {
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

		Collections.sort(listen, (s1, s2) -> Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2)));
		System.out.println(listen);
	}
}
