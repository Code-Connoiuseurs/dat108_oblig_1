package no.hvl.dat108.oppgaver;

import java.util.Arrays;
import java.util.List;

public class Oppgave_1_a {

	public static void main(String[] args) {
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
		listen.sort((o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2));
		System.out.println(listen);
	}

}
