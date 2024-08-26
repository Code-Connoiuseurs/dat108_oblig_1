package no.hvl.dat108.oppgaver;

import java.util.function.BinaryOperator;

public class Oppgave_1_b {

	public static void main(String[] args) {
		BinaryOperator<Integer> pluss = (t, u) -> t + u;
		BinaryOperator<Integer> maks = (t, u) -> Math.max(t, u);
		BinaryOperator<Integer> avstand = (t, u) -> Math.abs(t-u);
		
		System.out.println(beregn(12,13,pluss));
		System.out.println(beregn(-5,3,maks));
		System.out.println(beregn(12,13,avstand));
	}
	
	public static int beregn(int a, int b, BinaryOperator<Integer> funksjon) {
		return funksjon.apply(a, b);
	}
}
