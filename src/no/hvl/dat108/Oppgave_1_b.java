package no.hvl.dat108;

import java.util.function.BinaryOperator;

public class Oppgave_1_b {

	public static void main(String[] args) {
		
		// i)
		BinaryOperator<Integer> summerFunksjon = (x, y) -> x + y;
			int sum = beregn(12, 13, summerFunksjon);
				System.out.println(sum);
				
		// ii)
		BinaryOperator<Integer> storstAvFunksjon = (x, y) -> Math.max(x, y);
			int storst = beregn(-5, 3, storstAvFunksjon);
				System.out.println(storst + " er størst");
				
		// iii)
		BinaryOperator<Integer> abseluttDiff = (x, y) -> Math.abs(x - y);
			int absDiff = beregn(54, 45, abseluttDiff);
				System.out.println(absDiff);
			}
			
		public static int beregn(int a, int b, BinaryOperator<Integer> funksjon) {
			return funksjon.apply(a, b);
	}
}
