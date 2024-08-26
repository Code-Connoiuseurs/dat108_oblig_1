package no.hvl.dat108;

import java.util.function.BiFunction;

public class Oppgave_1_b {

	public static void main(String[] args) {
		// i)
		BiFunction<Integer, Integer, Integer> summerFunksjon = (a, b) -> a + b;
		System.out.println(beregn(12, 13, summerFunksjon));

		// ii)
		BiFunction<Integer, Integer, Integer> maksFunksjon = (a, b) -> Math.max(a, b);
		System.out.println(beregn(-5, 3, maksFunksjon));

		// iii)
		BiFunction<Integer, Integer, Integer> differanseFunksjon = (a, b) -> Math.abs(a - b);
		System.out.println(beregn(54, 45, differanseFunksjon));

	}

	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> bf) {
		return bf.apply(a, b);
	}
}